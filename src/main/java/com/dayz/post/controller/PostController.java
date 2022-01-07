package com.dayz.post.controller;

import com.dayz.common.dto.ApiResponse;
import com.dayz.common.dto.CustomPageRequest;
import com.dayz.common.dto.CustomPageResponse;
import com.dayz.common.jwt.JwtAuthentication;
import com.dayz.post.domain.Post;
import com.dayz.post.dto.ReadPostDetailResponse;
import com.dayz.post.dto.ReadPostDetailsResponse;
import com.dayz.post.dto.ReadPostsByAtelierResponse;
import com.dayz.post.dto.RegisterPostRequest;
import com.dayz.post.service.PostService;
import java.util.Map;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/posts")
public class PostController {

    private final PostService postService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ApiResponse registerPost(@RequestBody @Valid RegisterPostRequest request) {
        return ApiResponse.ok(Map.of("postId", postService.save(request)));
    }

    @GetMapping(value = "/{postId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ApiResponse<ReadPostDetailResponse> readPostDetail(@PathVariable("postId") Long postId) {
        ReadPostDetailResponse response = postService.getPostDetail(postId);

        return ApiResponse.<ReadPostDetailResponse>ok(response);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ApiResponse<ReadPostDetailsResponse> readPostDetails(
        @AuthenticationPrincipal JwtAuthentication authentication,
        @Valid CustomPageRequest request
    ) {
        ReadPostDetailsResponse response = postService.getPostDetails(
            authentication.getId(),
            request.convertToPageRequest(Post.class)
        );

        return ApiResponse.<ReadPostDetailsResponse>ok(response);
    }

    @GetMapping(value = "/ateliers/{atelierId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ApiResponse<ReadPostsByAtelierResponse> readPostsByAtelier(
        @PathVariable("atelierId") Long atelierId,
        @Valid CustomPageRequest request) {
        ReadPostsByAtelierResponse response =
            postService.getPostsByAtelier(atelierId, request.convertToPageRequest(Post.class));

        return ApiResponse.<ReadPostsByAtelierResponse>ok(response);
    }

}
