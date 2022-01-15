package com.dayz.onedayclass.domain;

import com.dayz.common.entity.BaseEntity;
import com.dayz.common.enums.ErrorInfo;
import com.dayz.common.enums.TimeStatus;
import com.dayz.common.exception.BusinessException;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import javax.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Where;

@Entity
@Getter
@Setter(AccessLevel.PRIVATE)
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

    public static OneDayClassTime of(Long id,
        LocalDate classDate,
        Long startTime,
        Long endTime,
        TimeStatus status,
        OneDayClass oneDayClass
    ) {
        OneDayClassTime oneDayClassTime = new OneDayClassTime();
        oneDayClassTime.setId(id);
        oneDayClassTime.setClassDate(classDate);
        oneDayClassTime.setStartTime(startTime);
        oneDayClassTime.setEndTime(endTime);
        oneDayClassTime.setStatus(status);
        oneDayClassTime.changeOneDayClass(oneDayClass);

        return oneDayClassTime;
    }

    public static OneDayClassTime of(LocalDate classDate,
        Long startTime,
        Long endTime,
        TimeStatus status,
        OneDayClass oneDayClass
    ) {
        OneDayClassTime oneDayClassTime = new OneDayClassTime();
        oneDayClassTime.setClassDate(classDate);
        oneDayClassTime.setStartTime(startTime);
        oneDayClassTime.setEndTime(endTime);
        oneDayClassTime.setStatus(status);
        oneDayClassTime.changeOneDayClass(oneDayClass);

        return oneDayClassTime;
    }

    public static OneDayClassTime of(LocalDate classDate,
        Long startTime,
        Long endTime,
        TimeStatus status
    ) {
        OneDayClassTime oneDayClassTime = new OneDayClassTime();
        oneDayClassTime.setClassDate(classDate);
        oneDayClassTime.setStartTime(startTime);
        oneDayClassTime.setEndTime(endTime);
        oneDayClassTime.setStatus(status);

        return oneDayClassTime;
    }

    public void changeOneDayClass(OneDayClass oneDayClass) {
        this.setOneDayClass(oneDayClass);
    }

    public boolean validateReservationPossibleDateTime() {
        long secondOfOverDateTime = Duration.between(
            LocalDateTime.of(classDate, LocalTime.ofSecondOfDay(startTime)),
            LocalDateTime.now()
        ).toSeconds();

        // 예약 가능 날짜, 시간이 지난경우
        if (secondOfOverDateTime > 0) {
            return false;
        }
        return true;
    }

    public boolean validateReservationPossiblePeopleNumber(int requestPeopleNumber, int currentReservationPeopleNumber) {
        int possibleReservationPeopleNumber =
            oneDayClass.getMaxPeopleNumber() - currentReservationPeopleNumber;

        // 예약 가능한 인원을 초과한 경우
        if (requestPeopleNumber > possibleReservationPeopleNumber) {
            return false;
        }

        return true;
    }

}
