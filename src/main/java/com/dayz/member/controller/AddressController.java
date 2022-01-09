package com.dayz.member.controller;

import com.dayz.atelier.dto.response.ReadAtelierDetailResponse;
import com.dayz.common.dto.CommonApiResponse;
import com.dayz.member.dto.response.ReadAddressesResponse;
import com.dayz.member.service.AddressService;
import io.swagger.annotations.*;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "AddressController V1", value = "주소 CRUD API를 제공하는 Controller입니다.")
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/addresses")
public class AddressController {

    private final AddressService addressService;

    @ApiOperation(
        value = "주소 목록 조회",
        notes = "주소 목록을 조회합니다.",
        produces = MediaType.APPLICATION_JSON_VALUE
    )
    @ApiResponses({
        @ApiResponse(code = 200, response = ReadAddressesResponse.class, message = "성공")
    })
    @ResponseStatus(HttpStatus.OK)
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public CommonApiResponse<ReadAddressesResponse> readAddresses() {
        return CommonApiResponse.<ReadAddressesResponse>ok(addressService.getAllAddresses());
    }

}
