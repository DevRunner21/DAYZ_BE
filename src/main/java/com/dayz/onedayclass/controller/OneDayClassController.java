package com.dayz.onedayclass.controller;

import com.dayz.common.aop.LoginMember;
import com.dayz.common.dto.ApiResponse;
import com.dayz.common.dto.CustomPageRequest;
import com.dayz.common.dto.CustomPageResponse;
import com.dayz.common.dto.SearchPageRequest;
import com.dayz.common.jwt.JwtAuthentication;
import com.dayz.member.domain.Member;
import com.dayz.onedayclass.domain.OneDayClass;
import com.dayz.onedayclass.dto.*;
import com.dayz.onedayclass.service.OneDayClassService;
import java.util.Map;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/classes")
public class OneDayClassController {

    private final OneDayClassService oneDayClassService;

    // TODO : oneDayClassService.getOneDayClassesByCategory()dptj member말고 memberId로 파라미터를 넘기도록 변경 필요
    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/categories/{categoryId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ApiResponse<CustomPageResponse<ReadOneDayClassesByCategoryResult>> readOneDayClassesByCategory(
        @LoginMember Member member,
        @PathVariable("categoryId") Long categoryId,
        CustomPageRequest pageRequest) {
        CustomPageResponse response = oneDayClassService.getOneDayClassesByCategory(
            member,
            categoryId,
            pageRequest.convertToPageRequest(OneDayClass.class)
        );

        return ApiResponse.<CustomPageResponse<ReadOneDayClassesByCategoryResult>>ok(response);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/{classId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ApiResponse<ReadOneDayClassDetailResponse> readOneDayClassesDetail(
        @PathVariable("classId") Long classId) {
        ReadOneDayClassDetailResponse response = oneDayClassService.getOneDayClassDetail(classId);

        return ApiResponse.<ReadOneDayClassDetailResponse>ok(response);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(
        value = "/ateliers/{atelierId}",
        produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ApiResponse readOneDayClassesByAtelier(
        @PathVariable("atelierId") Long atelierId,
        @Valid SearchPageRequest request
    ) {
        CustomPageResponse response = oneDayClassService.getOneDayClassesByAtelier(
            atelierId,
            request.convertToPageRequest(OneDayClass.class)
        );

        return ApiResponse.<CustomPageResponse<ReadOneDayClassByAtelierResult>>ok(response);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/search", produces = MediaType.APPLICATION_JSON_VALUE)
    public ApiResponse searchOneDayClass(
        @LoginMember Member member,
        @Valid SearchPageRequest request
    ) {
        CustomPageResponse response = oneDayClassService.searchOneDayClass(
            member,
            request.getKeyWord(),
            request.convertToPageRequest(OneDayClass.class)
        );

        return ApiResponse.ok(response);
    }

    @GetMapping(value = "/popular", produces = MediaType.APPLICATION_JSON_VALUE)
    public ApiResponse<ReadPopularOneDayClassesResponse> readPopularOneDayClasses(
        @AuthenticationPrincipal JwtAuthentication authentication
    ) {
        ReadPopularOneDayClassesResponse response = oneDayClassService
            .getPopularOneDayClasses(authentication.getId());

        return ApiResponse.<ReadPopularOneDayClassesResponse>ok(response);
    }

    @PostMapping(
        consumes = MediaType.APPLICATION_JSON_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ApiResponse saveOneDayClass(
        @Valid @RequestBody SaveOneDayClassRequest request
    ) {
        Long savedOneDayClassId = oneDayClassService.createOneDayClass(request);

        return ApiResponse.ok(Map.of("oneDayClassId", savedOneDayClassId));
    }

}
