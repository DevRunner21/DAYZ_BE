package com.dayz.reservation.service;

import com.dayz.atelier.domain.Atelier;
import com.dayz.atelier.domain.AtelierRepository;
import com.dayz.common.enums.ErrorInfo;
import com.dayz.common.exception.BusinessException;
import com.dayz.member.domain.Member;
import com.dayz.member.domain.MemberRepository;
import com.dayz.onedayclass.domain.OneDayClassTime;
import com.dayz.onedayclass.domain.OneDayClassTimeRepository;
import com.dayz.reservation.converter.ReservationConverter;
import com.dayz.reservation.domain.Reservation;
import com.dayz.reservation.domain.ReservationRepository;
import com.dayz.reservation.dto.response.ReadReservationsByAtelierResponse;
import com.dayz.reservation.dto.response.ReadReservationsByMemberResponse;
import com.dayz.reservation.dto.request.RegisterReservationRequest;
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

    private final MemberRepository memberRepository;

    private final AtelierRepository atelierRepository;

    private final ReservationConverter reservationConverter;

    private final OneDayClassTimeRepository oneDayClassTimeRepository;

    @Transactional
    public Long saveReservation(
        RegisterReservationRequest registerReservationRequest,
        Long memberId
    ) {
        Member foundMember = memberRepository.findById(memberId)
            .orElseThrow(() -> new BusinessException(ErrorInfo.MEMBER_NOT_FOUND));

        OneDayClassTime oneDayClassTime = oneDayClassTimeRepository.findById(
            registerReservationRequest.getClassTimeId())
            .orElseThrow(() -> new BusinessException(ErrorInfo.ONE_DAY_CLASS_TIME_NOT_FOUND));

        Reservation reservation = reservationConverter.convertToReservation(
            registerReservationRequest, foundMember, oneDayClassTime);

        return reservationRepository.save(reservation).getId();
    }

    public ReadReservationsByMemberResponse getReservationsByMember(
        PageRequest pageRequest,
        Long memberId
    ) {
        Member foundMember = memberRepository.findById(memberId)
            .orElseThrow(() -> new BusinessException(ErrorInfo.MEMBER_NOT_FOUND));

        Page<ReadReservationsByMemberResponse.ReservationResult> responsePage =
            reservationRepository.findReservationsByMember(foundMember.getId(), pageRequest)
                .map(reservationConverter::convertReadReservationsByMemberReservationResult);

        return ReadReservationsByMemberResponse.of(responsePage);
    }

    public ReadReservationsByAtelierResponse getReservationsByAtelier(
        PageRequest pageRequest,
        Long atelierId
    ) {
        Atelier foundAtelier = atelierRepository.findById(atelierId)
            .orElseThrow(() -> new BusinessException(ErrorInfo.ATELIER_NOT_FOUND));

        Page<ReadReservationsByAtelierResponse.ReservationResult> responsePage =
            reservationRepository.findReservationsByAtelier(foundAtelier.getId(), pageRequest)
                .map(reservationConverter::convertReadReservationsByAtelierReservationResult);

        return ReadReservationsByAtelierResponse.of(responsePage);
    }

    @Transactional
    public void deleteReservation(Long reservationId) {
        Reservation foundReservation = reservationRepository.findById(reservationId)
            .orElseThrow(() -> new BusinessException(ErrorInfo.RESERVATION_NOT_FOUND));

        foundReservation.changeUseFlag(false);
    }

}
