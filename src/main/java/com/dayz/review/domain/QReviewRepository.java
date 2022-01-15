package com.dayz.review.domain;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;

public interface QReviewRepository {

    Page<Review> findAllByMemberId(Long memberId, Pageable pageable);

    Page<Review> findAllByAtelierId(@Param("id") Long id, Pageable pageable);

    Page<Review> findAllByOneDayClassId(@Param("id") Long id, Pageable pageable);

}
