package com.dayz.review.controller;

import com.dayz.common.aop.LoginMember;
import com.dayz.common.dto.ApiResponse;
import com.dayz.common.dto.CustomPageRequest;
import com.dayz.common.dto.CustomPageResponse;
import com.dayz.member.domain.Member;
import com.dayz.review.dto.RegisterReviewRequest;
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
  public ApiResponse<CustomPageResponse> readReviews(@LoginMember Member member,
      CustomPageRequest pageRequest) {
    return ApiResponse.ok(reviewService.getAllReviews(pageRequest, member.getId()));
  }

  @GetMapping(value = "/reviews/ateliers/{atelierId}", produces = MediaType.APPLICATION_JSON_VALUE)
  public ApiResponse<CustomPageResponse> readAtelierReviews(
      @PathVariable("atelierId") Long atelierId,
      CustomPageRequest pageRequest
  ) {
    return ApiResponse.ok(reviewService.getAllAtelierReviews(pageRequest, atelierId));
  }

  @GetMapping(value = "/reviews/classes/{classId}", produces = MediaType.APPLICATION_JSON_VALUE)
  public ApiResponse<CustomPageResponse> readOneDayClassReviews(
      @PathVariable("classId") Long classId,
      @Valid CustomPageRequest pageRequest
  ) {
    return ApiResponse.ok(reviewService.getAllOneDayClassReviews(pageRequest, classId));
  }

  @GetMapping(value = "/reviews/score/ateliers/{atelierId}", produces = MediaType.APPLICATION_JSON_VALUE)
  public ApiResponse<Map<String, Double>> getAvgScore(@PathVariable("atelierId") Long atelierId) {
    return ApiResponse.ok(Map.of("avgScore", reviewService.getAvgScore(atelierId)));
  }

  @PostMapping(value = "/reviews", produces = MediaType.APPLICATION_JSON_VALUE)
  public ApiResponse<Map<String, Long>> saveReviews(
      @LoginMember Member member,
      @Valid @RequestBody RegisterReviewRequest registerReviewRequest
  ) {
    return ApiResponse
        .ok(Map.of("reviewId", reviewService.saveReview(registerReviewRequest, member)));
  }

}
