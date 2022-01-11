package com.dayz.post.controller;

import com.dayz.common.aop.LoginMemberId;
import com.dayz.common.dto.CommonApiResponse;
import com.dayz.onedayclass.dto.response.ReadOneDayClassesByCategoryResponse;
import com.dayz.post.domain.Post;
import com.dayz.post.dto.request.ReadPostDetailsRequest;
import com.dayz.post.dto.request.ReadPostsByAtelierRequest;
import com.dayz.post.dto.request.RegisterPostRequest;
import com.dayz.post.dto.response.ReadPostDetailResponse;
import com.dayz.post.dto.response.ReadPostDetailsResponse;
import com.dayz.post.dto.response.ReadPostsByAtelierResponse;
import com.dayz.post.dto.response.RegisterPostResponse;
import com.dayz.post.service.PostService;
import io.swagger.annotations.*;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

@Api(tags = "PostController V1", value = "게시글 CRUD API를 제공하는 Controller입니다.")
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/posts")
public class PostController {

    private final PostService postService;

    @ApiOperation(
        value = "게시글 상세조회",
        notes = "게시글을 상세조회합니다.",
        produces = MediaType.APPLICATION_JSON_VALUE
    )
    @ApiImplicitParams({
        @ApiImplicitParam(name = "postId", value = "게시글 ID", required = true, dataType = "Long", paramType = "path", defaultValue = ""),
    })
    @ApiResponses({
        @ApiResponse(code = 200, response = ReadPostDetailResponse.class, message = "성공")
    })
    @GetMapping(value = "/{postId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public CommonApiResponse<ReadPostDetailResponse> readPostDetail(@PathVariable("postId") Long postId) {
        ReadPostDetailResponse response = postService.getPostDetail(postId);

        return CommonApiResponse.<ReadPostDetailResponse>ok(response);
    }

    @ApiOperation(
        value = "게시글 상세정보 목록 조회( 피드 )",
        notes = "게시글 상세정보 목록을 조회합니다.",
        produces = MediaType.APPLICATION_JSON_VALUE
    )
    @ApiResponses({
        @ApiResponse(code = 200, response = ReadPostDetailsResponse.class, message = "성공")
    })
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public CommonApiResponse<ReadPostDetailsResponse> readPostDetails(
        @ApiIgnore @LoginMemberId Long memberId,
        @Valid ReadPostDetailsRequest request
    ) {
        ReadPostDetailsResponse response = postService.getPostDetails(
            memberId,
            request.convertToPageRequest(Post.class)
        );

        return CommonApiResponse.<ReadPostDetailsResponse>ok(response);
    }

    @ApiOperation(
        value = "공방 별 게시글 목록 조회",
        notes = "공방 별 게시글 목록을 조회합니다.",
        produces = MediaType.APPLICATION_JSON_VALUE
    )
    @ApiImplicitParams({
        @ApiImplicitParam(name = "atelierId", value = "공방 ID", required = true, dataType = "Long", paramType = "path", defaultValue = ""),
    })
    @ApiResponses({
        @ApiResponse(code = 200, response = ReadPostsByAtelierResponse.class, message = "성공")
    })
    @GetMapping(value = "/ateliers/{atelierId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public CommonApiResponse<ReadPostsByAtelierResponse> readPostsByAtelier(
        @PathVariable("atelierId") Long atelierId,
        @Valid ReadPostsByAtelierRequest request
    ) {
        ReadPostsByAtelierResponse response =
            postService.getPostsByAtelier(atelierId, request.convertToPageRequest(Post.class));

        return CommonApiResponse.<ReadPostsByAtelierResponse>ok(response);
    }

    @ApiOperation(
        value = "게시글 등록",
        notes = "게시글을 등록합니다.",
        produces = MediaType.APPLICATION_JSON_VALUE
    )
    @ApiResponses({
        @ApiResponse(code = 200, response = RegisterPostResponse.class, message = "성공")
    })
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public CommonApiResponse<RegisterPostResponse> registerPost(@RequestBody @Valid RegisterPostRequest request) {
        Long registeredPostId = postService.save(request);

        return CommonApiResponse.ok(RegisterPostResponse.of(registeredPostId));
    }

}
