package com.dayz.reservation.dto.response;

import com.dayz.common.dto.CustomPageResponse;
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

  @Getter
  @Setter(AccessLevel.PRIVATE)
  @NoArgsConstructor
  public static class ReservationResult {

    private Long reservationId;

    private String className;

    private String reservationDate;

    private String classDate;

    private String startTime;

    private String endTime;

    private String status;

    public static ReservationResult of(
        Long reservationId,
        String className,
        String reservationDate,
        String classDate,
        String startTime,
        String endTime,
        String status
    ) {

      ReservationResult reservationResult = new ReservationResult();
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
