package com.dayz.review.converter;

import com.dayz.common.util.ImageUrlUtil;
import com.dayz.member.domain.Member;
import com.dayz.onedayclass.domain.OneDayClass;
import com.dayz.review.domain.Review;
import com.dayz.review.domain.ReviewImage;
import com.dayz.review.dto.ReadReviewsByAtelierResponse;
import com.dayz.review.dto.ReadReviewsByMemberResponse;
import com.dayz.review.dto.ReadReviewsByOneDayClassResponse;
import com.dayz.review.dto.RegisterReviewRequest;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class ReviewConverter {

    private final ImageUrlUtil imageUrlUtil;

    public ReadReviewsByMemberResponse.ReviewResult convertToReadReviewsByMemberReviewResult(Review review) {

        ReadReviewsByMemberResponse.ReviewResult.MemberResult memberResult =
            ReadReviewsByMemberResponse.ReviewResult.MemberResult.of(
                review.getMember().getId(),
                review.getMember().getUsername(),
                review.getMember().getProfileImageUrl()
            );

        ReadReviewsByMemberResponse.ReviewResult.OneDayClassResult oneDayClassResult =
            ReadReviewsByMemberResponse.ReviewResult.OneDayClassResult.of(
                review.getOneDayClass().getId(),
                review.getOneDayClass().getName()
            );

        List<ReadReviewsByMemberResponse.ReviewResult.ReviewImageResult> reviewImageResult =
            review.getReviewImages().stream()
                .map(reviewImage -> ReadReviewsByMemberResponse.ReviewResult.ReviewImageResult.of(
                    imageUrlUtil.makeImageUrl(reviewImage.getImageFileName()),
                    reviewImage.getSequence())
                ).collect(Collectors.toList());

        return ReadReviewsByMemberResponse.ReviewResult.of(
            review.getId(),
            review.getContent(),
            review.getScore(),
            review.getCreatedAt(),
            memberResult,
            oneDayClassResult,
            reviewImageResult
        );
    }

    public ReadReviewsByOneDayClassResponse.ReviewResult convertReadReviewsByOneDayClassReviewResult(
        Review review
    ) {
        ReadReviewsByOneDayClassResponse.ReviewResult.OneDayClassMemberResult memberResult =
            ReadReviewsByOneDayClassResponse.ReviewResult.OneDayClassMemberResult.of(
                review.getMember().getId(),
                review.getMember().getUsername(),
                review.getMember().getProfileImageUrl()
            );

        List<ReadReviewsByOneDayClassResponse.ReviewResult.OneDayClassReviewImageResult> reviewImageResults =
            review.getReviewImages().stream()
                .map(reviewImage -> ReadReviewsByOneDayClassResponse.ReviewResult.OneDayClassReviewImageResult.of(
                        imageUrlUtil.makeImageUrl(reviewImage.getImageFileName()),
                        reviewImage.getSequence()
                    )
                ).collect(Collectors.toList());

        return ReadReviewsByOneDayClassResponse.ReviewResult.of(
            review.getId(),
            review.getContent(),
            review.getScore(),
            review.getCreatedAt(),
            memberResult,
            reviewImageResults
        );
    }

    public ReadReviewsByAtelierResponse.ReviewResult convertToReadReviewsByAtelierReviewResult(Review review) {
        ReadReviewsByAtelierResponse.ReviewResult.AtelierMemberResult atelierMemberResult =
            ReadReviewsByAtelierResponse.ReviewResult.AtelierMemberResult.of(
                review.getMember().getId(),
                review.getMember().getUsername(),
                review.getMember().getProfileImageUrl()
            );

        ReadReviewsByAtelierResponse.ReviewResult.AtelierOneDayClassResult atelierOneDayClassResult =
            ReadReviewsByAtelierResponse.ReviewResult.AtelierOneDayClassResult.of(
                review.getOneDayClass().getId(),
                review.getOneDayClass().getName()
            );

        List<ReadReviewsByAtelierResponse.ReviewResult.AtelierReviewImageResult> atelierReviewImageResult =
            review.getReviewImages().stream()
                .map(reviewImage -> ReadReviewsByAtelierResponse.ReviewResult.AtelierReviewImageResult.of(
                        imageUrlUtil.makeImageUrl(reviewImage.getImageFileName()), reviewImage.getSequence()
                    )
                ).collect(Collectors.toList());

        return ReadReviewsByAtelierResponse.ReviewResult.of(
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
