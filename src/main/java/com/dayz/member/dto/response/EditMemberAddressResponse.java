package com.dayz.member.dto.response;

import io.swagger.annotations.ApiModelProperty;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter(AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class EditMemberAddressResponse {

    @ApiModelProperty(value = "시/군/구 ID", dataType = "number", example = "1")
    private Long cityId;

    @ApiModelProperty(value = "시/군/구 이름", dataType = "string", example = "강남구")
    private String cityName;

    @ApiModelProperty(value = "동 ID", dataType = "number", example = "1")
    private Long regionId;

    @ApiModelProperty(value = "동 이름", dataType = "string", example = "자곡동")
    private String regionName;

    public static EditMemberAddressResponse of(Long cityId, String cityName, Long regionId, String regionName) {
        EditMemberAddressResponse editMemberAddressResponse = new EditMemberAddressResponse();
        editMemberAddressResponse.setCityId(cityId);
        editMemberAddressResponse.setCityName(cityName);
        editMemberAddressResponse.setRegionId(regionId);
        editMemberAddressResponse.setRegionName(regionName);

        return editMemberAddressResponse;
    }

}
