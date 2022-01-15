package com.dayz.reservation.converter;

import com.dayz.common.util.TimeUtil;
import com.dayz.member.domain.Member;
import com.dayz.onedayclass.domain.OneDayClassTime;
import com.dayz.reservation.domain.Reservation;
import com.dayz.reservation.dto.response.ReadReservationsByAtelierResponse;
import com.dayz.reservation.dto.response.ReadReservationsByMemberResponse;
import com.dayz.reservation.dto.request.RegisterReservationRequest;
import com.dayz.reservation.dto.query.ReservationInfoProjection;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ReservationConverter {

    private final TimeUtil timeUtil;

    public Reservation convertToReservation(
        RegisterReservationRequest registerReservationRequest,
        Member member,
        OneDayClassTime oneDayClassTime
    ) {
        return Reservation
            .of(registerReservationRequest.getPeopleNumber(), registerReservationRequest
                    .getPrice(),
                LocalDate.now(), member, oneDayClassTime);
    }

    public ReadReservationsByMemberResponse.ReservationResult convertReadReservationsByMemberReservationResult(
        ReservationInfoProjection reservationInfoProjection
    ) {
        return ReadReservationsByMemberResponse.ReservationResult.of(
            reservationInfoProjection.getReservationId(),
            reservationInfoProjection.getClassName(),
            convertToDate(reservationInfoProjection.getReservationDate()),
            convertToDate(reservationInfoProjection.getClassDate()),
            timeUtil.secondToTimeString(reservationInfoProjection.getStartTime()),
            timeUtil.secondToTimeString(reservationInfoProjection.getEndTime()),
            reservationInfoProjection.getStatus());
    }

    public ReadReservationsByAtelierResponse.ReservationResult convertReadReservationsByAtelierReservationResult(
        ReservationInfoProjection reservationInfoProjection
    ) {
        return ReadReservationsByAtelierResponse.ReservationResult.of(
            reservationInfoProjection.getReservationId(),
            reservationInfoProjection.getClassName(),
            convertToDate(reservationInfoProjection.getReservationDate()),
            convertToDate(reservationInfoProjection.getClassDate()),
            timeUtil.secondToTimeString(reservationInfoProjection.getStartTime()),
            timeUtil.secondToTimeString(reservationInfoProjection.getEndTime()),
            reservationInfoProjection.getStatus());
    }

    public String convertToDate(LocalDate date) {
        return date.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
    }

}
