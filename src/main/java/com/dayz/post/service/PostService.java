package com.dayz.post.service;

import com.dayz.atelier.domain.Atelier;
import com.dayz.atelier.domain.AtelierRepository;
import com.dayz.common.enums.ErrorInfo;
import com.dayz.common.exception.BusinessException;
import com.dayz.follow.domain.FollowRepository;
import com.dayz.member.domain.Member;
import com.dayz.member.domain.MemberRepository;
import com.dayz.onedayclass.domain.OneDayClass;
import com.dayz.onedayclass.domain.OneDayClassRepository;
import com.dayz.post.converter.PostConverter;
import com.dayz.post.domain.Post;
import com.dayz.post.domain.PostRepository;
import com.dayz.post.dto.response.ReadPostDetailResponse;
import com.dayz.post.dto.response.ReadPostDetailsResponse;
import com.dayz.post.dto.response.ReadPostsByAtelierResponse;
import com.dayz.post.dto.request.RegisterPostRequest;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class PostService {

    private final PostRepository postRepository;

    private final MemberRepository memberRepository;

    private final AtelierRepository atelierRepository;

    private final OneDayClassRepository oneDayClassRepository;

    private final FollowRepository followRepository;

    private final PostConverter postConverter;

    @Transactional
    public Long save(RegisterPostRequest request) {
        Atelier atelier = atelierRepository.findById(request.getAtelierId())
            .orElseThrow(() -> new BusinessException(ErrorInfo.ATELIER_NOT_FOUND));
        OneDayClass oneDayClass = oneDayClassRepository.findById(request.getOneDayClassId())
            .orElseThrow(() -> new BusinessException(ErrorInfo.ONE_DAY_CLASS_NOT_FOUND));

        return postRepository
            .save(postConverter.convertToPost(request, atelier.getMember(), oneDayClass)).getId();
    }

    public ReadPostDetailResponse getPostDetail(Long postId) {
        Post foundPost = postRepository.findDetailPostById(postId)
            .orElseThrow(() -> new BusinessException(ErrorInfo.POST_NOT_FOUND));

        return postConverter.convertToReadPostDetailResponse(foundPost);
    }

    public ReadPostDetailsResponse getPostDetails(Long memberId, Pageable pageRequest) {
        Member foundMember = memberRepository.findById(memberId)
            .orElseThrow(() -> new BusinessException(ErrorInfo.MEMBER_NOT_FOUND));

        // TODO : 애초에 DTO를 쓰던지, 아니면 다른 방법으로 ID 값들만 가져오는게 좋아보임
        List<Long> ids = followRepository.findFollowsByMemberId(foundMember.getId())
            .stream()
            .map(follow -> follow.getAtelier().getMember().getId())
            .collect(Collectors.toList());

        Page<ReadPostDetailsResponse.PostDetailResult> readPostDetailsResultPage = postRepository
            .findPostsByFollows(ids, pageRequest)
            .map(postConverter::convertToReadPostDetailsResult);

        return ReadPostDetailsResponse.of(readPostDetailsResultPage);
    }

    public ReadPostsByAtelierResponse getPostsByAtelier(
        Long atelierId,
        Pageable pageRequest
    ) {
        Atelier foundAtelier = atelierRepository.findById(atelierId)
            .orElseThrow(() -> new BusinessException(ErrorInfo.ATELIER_NOT_FOUND));

        Page<ReadPostsByAtelierResponse.PostResult> readPostsByAtelierResultPage =
            postRepository.findPostsByAtelier(atelierId, pageRequest)
                .map(postConverter::convertToReadPostsByAtelierAtelierResult);

        return ReadPostsByAtelierResponse.of(readPostsByAtelierResultPage);
    }

}
