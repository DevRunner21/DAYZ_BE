package com.dayz.onedayclass.domain;

import java.util.List;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;

public interface QOneDayClassRepository {

    Optional<OneDayClass> findOneDayClassById(Long oneDayClassId);

    Page<OneDayClass> findOneDayClassByAtelierId(Long atelierId, Pageable pageRequest);

    List<OneDayClass> findOneDayClassesByIds(List<Long> oneDayClassIds);

    Page<OneDayClass> findOneDayClassByCategoryId(
        Long categoryId,
        Long cityId,
        Long regionId,
        Pageable pageRequest
    );

    Page<OneDayClass> searchOneDayClass(
        Long cityId,
        Long regionId,
        String keyWord,
        Pageable pageable
    );

}
