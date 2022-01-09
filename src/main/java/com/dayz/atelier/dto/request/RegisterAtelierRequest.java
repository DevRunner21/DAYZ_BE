package com.dayz.atelier.dto.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
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

    @ApiModelProperty(value = "공방 이름", dataType = "string", example = "지훈공방")
    @NotBlank(message = "name is not blank")
    private String name;

    @ApiModelProperty(value = "공방 사업자 등록 번호", dataType = "string", example = "1111222334")
    @NotBlank(message = "businessNumber is not blank")
    private String businessNumber;

    @ApiModelProperty(value = "공방 주소", dataType = "object")
    @Valid
    @NotNull(message = "address is not null")
    private AddressResult address;

    @ApiModelProperty(value = "공방 소개", dataType = "string", example = "안녕하세요~! 지훈공방입니다.")
    private String intro;

    @ApiModelProperty(value = "공방 전화번호", dataType = "string", example = "0312234544")
    @NotBlank(message = "callNumber is not blank")
    private String callNumber;

    @ApiModelProperty(value = "공방 오픈시간", dataType = "string", example = "09:30")
    @NotBlank(message = "workStartTime is not blank")
    @Pattern(regexp = "^(([0-1]{1}[0-9]{1})|([2]{1}[0-3]{1})):(([0-5]{1}[0-9]{1}))$", message = "workStartTime must be HH:mm format")
    private String workStartTime;

    @ApiModelProperty(value = "공방 마감시간", dataType = "string", example = "19:30")
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

    @ApiModel(value = "RegisterAtelierRequest.AddressResult")
    @Getter
    @Setter
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    public static class AddressResult {

        @ApiModelProperty(value = "시/군/구 ID", dataType = "number", example = "1")
        @NotNull(message = "cityId is not null")
        private Long cityId;

        @ApiModelProperty(value = "동 ID", dataType = "number", example = "1")
        @NotNull(message = "regionId is not null")
        private Long regionId;

        @ApiModelProperty(value = "상세주소", dataType = "string", example = "율암빌딩 2층 201호")
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
