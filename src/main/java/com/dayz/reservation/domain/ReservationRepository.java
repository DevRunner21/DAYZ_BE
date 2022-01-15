package com.dayz.reservation.domain;

import com.dayz.reservation.dto.query.ReservationInfoProjection;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ReservationRepository extends JpaRepository<Reservation, Long>,
    QReservationRepository {

    @Query("select r from Reservation r JOIN fetch r.oneDayClassTime t join fetch t.oneDayClass o where r.id=:reservationId")
    Optional<Reservation> findByReservationId(@Param("reservationId") Long reservationId);

    Page<ReservationInfoProjection> findReservationsByMember(Long memberId, Pageable pageable);

    Page<ReservationInfoProjection> findReservationsByAtelier(Long atelierId, Pageable pageable);

    @Query("select SUM(r.peopleNumber)"
        + " from Reservation r "
        + " where r.oneDayClassTime.id = :oneDayClassTimeId "
        )
    int findSumReservationPeopleNumberByOneDayClassTime(@Param("oneDayClassTimeId") Long oneDayClassTimeId);

}
