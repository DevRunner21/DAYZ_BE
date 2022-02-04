package com.dayz.reservation.converter;

import com.dayz.member.domain.Member;
import com.dayz.onedayclass.domain.OneDayClassTime;
import com.dayz.reservation.domain.Reservation;
import com.dayz.reservation.dto.query.ReservationInfoProjection;
import com.dayz.reservation.dto.request.RegisterReservationRequest;
import com.dayz.reservation.dto.response.ReadReservationsByAtelierResponse;
import com.dayz.reservation.dto.response.ReadReservationsByMemberResponse;
import java.time.LocalDate;
import java.time.LocalTime;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ReservationConverter {

    public Reservation convertToReservation(
        RegisterReservationRequest registerReservationRequest,
        Member member,
        OneDayClassTime oneDayClassTime
    ) {
        return Reservation.builder()
            .peopleNumber(registerReservationRequest.getPeopleNumber())
            .price(registerReservationRequest.getPrice())
            .reservationDate(LocalDate.now())
            .member(member)
            .oneDayClassTime(oneDayClassTime)
            .build();
    }

    public ReadReservationsByMemberResponse.ReservationResult convertReadReservationsByMemberReservationResult(
        ReservationInfoProjection reservationInfoProjection
    ) {
        return ReadReservationsByMemberResponse.ReservationResult.of(
            reservationInfoProjection.getReservationId(),
            reservationInfoProjection.getClassName(),
            reservationInfoProjection.getReservationDate(),
            reservationInfoProjection.getClassDate(),
            LocalTime.ofSecondOfDay(reservationInfoProjection.getStartTime()),
            LocalTime.ofSecondOfDay(reservationInfoProjection.getEndTime()),
            reservationInfoProjection.getStatus());
    }

    public ReadReservationsByAtelierResponse.ReservationResult convertReadReservationsByAtelierReservationResult(
        ReservationInfoProjection reservationInfoProjection
    ) {
        return ReadReservationsByAtelierResponse.ReservationResult.of(
            reservationInfoProjection.getReservationId(),
            reservationInfoProjection.getClassName(),
            reservationInfoProjection.getReservationDate(),
            reservationInfoProjection.getClassDate(),
            LocalTime.ofSecondOfDay(reservationInfoProjection.getStartTime()),
            LocalTime.ofSecondOfDay(reservationInfoProjection.getEndTime()),
            reservationInfoProjection.getStatus());
    }

}
