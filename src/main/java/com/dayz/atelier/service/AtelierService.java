package com.dayz.atelier.service;

import com.dayz.atelier.converter.AtelierConverter;
import com.dayz.atelier.domain.Atelier;
import com.dayz.atelier.domain.AtelierRepository;
import com.dayz.atelier.domain.WorkTime;
import com.dayz.atelier.dto.*;
import com.dayz.common.enums.Auth;
import com.dayz.common.enums.ErrorInfo;
import com.dayz.common.exception.BusinessException;
import com.dayz.common.jwt.Jwt;
import com.dayz.common.jwt.JwtAuthentication;
import com.dayz.common.jwt.JwtAuthenticationToken;
import com.dayz.common.util.TimeUtil;
import com.dayz.member.domain.*;
import java.util.Arrays;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
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

    private final AtelierConverter atelierConverter;

    private final PermissionRepository permissionRepository;

    private final MemberRepository memberRepository;

    private final Jwt jwt;

    private final TimeUtil timeUtil;

    public ReadAtelierDetailResponse getAtelierDetail(Long atelierId) {
        Atelier foundAtelier = atelierRepository.findById(atelierId)
            .orElseThrow(() -> new BusinessException(ErrorInfo.ATELIER_NOT_FOUND));

        return atelierConverter.convertToReadAtelierDetailResponse(foundAtelier);
    }

    @Transactional
    public SaveAtelierResponse saveAtelierInfo(Long memberId, RegisterAtelierRequest request) {

        Address address = addressRepository
            .findByCityIdAndRegionId(request.getAddress().getCityId(),
                request.getAddress().getRegionId())
            .orElseThrow(() -> new BusinessException(ErrorInfo.ADDRESS_NOT_FOUND));

        Member member = memberRepository.findById(memberId)
            .orElseThrow(() -> new BusinessException(ErrorInfo.MEMBER_NOT_FOUND));

        if (atelierRepository.existsAtelierByMemberId(member.getId())) {
            throw new BusinessException(ErrorInfo.DUPLICATED_ATELIER_ID);
        }

        Atelier newAtelier = Atelier.of(
            request.getName(),
            address,
            request.getAddress().getDetail(),
            request.getIntro(),
            request.getCallNumber(),
            WorkTime.of(timeUtil.timeStringToSecond(request.getWorkStartTime()),
                timeUtil.timeStringToSecond(request.getWorkEndTime())),
            request.getBusinessNumber(),
            member
        );

        Atelier savedAtelier = atelierRepository.save(newAtelier);

        Permission permission = permissionRepository.findByName("ROLE_" + Auth.ATELIER.getValue())
            .get();
        member.changePermission(permission);

        String token = jwt
            .sign(Jwt.Claims.from(member.getId(), member.getProviderId(), member.getUsername(),
                new String[]{member.getPermission().getName()}));

        List<SimpleGrantedAuthority> authorities = Arrays
            .asList(new SimpleGrantedAuthority(member.getPermission().getName()));
        JwtAuthenticationToken authentication = new JwtAuthenticationToken(
            new JwtAuthentication(member.getId(), member.getProviderId(), token,
                member.getUsername()),
            null, authorities);
        SecurityContextHolder.getContext().setAuthentication(authentication);

        return atelierConverter.convertToSaveAtelierResponse(savedAtelier.getId(), token);
    }

    public ReadAteliersResponse getAteliers(Long memberId,
        PageRequest pageRequest) {
        Member foundMember = memberRepository.findById(memberId)
            .orElseThrow(() -> new BusinessException(ErrorInfo.MEMBER_NOT_FOUND));

        Address foundMemberAddress = foundMember.getAddress();

        Page<ReadAteliersResponse.AtelierResult> atelierResultPage = atelierRepository
            .findAteliersByAddress(
                foundMemberAddress.getCityId(),
                foundMemberAddress.getRegionId(),
                pageRequest
            ).map(atelierConverter::convertToReadAteliersAtelierResult);

        return ReadAteliersResponse.of(atelierResultPage);
    }

    public SearchAtelierResponse searchAtelier(
        Member member,
        String keyword,
        Pageable pageRequest
    ) {
        Page<SearchAtelierResponse.AtelierResult> searchOneDayClassResponsePage = atelierRepository
            .searchAteliers(
                member.getAddress().getCityId(),
                member.getAddress().getRegionId(),
                keyword,
                pageRequest
            );

        return SearchAtelierResponse.of(searchOneDayClassResponsePage);

    }

}
