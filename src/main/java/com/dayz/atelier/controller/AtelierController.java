package com.dayz.atelier.controller;


import com.dayz.atelier.domain.Atelier;
import com.dayz.atelier.dto.*;
import com.dayz.atelier.service.AtelierService;
import com.dayz.common.aop.LoginMember;
import com.dayz.common.dto.ApiResponse;
import com.dayz.common.dto.CustomPageRequest;
import com.dayz.common.dto.SearchPageRequest;
import com.dayz.common.jwt.JwtAuthentication;
import com.dayz.member.domain.Member;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/ateliers")
public class AtelierController {

    private final AtelierService atelierService;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/{atelierId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ApiResponse<ReadAtelierDetailResponse> readAtelierDetail(
        @PathVariable("atelierId") Long atelierId) {
        ReadAtelierDetailResponse response = atelierService.getAtelierDetail(atelierId);

        return ApiResponse.<ReadAtelierDetailResponse>ok(response);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ApiResponse<ReadAteliersResponse> readAteliers(
        @AuthenticationPrincipal JwtAuthentication authentication,
        @Valid CustomPageRequest pageRequest) {

        ReadAteliersResponse response = atelierService.getAteliers(
            authentication.getId(),
            pageRequest.convertToPageRequest(Atelier.class)
        );

        return ApiResponse.<ReadAteliersResponse>ok(response);
    }

    @ResponseStatus(HttpStatus.OK)
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ApiResponse<SaveAtelierResponse> registerAtelier(
        @AuthenticationPrincipal JwtAuthentication authentication,
        @Valid @RequestBody RegisterAtelierRequest request) {
        SaveAtelierResponse response = atelierService
            .saveAtelierInfo(authentication.getId(), request);

        return ApiResponse.<SaveAtelierResponse>ok(response);
    }

    @GetMapping(value = "/search", produces = MediaType.APPLICATION_JSON_VALUE)
    public ApiResponse<SearchAtelierResponse> searchOneDayClass(
        @LoginMember Member member,
        @Valid SearchPageRequest request) {
        SearchAtelierResponse response = atelierService.searchAtelier(
            member,
            request.getKeyWord(),
            request.convertToPageRequest(Atelier.class)
        );

        return ApiResponse.<SearchAtelierResponse>ok(response);
    }

}
