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
import io.swagger.annotations.*;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

@Api(tags = "OneDayClassController V1", value = "원데이클래스 CRUD API를 제공하는 Controller입니다.")
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/classes")
public class OneDayClassController {

    private final OneDayClassService oneDayClassService;

    @ApiOperation(
        value = "카테고리 별 원데이클래스 조회",
        notes = "카테고리 별 원데이클래스를 조회합니다.",
        produces = MediaType.APPLICATION_JSON_VALUE
    )
    @ApiImplicitParams({
        @ApiImplicitParam(name = "categoryId", value = "카테고리 ID", required = true, dataType = "Long", paramType = "path", defaultValue = ""),
    })
    @ApiResponses({
        @ApiResponse(code = 200, response = ReadOneDayClassesByCategoryResponse.class, message = "성공")
    })
    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/categories/{categoryId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public CommonApiResponse<ReadOneDayClassesByCategoryResponse> readOneDayClassesByCategory(
        @ApiIgnore @LoginMemberId Long memberId,
        @PathVariable("categoryId") Long categoryId,
        @Valid ReadOneDayClassesByCategoryRequest request
    ) {
        ReadOneDayClassesByCategoryResponse response =
            oneDayClassService.getOneDayClassesByCategory(
                memberId,
                categoryId,
                request.convertToPageRequest(OneDayClass.class)
            );

        return CommonApiResponse.<ReadOneDayClassesByCategoryResponse>ok(response);
    }

    @ApiOperation(
        value = "원데이클래스 상세정보 조회",
        notes = "원데이클래스 상세정보를 조회합니다.",
        produces = MediaType.APPLICATION_JSON_VALUE
    )
    @ApiImplicitParams({
        @ApiImplicitParam(name = "classId", value = "원데이클래스 ID", required = true, dataType = "Long", paramType = "path", defaultValue = ""),
    })
    @ApiResponses({
        @ApiResponse(code = 200, response = ReadOneDayClassDetailResponse.class, message = "성공")
    })
    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/{classId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public CommonApiResponse<ReadOneDayClassDetailResponse> readOneDayClassesDetail(
        @PathVariable("classId") Long classId
    ) {
        ReadOneDayClassDetailResponse response = oneDayClassService.getOneDayClassDetail(classId);

        return CommonApiResponse.<ReadOneDayClassDetailResponse>ok(response);
    }

    @ApiOperation(
        value = "공방 별 원데이클래스 목록 조회",
        notes = "공방 별 원데이클래스 목록을 조회합니다.",
        produces = MediaType.APPLICATION_JSON_VALUE
    )
    @ApiImplicitParams({
        @ApiImplicitParam(name = "atelierId", value = "공방 ID", required = true, dataType = "Long", paramType = "path", defaultValue = ""),
    })
    @ApiResponses({
        @ApiResponse(code = 200, response = ReadOneDayClassesByAtelierResponse.class, message = "성공")
    })
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

    @ApiOperation(
        value = "원데이클래스 검색",
        notes = "원데이클래스을 검색합니다.",
        produces = MediaType.APPLICATION_JSON_VALUE
    )
    @ApiResponses({
        @ApiResponse(code = 200, response = SearchOneDayClassResponse.class, message = "성공")
    })
    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/search", produces = MediaType.APPLICATION_JSON_VALUE)
    public CommonApiResponse<SearchOneDayClassResponse> searchOneDayClass(
        @ApiIgnore @LoginMemberId Long memberId,
        @Valid SearchOneDayClassRequest request
    ) {
        SearchOneDayClassResponse response = oneDayClassService.searchOneDayClass(
            memberId,
            request.getKeyword(),
            request.convertToPageRequest(OneDayClass.class)
        );

        return CommonApiResponse.<SearchOneDayClassResponse>ok(response);
    }

    @ApiOperation(
        value = "금주 인기 원데이 클래스 조회",
        notes = "이번주에 가장 인기있는 원데이클래스 3개를 조회합니다.\n(예약수 기준)",
        produces = MediaType.APPLICATION_JSON_VALUE
    )
    @ApiResponses({
        @ApiResponse(code = 200, response = ReadPopularOneDayClassesResponse.class, message = "성공")
    })
    @GetMapping(value = "/popular", produces = MediaType.APPLICATION_JSON_VALUE)
    public CommonApiResponse<ReadPopularOneDayClassesResponse> readPopularOneDayClasses(
        @ApiIgnore @LoginMemberId Long memberId
    ) {
        ReadPopularOneDayClassesResponse response = oneDayClassService
            .getPopularOneDayClasses(memberId);

        return CommonApiResponse.<ReadPopularOneDayClassesResponse>ok(response);
    }

    @ApiOperation(
        value = "원데이클래스 등록",
        notes = "새 원데이클래스를 등록합니다.",
        produces = MediaType.APPLICATION_JSON_VALUE
    )
    @ApiResponses({
        @ApiResponse(code = 200, response = RegisterOneDayClassResponse.class, message = "성공")
    })
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
