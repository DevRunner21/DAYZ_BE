package com.dayz.atelier.service;

import com.dayz.atelier.converter.AtelierConverter;
import com.dayz.atelier.domain.Atelier;
import com.dayz.atelier.domain.AtelierRepository;
import com.dayz.atelier.domain.WorkTime;
import com.dayz.atelier.dto.request.RegisterAtelierRequest;
import com.dayz.atelier.dto.response.ReadAtelierDetailResponse;
import com.dayz.atelier.dto.response.ReadAteliersResponse;
import com.dayz.atelier.dto.response.SaveAtelierResponse;
import com.dayz.atelier.dto.response.SearchAtelierResponse;
import com.dayz.common.enums.Auth;
import com.dayz.common.enums.ErrorInfo;
import com.dayz.common.exception.BusinessException;
import com.dayz.common.jwt.Jwt;
import com.dayz.common.jwt.JwtAuthentication;
import com.dayz.common.jwt.JwtAuthenticationToken;
import com.dayz.member.domain.*;
import java.time.LocalTime;
import java.util.Collections;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class AtelierService {

    private final AtelierRepository atelierRepository;

    private final AddressRepository addressRepository;

    private final PermissionRepository permissionRepository;

    private final MemberRepository memberRepository;

    private final AtelierConverter atelierConverter;

    private final Jwt jwt;

//    private final TimeUtil timeUtil;

    public ReadAteliersResponse getAteliers(Long memberId, Pageable pageRequest) {
        Member foundMember = memberRepository.findById(memberId)
            .orElseThrow(() -> new BusinessException(ErrorInfo.MEMBER_NOT_FOUND));
        Address foundMemberAddress = foundMember.getAddress();

        Page<ReadAteliersResponse.AtelierResult> atelierResultPage = atelierRepository.findAteliersByAddress(
                foundMemberAddress.getCityId(),
                foundMemberAddress.getRegionId(),
                pageRequest
            ).map(atelierConverter::convertToReadAteliersAtelierResult);

        return ReadAteliersResponse.of(atelierResultPage);
    }

    public ReadAtelierDetailResponse getAtelierDetail(Long atelierId) {
        Atelier foundAtelier = atelierRepository.findById(atelierId)
            .orElseThrow(() -> new BusinessException(ErrorInfo.ATELIER_NOT_FOUND));

        return atelierConverter.convertToReadAtelierDetailResponse(foundAtelier);
    }

    @Transactional
    public SaveAtelierResponse saveAtelierInfo(Long memberId, RegisterAtelierRequest request) {
        Address address = addressRepository.findByCityIdAndRegionId(
            request.getAddress().getCityId(),
            request.getAddress().getRegionId()
        ).orElseThrow(() -> new BusinessException(ErrorInfo.ADDRESS_NOT_FOUND));

        Member member = memberRepository.findById(memberId)
            .orElseThrow(() -> new BusinessException(ErrorInfo.MEMBER_NOT_FOUND));

        if (atelierRepository.existsAtelierByMemberId(member.getId())) {
            throw new BusinessException(ErrorInfo.DUPLICATED_ATELIER_ID);
        }

        Atelier newAtelier = createNewAtelier(request, address, member);
        Atelier savedAtelier = atelierRepository.save(newAtelier);

        // TODO : ????????? ??????!!
        Permission permission = permissionRepository.findByName("ROLE_" + Auth.ATELIER.getValue()).get();
        member.changePermission(permission);

        String token = jwt.sign(
            Jwt.Claims.from(
                member.getId(),
                member.getProviderId(),
                member.getUsername(),
                new String[]{member.getPermission().getName()}
            )
        );

        List<SimpleGrantedAuthority> authorities =
            Collections.singletonList(new SimpleGrantedAuthority(member.getPermission().getName()));

        JwtAuthenticationToken authentication = new JwtAuthenticationToken(
            new JwtAuthentication(
                member.getId(),
                member.getProviderId(),
                token,
                member.getUsername()
            ),
            null,
            authorities
        );
        SecurityContextHolder.getContext().setAuthentication(authentication);

        return atelierConverter.convertToSaveAtelierResponse(savedAtelier.getId(), token);
    }

    public SearchAtelierResponse searchAtelier(
        Long memberId,
        String keyword,
        Pageable pageRequest
    ) {
        Member foundMember = memberRepository.findById(memberId)
            .orElseThrow(() -> new BusinessException(ErrorInfo.MEMBER_NOT_FOUND));

        Page<SearchAtelierResponse.AtelierResult> searchOneDayClassResponsePage =
            atelierRepository.searchAteliers(
                foundMember.getAddress().getCityId(),
                foundMember.getAddress().getRegionId(),
                keyword,
                pageRequest
            );

        return SearchAtelierResponse.of(searchOneDayClassResponsePage);
    }

    private Atelier createNewAtelier(RegisterAtelierRequest request, Address address, Member member) {
        return Atelier.builder()
            .name(request.getName())
            .address(address)
            .detail(request.getAddress().getDetail())
            .intro(request.getIntro())
            .callNumber(request.getCallNumber())
            .workTime(
                WorkTime.builder()
                    .startTime(LocalTime.parse(request.getWorkStartTime()))
                    .endTime(LocalTime.parse(request.getWorkEndTime()))
                    .build()
            )
            .businessNumber(request.getBusinessNumber())
            .member(member)
            .build();
    }

}
