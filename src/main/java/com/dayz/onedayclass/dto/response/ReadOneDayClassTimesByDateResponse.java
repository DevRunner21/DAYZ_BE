package com.dayz.onedayclass.dto.response;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter(AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ReadOneDayClassTimesByDateResponse {

    @ApiModelProperty(value = "원데이클래스 시간 목록", dataType = "array")
    private List<OneDayClassTimeResult> classTimes;

    public static ReadOneDayClassTimesByDateResponse of(
            List<OneDayClassTimeResult> classTimes) {
        ReadOneDayClassTimesByDateResponse readOneDayClassTimesByDateResponse = new ReadOneDayClassTimesByDateResponse();
        readOneDayClassTimesByDateResponse.setClassTimes(classTimes);

        return readOneDayClassTimesByDateResponse;
    }

    @ApiModel(value = "ReadOneDayClassTimesByDateResponse.OneDayClassTimeResult")
    @Getter
    @Setter(AccessLevel.PRIVATE)
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    public static class OneDayClassTimeResult {

        @ApiModelProperty(value = "원데이클래스 시간 ID", dataType = "number", example = "1")
        private Long classTimeId;

        @ApiModelProperty(value = "현재 예약 인원", dataType = "number", example = "3")
        private int currentPeopleNumber;

        @ApiModelProperty(value = "수업 시작 시간", dataType = "string", example = "13:30")
        private String startTime;

        @ApiModelProperty(value = "수업 종료 시간", dataType = "string", example = "14:30")
        private String endTime;

        @ApiModelProperty(value = "예약 가능 여부", dataType = "boolean", example = "true")
        private Boolean status;

        public static OneDayClassTimeResult of(
                Long classTimeId,
                int currentPeopleNumber,
                String startTime,
                String endTime,
                Boolean status) {
            OneDayClassTimeResult oneDayClassTimeResult = new OneDayClassTimeResult();
            oneDayClassTimeResult.setClassTimeId(classTimeId);
            oneDayClassTimeResult.setCurrentPeopleNumber(currentPeopleNumber);
            oneDayClassTimeResult.setStartTime(startTime);
            oneDayClassTimeResult.setEndTime(endTime);
            oneDayClassTimeResult.setStatus(status);

            return oneDayClassTimeResult;
        }

    }

}
