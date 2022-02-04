package com.dayz.onedayclass.converter;

import com.dayz.common.enums.TimeStatus;
import com.dayz.onedayclass.dto.response.ReadOneDayClassTimesByDateResponse;
import com.dayz.onedayclass.dto.query.CurrentOneDayClassTime;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class OneDayClassTimeConverter {

    public ReadOneDayClassTimesByDateResponse convertToReadOneDayClassTimesByDateResponse(
        List<CurrentOneDayClassTime> oneDayClassTimes
    ) {
        return ReadOneDayClassTimesByDateResponse.of(
            oneDayClassTimes.stream()
                .map(this::convertToReadOneDayClassTimesByDateOneDayClassTimeResult)
                .collect(Collectors.toList())
        );
    }

    public ReadOneDayClassTimesByDateResponse.OneDayClassTimeResult convertToReadOneDayClassTimesByDateOneDayClassTimeResult(
        CurrentOneDayClassTime oneDayClassTime
    ) {
        return ReadOneDayClassTimesByDateResponse.OneDayClassTimeResult.of(
            oneDayClassTime.getClassTimeId(),
            oneDayClassTime.getCurrentPeopleNumber(),
            LocalTime.ofSecondOfDay(oneDayClassTime.getStartTime()),
            LocalTime.ofSecondOfDay(oneDayClassTime.getEndTime()),
            checkTimeStatus(oneDayClassTime)
        );
    }

    private boolean checkTimeStatus(CurrentOneDayClassTime classTimeQuery) {
        LocalDateTime now = LocalDateTime.now();

        return classTimeQuery.getStatus().equals(TimeStatus.PROCESS.getValue())
            && (classTimeQuery.getCurrentPeopleNumber() < classTimeQuery.getMaxPeopleNumber())
            && (now.toLocalTime().toSecondOfDay()) < classTimeQuery.getStartTime();
    }

}
