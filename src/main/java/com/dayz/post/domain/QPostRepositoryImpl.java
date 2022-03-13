package com.dayz.post.domain;

import static com.dayz.atelier.domain.QAtelier.atelier;
import static com.dayz.member.domain.QMember.member;
import static com.dayz.onedayclass.domain.QOneDayClass.oneDayClass;
import static com.dayz.post.domain.QPost.post;

import com.querydsl.core.types.Order;
import com.querydsl.core.types.OrderSpecifier;
import com.querydsl.core.types.dsl.PathBuilder;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.support.PageableExecutionUtils;

@RequiredArgsConstructor
public class QPostRepositoryImpl implements QPostRepository {

    private final JPAQueryFactory jpaQueryFactory;

    @Override
    public Optional<Post> findDetailPostById(Long postId) {
        Post foundPost = jpaQueryFactory.selectFrom(post)
            .innerJoin(member).on(post.memberId.eq(member.id))
            .innerJoin(member.atelier, atelier)
            .innerJoin(oneDayClass).on(post.oneDayClassId.eq(oneDayClass.id))
            .where(post.id.eq(postId))
            .fetchOne();

        return Optional.of(foundPost);
    }

    @Override
    public Page<Post> findPostsByFollows(List<Long> ids, Pageable pageRequest) {
        JPAQuery<Post> contentQuery = jpaQueryFactory.selectFrom(post)
            .innerJoin(member).on(post.memberId.eq(member.id))
            .innerJoin(member.atelier, atelier)
            .innerJoin(oneDayClass).on(post.oneDayClassId.eq(oneDayClass.id))
            .where(member.id.in(ids))
            .offset(pageRequest.getOffset())
            .limit(pageRequest.getPageSize());

        for (Sort.Order o : pageRequest.getSort()) {
            PathBuilder pathBuilder = new PathBuilder(post.getType(), post.getMetadata());
            contentQuery.orderBy(new OrderSpecifier<>(o.isAscending() ? Order.ASC : Order.DESC,
                pathBuilder.get(o.getProperty())));
        }

        List<Post> content = contentQuery.fetch();

        JPAQuery<Post> countQuery = jpaQueryFactory.selectFrom(post)
            .innerJoin(member).on(post.memberId.eq(member.id))
            .where(member.id.in(ids)
                .and(post.useFlag.eq(true)));

        return PageableExecutionUtils.getPage(content, pageRequest, countQuery::fetchCount);
    }

    @Override
    public Page<Post> findPostsByAtelier(Long atelierId, Pageable pageRequest) {
        JPAQuery<Post> contentQuery = jpaQueryFactory.selectFrom(post)
            .innerJoin(member).on(post.memberId.eq(member.id))
            .innerJoin(member.atelier, atelier)
            .where(atelier.id.in(atelierId))
            .offset(pageRequest.getOffset())
            .limit(pageRequest.getPageSize());

        for (Sort.Order o : pageRequest.getSort()) {
            PathBuilder pathBuilder = new PathBuilder(post.getType(), post.getMetadata());
            contentQuery.orderBy(new OrderSpecifier<>(o.isAscending() ? Order.ASC : Order.DESC,
                pathBuilder.get(o.getProperty())));
        }

        List<Post> content = contentQuery.fetch();

        JPAQuery<Post> countQuery = jpaQueryFactory.selectFrom(post)
            .innerJoin(member).on(post.memberId.eq(member.id))
            .innerJoin(member.atelier, atelier).fetchJoin()
            .where(atelier.id.in(atelierId));

        return PageableExecutionUtils.getPage(content, pageRequest, countQuery::fetchCount);
    }

}
