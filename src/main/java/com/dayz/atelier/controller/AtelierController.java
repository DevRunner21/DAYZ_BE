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
    public CommonApiResponse<ReadAtelierDetailResponse> readAtelierDetail(
        @PathVariable("atelierId") Long atelierId
    ) {
        ReadAtelierDetailResponse response = atelierService.getAtelierDetail(atelierId);

        return CommonApiResponse.<ReadAtelierDetailResponse>ok(response);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public CommonApiResponse<ReadAteliersResponse> readAteliers(
        @LoginMemberId Long memberId,
        @Valid ReadAteliersRequest pageRequest
    ) {
        ReadAteliersResponse response = atelierService.getAteliers(
            memberId,
            pageRequest.convertToPageRequest(Atelier.class)
        );

        return CommonApiResponse.<ReadAteliersResponse>ok(response);
    }

    @ResponseStatus(HttpStatus.OK)
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public CommonApiResponse<SaveAtelierResponse> registerAtelier(
        @LoginMemberId Long memberId,
        @Valid @RequestBody RegisterAtelierRequest request) {
        SaveAtelierResponse response = atelierService
            .saveAtelierInfo(memberId, request);

        return CommonApiResponse.<SaveAtelierResponse>ok(response);
    }

    @GetMapping(value = "/search", produces = MediaType.APPLICATION_JSON_VALUE)
    public CommonApiResponse<SearchAtelierResponse> searchAteliers(
        @LoginMemberId Long memberId,
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
