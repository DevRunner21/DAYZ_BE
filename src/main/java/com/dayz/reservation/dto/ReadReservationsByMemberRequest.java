package com.dayz.reservation.dto;

import com.dayz.common.dto.CustomPageRequest;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ReadReservationsByMemberRequest extends CustomPageRequest {

}
