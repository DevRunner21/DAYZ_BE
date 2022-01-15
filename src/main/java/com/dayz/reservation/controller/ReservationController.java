package com.dayz.reservation.controller;

import com.dayz.common.aop.LoginMemberId;
import com.dayz.common.dto.CommonApiResponse;
import com.dayz.reservation.domain.Reservation;
import com.dayz.reservation.dto.request.ReadReservationsByAtelierRequest;
import com.dayz.reservation.dto.request.ReadReservationsByMemberRequest;
import com.dayz.reservation.dto.request.RegisterReservationRequest;
import com.dayz.reservation.dto.response.ReadReservationsByAtelierResponse;
import com.dayz.reservation.dto.response.ReadReservationsByMemberResponse;
import com.dayz.reservation.dto.response.RegisterReservationResponse;
import com.dayz.reservation.service.ReservationService;
import io.swagger.annotations.*;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

@Api(tags = "ReservationController V1", value = "예약 CRUD API를 제공하는 Controller입니다.")
@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/api/v1")
public class ReservationController {

    private final ReservationService reservationService;

    @ApiOperation(
        value = "사용자 별 예약 목록 조회",
        notes = "사용자 별 예약 목록을 조회합니다.",
        produces = MediaType.APPLICATION_JSON_VALUE
    )
    @ApiResponses({
        @ApiResponse(code = 200, response = ReadReservationsByMemberResponse.class, message = "성공")
    })
    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/reservations", produces = MediaType.APPLICATION_JSON_VALUE)
    public CommonApiResponse<ReadReservationsByMemberResponse> readReservationsByMember(
        @ApiIgnore @LoginMemberId Long memberId,
        @Valid ReadReservationsByMemberRequest request
    ) {
        ReadReservationsByMemberResponse myReservation = reservationService.getReservationsByMember(
            request.convertToPageRequest(Reservation.class),
            memberId
        );

        return CommonApiResponse.<ReadReservationsByMemberResponse>ok(myReservation);
    }

    // TODO : URL 규칙대로 변경 필요
    @ApiOperation(
        value = "공방 별 예약 목록 조회",
        notes = "공방 별 예약 목록을 조회합니다.",
        produces = MediaType.APPLICATION_JSON_VALUE
    )
    @ApiImplicitParams({
        @ApiImplicitParam(name = "atelierId", value = "공방 ID", required = true, dataType = "Long", paramType = "path", defaultValue = ""),
    })
    @ApiResponses({
        @ApiResponse(code = 200, response = ReadReservationsByAtelierResponse.class, message = "성공")
    })
    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/reservations/ateliers/{atelierId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public CommonApiResponse<ReadReservationsByAtelierResponse> readReservationsByAtelier(
        @PathVariable("atelierId") Long atelierId,
        @Valid ReadReservationsByAtelierRequest request
    ) {
        ReadReservationsByAtelierResponse response = reservationService.getReservationsByAtelier(
            request.convertToPageRequest(Reservation.class),
            atelierId
        );

        return CommonApiResponse.<ReadReservationsByAtelierResponse>ok(response);
    }

    @ApiOperation(
        value = "예약하기",
        notes = "예약을 등록합니다.",
        produces = MediaType.APPLICATION_JSON_VALUE
    )
    @ApiResponses({
        @ApiResponse(code = 200, response = RegisterReservationResponse.class, message = "성공")
    })
    @ResponseStatus(HttpStatus.OK)
    @PostMapping(value = "/reservations", produces = MediaType.APPLICATION_JSON_VALUE)
    public CommonApiResponse<RegisterReservationResponse> registerReservation(
        @ApiIgnore @LoginMemberId Long memberId,
        @Valid @RequestBody RegisterReservationRequest registerReservationRequest
    ) {
        Long registeredReservationId = reservationService
            .saveReservation(registerReservationRequest, memberId);

        return CommonApiResponse.ok(RegisterReservationResponse.of(registeredReservationId));
    }

    @ApiOperation(
        value = "예약 취소하기",
        notes = "예약을 삭제합니다.",
        produces = MediaType.APPLICATION_JSON_VALUE
    )
    @ApiImplicitParams({
        @ApiImplicitParam(name = "reservationId", value = "예약 ID", required = true, dataType = "Long", paramType = "path", defaultValue = ""),
    })
//    @ApiResponses({
//        @ApiResponse(code = 200, response = ReadOneDayClassesByCategoryResponse.class, message = "성공")
//    })
    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping(value = "/reservations/{reservationId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public CommonApiResponse deleteReservation(@PathVariable("reservationId") Long reservationId) {
        reservationService.deleteReservation(reservationId);

        return CommonApiResponse.noContent();
    }

}
