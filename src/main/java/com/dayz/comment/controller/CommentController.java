package com.dayz.comment.controller;

import com.dayz.atelier.dto.response.ReadAtelierDetailResponse;
import com.dayz.comment.domain.Comment;
import com.dayz.comment.dto.request.ReadCommentsRequest;
import com.dayz.comment.dto.response.ReadCommentsResponse;
import com.dayz.comment.dto.request.RegisterCommentRequest;
import com.dayz.comment.dto.response.RegisterCommentResponse;
import com.dayz.comment.service.CommentService;
import com.dayz.common.aop.LoginMemberId;
import com.dayz.common.dto.CommonApiResponse;
import io.swagger.annotations.*;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

@Api(tags = "CommentController V1", value = "댓글 CRUD API를 제공하는 Controller입니다.")
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/comments")
public class CommentController {

    private final CommentService commentService;

    @ApiOperation(
        value = "게시글 별 댓글 목록 조회",
        notes = "게시글 별로 댓글 목록을 조회합니다.",
        produces = MediaType.APPLICATION_JSON_VALUE
    )
    @ApiImplicitParams({
        @ApiImplicitParam(name = "postId", value = "게시글 ID", required = true, dataType = "Long", paramType = "path", defaultValue = ""),
    })
    @ApiResponses({
        @ApiResponse(code = 200, response = ReadCommentsResponse.class, message = "성공")
    })
    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/posts/{postId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public CommonApiResponse<ReadCommentsResponse> readComments(
        @PathVariable("postId") Long postId,
        @Valid ReadCommentsRequest request
    ) {
        ReadCommentsResponse response = commentService.getComments(
            postId,
            request.convertToPageRequest(Comment.class)
        );

        return CommonApiResponse.<ReadCommentsResponse>ok(response);
    }

    @ApiOperation(
        value = "댓글 등록",
        notes = "게시글에 댓글을 등록합니다.",
        produces = MediaType.APPLICATION_JSON_VALUE
    )
    @ApiResponses({
        @ApiResponse(code = 200, response = CommonApiResponse.class, message = "성공")
    })
    @ResponseStatus(HttpStatus.OK)
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public CommonApiResponse<RegisterCommentResponse> registerComment(
        @ApiIgnore @LoginMemberId Long memberId,
        @Valid @RequestBody RegisterCommentRequest request
    ) {
        Long registeredCommentId = commentService.save(memberId, request);

        return CommonApiResponse.<RegisterCommentResponse>ok(RegisterCommentResponse.of(registeredCommentId));
    }

}
