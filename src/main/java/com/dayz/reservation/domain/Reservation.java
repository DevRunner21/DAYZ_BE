package com.dayz.reservation.domain;

import com.dayz.common.entity.BaseEntity;
import com.dayz.common.enums.ReservationStatus;
import com.dayz.member.domain.Member;
import com.dayz.onedayclass.domain.OneDayClassTime;
import java.time.LocalDate;
import javax.persistence.*;
import lombok.*;
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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id", foreignKey = @ForeignKey(name = "fk_reservation_to_member"))
    private Member member;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "onedayclass_time_id", foreignKey = @ForeignKey(name = "fk_reservation_to_onedayclass_time"))
    private OneDayClassTime oneDayClassTime;

    @Builder
    private Reservation(
        Long id,
        int peopleNumber,
        int price,
        ReservationStatus status,
        LocalDate reservationDate,
        Member member,
        OneDayClassTime oneDayClassTime
    ) {
        Assert.isTrue(peopleNumber > 0, "peopleNumber must be not positive.");
        Assert.isTrue(price > 0, "price must be not positive.");
        Assert.notNull(status, "status must be not null.");
        Assert.notNull(reservationDate, "reservationDate must be not null.");
        Assert.notNull(member, "member must be not null.");
        Assert.notNull(oneDayClassTime, "oneDayClassTime must be not null.");

        this.id = id;
        this.peopleNumber = peopleNumber;
        this.price = price;
        this.status = status;
        this.reservationDate = reservationDate;
        this.member = member;
        this.oneDayClassTime = oneDayClassTime;
    }

}
