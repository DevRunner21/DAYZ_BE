package com.dayz.member.controller;

import com.dayz.common.dto.ApiResponse;
import com.dayz.member.dto.ReadAddressesResponse;
import com.dayz.member.service.AddressService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/addresses")
public class AddressController {

    private final AddressService addressService;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ApiResponse<ReadAddressesResponse> readAddresses() {
        return ApiResponse.<ReadAddressesResponse>ok(addressService.getAllAddresses());
    }

}
