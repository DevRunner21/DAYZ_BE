package com.dayz.reservation.controller;

import com.dayz.common.aop.LoginMember;
import com.dayz.common.dto.ApiResponse;
import com.dayz.common.dto.CustomPageRequest;
import com.dayz.member.domain.Member;
import com.dayz.reservation.dto.ReadReservationsByAtelierResponse;
import com.dayz.reservation.dto.ReadReservationsByMemberResponse;
import com.dayz.reservation.dto.RegisterReservationRequest;
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
    public ApiResponse<Map<String, Long>> registerReservation(
        @LoginMember Member member,
        @Valid @RequestBody RegisterReservationRequest registerReservationRequest
    ) {
        return ApiResponse.ok(Map.of("reservationId",
            reservationService.saveReservation(registerReservationRequest, member)));
    }

    @GetMapping(value = "/reservations", produces = MediaType.APPLICATION_JSON_VALUE)
    public ApiResponse<ReadReservationsByMemberResponse> readReservationsByMember(
        @LoginMember Member member,
        @Valid CustomPageRequest pageRequest
    ) {
        ReadReservationsByMemberResponse myReservation = reservationService.getReservationsByMember(
            pageRequest,
            member.getId()
        );

        return ApiResponse.<ReadReservationsByMemberResponse>ok(myReservation);
    }

    // TODO : URL 규칙대로 변경 필요
    @GetMapping(value = "/reservations/ateliers/{atelierId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ApiResponse<ReadReservationsByAtelierResponse> readReservationsByAtelier(
        @PathVariable("atelierId") Long atelierId,
        @Valid CustomPageRequest pageRequest
    ) {
        ReadReservationsByAtelierResponse response = reservationService.getReservationsByAtelier(
            pageRequest,
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
