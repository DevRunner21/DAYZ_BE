package com.dayz.member.controller;

import com.dayz.common.dto.ApiResponse;
import com.dayz.common.jwt.JwtAuthentication;
import com.dayz.member.dto.*;
import com.dayz.member.service.MemberService;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/members")
public class MemberController {

    private final MemberService memberService;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(path = "/info", produces = MediaType.APPLICATION_JSON_VALUE)
    public ApiResponse<ReadMemberInfoResponse> readMemberDetail(
        @AuthenticationPrincipal JwtAuthentication authentication
    ) {
        ReadMemberInfoResponse memberInfo = memberService
            .getMemberInfo(authentication.getId(), authentication.getToken());
        return ApiResponse.<ReadMemberInfoResponse>ok(memberInfo);
    }

    @ResponseStatus(HttpStatus.OK)
    @PostMapping(path = "/address", produces = MediaType.APPLICATION_JSON_VALUE)
    public ApiResponse<EditMemberAddressResponse> editMemberAddress(
        @AuthenticationPrincipal JwtAuthentication authentication,
        @RequestBody @Valid EditMemberAddressRequest request
    ) {
        EditMemberAddressResponse editedAddress = memberService.updateMemberAddress(
            request.getCityId(),
            request.getRegionId(),
            authentication.getId()
        );

        return ApiResponse.<EditMemberAddressResponse>ok(editedAddress);
    }

    @ResponseStatus(HttpStatus.OK)
    @PatchMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ApiResponse<EditMemberProfileResponse> editMemberProfile(
        @AuthenticationPrincipal JwtAuthentication authentication,
        @RequestBody @Valid EditMemberProfileRequest request
    ) {
        EditMemberProfileResponse response = memberService.updateMemberProfile(
            authentication.getId(),
            request.getName(),
            request.getImageUrl()
        );

        return ApiResponse.<EditMemberProfileResponse>ok(response);
    }

}
