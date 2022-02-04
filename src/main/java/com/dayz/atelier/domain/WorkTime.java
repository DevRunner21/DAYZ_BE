package com.dayz.atelier.domain;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import lombok.*;
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
    private WorkTime(Long startTime, Long endTime) {
        Assert.notNull(startTime, "startTime must be not null.");
        Assert.notNull(endTime, "endTime must be not null.");

        this.startTime = startTime;
        this.endTime = endTime;
    }

}
