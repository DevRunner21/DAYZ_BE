package com.dayz.review.service;

import com.dayz.common.dto.CustomPageRequest;
import com.dayz.common.dto.CustomPageResponse;
import com.dayz.common.enums.ErrorInfo;
import com.dayz.common.exception.BusinessException;
import com.dayz.member.domain.Member;
import com.dayz.onedayclass.domain.OneDayClass;
import com.dayz.reservation.domain.Reservation;
import com.dayz.reservation.domain.ReservationRepository;
import com.dayz.review.converter.ReviewConverter;
import com.dayz.review.domain.Review;
import com.dayz.review.domain.ReviewRepository;
import com.dayz.review.dto.ReadMyReviewsResponse;
import com.dayz.review.dto.ReadReviewsByAtelierResponse;
import com.dayz.review.dto.ReadReviewsByOneDayClassResponse;
import com.dayz.review.dto.RegisterReviewRequest;
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
    public CustomPageResponse getAllReviews(CustomPageRequest pageRequest, Long memberId) {
        PageRequest pageable = pageRequest.convertToPageRequest(Review.class);
        Page<ReadMyReviewsResponse> reviewsResponses =
            reviewRepository.findAllByMemberId(memberId, pageable)
                .map(reviewConverter::convertToReadMyReviewsResponse);

        return CustomPageResponse.of(reviewsResponses);
    }

    //    공방별 후기 목록 조회
    public CustomPageResponse getAllAtelierReviews(CustomPageRequest pageRequest, Long atelierId) {
        PageRequest pageable = pageRequest.convertToPageRequest(Review.class);

        Page<ReadReviewsByAtelierResponse> reviewsResponses = reviewRepository.findAllByAtelierId(
            atelierId, pageable)
            .map(reviewConverter::convertToReadReviewsByAtelierResponse);

        return CustomPageResponse.of(reviewsResponses);
    }

    //원데이 클래스별 후기 조회
    public CustomPageResponse getAllOneDayClassReviews(CustomPageRequest pageRequest,
        Long oneDayClassId) {

        PageRequest pageable = pageRequest.convertToPageRequest(Review.class);

        Page<ReadReviewsByOneDayClassResponse> reviewsResponses = reviewRepository
            .findAllByOneDayClassId(
                oneDayClassId, pageable)
            .map(reviewConverter::convertReadAllOneDayClassReviewsResponse);

        return CustomPageResponse.of(reviewsResponses);
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
