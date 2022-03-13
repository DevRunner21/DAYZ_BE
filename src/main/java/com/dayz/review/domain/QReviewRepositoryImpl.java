package com.dayz.review.domain;

import static com.dayz.atelier.domain.QAtelier.atelier;
import static com.dayz.member.domain.QMember.member;
import static com.dayz.onedayclass.domain.QOneDayClass.oneDayClass;
import static com.dayz.review.domain.QReview.review;

import com.dayz.atelier.domain.QAtelier;
import com.dayz.member.domain.QMember;
import com.dayz.onedayclass.domain.QOneDayClass;
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
public class QReviewRepositoryImpl implements QReviewRepository {

    private final JPAQueryFactory jpaQueryFactory;

    @Override
    public Page<Review> findAllByMemberId(Long memberId, Pageable pageable) {

        List<OrderSpecifier> orderlist = new ArrayList<>();

        for (Sort.Order o : pageable.getSort()) {
            PathBuilder pathBuilder = new PathBuilder(review.getType(),
                review.getMetadata());
            orderlist.add(new OrderSpecifier(o.isAscending() ? Order.ASC : Order.DESC,
                pathBuilder.get(o.getProperty())));
        }
        QueryResults<Review> results = jpaQueryFactory
            .selectFrom(review)
            .innerJoin(member).on(review.memberId.eq(member.id))
            .innerJoin(oneDayClass).on(review.oneDayClassId.eq(oneDayClass.id))
            .where(member.id.eq(memberId))
            .offset(pageable.getOffset())
            .limit(pageable.getPageSize())
            .orderBy(orderlist.stream().toArray(OrderSpecifier[]::new))
            .fetchResults();

        return new PageImpl<>(results.getResults(), pageable, results.getTotal());
    }

    @Override
    public Page<Review> findAllByAtelierId(Long atelierId, Pageable pageable) {
        List<OrderSpecifier> orderlist = new ArrayList<>();

        for (Sort.Order o : pageable.getSort()) {
            PathBuilder pathBuilder = new PathBuilder(review.getType(),
                review.getMetadata());
            orderlist.add(new OrderSpecifier(o.isAscending() ? Order.ASC : Order.DESC,
                pathBuilder.get(o.getProperty())));
        }

        QueryResults<Review> results = jpaQueryFactory
            .selectFrom(review)
            .innerJoin(member).on(review.memberId.eq(member.id))
            .innerJoin(oneDayClass).on(review.oneDayClassId.eq(oneDayClass.id))
            .innerJoin(atelier).on(oneDayClass.id.eq(atelier.id))
            .where(atelier.id.eq(atelierId))
            .offset(pageable.getOffset())
            .limit(pageable.getPageSize())
            .orderBy(orderlist.stream().toArray(OrderSpecifier[]::new))
            .fetchResults();

        return new PageImpl<>(results.getResults(), pageable, results.getTotal());

    }

    @Override
    public Page<Review> findAllByOneDayClassId(Long oneDayClassId, Pageable pageable) {
        List<OrderSpecifier> orderlist = new ArrayList<>();

        for (Sort.Order o : pageable.getSort()) {
            PathBuilder pathBuilder = new PathBuilder(review.getType(),
                review.getMetadata());
            orderlist.add(new OrderSpecifier(o.isAscending() ? Order.ASC : Order.DESC,
                pathBuilder.get(o.getProperty())));
        }

        QueryResults<Review> results = jpaQueryFactory
            .selectFrom(review)
            .innerJoin(member).on(review.memberId.eq(member.id))
            .innerJoin(oneDayClass).on(review.oneDayClassId.eq(oneDayClass.id))
            .where(oneDayClass.id.eq(oneDayClassId))
            .offset(pageable.getOffset())
            .limit(pageable.getPageSize())
            .orderBy(orderlist.stream().toArray(OrderSpecifier[]::new))
            .fetchResults();

        return new PageImpl<>(results.getResults(), pageable, results.getTotal());

    }

}
