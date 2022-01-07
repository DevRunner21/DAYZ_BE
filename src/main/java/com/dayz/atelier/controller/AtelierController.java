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
import com.dayz.common.dto.ApiResponse;
import com.dayz.member.domain.Member;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/ateliers")
public class AtelierController {

    private final AtelierService atelierService;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/{atelierId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ApiResponse<ReadAtelierDetailResponse> readAtelierDetail(
        @PathVariable("atelierId") Long atelierId
    ) {
        ReadAtelierDetailResponse response = atelierService.getAtelierDetail(atelierId);

        return ApiResponse.<ReadAtelierDetailResponse>ok(response);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ApiResponse<ReadAteliersResponse> readAteliers(
        @LoginMemberId Long memberId,
        @Valid ReadAteliersRequest pageRequest
    ) {
        ReadAteliersResponse response = atelierService.getAteliers(
            memberId,
            pageRequest.convertToPageRequest(Atelier.class)
        );

        return ApiResponse.<ReadAteliersResponse>ok(response);
    }

    @ResponseStatus(HttpStatus.OK)
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ApiResponse<SaveAtelierResponse> registerAtelier(
        @LoginMemberId Long memberId,
        @Valid @RequestBody RegisterAtelierRequest request) {
        SaveAtelierResponse response = atelierService
            .saveAtelierInfo(memberId, request);

        return ApiResponse.<SaveAtelierResponse>ok(response);
    }

    @GetMapping(value = "/search", produces = MediaType.APPLICATION_JSON_VALUE)
    public ApiResponse<SearchAtelierResponse> searchAteliers(
        @LoginMemberId Member member,
        @Valid SearchAtelierRequest request
    ) {
        SearchAtelierResponse response = atelierService.searchAtelier(
            member,
            request.getKeyword(),
            request.convertToPageRequest(Atelier.class)
        );

        return ApiResponse.<SearchAtelierResponse>ok(response);
    }

}
