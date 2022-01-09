package com.dayz.member.controller;

import com.dayz.atelier.dto.response.ReadAtelierDetailResponse;
import com.dayz.common.aop.LoginMemberId;
import com.dayz.common.dto.CommonApiResponse;
import com.dayz.common.jwt.JwtAuthentication;
import com.dayz.member.dto.request.EditMemberAddressRequest;
import com.dayz.member.dto.request.EditMemberProfileRequest;
import com.dayz.member.dto.response.EditMemberAddressResponse;
import com.dayz.member.dto.response.EditMemberProfileResponse;
import com.dayz.member.dto.response.ReadMemberInfoResponse;
import com.dayz.member.service.MemberService;
import io.swagger.annotations.*;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

@Api(tags = "MemberController V1", value = "사용자 CRUD API를 제공하는 Controller입니다.")
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/members")
public class MemberController {

    private final MemberService memberService;

    @ApiOperation(
        value = "사용자 정보 조회",
        notes = "사용자 정보를 조회합니다.",
        produces = MediaType.APPLICATION_JSON_VALUE
    )
    @ApiResponses({
        @ApiResponse(code = 200, response = ReadMemberInfoResponse.class, message = "성공")
    })
    @ResponseStatus(HttpStatus.OK)
    @GetMapping(path = "/info", produces = MediaType.APPLICATION_JSON_VALUE)
    public CommonApiResponse<ReadMemberInfoResponse> readMemberDetail(
        @ApiIgnore @AuthenticationPrincipal JwtAuthentication authentication
    ) {
        ReadMemberInfoResponse memberInfo = memberService
            .getMemberInfo(authentication.getId(), authentication.getToken());
        return CommonApiResponse.<ReadMemberInfoResponse>ok(memberInfo);
    }

    @ApiOperation(
        value = "사용자 관심주소 변경",
        notes = "사용자의 관심주소를 변경합니다.",
        produces = MediaType.APPLICATION_JSON_VALUE
    )
    @ApiResponses({
        @ApiResponse(code = 200, response = EditMemberAddressResponse.class, message = "성공")
    })
    @ResponseStatus(HttpStatus.OK)
    @PostMapping(path = "/address", produces = MediaType.APPLICATION_JSON_VALUE)
    public CommonApiResponse<EditMemberAddressResponse> editMemberAddress(
        @ApiIgnore @LoginMemberId Long memberId,
        @RequestBody @Valid EditMemberAddressRequest request
    ) {
        EditMemberAddressResponse editedAddress = memberService.updateMemberAddress(
            request.getCityId(),
            request.getRegionId(),
            memberId
        );

        return CommonApiResponse.<EditMemberAddressResponse>ok(editedAddress);
    }

    @ApiOperation(
        value = "사용자 프로필 변경",
        notes = "사용자의프로필을 변경합니다.",
        produces = MediaType.APPLICATION_JSON_VALUE,
        consumes = MediaType.APPLICATION_JSON_VALUE
    )
    @ApiResponses({
        @ApiResponse(code = 200, response = EditMemberProfileResponse.class, message = "성공")
    })
    @ResponseStatus(HttpStatus.OK)
    @PatchMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public CommonApiResponse<EditMemberProfileResponse> editMemberProfile(
        @ApiIgnore @LoginMemberId Long memberId,
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
