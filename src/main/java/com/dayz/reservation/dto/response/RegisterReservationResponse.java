package com.dayz.reservation.dto.response;

import io.swagger.annotations.ApiModelProperty;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter(AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class RegisterReservationResponse {

    @ApiModelProperty(value = "예약 ID", dataType = "number", example = "1")
    private Long reservationId;

    public static RegisterReservationResponse of(Long reservationId) {
        RegisterReservationResponse registerReservationResponse = new RegisterReservationResponse();
        registerReservationResponse.setReservationId(reservationId);

        return registerReservationResponse;
    }

}
