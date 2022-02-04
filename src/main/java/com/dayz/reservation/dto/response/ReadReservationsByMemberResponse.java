package com.dayz.reservation.dto.response;

import com.dayz.common.dto.CustomPageResponse;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.time.LocalDate;
import java.time.LocalTime;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.domain.Page;

@Getter
@Setter(AccessLevel.PRIVATE)
@NoArgsConstructor
public class ReadReservationsByMemberResponse extends CustomPageResponse<ReadReservationsByMemberResponse.ReservationResult> {

  private ReadReservationsByMemberResponse(Page tPage) {
    super(tPage);
  }

  public static ReadReservationsByMemberResponse of(Page tPage) {
    return new ReadReservationsByMemberResponse(tPage);
  }

  @ApiModel(value = "ReadReservationsByMemberResponse.ReservationResult")
  @Getter
  @Setter(AccessLevel.PRIVATE)
  @NoArgsConstructor
  public static class ReservationResult {

    @ApiModelProperty(value = "예약 ID", dataType = "number", example = "1")
    private Long reservationId;

    @ApiModelProperty(value = "원데이클래스 이름", dataType = "string", example = "재미이쓴 도자기 클래스")
    private String className;

    @ApiModelProperty(value = "예약날짜", dataType = "string", example = "2022-01-07")
    private LocalDate reservationDate;

    @ApiModelProperty(value = "클래스 시작 날짜", dataType = "string", example = "2022-01-09")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate classDate;

    @ApiModelProperty(value = "수업 시작 시간", dataType = "string", example = "13:30")
    @JsonFormat(pattern = "HH:mm")
    private LocalTime startTime;

    @ApiModelProperty(value = "수업 종료 시간", dataType = "string", example = "14:30")
    @JsonFormat(pattern = "HH:mm")
    private LocalTime endTime;

    @ApiModelProperty(value = "예약 상태", dataType = "string", example = "ACCEPTED")
    private String status;

    public static ReservationResult of(
        Long reservationId,
        String className,
        LocalDate reservationDate,
        LocalDate classDate,
        LocalTime startTime,
        LocalTime endTime,
        String status
    ) {

      ReadReservationsByMemberResponse.ReservationResult reservationResult = new ReservationResult();
      reservationResult.setReservationId(reservationId);
      reservationResult.setClassName(className);
      reservationResult.setReservationDate(reservationDate);
      reservationResult.setClassDate(classDate);
      reservationResult.setStartTime(startTime);
      reservationResult.setEndTime(endTime);
      reservationResult.setStatus(status);

      return reservationResult;
    }

  }

}
