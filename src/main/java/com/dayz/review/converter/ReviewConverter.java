package com.dayz.review.converter;

import com.dayz.common.util.ImageUrlUtil;
import com.dayz.member.domain.Member;
import com.dayz.onedayclass.domain.OneDayClass;
import com.dayz.review.domain.Review;
import com.dayz.review.domain.ReviewImage;
import com.dayz.review.dto.ReadMyReviewsResponse;
import com.dayz.review.dto.ReadMyReviewsResponse.MemberResult;
import com.dayz.review.dto.ReadMyReviewsResponse.OneDayClassResult;
import com.dayz.review.dto.ReadMyReviewsResponse.ReviewImageResult;
import com.dayz.review.dto.ReadReviewsByAtelierResponse;
import com.dayz.review.dto.ReadReviewsByAtelierResponse.AtelierMemberResult;
import com.dayz.review.dto.ReadReviewsByAtelierResponse.AtelierOneDayClassResult;
import com.dayz.review.dto.ReadReviewsByAtelierResponse.AtelierReviewImageResult;
import com.dayz.review.dto.ReadReviewsByOneDayClassResponse;
import com.dayz.review.dto.ReadReviewsByOneDayClassResponse.OneDayClassMemberResult;
import com.dayz.review.dto.ReadReviewsByOneDayClassResponse.OneDayClassReviewImageResult;
import com.dayz.review.dto.RegisterReviewRequest;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class ReviewConverter {

    private final ImageUrlUtil imageUrlUtil;

    public ReadMyReviewsResponse convertToReadMyReviewsResponse(Review review) {

        MemberResult memberResult = MemberResult.of(review.getMember().getId(),
            review.getMember().getUsername(), review.getMember().getProfileImageUrl());

        OneDayClassResult oneDayClassResult = OneDayClassResult.of(review.getOneDayClass().getId(),
            review.getOneDayClass().getName());

        List<ReviewImageResult> reviewImageResult = review.getReviewImages().stream()
            .map(reviewImage -> ReviewImageResult
                .of(imageUrlUtil.makeImageUrl(reviewImage.getImageFileName()),
                    reviewImage.getSequence())).collect(Collectors.toList());

        return ReadMyReviewsResponse.of(
            review.getId(),
            review.getContent(),
            review.getScore(),
            review.getCreatedAt(),
            memberResult,
            oneDayClassResult,
            reviewImageResult
        );
    }

    public ReadReviewsByOneDayClassResponse convertReadAllOneDayClassReviewsResponse(
        Review review) {

        OneDayClassMemberResult memberResult = OneDayClassMemberResult
            .of(review.getMember().getId(),
                review.getMember().getUsername(), review.getMember().getProfileImageUrl());

        List<OneDayClassReviewImageResult> reviewImageResults = review.getReviewImages().stream()
            .map(reviewImage -> OneDayClassReviewImageResult
                .of(imageUrlUtil.makeImageUrl(reviewImage.getImageFileName()),
                    reviewImage.getSequence())).collect(Collectors.toList());

        return ReadReviewsByOneDayClassResponse.of(
            review.getId(),
            review.getContent(),
            review.getScore(),
            review.getCreatedAt(),
            memberResult,
            reviewImageResults
        );
    }

    public ReadReviewsByAtelierResponse convertToReadReviewsByAtelierResponse(Review review) {
        AtelierMemberResult atelierMemberResult = AtelierMemberResult.of(review.getMember().getId(),
            review.getMember().getUsername(), review.getMember().getProfileImageUrl());

        AtelierOneDayClassResult atelierOneDayClassResult = AtelierOneDayClassResult
            .of(review.getOneDayClass().getId(),
                review.getOneDayClass().getName());

        List<AtelierReviewImageResult> atelierReviewImageResult = review.getReviewImages().stream()
            .map(reviewImage -> AtelierReviewImageResult
                .of(imageUrlUtil.makeImageUrl(reviewImage.getImageFileName()),
                    reviewImage.getSequence())).collect(Collectors.toList());

        return ReadReviewsByAtelierResponse.of(
            review.getId(),
            review.getContent(),
            review.getScore(),
            review.getCreatedAt(),
            atelierMemberResult,
            atelierOneDayClassResult,
            atelierReviewImageResult
        );
    }

    public Review convertToReview(
        RegisterReviewRequest registerReviewRequest,
        Member member,
        OneDayClass oneDayClass
    ) {
        List<ReviewImage> reviewImages = registerReviewRequest.getImages().stream().map(
            imageRequest -> ReviewImage.of(imageUrlUtil.extractFileName(imageRequest.getImageUrl()),
                imageRequest.getSequence())).collect(Collectors.toList());

        return Review.of(
            registerReviewRequest.getContent(),
            registerReviewRequest.getScore(),
            member,
            oneDayClass,
            reviewImages
        );
    }

}
