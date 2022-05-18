package com.dayz.reservation.converter;

import com.dayz.common.enums.ReservationStatus;
import com.dayz.member.domain.Member;
import com.dayz.onedayclass.domain.OneDayClass;
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
        int price,
        int peopleNumber,
        ReservationStatus status,
        Member member,
        OneDayClass oneDayClass,
        OneDayClassTime oneDayClassTime
    ) {
        return Reservation.builder()
            .peopleNumber(peopleNumber)
            .price(price)
            .reservationDate(LocalDate.now())
            .status(status)
            .oneDayClassId(oneDayClass.getId())
            .oneDayClassName(oneDayClass.getName())
            .oneDayClassTimeId(oneDayClassTime.getId())
            .oneDayClassDate(oneDayClassTime.getClassDate())
            .oneDayClassStartTime(oneDayClassTime.getStartTime())
            .oneDayClassEndTime(oneDayClassTime.getEndTime())
            .atelierId(oneDayClass.getAtelierId())
            .memberId(member.getId())
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
