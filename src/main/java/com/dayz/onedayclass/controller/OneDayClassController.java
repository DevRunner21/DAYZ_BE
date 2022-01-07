package com.dayz.onedayclass.controller;

import com.dayz.common.aop.LoginMemberId;
import com.dayz.common.dto.ApiResponse;
import com.dayz.member.domain.Member;
import com.dayz.onedayclass.domain.OneDayClass;
import com.dayz.onedayclass.dto.request.ReadOneDayClassesByAtelierRequest;
import com.dayz.onedayclass.dto.request.ReadOneDayClassesByCategoryRequest;
import com.dayz.onedayclass.dto.request.SaveOneDayClassRequest;
import com.dayz.onedayclass.dto.request.SearchOneDayClassRequest;
import com.dayz.onedayclass.dto.response.*;
import com.dayz.onedayclass.service.OneDayClassService;
import java.util.Map;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/classes")
public class OneDayClassController {

    private final OneDayClassService oneDayClassService;

    // TODO : oneDayClassService.getOneDayClassesByCategory()dptj member말고 memberId로 파라미터를 넘기도록 변경 필요
    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/categories/{categoryId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ApiResponse<ReadOneDayClassesByCategoryResponse> readOneDayClassesByCategory(
        @LoginMemberId Long memberId,
        @PathVariable("categoryId") Long categoryId,
        ReadOneDayClassesByCategoryRequest request
    ) {
        ReadOneDayClassesByCategoryResponse response =
            oneDayClassService.getOneDayClassesByCategory(
                memberId,
                categoryId,
                request.convertToPageRequest(OneDayClass.class)
            );

        return ApiResponse.<ReadOneDayClassesByCategoryResponse>ok(response);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/{classId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ApiResponse<ReadOneDayClassDetailResponse> readOneDayClassesDetail(
        @PathVariable("classId") Long classId
    ) {
        ReadOneDayClassDetailResponse response = oneDayClassService.getOneDayClassDetail(classId);

        return ApiResponse.<ReadOneDayClassDetailResponse>ok(response);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(
        value = "/ateliers/{atelierId}",
        produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ApiResponse<ReadOneDayClassesByAtelierResponse> readOneDayClassesByAtelier(
        @PathVariable("atelierId") Long atelierId,
        @Valid ReadOneDayClassesByAtelierRequest request
    ) {
        ReadOneDayClassesByAtelierResponse response = oneDayClassService.getOneDayClassesByAtelier(
            atelierId,
            request.convertToPageRequest(OneDayClass.class)
        );

        return ApiResponse.<ReadOneDayClassesByAtelierResponse>ok(response);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/search", produces = MediaType.APPLICATION_JSON_VALUE)
    public ApiResponse<SearchOneDayClassResponse> searchOneDayClass(
        @LoginMemberId Member member,
        @Valid SearchOneDayClassRequest request
    ) {
        SearchOneDayClassResponse response = oneDayClassService.searchOneDayClass(
            member,
            request.getKeyword(),
            request.convertToPageRequest(OneDayClass.class)
        );

        return ApiResponse.<SearchOneDayClassResponse>ok(response);
    }

    @GetMapping(value = "/popular", produces = MediaType.APPLICATION_JSON_VALUE)
    public ApiResponse<ReadPopularOneDayClassesResponse> readPopularOneDayClasses(
        @LoginMemberId Long memberId
    ) {
        ReadPopularOneDayClassesResponse response = oneDayClassService
            .getPopularOneDayClasses(memberId);

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
