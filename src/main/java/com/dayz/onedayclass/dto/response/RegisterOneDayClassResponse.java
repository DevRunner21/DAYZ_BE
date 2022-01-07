package com.dayz.onedayclass.dto.response;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter(AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class RegisterOneDayClassResponse {

    private Long oneDayClassId;

    public static RegisterOneDayClassResponse of(Long oneDayClassId) {
        RegisterOneDayClassResponse registerOneDayClassResponse = new RegisterOneDayClassResponse();
        registerOneDayClassResponse.setOneDayClassId(oneDayClassId);

        return registerOneDayClassResponse;
    }

}
