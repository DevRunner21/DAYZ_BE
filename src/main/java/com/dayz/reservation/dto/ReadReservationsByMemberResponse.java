package com.dayz.reservation.dto;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter(AccessLevel.PRIVATE)
@NoArgsConstructor
public class ReadReservationsByMemberResponse {

  private Long reservationId;

  private String className;

  private String reservationDate;

  private String classDate;

  private String startTime;

  private String endTime;

  private String status;

  public static ReadReservationsByMemberResponse of(Long reservationId, String className,
      String reservationDate, String classDate, String startTime, String endTime,
      String status) {

    ReadReservationsByMemberResponse readReservationsByMemberResponse = new ReadReservationsByMemberResponse();
    readReservationsByMemberResponse.setReservationId(reservationId);
    readReservationsByMemberResponse.setClassName(className);
    readReservationsByMemberResponse.setReservationDate(reservationDate);
    readReservationsByMemberResponse.setClassDate(classDate);
    readReservationsByMemberResponse.setStartTime(startTime);
    readReservationsByMemberResponse.setEndTime(endTime);
    readReservationsByMemberResponse.setStatus(status);

    return readReservationsByMemberResponse;
  }
}
