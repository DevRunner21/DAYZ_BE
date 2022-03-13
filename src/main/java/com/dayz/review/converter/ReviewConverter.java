package com.dayz.review.converter;

import com.dayz.member.domain.Member;
import com.dayz.onedayclass.domain.OneDayClass;
import com.dayz.review.domain.Review;
import com.dayz.review.domain.ReviewImage;
import com.dayz.review.dto.response.ReadReviewsByAtelierResponse;
import com.dayz.review.dto.response.ReadReviewsByAtelierResponse.ReviewResult.OneDayClassResult;
import com.dayz.review.dto.response.ReadReviewsByMemberResponse;
import com.dayz.review.dto.response.ReadReviewsByOneDayClassResponse;
import com.dayz.review.dto.request.RegisterReviewRequest;
import com.dayz.review.dto.response.ReadReviewsByOneDayClassResponse.ReviewResult.MemberResult;
import com.dayz.review.dto.response.ReadReviewsByOneDayClassResponse.ReviewResult.ReviewImageResult;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class ReviewConverter {

    public ReadReviewsByMemberResponse.ReviewResult convertToReadReviewsByMemberReviewResult(Review review, Member member, OneDayClass oneDayClass) {

        ReadReviewsByMemberResponse.ReviewResult.MemberResult memberResult =
            ReadReviewsByMemberResponse.ReviewResult.MemberResult.of(
                member.getId(),
                member.getUsername(),
                member.getProfileImageUrl()
            );

        ReadReviewsByMemberResponse.ReviewResult.OneDayClassResult oneDayClassResult =
            ReadReviewsByMemberResponse.ReviewResult.OneDayClassResult.of(
                oneDayClass.getId(),
                oneDayClass.getName()
            );

        List<ReadReviewsByMemberResponse.ReviewResult.ReviewImageResult> reviewImageResult =
            review.getReviewImages().stream()
                .map(reviewImage -> ReadReviewsByMemberResponse.ReviewResult.ReviewImageResult.of(
                    reviewImage.getFullImageUrl(),
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
        Review review,
        Member member
    ) {
        MemberResult memberResult =
            MemberResult.of(
                member.getId(),
                member.getUsername(),
                member.getProfileImageUrl()
            );

        List<ReviewImageResult> reviewImageResults =
            review.getReviewImages().stream()
                .map(reviewImage -> ReviewImageResult.of(
                    reviewImage.getFullImageUrl(),
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

    public ReadReviewsByAtelierResponse.ReviewResult convertToReadReviewsByAtelierReviewResult(Review review, Member member, OneDayClass oneDayClass) {
        ReadReviewsByAtelierResponse.ReviewResult.MemberResult memberResult =
            ReadReviewsByAtelierResponse.ReviewResult.MemberResult.of(
                member.getId(),
                member.getUsername(),
                member.getProfileImageUrl()
            );

        OneDayClassResult oneDayClassResult =
            OneDayClassResult.of(
                oneDayClass.getId(),
                oneDayClass.getName()
            );

        List<ReadReviewsByAtelierResponse.ReviewResult.ReviewImageResult> reviewImageResult =
            review.getReviewImages().stream()
                .map(reviewImage -> ReadReviewsByAtelierResponse.ReviewResult.ReviewImageResult.of(
                        reviewImage.getFullImageUrl(),
                        reviewImage.getSequence()
                    )
                ).collect(Collectors.toList());

        return ReadReviewsByAtelierResponse.ReviewResult.of(
            review.getId(),
            review.getContent(),
            review.getScore(),
            review.getCreatedAt(),
            memberResult,
            oneDayClassResult,
            reviewImageResult
        );
    }

    public Review convertToReview(
        RegisterReviewRequest registerReviewRequest,
        Member member,
        OneDayClass oneDayClass
    ) {
        List<ReviewImage> reviewImages =
            registerReviewRequest.getImages().stream().map(
                imageRequest -> ReviewImage.builder()
                    .sequence(imageRequest.getSequence())
                    .imageFileName(imageRequest.getImageUrl()).build()
            ).collect(Collectors.toList());

        return Review.builder()
            .content(registerReviewRequest.getContent())
            .score(registerReviewRequest.getScore())
            .memberId(member.getId())
            .oneDayClassId(oneDayClass.getId())
            .reviewImages(reviewImages)
            .build();
    }

}
