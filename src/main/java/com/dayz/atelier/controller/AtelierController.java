package com.dayz.atelier.controller;

import com.dayz.atelier.domain.Atelier;
import com.dayz.atelier.dto.request.ReadAteliersRequest;
import com.dayz.atelier.dto.request.RegisterAtelierRequest;
import com.dayz.atelier.dto.request.SearchAtelierRequest;
import com.dayz.atelier.dto.response.ReadAtelierDetailResponse;
import com.dayz.atelier.dto.response.ReadAteliersResponse;
import com.dayz.atelier.dto.response.SaveAtelierResponse;
import com.dayz.atelier.dto.response.SearchAtelierResponse;
import com.dayz.atelier.service.AtelierService;
import com.dayz.common.aop.LoginMemberId;
import com.dayz.common.dto.CommonApiResponse;
import io.swagger.annotations.*;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

@Api(tags = "AtelierController V1", value = "공방 CRUD API를 제공하는 Controller입니다.")
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/ateliers")
public class AtelierController {

    private final AtelierService atelierService;

    @ApiOperation(
        value = "공방 상세정보 조회",
        notes = "atelierId에 해당하는 공방 상세정보를 조회합니다.",
        produces = MediaType.APPLICATION_JSON_VALUE
    )
    @ApiImplicitParams({
        @ApiImplicitParam(name = "atelierId", value = "공방 ID", required = true, dataType = "Long", paramType = "path", defaultValue = ""),
    })
    @ApiResponses({
        @ApiResponse(code = 200, response = ReadAtelierDetailResponse.class, message = "성공")
    })
    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/{atelierId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public CommonApiResponse<ReadAtelierDetailResponse> readAtelierDetail(
        @PathVariable("atelierId") Long atelierId
    ) {
        ReadAtelierDetailResponse response = atelierService.getAtelierDetail(atelierId);

        return CommonApiResponse.<ReadAtelierDetailResponse>ok(response);
    }

    @ApiOperation(
        value = "공방 목록 조회",
        notes = "공방 목록을 조회합니다.",
        produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiResponses({
        @ApiResponse(code = 200, response = ReadAteliersResponse.class, message = "성공")
    })
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public CommonApiResponse<ReadAteliersResponse> readAteliers(
        @ApiIgnore @LoginMemberId Long memberId,
        @Valid ReadAteliersRequest pageRequest
    ) {
        ReadAteliersResponse response = atelierService.getAteliers(
            memberId,
            pageRequest.convertToPageRequest(Atelier.class)
        );

        return CommonApiResponse.<ReadAteliersResponse>ok(response);
    }

    @ApiOperation(
        value = "공방 등록",
        notes = "새 공방을 등록합니다.",
        produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiResponses({
        @ApiResponse(code = 200, response = SaveAtelierResponse.class, message = "성공")
    })
    @ResponseStatus(HttpStatus.OK)
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public CommonApiResponse<SaveAtelierResponse> registerAtelier(
        @ApiIgnore @LoginMemberId Long memberId,
        @Valid @RequestBody RegisterAtelierRequest request) {
        SaveAtelierResponse response = atelierService
            .saveAtelierInfo(memberId, request);

        return CommonApiResponse.<SaveAtelierResponse>ok(response);
    }

    @ApiOperation(
        value = "공방 검색",
        notes = "공방을 검색합니다.",
        produces = MediaType.APPLICATION_JSON_VALUE)
    @GetMapping(value = "/search", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiResponses({
        @ApiResponse(code = 200, response = SearchAtelierResponse.class, message = "성공")
    })
    public CommonApiResponse<SearchAtelierResponse> searchAteliers(
        @ApiIgnore @LoginMemberId Long memberId,
        @Valid SearchAtelierRequest request
    ) {
        SearchAtelierResponse response = atelierService.searchAtelier(
            memberId,
            request.getKeyword(),
            request.convertToPageRequest(Atelier.class)
        );

        return CommonApiResponse.<SearchAtelierResponse>ok(response);
    }

}
