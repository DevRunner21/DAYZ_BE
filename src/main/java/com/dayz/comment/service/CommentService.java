package com.dayz.comment.service;

import com.dayz.comment.converter.CommentConverter;
import com.dayz.comment.domain.CommentRepository;
import com.dayz.comment.dto.request.RegisterCommentRequest;
import com.dayz.comment.dto.response.ReadCommentsResponse;
import com.dayz.comment.dto.response.ReadCommentsResponse.CommentResult;
import com.dayz.common.enums.ErrorInfo;
import com.dayz.common.exception.BusinessException;
import com.dayz.member.domain.Member;
import com.dayz.member.domain.MemberRepository;
import com.dayz.post.domain.Post;
import com.dayz.post.domain.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class CommentService {

    private final CommentRepository commentRepository;

    private final PostRepository postRepository;

    private final MemberRepository memberRepository;

    private final CommentConverter commentConverter;

    public ReadCommentsResponse getComments( Long postId, PageRequest pageRequest) {
        Page<CommentResult> readCommentsResultPage =
            commentRepository.findCommentsByPostId(postId, pageRequest)
                .map(comment -> commentConverter.convertToReadCommentsResult(
                    comment,
                    memberRepository.findById(comment.getId())
                        .orElseThrow(() -> new BusinessException(ErrorInfo.MEMBER_NOT_FOUND))
                    )
                );

        return ReadCommentsResponse.of(readCommentsResultPage);
    }

    @Transactional
    public Long save(Long memberId, RegisterCommentRequest request) {
        Post foundPost = postRepository.findById(request.getPostId())
            .orElseThrow(() -> new BusinessException(ErrorInfo.POST_NOT_FOUND));

        Member foundMember = memberRepository.findById(memberId)
            .orElseThrow(() -> new BusinessException(ErrorInfo.MEMBER_NOT_FOUND));

        return commentRepository.save(
            commentConverter.convertToComment(
                request.getContent(),
                foundPost,
                foundMember
            )
        ).getId();
    }

}
