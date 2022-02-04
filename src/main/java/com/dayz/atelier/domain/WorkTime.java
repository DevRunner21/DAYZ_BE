package com.dayz.atelier.domain;

import java.time.LocalTime;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.util.Assert;

@Getter
@NoArgsConstructor
@Embeddable
public class WorkTime {

    @Column(name = "work_start_time")
    private Long startTime;

    @Column(name = "work_end_time")
    private Long endTime;

    @Builder
    private WorkTime(LocalTime startTime, LocalTime endTime) {
        Assert.notNull(startTime, "startTime must be not null.");
        Assert.notNull(endTime, "endTime must be not null.");

        this.startTime = convertLocalTimeToSecond(startTime);
        this.endTime = convertLocalTimeToSecond(endTime);
    }

//    @Builder
//    private WorkTime(Long startTime, Long endTime) {
//        Assert.notNull(startTime, "startTime must be not null.");
//        Assert.notNull(endTime, "endTime must be not null.");
//
//        this.startTime = startTime;
//        this.endTime = endTime;
//    }

    public Long convertLocalTimeToSecond(LocalTime nowTime) {
        return (long) ((nowTime.getHour() * 3600) + (nowTime.getMinute() * 60) + nowTime.getSecond());
    }

    public LocalTime convertSecondsToLocalTime(Long seconds) {
        return LocalTime.ofSecondOfDay(seconds);
    }

}
