package com.dayz.reservation.domain;

import com.dayz.common.entity.BaseEntity;
import com.dayz.common.enums.ReservationStatus;
import java.time.LocalDate;
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
@Table(name = "reservation")

public class Reservation extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "reservation_id")
    private Long id;

    @Column(name = "people_number")
    private int peopleNumber;

    @Column(name = "price")
    private int price;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private ReservationStatus status;

    @Column(name = "reservation_date", nullable = false)
    private LocalDate reservationDate;

    @Column(name = "class_id", nullable = false)
    private Long oneDayClassId;

    @Column(name = "class_name", nullable = false, length = 50)
    private String oneDayClassName;

    @Column(name = "class_date", nullable = false)
    private LocalDate oneDayClassDate;

    @Column(name = "class_time_id", nullable = false)
    private Long oneDayClassTimeId;

    @Column(name = "class_start_time", nullable = false)
    private Long oneDayClassStartTime;

    @Column(name = "class_end_time", nullable = false)
    private Long oneDayClassEndTime;

    @Column(name = "atelier_id", nullable = false)
    private Long atelierId;

    @Column(name = "member_id", nullable = false)
    private Long memberId;

    @Builder
    private Reservation(
        Long id,
        int peopleNumber,
        int price,
        ReservationStatus status,
        LocalDate reservationDate,
        Long oneDayClassId,
        String oneDayClassName,
        LocalDate oneDayClassDate,
        Long oneDayClassTimeId,
        Long oneDayClassStartTime,
        Long oneDayClassEndTime,
        Long atelierId,
        Long memberId
    ) {
        Assert.isTrue(peopleNumber > 0, "peopleNumber must be not positive.");
        Assert.isTrue(price > 0, "price must be not positive.");
        Assert.notNull(status, "status must be not null.");
        Assert.notNull(reservationDate, "reservationDate must be not null.");
        Assert.notNull(oneDayClassId, "oneDayClassId must be not null.");
        Assert.notNull(oneDayClassName, "oneDayClassName must be not null.");
        Assert.notNull(oneDayClassDate, "oneDayClassDate must be not null.");
        Assert.notNull(oneDayClassTimeId, "oneDayClassTimeId must be not null.");
        Assert.notNull(oneDayClassStartTime, "oneDayClassStartTime must be not null.");
        Assert.notNull(oneDayClassEndTime, "oneDayClassEndTime must be not null.");
        Assert.isTrue(oneDayClassStartTime < oneDayClassEndTime, "oneDayClassStartTime must be less than oneDayClassEndTime.");
        Assert.notNull(atelierId, "atelierId must be not null.");
        Assert.notNull(memberId, "memberId must be not null.");

        this.id = id;
        this.peopleNumber = peopleNumber;
        this.price = price;
        this.status = status;
        this.reservationDate = reservationDate;
        this.oneDayClassId = oneDayClassId;
        this.oneDayClassName = oneDayClassName;
        this.oneDayClassDate = oneDayClassDate;
        this.oneDayClassTimeId = oneDayClassTimeId;
        this.oneDayClassStartTime = oneDayClassStartTime;
        this.oneDayClassEndTime = oneDayClassEndTime;
        this.atelierId = atelierId;
        this.memberId = memberId;
    }

}
