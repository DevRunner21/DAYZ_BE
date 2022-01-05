package com.dayz.follow.controller;

import com.dayz.common.dto.ApiResponse;
import com.dayz.common.dto.CustomPageRequest;
import com.dayz.common.dto.CustomPageResponse;
import com.dayz.common.jwt.JwtAuthentication;
import com.dayz.follow.domain.Follow;
import com.dayz.follow.dto.FollowRequest;
import com.dayz.follow.dto.ReadFollowsResponse;
import com.dayz.follow.service.FollowService;
import java.util.Map;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/follows")
public class FollowController {

    private final FollowService followService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ApiResponse<CustomPageResponse<ReadFollowsResponse>> readFollows(
        @AuthenticationPrincipal JwtAuthentication authentication,
        @Valid CustomPageRequest pageRequest) {
        CustomPageResponse<ReadFollowsResponse> response = followService.getAllFollowings(
            authentication.getId(),
            pageRequest.convertToPageRequest(Follow.class)
        );

        return ApiResponse.ok(response);
    }

    // TODO : Map으로 처리한 부분 고치기
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ApiResponse registerFollow(@RequestBody @Valid FollowRequest followRequest) {
        boolean followFlag = followService
            .followingUnfollowing(followRequest.getMemberId(), followRequest.getAtelierId());

        return ApiResponse.ok(Map.of("followFlag", followFlag));
    }

}

