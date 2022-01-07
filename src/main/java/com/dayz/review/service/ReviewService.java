package com.dayz.review.service;

import com.dayz.common.enums.ErrorInfo;
import com.dayz.common.exception.BusinessException;
import com.dayz.member.domain.Member;
import com.dayz.onedayclass.domain.OneDayClass;
import com.dayz.reservation.domain.Reservation;
import com.dayz.reservation.domain.ReservationRepository;
import com.dayz.review.converter.ReviewConverter;
import com.dayz.review.domain.Review;
import com.dayz.review.domain.ReviewRepository;
import com.dayz.review.dto.response.ReadReviewsByAtelierResponse;
import com.dayz.review.dto.response.ReadReviewsByMemberResponse;
import com.dayz.review.dto.response.ReadReviewsByOneDayClassResponse;
import com.dayz.review.dto.request.RegisterReviewRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ReviewService {

    private final ReviewRepository reviewRepository;

    private final ReviewConverter reviewConverter;

    private final ReservationRepository reservationRepository;

    //사용자 마이페이지에서 후기 전체 조회 하는 로직
    public ReadReviewsByMemberResponse getReviewsByMember(
        PageRequest pageRequest,
        Long memberId
    ) {
        Page<ReadReviewsByMemberResponse.ReviewResult> reviewsResponses =
            reviewRepository.findAllByMemberId(memberId, pageRequest)
                .map(reviewConverter::convertToReadReviewsByMemberReviewResult);

        return ReadReviewsByMemberResponse.of(reviewsResponses);
    }

    // 공방별 후기 목록 조회
    public ReadReviewsByAtelierResponse getReviewsByAtelier(PageRequest pageRequest,
        Long atelierId) {

        Page<ReadReviewsByAtelierResponse.ReviewResult> reviewsResponses =
            reviewRepository.findAllByAtelierId(atelierId, pageRequest)
                .map(reviewConverter::convertToReadReviewsByAtelierReviewResult);

        return ReadReviewsByAtelierResponse.of(reviewsResponses);
    }

    //원데이 클래스별 후기 조회
    public ReadReviewsByOneDayClassResponse getReviewsByOneDayClass(
        PageRequest pageRequest,
        Long oneDayClassId
    ) {
        Page<ReadReviewsByOneDayClassResponse.ReviewResult> reviewsResponses =
            reviewRepository.findAllByOneDayClassId(oneDayClassId, pageRequest)
                .map(reviewConverter::convertReadReviewsByOneDayClassReviewResult);

        return ReadReviewsByOneDayClassResponse.of(reviewsResponses);
    }

    // 후기 작성
    @Transactional
    public Long saveReview(RegisterReviewRequest registerReviewRequest, Member member) {
        Reservation reservation = reservationRepository
            .findByreservationId(registerReviewRequest.getReservationId())
            .orElseThrow(() -> new BusinessException(ErrorInfo.RESERVATION_NOT_FOUND));
        OneDayClass oneDayClass = reservation.getOneDayClassTime().getOneDayClass();
        Review review = reviewConverter.convertToReview(registerReviewRequest, member, oneDayClass);

        return reviewRepository.save(review).getId();
    }

    //공방별 리뷰 평점 계산 API
    public Double getAvgScore(Long atelierId) {
        double score = reviewRepository.getReviewAverageByAtelier(atelierId);
        return Math.round(score * 10) / 10.0;
    }

}
