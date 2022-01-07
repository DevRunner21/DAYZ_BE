package com.dayz.review.service;

import com.dayz.atelier.domain.Atelier;
import com.dayz.atelier.domain.AtelierRepository;
import com.dayz.common.enums.ErrorInfo;
import com.dayz.common.exception.BusinessException;
import com.dayz.member.domain.Member;
import com.dayz.member.domain.MemberRepository;
import com.dayz.onedayclass.domain.OneDayClass;
import com.dayz.onedayclass.domain.OneDayClassRepository;
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

    private final MemberRepository memberRepository;

    private final AtelierRepository atelierRepository;

    private final OneDayClassRepository oneDayClassRepository;

    private final ReservationRepository reservationRepository;

    private final ReviewConverter reviewConverter;

    //사용자 마이페이지에서 후기 전체 조회 하는 로직
    public ReadReviewsByMemberResponse getReviewsByMember(
        PageRequest pageRequest,
        Long memberId
    ) {
        Member foundMember = memberRepository.findById(memberId)
            .orElseThrow(() -> new BusinessException(ErrorInfo.MEMBER_NOT_FOUND));

        Page<ReadReviewsByMemberResponse.ReviewResult> reviewsResponses =
            reviewRepository.findAllByMemberId(foundMember.getId(), pageRequest)
                .map(reviewConverter::convertToReadReviewsByMemberReviewResult);

        return ReadReviewsByMemberResponse.of(reviewsResponses);
    }

    // 공방별 후기 목록 조회
    public ReadReviewsByAtelierResponse getReviewsByAtelier(PageRequest pageRequest, Long atelierId) {
        Atelier foundAtelier = atelierRepository.findById(atelierId)
            .orElseThrow(() -> new BusinessException(ErrorInfo.ATELIER_NOT_FOUND));

        Page<ReadReviewsByAtelierResponse.ReviewResult> reviewsResponses =
            reviewRepository.findAllByAtelierId(foundAtelier.getId(), pageRequest)
                .map(reviewConverter::convertToReadReviewsByAtelierReviewResult);

        return ReadReviewsByAtelierResponse.of(reviewsResponses);
    }

    //원데이 클래스별 후기 조회
    public ReadReviewsByOneDayClassResponse getReviewsByOneDayClass(
        PageRequest pageRequest,
        Long oneDayClassId
    ) {
        OneDayClass foundOneDayClass = oneDayClassRepository.findOneDayClassById(oneDayClassId)
            .orElseThrow(() -> new BusinessException(ErrorInfo.ONE_DAY_CLASS_NOT_FOUND));

        Page<ReadReviewsByOneDayClassResponse.ReviewResult> reviewsResponses =
            reviewRepository.findAllByOneDayClassId(foundOneDayClass.getId(), pageRequest)
                .map(reviewConverter::convertReadReviewsByOneDayClassReviewResult);

        return ReadReviewsByOneDayClassResponse.of(reviewsResponses);
    }

    // 후기 작성
    @Transactional
    public Long saveReview(RegisterReviewRequest registerReviewRequest, Long memberId) {
        Member foundMember = memberRepository.findById(memberId)
            .orElseThrow(() -> new BusinessException(ErrorInfo.MEMBER_NOT_FOUND));

        Reservation foundReservation = reservationRepository.findByreservationId(registerReviewRequest.getReservationId())
            .orElseThrow(() -> new BusinessException(ErrorInfo.RESERVATION_NOT_FOUND));

        OneDayClass oneDayClass = foundReservation.getOneDayClassTime().getOneDayClass();
        Review review = reviewConverter.convertToReview(registerReviewRequest, foundMember, oneDayClass);

        return reviewRepository.save(review).getId();
    }

    //공방별 리뷰 평점 계산 API
    public double getAvgScore(Long atelierId) {
        Atelier foundAtelier = atelierRepository.findById(atelierId)
            .orElseThrow(() -> new BusinessException(ErrorInfo.ATELIER_NOT_FOUND));
        double score = reviewRepository.getReviewAverageByAtelier(foundAtelier.getId());

        return Math.round(score * 10) / 10.0;
    }

}
