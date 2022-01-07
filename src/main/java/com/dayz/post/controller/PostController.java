package com.dayz.post.controller;

import com.dayz.common.aop.LoginMemberId;
import com.dayz.common.dto.ApiResponse;
import com.dayz.post.domain.Post;
import com.dayz.post.dto.request.ReadPostDetailsRequest;
import com.dayz.post.dto.request.ReadPostsByAtelierRequest;
import com.dayz.post.dto.request.RegisterPostRequest;
import com.dayz.post.dto.response.ReadPostDetailResponse;
import com.dayz.post.dto.response.ReadPostDetailsResponse;
import com.dayz.post.dto.response.ReadPostsByAtelierResponse;
import com.dayz.post.dto.response.RegisterPostResponse;
import com.dayz.post.service.PostService;
import java.util.Map;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/posts")
public class PostController {

    private final PostService postService;

    @GetMapping(value = "/{postId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ApiResponse<ReadPostDetailResponse> readPostDetail(@PathVariable("postId") Long postId) {
        ReadPostDetailResponse response = postService.getPostDetail(postId);

        return ApiResponse.<ReadPostDetailResponse>ok(response);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ApiResponse<ReadPostDetailsResponse> readPostDetails(
        @LoginMemberId Long memberId,
        @Valid ReadPostDetailsRequest request
    ) {
        ReadPostDetailsResponse response = postService.getPostDetails(
            memberId,
            request.convertToPageRequest(Post.class)
        );

        return ApiResponse.<ReadPostDetailsResponse>ok(response);
    }

    @GetMapping(value = "/ateliers/{atelierId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ApiResponse<ReadPostsByAtelierResponse> readPostsByAtelier(
        @PathVariable("atelierId") Long atelierId,
        @Valid ReadPostsByAtelierRequest request
    ) {
        ReadPostsByAtelierResponse response =
            postService.getPostsByAtelier(atelierId, request.convertToPageRequest(Post.class));

        return ApiResponse.<ReadPostsByAtelierResponse>ok(response);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ApiResponse<RegisterPostResponse> registerPost(@RequestBody @Valid RegisterPostRequest request) {
        Long registeredPostId = postService.save(request);

        return ApiResponse.ok(RegisterPostResponse.of(registeredPostId));
    }

}
