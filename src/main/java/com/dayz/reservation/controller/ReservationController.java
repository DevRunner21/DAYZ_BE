package com.dayz.reservation.controller;

import com.dayz.common.aop.LoginMemberId;
import com.dayz.common.dto.ApiResponse;
import com.dayz.member.domain.Member;
import com.dayz.reservation.domain.Reservation;
import com.dayz.reservation.dto.request.ReadReservationsByAtelierRequest;
import com.dayz.reservation.dto.request.ReadReservationsByMemberRequest;
import com.dayz.reservation.dto.request.RegisterReservationRequest;
import com.dayz.reservation.dto.response.ReadReservationsByAtelierResponse;
import com.dayz.reservation.dto.response.ReadReservationsByMemberResponse;
import com.dayz.reservation.dto.response.RegisterReservationResponse;
import com.dayz.reservation.service.ReservationService;
import java.util.Map;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/api/v1")
public class ReservationController {

    private final ReservationService reservationService;

    @PostMapping(value = "/reservations", produces = MediaType.APPLICATION_JSON_VALUE)
    public ApiResponse<RegisterReservationResponse> registerReservation(
        @LoginMemberId Long memberId,
        @Valid @RequestBody RegisterReservationRequest registerReservationRequest
    ) {
        Long registeredReservationId = reservationService.saveReservation(registerReservationRequest, memberId);

        return ApiResponse.ok(RegisterReservationResponse.of(registeredReservationId));
    }

    @GetMapping(value = "/reservations", produces = MediaType.APPLICATION_JSON_VALUE)
    public ApiResponse<ReadReservationsByMemberResponse> readReservationsByMember(
        @LoginMemberId Long memberId,
        @Valid ReadReservationsByMemberRequest request
    ) {
        ReadReservationsByMemberResponse myReservation = reservationService.getReservationsByMember(
            request.convertToPageRequest(Reservation.class),
            memberId
        );

        return ApiResponse.<ReadReservationsByMemberResponse>ok(myReservation);
    }

    // TODO : URL 규칙대로 변경 필요
    @GetMapping(value = "/reservations/ateliers/{atelierId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ApiResponse<ReadReservationsByAtelierResponse> readReservationsByAtelier(
        @PathVariable("atelierId") Long atelierId,
        @Valid ReadReservationsByAtelierRequest request
    ) {
        ReadReservationsByAtelierResponse response = reservationService.getReservationsByAtelier(
            request.convertToPageRequest(Reservation.class),
            atelierId
        );

        return ApiResponse.<ReadReservationsByAtelierResponse>ok(response);
    }

    @DeleteMapping(value = "/reservations/{reservationId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ApiResponse deleteReservation(@PathVariable("reservationId") Long reservationId) {
        reservationService.deleteReservation(reservationId);

        return ApiResponse.noContent();
    }

}
