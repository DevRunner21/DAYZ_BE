package com.dayz.comment.controller;

import com.dayz.comment.domain.Comment;
import com.dayz.comment.dto.request.ReadCommentsRequest;
import com.dayz.comment.dto.response.ReadCommentsResponse;
import com.dayz.comment.dto.request.RegisterCommentRequest;
import com.dayz.comment.dto.response.RegisterCommentResponse;
import com.dayz.comment.service.CommentService;
import com.dayz.common.aop.LoginMemberId;
import com.dayz.common.dto.CommonApiResponse;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/comments")
public class CommentController {

    private final CommentService commentService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public CommonApiResponse<RegisterCommentResponse> registerComment(
        @LoginMemberId Long memberId,
        @Valid @RequestBody RegisterCommentRequest request
    ) {
        Long registeredCommentId = commentService.save(memberId, request);

        return CommonApiResponse.<RegisterCommentResponse>ok(RegisterCommentResponse.of(registeredCommentId));
    }

    @GetMapping(value = "/posts/{postId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public CommonApiResponse<ReadCommentsResponse> readComments(
        @PathVariable("postId") Long postId,
        @Valid ReadCommentsRequest request
    ) {
        ReadCommentsResponse response =
            commentService.getComments(
                request.convertToPageRequest(Comment.class),
                postId
            );

        return CommonApiResponse.<ReadCommentsResponse>ok(response);
    }

}
