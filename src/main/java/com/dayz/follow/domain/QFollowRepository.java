package com.dayz.follow.domain;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;

public interface QFollowRepository {

    Page<Follow> findFollowsByMemberId(@Param("memberId") Long memberId, Pageable pageRequest);

}
