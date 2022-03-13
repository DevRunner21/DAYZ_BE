package com.dayz.follow.domain;

import static com.dayz.atelier.domain.QAtelier.atelier;
import static com.dayz.follow.domain.QFollow.follow;
import static com.dayz.member.domain.QMember.member;
import static com.dayz.onedayclass.domain.QOneDayClass.oneDayClass;

import com.dayz.atelier.domain.QAtelier;
import com.dayz.follow.domain.Follow;
import com.dayz.follow.domain.QFollow;
import com.dayz.follow.domain.QFollowRepository;
import com.dayz.member.domain.QMember;
import com.querydsl.core.types.Order;
import com.querydsl.core.types.OrderSpecifier;
import com.querydsl.core.types.dsl.PathBuilder;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.support.PageableExecutionUtils;

@RequiredArgsConstructor
public class QFollowRepositoryImpl implements QFollowRepository {

    private final JPAQueryFactory jpaQueryFactory;

    @Override
    public Page<Follow> findFollowsByMemberId(Long memberId, Pageable pageRequest) {

        JPAQuery<Follow> contentQuery = jpaQueryFactory.selectFrom(follow)
            .innerJoin(follow.member, member).fetchJoin()
            .innerJoin(follow.atelier, atelier).fetchJoin()
            .where(member.id.eq(memberId))
            .offset(pageRequest.getOffset())
            .limit(pageRequest.getPageSize());

        for (Sort.Order o : pageRequest.getSort()) {
            PathBuilder pathBuilder = new PathBuilder(follow.getType(),
                follow.getMetadata());
            contentQuery.orderBy(new OrderSpecifier<>(o.isAscending() ? Order.ASC : Order.DESC,
                pathBuilder.get(o.getProperty())));
        }

        JPAQuery<Follow> countQuery = jpaQueryFactory.selectFrom(follow)
            .where(follow.member.id.eq(memberId))
            .offset(pageRequest.getOffset())
            .limit(pageRequest.getPageSize());

        return PageableExecutionUtils.getPage(contentQuery.fetch(), pageRequest, countQuery::fetchCount);
    }

}
