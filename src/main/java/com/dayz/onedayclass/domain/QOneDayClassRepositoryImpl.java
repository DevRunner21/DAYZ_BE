package com.dayz.onedayclass.domain;

import static com.dayz.atelier.domain.QAtelier.atelier;
import static com.dayz.category.domain.QCategory.category;
import static com.dayz.member.domain.QAddress.address;
import static com.dayz.onedayclass.domain.QCurriculum.curriculum;
import static com.dayz.onedayclass.domain.QOneDayClass.oneDayClass;
import static com.dayz.onedayclass.domain.QOneDayClassImage.oneDayClassImage;


import com.dayz.category.domain.QCategory;
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
public class QOneDayClassRepositoryImpl implements QOneDayClassRepository {

    private final JPAQueryFactory jpaQueryFactory;

    @Override
    public Optional<OneDayClass> findOneDayClassById(Long oneDayClassId) {
        OneDayClass foundOneDayClass = jpaQueryFactory.selectFrom(oneDayClass)
            .leftJoin(oneDayClass.oneDayClassImages, oneDayClassImage).fetchJoin()
            .where(oneDayClass.id.eq(oneDayClassId))
            .fetchOne();

        return Optional.ofNullable(foundOneDayClass);
    }

    @Override
    public Page<OneDayClass> findOneDayClassByAtelierId(Long atelierId, Pageable pageRequest) {
        JPAQuery<OneDayClass> contentQuery = jpaQueryFactory.selectFrom(oneDayClass)
            .leftJoin(oneDayClass.oneDayClassImages, oneDayClassImage).fetchJoin()
            .where(oneDayClass.atelierId.eq(atelierId))
            .offset(pageRequest.getOffset())
            .limit(pageRequest.getPageSize());

        for (Sort.Order o : pageRequest.getSort()) {
            PathBuilder pathBuilder = new PathBuilder(oneDayClass.getType(), oneDayClass.getMetadata());
            contentQuery.orderBy(new OrderSpecifier<>(o.isAscending() ? Order.ASC : Order.DESC,
                pathBuilder.get(o.getProperty())));
        }

        JPAQuery<OneDayClass> countQuery = jpaQueryFactory.selectFrom(oneDayClass)
            .where(oneDayClass.atelierId.eq(atelierId));

        return PageableExecutionUtils.getPage(contentQuery.fetch(), pageRequest, countQuery::fetchCount);
    }

    @Override
    public List<OneDayClass> findOneDayClassesByIds(List<Long> oneDayClassIds) {
        return jpaQueryFactory.selectFrom(oneDayClass)
                .where(oneDayClass.id.in(oneDayClassIds))
                .fetch();
    }

    @Override
    public Page<OneDayClass> findOneDayClassByCategoryId(
        Long categoryId,
        Long cityId,
        Long regionId,
        Pageable pageRequest) {

        JPAQuery<OneDayClass> contentQuery = jpaQueryFactory.select(oneDayClass)
            .from(oneDayClass)
            .innerJoin(category).on(oneDayClass.categoryId.eq(category.id))
            .innerJoin(atelier).on(oneDayClass.atelierId.eq(atelier.id))
            .innerJoin(atelier.address, address)
            .innerJoin(oneDayClass.oneDayClassImages, oneDayClassImage).fetchJoin()
            .where(oneDayClass.categoryId.eq(categoryId)
                .and(atelier.address.cityId.eq(cityId))
                .and(atelier.address.regionId.eq(regionId))
            )
            .offset(pageRequest.getOffset())
            .limit(pageRequest.getPageSize());

        for (Sort.Order o : pageRequest.getSort()) {
            PathBuilder pathBuilder = new PathBuilder(oneDayClass.getType(), oneDayClass.getMetadata());
            contentQuery.orderBy(new OrderSpecifier<>(o.isAscending() ? Order.ASC : Order.DESC,
                pathBuilder.get(o.getProperty())));
        }

        JPAQuery<OneDayClass> countQuery = jpaQueryFactory.select(oneDayClass)
            .from(oneDayClass)
            .innerJoin(category).on(oneDayClass.categoryId.eq(category.id))
            .innerJoin(atelier).on(oneDayClass.atelierId.eq(atelier.id))
            .innerJoin(atelier.address, address)
            .where(oneDayClass.categoryId.eq(categoryId)
                .and(address.cityId.eq(cityId))
                .and(address.regionId.eq(regionId))
            );

        return PageableExecutionUtils.getPage(contentQuery.fetch(), pageRequest, countQuery::fetchCount);
    }

    @Override
    public Page<OneDayClass> searchOneDayClass(Long cityId, Long regionId, String keyWord, Pageable pageRequest) {

        JPAQuery<OneDayClass> contentQuery = jpaQueryFactory
            .selectFrom(oneDayClass)
            .innerJoin(atelier).on(oneDayClass.atelierId.eq(atelier.id))
            .innerJoin(atelier.address, address)
            .leftJoin(oneDayClass.oneDayClassImages, oneDayClassImage).fetchJoin()
            .where(oneDayClass.name.contains(keyWord)
                    .and(address.cityId.eq(cityId))
                    .and(address.regionId.eq(regionId))
            )
            .offset(pageRequest.getOffset())
            .limit(pageRequest.getPageSize());

        for (Sort.Order o : pageRequest.getSort()) {
            PathBuilder pathBuilder = new PathBuilder(oneDayClass.getType(), oneDayClass.getMetadata());
            contentQuery.orderBy(new OrderSpecifier<>(o.isAscending() ? Order.ASC : Order.DESC,
                pathBuilder.get(o.getProperty())));
        }

        return PageableExecutionUtils.getPage(contentQuery.fetch(), pageRequest, contentQuery::fetchCount);
    }

}
