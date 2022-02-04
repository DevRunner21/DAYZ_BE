package com.dayz.follow.service;

import com.dayz.atelier.domain.Atelier;
import com.dayz.atelier.domain.AtelierRepository;
import com.dayz.common.enums.ErrorInfo;
import com.dayz.common.exception.BusinessException;
import com.dayz.follow.converter.FollowConverter;
import com.dayz.follow.domain.Follow;
import com.dayz.follow.domain.FollowRepository;
import com.dayz.follow.dto.response.ReadFollowsResponse;
import com.dayz.member.domain.Member;
import com.dayz.member.domain.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class FollowService {

    private final FollowRepository followRepository;

    private final MemberRepository memberRepository;

    private final AtelierRepository atelierRepository;

    private final FollowConverter followConverter;

    @Transactional
    public boolean followingUnfollowing(Long memberId, Long atelierId) {
        Member member = memberRepository.findById(memberId)
            .orElseThrow(() -> new BusinessException(ErrorInfo.MEMBER_NOT_FOUND));
        Atelier atelier = atelierRepository.findById(atelierId)
            .orElseThrow(() -> new BusinessException(ErrorInfo.ATELIER_NOT_FOUND));

        if (followRepository.existsByMemberIdAndAtelierId(member.getId(), atelier.getId())) {
            Follow follow = followRepository.findFollowByMemberIdAndAtelierId(member.getId(), atelier.getId());
            follow.changeUseFlag(false);

            return false;
        } else {
            Follow newFollow = Follow.builder()
                .member(member)
                .atelier(atelier)
                .build();
            followRepository.save(newFollow);

            return true;
        }
    }

    public ReadFollowsResponse getFollows(
        Long memberId,
        Pageable pageRequest
    ) {
        Member member = memberRepository.findById(memberId)
            .orElseThrow(() -> new BusinessException(ErrorInfo.MEMBER_NOT_FOUND));

        Page<ReadFollowsResponse.FollowResult> followResultPage =
            followRepository.findFollowsByMemberId(member.getId(), pageRequest)
                .map(followConverter::convertToReadFollowsFollowResult);

        return ReadFollowsResponse.of(followResultPage);
    }

}


