package com.dayz.review.controller;

import com.dayz.common.aop.LoginMemberId;
import com.dayz.common.dto.CommonApiResponse;
import com.dayz.review.domain.Review;
import com.dayz.review.dto.request.ReadReviewsByAtelierRequest;
import com.dayz.review.dto.request.ReadReviewsByMemberRequest;
import com.dayz.review.dto.request.ReadReviewsByOneDayClassRequest;
import com.dayz.review.dto.request.RegisterReviewRequest;
import com.dayz.review.dto.response.*;
import com.dayz.review.service.ReviewService;
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
    public CommonApiResponse<ReadReviewsByMemberResponse> readReviewsByMember(
        @LoginMemberId Long memberId,
        ReadReviewsByMemberRequest request
    ) {
        ReadReviewsByMemberResponse response = reviewService.getReviewsByMember(
            request.convertToPageRequest(Review.class),
            memberId
        );

        return CommonApiResponse.<ReadReviewsByMemberResponse>ok(response);
    }

    @GetMapping(value = "/reviews/ateliers/{atelierId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public CommonApiResponse<ReadReviewsByAtelierResponse> readReviewsByAtelier(
        @PathVariable("atelierId") Long atelierId,
        ReadReviewsByAtelierRequest request
    ) {
        ReadReviewsByAtelierResponse response =
            reviewService.getReviewsByAtelier(
                request.convertToPageRequest(Review.class),
                atelierId
            );

        return CommonApiResponse.<ReadReviewsByAtelierResponse>ok(response);
    }

    @GetMapping(value = "/reviews/classes/{classId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public CommonApiResponse<ReadReviewsByOneDayClassResponse> readReviewsByOneDayClass(
        @PathVariable("classId") Long classId,
        @Valid ReadReviewsByOneDayClassRequest request
    ) {
        ReadReviewsByOneDayClassResponse response =
            reviewService.getReviewsByOneDayClass(
                request.convertToPageRequest(Review.class),
                classId
            );

        return CommonApiResponse.<ReadReviewsByOneDayClassResponse>ok(response);
    }

    @GetMapping(value = "/reviews/score/ateliers/{atelierId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public CommonApiResponse<ReadAvgScoreResponse> readAvgScore(
        @PathVariable("atelierId") Long atelierId
    ) {
        double avgScore = reviewService.getAvgScore(atelierId);

        return CommonApiResponse.ok(ReadAvgScoreResponse.of(avgScore));
    }

    @PostMapping(value = "/reviews", produces = MediaType.APPLICATION_JSON_VALUE)
    public CommonApiResponse<RegisterReviewResponse> registerReview(
        @LoginMemberId Long memberId,
        @Valid @RequestBody RegisterReviewRequest registerReviewRequest
    ) {
        Long registeredReviewId = reviewService.saveReview(registerReviewRequest, memberId);

        return CommonApiResponse
            .<RegisterReviewResponse>ok(RegisterReviewResponse.of(registeredReviewId));
    }

}
