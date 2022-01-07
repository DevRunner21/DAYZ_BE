package com.dayz.atelier.dto.request;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class RegisterAtelierRequest {

    @NotBlank(message = "name is not blank")
    private String name;

    @NotBlank(message = "businessNumber is not blank")
    private String businessNumber;

    @Valid
    @NotNull(message = "address is not null")
    private AddressResult address;

    private String intro;

    @NotBlank(message = "callNumber is not blank")
    private String callNumber;

    @NotBlank(message = "workStartTime is not blank")
    @Pattern(regexp = "^(([0-1]{1}[0-9]{1})|([2]{1}[0-3]{1})):(([0-5]{1}[0-9]{1}))$", message = "workStartTime must be HH:mm format")
    private String workStartTime;

    @NotBlank(message = "workEndTime is not blank")
    @Pattern(regexp = "^(([0-1]{1}[0-9]{1})|([2]{1}[0-3]{1})):(([0-5]{1}[0-9]{1}))$", message = "workEndTime must be HH:mm format")
    private String workEndTime;

    public static RegisterAtelierRequest of(String name, String businessNumber,
        AddressResult address,
        String callNumber, String workStartTime, String workEndTime) {
        RegisterAtelierRequest registerAtelierRequest = new RegisterAtelierRequest();
        registerAtelierRequest.setName(name);
        registerAtelierRequest.setBusinessNumber(businessNumber);
        registerAtelierRequest.setAddress(address);
        registerAtelierRequest.setCallNumber(callNumber);
        registerAtelierRequest.setWorkStartTime(workStartTime);
        registerAtelierRequest.setWorkEndTime(workEndTime);

        return registerAtelierRequest;
    }

    @Getter
    @Setter
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    public static class AddressResult {

        @NotNull(message = "cityId is not null")
        private Long cityId;

        @NotNull(message = "regionId is not null")
        private Long regionId;

        @NotBlank(message = "detail is not blank")
        private String detail;

        public static AddressResult of(Long cityId, Long regionId, String detail) {
            AddressResult addressResult = new AddressResult();
            addressResult.setCityId(cityId);
            addressResult.setRegionId(regionId);
            addressResult.setDetail(detail);

            return addressResult;
        }
    }

}
