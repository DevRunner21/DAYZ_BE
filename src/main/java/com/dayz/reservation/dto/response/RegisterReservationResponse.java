package com.dayz.reservation.dto.response;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter(AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class RegisterReservationResponse {

    private Long reservationId;

    public static RegisterReservationResponse of(Long reservationId) {
        RegisterReservationResponse registerReservationResponse = new RegisterReservationResponse();
        registerReservationResponse.setReservationId(reservationId);

        return registerReservationResponse;
    }

}
