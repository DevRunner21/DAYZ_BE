package com.dayz.reservation.domain;

import static com.dayz.atelier.domain.QAtelier.atelier;
import static com.dayz.onedayclass.domain.QOneDayClassTime.oneDayClassTime;
import static com.dayz.onedayclass.domain.QOneDayClass.oneDayClass;
import static com.dayz.reservation.domain.QReservation.reservation;
import static com.dayz.member.domain.QMember.member;

import com.dayz.onedayclass.domain.QOneDayClassTime;
import com.dayz.reservation.dto.query.QReservationInfoProjection;
import com.dayz.reservation.dto.query.ReservationInfoProjection;
import com.querydsl.core.QueryResults;
import com.querydsl.core.types.Order;
import com.querydsl.core.types.OrderSpecifier;
import com.querydsl.core.types.dsl.PathBuilder;
import com.querydsl.jpa.impl.JPAQueryFactory;
import java.util.ArrayList;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

@RequiredArgsConstructor
public class QReservationRepositoryImpl implements QReservationRepository {

    private final JPAQueryFactory jpaQueryFactory;

    @Override
    public Page<ReservationInfoProjection> findReservationsByMember(Long memberId, Pageable pageable) {
        List<OrderSpecifier> orderlist = new ArrayList<>();

        for (Sort.Order o : pageable.getSort()) {
            PathBuilder pathBuilder = new PathBuilder(
                reservation.getType(),
                reservation.getMetadata()
            );
            orderlist.add(new OrderSpecifier(o.isAscending() ? Order.ASC : Order.DESC,
                pathBuilder.get(o.getProperty())));
        }

        QueryResults<ReservationInfoProjection> results =
            jpaQueryFactory.select(
                new QReservationInfoProjection(
                    reservation.id,
                    oneDayClassTime.oneDayClass.name,
                    reservation.reservationDate,
                    oneDayClassTime.classDate,
                    oneDayClassTime.startTime,
                    oneDayClassTime.endTime,
                    reservation.status.stringValue()
                )
            ).from(reservation)
                .innerJoin(member).on(reservation.memberId.eq(member.id))
                .innerJoin(oneDayClassTime).on(reservation.oneDayClassTimeId.eq(oneDayClassTime.id))
                .innerJoin(oneDayClassTime.oneDayClass, oneDayClass).fetchJoin()
                .where(member.id.eq(memberId))
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .orderBy(orderlist.stream().toArray(OrderSpecifier[]::new))
                .fetchResults();

        return new PageImpl<>(results.getResults(), pageable, results.getTotal());
    }

    @Override
    public Page<ReservationInfoProjection> findReservationsByAtelier(
        Long atelierId,
        Pageable pageable) {
        List<OrderSpecifier> orderlist = new ArrayList<>();

        for (Sort.Order o : pageable.getSort()) {
            PathBuilder pathBuilder = new PathBuilder(
                reservation.getType(),
                reservation.getMetadata()
            );
            orderlist.add(new OrderSpecifier(o.isAscending() ? Order.ASC : Order.DESC,
                pathBuilder.get(o.getProperty())));
        }

        QueryResults<ReservationInfoProjection> results = jpaQueryFactory
            .select(new QReservationInfoProjection(
                reservation.id,
                oneDayClassTime.oneDayClass.name,
                reservation.reservationDate,
                oneDayClassTime.classDate,
                oneDayClassTime.startTime,
                oneDayClassTime.endTime,
                reservation.status.stringValue()))
            .from(reservation)
            .innerJoin(oneDayClassTime, oneDayClassTime).on(reservation.oneDayClassTimeId.eq(oneDayClassTime.id))
            .innerJoin(oneDayClassTime.oneDayClass, oneDayClass).fetchJoin()
            .innerJoin(atelier).on(oneDayClass.atelierId.eq(atelier.id))
            .where(atelier.id.eq(atelierId))
            .offset(pageable.getOffset())
            .limit(pageable.getPageSize())
            .orderBy(orderlist.stream().toArray(OrderSpecifier[]::new))
            .fetchResults();

        return new PageImpl<>(results.getResults(), pageable, results.getTotal());

    }
}
