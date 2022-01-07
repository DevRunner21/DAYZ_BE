package com.dayz.review.controller;

import com.dayz.common.aop.LoginMemberId;
import com.dayz.common.dto.ApiResponse;
import com.dayz.member.domain.Member;
import com.dayz.review.domain.Review;
import com.dayz.review.dto.*;
import com.dayz.review.service.ReviewService;
import java.util.Map;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "api/v1")
public class ReviewController {

    private final ReviewService reviewService;

    @GetMapping(value = "/reviews", produces = MediaType.APPLICATION_JSON_VALUE)
    public ApiResponse<ReadReviewsByMemberResponse> readReviewsByMember(
        @LoginMemberId Member member,
        ReadReviewsByMemberRequest request
    ) {
        ReadReviewsByMemberResponse response
            = reviewService.getReviewsByMember(
            request.convertToPageRequest(Review.class),
            member.getId()
        );

        return ApiResponse.<ReadReviewsByMemberResponse>ok(response);
    }

    @GetMapping(value = "/reviews/ateliers/{atelierId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ApiResponse<ReadReviewsByAtelierResponse> readReviewsByAtelier(
        @PathVariable("atelierId") Long atelierId,
        ReadReviewsByAtelierRequest request
    ) {
        ReadReviewsByAtelierResponse response =
            reviewService.getReviewsByAtelier(
                request.convertToPageRequest(Review.class),
                atelierId
            );

        return ApiResponse.<ReadReviewsByAtelierResponse>ok(response);
    }

    @GetMapping(value = "/reviews/classes/{classId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ApiResponse<ReadReviewsByOneDayClassResponse> readReviewsByOneDayClass(
        @PathVariable("classId") Long classId,
        @Valid ReadReviewsByOneDayClassRequest request
    ) {
        ReadReviewsByOneDayClassResponse response =
            reviewService.getReviewsByOneDayClass(
                request.convertToPageRequest(Review.class),
                classId
            );

        return ApiResponse.<ReadReviewsByOneDayClassResponse>ok(response);
    }

    @GetMapping(value = "/reviews/score/ateliers/{atelierId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ApiResponse<Map<String, Double>> getAvgScore(@PathVariable("atelierId") Long atelierId) {
        return ApiResponse.ok(Map.of("avgScore", reviewService.getAvgScore(atelierId)));
    }

    @PostMapping(value = "/reviews", produces = MediaType.APPLICATION_JSON_VALUE)
    public ApiResponse<Map<String, Long>> saveReviews(
        @LoginMemberId Member member,
        @Valid @RequestBody RegisterReviewRequest registerReviewRequest
    ) {
        return ApiResponse
            .ok(Map.of("reviewId", reviewService.saveReview(registerReviewRequest, member)));
    }

}
