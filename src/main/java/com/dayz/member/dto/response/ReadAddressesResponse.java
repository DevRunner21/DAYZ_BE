package com.dayz.member.dto.response;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter(AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ReadAddressesResponse {

    @ApiModelProperty(value = "주소 목록", dataType = "array")
    private List<AddressByCityResult> addresses = new ArrayList<>();

    public static ReadAddressesResponse of() {
        return new ReadAddressesResponse();
    }

    public void addAddressByCityResult(AddressByCityResult addressByCityResult) {
        this.addresses.add(addressByCityResult);
    }

    @ApiModel(value = "ReadAddressesResponse.AddressByCityResult")
    @Getter
    @Setter(AccessLevel.PRIVATE)
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    public static class AddressByCityResult {

        @ApiModelProperty(value = "시/군/구 ID", dataType = "number", example = "1")
        private Long cityId;

        @ApiModelProperty(value = "시/군/구 이름", dataType = "string", example = "강남구")
        private String cityName;

        @ApiModelProperty(value = "동 목록", dataType = "array")
        private List<RegionByCityResult> regions = new ArrayList<>();

        public static AddressByCityResult of(Long cityId, String cityName,
            List<RegionByCityResult> regions) {
            AddressByCityResult addressByCityResult = new AddressByCityResult();
            addressByCityResult.setCityId(cityId);
            addressByCityResult.setCityName(cityName);
            addressByCityResult.setRegions(regions);

            return addressByCityResult;
        }

        @ApiModel(value = "ReadAddressesResponse.AddressByCityResult.RegionByCityResult")
        @Getter
        @Setter(AccessLevel.PRIVATE)
        @NoArgsConstructor(access = AccessLevel.PROTECTED)
        public static class RegionByCityResult {

            @ApiModelProperty(value = "동 ID", dataType = "number", example = "1")
            private Long regionId;

            @ApiModelProperty(value = "동 이름", dataType = "string", example = "자곡동")
            private String regionName;

            public static RegionByCityResult of(Long regionId, String regionName) {
                RegionByCityResult regionByCityResult = new RegionByCityResult();
                regionByCityResult.setRegionId(regionId);
                regionByCityResult.setRegionName(regionName);

                return regionByCityResult;
            }

        }

    }

}
