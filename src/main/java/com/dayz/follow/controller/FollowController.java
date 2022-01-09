package com.dayz.follow.controller;

import com.dayz.common.aop.LoginMemberId;
import com.dayz.common.dto.CommonApiResponse;
import com.dayz.follow.domain.Follow;
import com.dayz.follow.dto.request.FollowRequest;
import com.dayz.follow.dto.request.ReadFollowsRequest;
import com.dayz.follow.dto.response.ReadFollowsResponse;
import com.dayz.follow.dto.response.RegisterFollowResponse;
import com.dayz.follow.service.FollowService;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/follows")
public class FollowController {

    private final FollowService followService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public CommonApiResponse<ReadFollowsResponse> readFollows(
        @LoginMemberId Long memberId,
        @Valid ReadFollowsRequest request
    ) {
        ReadFollowsResponse response = followService.getFollows(
            memberId,
            request.convertToPageRequest(Follow.class)
        );

        return CommonApiResponse.<ReadFollowsResponse>ok(response);
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public CommonApiResponse<RegisterFollowResponse> registerFollow(@RequestBody @Valid FollowRequest followRequest) {
        boolean followFlag = followService.followingUnfollowing(
            followRequest.getMemberId(),
            followRequest.getAtelierId()
        );

        return CommonApiResponse.<RegisterFollowResponse>ok(RegisterFollowResponse.of(followFlag));
    }

}

