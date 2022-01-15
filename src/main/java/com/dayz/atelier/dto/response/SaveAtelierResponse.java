package com.dayz.atelier.dto.response;

import io.swagger.annotations.ApiModelProperty;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter(AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class SaveAtelierResponse {

    @ApiModelProperty(value = "공방 ID", dataType = "long", example = "1")
    private Long atelierId;

    @ApiModelProperty(value = "변경된 사용자 Token", dataType = "string", example = "sdfsdfjndjfksdfsdfsdsdfmksldmfdsl")
    private String token;

    public static SaveAtelierResponse of(Long atelierId, String token) {
        SaveAtelierResponse saveAtelierResponse = new SaveAtelierResponse();
        saveAtelierResponse.setAtelierId(atelierId);
        saveAtelierResponse.setToken(token);

        return saveAtelierResponse;
    }

}
