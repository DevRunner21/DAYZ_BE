package com.dayz.onedayclass.controller;

import com.dayz.common.aop.LoginMemberId;
import com.dayz.common.dto.CommonApiResponse;
import com.dayz.onedayclass.domain.OneDayClass;
import com.dayz.onedayclass.dto.request.ReadOneDayClassesByAtelierRequest;
import com.dayz.onedayclass.dto.request.ReadOneDayClassesByCategoryRequest;
import com.dayz.onedayclass.dto.request.RegisterOneDayClassRequest;
import com.dayz.onedayclass.dto.request.SearchOneDayClassRequest;
import com.dayz.onedayclass.dto.response.*;
import com.dayz.onedayclass.service.OneDayClassService;
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

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/categories/{categoryId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public CommonApiResponse<ReadOneDayClassesByCategoryResponse> readOneDayClassesByCategory(
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

        return CommonApiResponse.<ReadOneDayClassesByCategoryResponse>ok(response);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/{classId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public CommonApiResponse<ReadOneDayClassDetailResponse> readOneDayClassesDetail(
        @PathVariable("classId") Long classId
    ) {
        ReadOneDayClassDetailResponse response = oneDayClassService.getOneDayClassDetail(classId);

        return CommonApiResponse.<ReadOneDayClassDetailResponse>ok(response);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(
        value = "/ateliers/{atelierId}",
        produces = MediaType.APPLICATION_JSON_VALUE
    )
    public CommonApiResponse<ReadOneDayClassesByAtelierResponse> readOneDayClassesByAtelier(
        @PathVariable("atelierId") Long atelierId,
        @Valid ReadOneDayClassesByAtelierRequest request
    ) {
        ReadOneDayClassesByAtelierResponse response = oneDayClassService.getOneDayClassesByAtelier(
            atelierId,
            request.convertToPageRequest(OneDayClass.class)
        );

        return CommonApiResponse.<ReadOneDayClassesByAtelierResponse>ok(response);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/search", produces = MediaType.APPLICATION_JSON_VALUE)
    public CommonApiResponse<SearchOneDayClassResponse> searchOneDayClass(
        @LoginMemberId Long memberId,
        @Valid SearchOneDayClassRequest request
    ) {
        SearchOneDayClassResponse response = oneDayClassService.searchOneDayClass(
            memberId,
            request.getKeyword(),
            request.convertToPageRequest(OneDayClass.class)
        );

        return CommonApiResponse.<SearchOneDayClassResponse>ok(response);
    }

    @GetMapping(value = "/popular", produces = MediaType.APPLICATION_JSON_VALUE)
    public CommonApiResponse<ReadPopularOneDayClassesResponse> readPopularOneDayClasses(
        @LoginMemberId Long memberId
    ) {
        ReadPopularOneDayClassesResponse response = oneDayClassService
            .getPopularOneDayClasses(memberId);

        return CommonApiResponse.<ReadPopularOneDayClassesResponse>ok(response);
    }

    @PostMapping(
        consumes = MediaType.APPLICATION_JSON_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE
    )
    public CommonApiResponse<RegisterOneDayClassResponse> registerOneDayClass(
        @Valid @RequestBody RegisterOneDayClassRequest request
    ) {
        Long registeredOneDayClassId = oneDayClassService.createOneDayClass(request);

        return CommonApiResponse.ok(RegisterOneDayClassResponse.of(registeredOneDayClassId));
    }

}
