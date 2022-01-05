package com.dayz.reservation.domain;

import com.dayz.reservation.dto.query.ReservationInfoProjection;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface QReservationRepository {

    Page<ReservationInfoProjection> findReservationsByMember(Long memberId, Pageable pageable);

    Page<ReservationInfoProjection> findReservationsByAtelier(Long atelierId, Pageable pageable);

}
