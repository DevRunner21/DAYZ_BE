package com.dayz.onedayclass.dto.response;

import io.swagger.annotations.ApiModelProperty;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter(AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class RegisterOneDayClassResponse {

    @ApiModelProperty(value = "원데이클래스 ID", dataType = "number", example = "1")
    private Long oneDayClassId;

    public static RegisterOneDayClassResponse of(Long oneDayClassId) {
        RegisterOneDayClassResponse registerOneDayClassResponse = new RegisterOneDayClassResponse();
        registerOneDayClassResponse.setOneDayClassId(oneDayClassId);

        return registerOneDayClassResponse;
    }

}
