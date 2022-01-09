package com.dayz.member.controller;

import com.dayz.common.aop.LoginMemberId;
import com.dayz.common.dto.CommonApiResponse;
import com.dayz.common.jwt.JwtAuthentication;
import com.dayz.member.dto.request.EditMemberAddressRequest;
import com.dayz.member.dto.request.EditMemberProfileRequest;
import com.dayz.member.dto.response.EditMemberAddressResponse;
import com.dayz.member.dto.response.EditMemberProfileResponse;
import com.dayz.member.dto.response.ReadMemberInfoResponse;
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
    public CommonApiResponse<ReadMemberInfoResponse> readMemberDetail(
        @AuthenticationPrincipal JwtAuthentication authentication
    ) {
        ReadMemberInfoResponse memberInfo = memberService
            .getMemberInfo(authentication.getId(), authentication.getToken());
        return CommonApiResponse.<ReadMemberInfoResponse>ok(memberInfo);
    }

    @ResponseStatus(HttpStatus.OK)
    @PostMapping(path = "/address", produces = MediaType.APPLICATION_JSON_VALUE)
    public CommonApiResponse<EditMemberAddressResponse> editMemberAddress(
        @LoginMemberId Long memberId,
        @RequestBody @Valid EditMemberAddressRequest request
    ) {
        EditMemberAddressResponse editedAddress = memberService.updateMemberAddress(
            request.getCityId(),
            request.getRegionId(),
            memberId
        );

        return CommonApiResponse.<EditMemberAddressResponse>ok(editedAddress);
    }

    @ResponseStatus(HttpStatus.OK)
    @PatchMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public CommonApiResponse<EditMemberProfileResponse> editMemberProfile(
        @LoginMemberId Long memberId,
        @RequestBody @Valid EditMemberProfileRequest request
    ) {
        EditMemberProfileResponse response = memberService.updateMemberProfile(
            memberId,
            request.getName(),
            request.getImageUrl()
        );

        return CommonApiResponse.<EditMemberProfileResponse>ok(response);
    }

}
