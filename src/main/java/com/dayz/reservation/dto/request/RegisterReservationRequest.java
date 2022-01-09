package com.dayz.reservation.dto.request;

import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class RegisterReservationRequest {

    @ApiModelProperty(value = "원데이클래스 시간 ID", dataType = "number", example = "1")
    @NotNull(message = "classTimeId null이 될 수 없습니다.")
    private Long classTimeId;

    @ApiModelProperty(value = "총 예약 금액", dataType = "number", example = "30000")
    @Min(value = 1, message = "price값은 1 이상이어야 합니다")
    private int price;

    @ApiModelProperty(value = "예약 인원", dataType = "number", example = "3")
    @Min(value = 1, message = "peopelNumber의 값은 1이상이어야 합니다.")
    private int peopleNumber;

}
