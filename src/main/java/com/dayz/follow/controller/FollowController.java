package com.dayz.follow.controller;

import com.dayz.common.aop.LoginMemberId;
import com.dayz.common.dto.CommonApiResponse;
import com.dayz.follow.domain.Follow;
import com.dayz.follow.dto.request.FollowRequest;
import com.dayz.follow.dto.request.ReadFollowsRequest;
import com.dayz.follow.dto.response.ReadFollowsResponse;
import com.dayz.follow.dto.response.RegisterFollowResponse;
import com.dayz.follow.service.FollowService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

@Api(tags = "FollowController V1", value = "팔로우 CRUD API를 제공하는 Controller입니다.")
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/follows")
public class FollowController {

    private final FollowService followService;

    @ApiOperation(
        value = "팔로우 목록 조회",
        notes = "팔로우 목록을 조회합니다.",
        produces = MediaType.APPLICATION_JSON_VALUE
    )
    @ApiResponses({
        @ApiResponse(code = 200, response = ReadFollowsResponse.class, message = "성공")
    })
    @ResponseStatus(HttpStatus.OK)
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public CommonApiResponse<ReadFollowsResponse> readFollows(
        @ApiIgnore @LoginMemberId Long memberId,
        @Valid ReadFollowsRequest request
    ) {
        ReadFollowsResponse response = followService.getFollows(
            memberId,
            request.convertToPageRequest(Follow.class)
        );

        return CommonApiResponse.<ReadFollowsResponse>ok(response);
    }

    @ApiOperation(
        value = "팔로우/언팔로우",
        notes = "공방을 팔로우합니다. ( 이미 팔로우 되어 있다면 언팔로우 합니다. )\n 팔로우했다면 followFlag = true, 언팔로우 헀다면 followFlag = false로 반환합니다.",
        produces = MediaType.APPLICATION_JSON_VALUE,
        consumes = MediaType.APPLICATION_JSON_VALUE
    )
    @ApiResponses({
        @ApiResponse(code = 200, response = RegisterFollowResponse.class, message = "성공")
    })
    @ResponseStatus(HttpStatus.OK)
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public CommonApiResponse<RegisterFollowResponse> registerFollow(@RequestBody @Valid FollowRequest followRequest) {
        boolean followFlag = followService.followingUnfollowing(
            followRequest.getMemberId(),
            followRequest.getAtelierId()
        );

        return CommonApiResponse.<RegisterFollowResponse>ok(RegisterFollowResponse.of(followFlag));
    }

}

