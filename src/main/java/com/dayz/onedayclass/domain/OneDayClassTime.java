package com.dayz.onedayclass.domain;

import com.dayz.common.entity.BaseEntity;
import com.dayz.common.enums.TimeStatus;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import javax.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Where;
import org.springframework.util.Assert;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Where(clause = "use_flag = true")
@Table(name = "onedayclass_time")
public class OneDayClassTime extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "onedayclass_time_id")
    private Long id;

    @Column(name = "class_date", nullable = false)
    private LocalDate classDate;

    @Column(name = "start_time", nullable = false)
    private Long startTime;

    @Column(name = "end_time", nullable = false)
    private Long endTime;

    @Enumerated(EnumType.STRING)
    private TimeStatus status;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "onedayclass_id", foreignKey = @ForeignKey(name = "fk_onedayclass_time_to_onedayclass"))
    private OneDayClass oneDayClass;

    @Builder
    private OneDayClassTime(Long id, LocalDate classDate, Long startTime, Long endTime, TimeStatus status, OneDayClass oneDayClass) {
        Assert.notNull(classDate, "classDate must be not null");
        Assert.notNull(startTime, "startTime must be not null");
        Assert.notNull(endTime, "endTime must be not null");
        Assert.notNull(status, "status must be not null");
        Assert.notNull(oneDayClass, "oneDayClass must be not null");

        this.id = id;
        this.classDate = classDate;
        this.startTime = startTime;
        this.endTime = endTime;
        this.status = status;
        changeOneDayClass(oneDayClass);
    }

    public void changeOneDayClass(OneDayClass oneDayClass) {
        this.oneDayClass = oneDayClass;
    }

    public boolean validateReservationPossibleDateTime() {
        long secondOfOverDateTime = Duration.between(
            LocalDateTime.of(classDate, LocalTime.ofSecondOfDay(startTime)),
            LocalDateTime.now()
        ).toSeconds();

        // 예약 가능 날짜, 시간이 지난경우
        return secondOfOverDateTime <= 0;
    }

    public boolean validateReservationPossiblePeopleNumber(int requestPeopleNumber, int currentReservationPeopleNumber) {
        int possibleReservationPeopleNumber =
            oneDayClass.getMaxPeopleNumber() - currentReservationPeopleNumber;

        return requestPeopleNumber <= possibleReservationPeopleNumber;
    }

}
