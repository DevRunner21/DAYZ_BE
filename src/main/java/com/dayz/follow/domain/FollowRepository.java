package com.dayz.follow.domain;

import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface FollowRepository extends JpaRepository<Follow, Long>, QFollowRepository {

    @Query("select f from Follow f join fetch f.member m join fetch f.atelier a where m.id = :memberId and a.id = :atelierId")
    Follow findFollowByMemberIdAndAtelierId(@Param("memberId") Long memberId, @Param("atelierId") Long atelierId);

    boolean existsByMemberIdAndAtelierId(Long memberId, Long atelierId);

    // TODO : 이게 왜 안되는지 알아보자
//    @Query("select f from Follow f join fetch f.member m join fetch f.atelier a where m.id = :memberId")
//    Page<Follow> findFollowsByMemberId(@Param("memberId") Long memberId, Pageable pageRequest);

    List<Follow> findFollowsByMemberId(@Param("memberId") Long memberId);

}
