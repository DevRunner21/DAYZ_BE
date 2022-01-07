package com.dayz.reservation.service;

import com.dayz.common.dto.CustomPageRequest;
import com.dayz.common.enums.ErrorInfo;
import com.dayz.common.exception.BusinessException;
import com.dayz.member.domain.Member;
import com.dayz.onedayclass.domain.OneDayClassTime;
import com.dayz.onedayclass.domain.OneDayClassTimeRepository;
import com.dayz.reservation.converter.ReservationConverter;
import com.dayz.reservation.domain.Reservation;
import com.dayz.reservation.domain.ReservationRepository;
import com.dayz.reservation.dto.ReadReservationsByAtelierResponse;
import com.dayz.reservation.dto.ReadReservationsByMemberResponse;
import com.dayz.reservation.dto.RegisterReservationRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ReservationService {

    private final ReservationRepository reservationRepository;

    private final ReservationConverter reservationConverter;

    private final OneDayClassTimeRepository oneDayClassTimeRepository;

    @Transactional
    public Long saveReservation(
        RegisterReservationRequest registerReservationRequest,
        Member member
    ) {
        OneDayClassTime oneDayClassTime = oneDayClassTimeRepository.findById(
            registerReservationRequest.getClassTimeId())
            .orElseThrow(() -> new BusinessException(ErrorInfo.ONE_DAY_CLASS_TIME_NOT_FOUND));

        Reservation reservation = reservationConverter.convertToReservation(
            registerReservationRequest, member, oneDayClassTime);

        return reservationRepository.save(reservation).getId();
    }

    public ReadReservationsByMemberResponse getReservationsByMember(
        CustomPageRequest pageRequest,
        Long memberId
    ) {
        PageRequest pageable = pageRequest.convertToPageRequest(Reservation.class);

        Page<ReadReservationsByMemberResponse.ReservationResult> responsePage =
            reservationRepository.findReservationsByMember(memberId, pageable)
            .map(reservationConverter::convertReadReservationsByMemberReservationResult);

        return ReadReservationsByMemberResponse.of(responsePage);
    }

    public ReadReservationsByAtelierResponse getReservationsByAtelier(
        CustomPageRequest pageRequest,
        Long atelierId
    ) {
        PageRequest pageable = pageRequest.convertToPageRequest(Reservation.class);

        Page<ReadReservationsByAtelierResponse.ReservationResult> responsePage =
            reservationRepository.findReservationsByAtelier(atelierId, pageable)
            .map(reservationConverter::convertReadReservationsByAtelierReservationResult);

        return ReadReservationsByAtelierResponse.of(responsePage);
    }

    @Transactional
    public void deleteReservation(Long reservationId) {
        Reservation reservation = reservationRepository.findById(reservationId)
            .orElseThrow(() -> new BusinessException(ErrorInfo.RESERVATION_NOT_FOUND));
        reservation.changeUseFlag(false);
    }

}
