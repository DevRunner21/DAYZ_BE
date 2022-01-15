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
import io.swagger.annotations.*;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

@Api(tags = "ReviewController V1", value = "리뷰 CRUD API를 제공하는 Controller입니다.")
@RestController
@RequiredArgsConstructor
@RequestMapping(path = "api/v1")
public class ReviewController {

    private final ReviewService reviewService;

    @ApiOperation(
        value = "사용자 별 리뷰 목록 조회",
        notes = "사용자 별 리뷰 목록을 조회합니다.",
        produces = MediaType.APPLICATION_JSON_VALUE
    )
    @ApiResponses({
        @ApiResponse(code = 200, response = ReadReviewsByMemberResponse.class, message = "성공")
    })
    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/reviews", produces = MediaType.APPLICATION_JSON_VALUE)
    public CommonApiResponse<ReadReviewsByMemberResponse> readReviewsByMember(
        @ApiIgnore @LoginMemberId Long memberId,
        ReadReviewsByMemberRequest request
    ) {
        ReadReviewsByMemberResponse response = reviewService.getReviewsByMember(
            request.convertToPageRequest(Review.class),
            memberId
        );

        return CommonApiResponse.<ReadReviewsByMemberResponse>ok(response);
    }

    @ApiOperation(
        value = "공방 별 리뷰 목록 조회",
        notes = "공방 별 리뷰 목록을 조회합니다.",
        produces = MediaType.APPLICATION_JSON_VALUE
    )
    @ApiImplicitParams({
        @ApiImplicitParam(name = "atelierId", value = "공방 ID", required = true, dataType = "Long", paramType = "path", defaultValue = ""),
    })
    @ApiResponses({
        @ApiResponse(code = 200, response = ReadReviewsByAtelierResponse.class, message = "성공")
    })
    @ResponseStatus(HttpStatus.OK)
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

    @ApiOperation(
        value = "원데이클래스 별 리뷰 목록 조회",
        notes = "원데이클래스 별 리뷰 목록을 조회합니다.",
        produces = MediaType.APPLICATION_JSON_VALUE
    )
    @ApiImplicitParams({
        @ApiImplicitParam(name = "classId", value = "원데이클래스 ID", required = true, dataType = "Long", paramType = "path", defaultValue = ""),
    })
    @ApiResponses({
        @ApiResponse(code = 200, response = ReadReviewsByOneDayClassResponse.class, message = "성공")
    })
    @ResponseStatus(HttpStatus.OK)
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

    @ApiOperation(
        value = "공방 별 리뷰 평균평점 조회",
        notes = "공방 별 리뷰 평균평점을 조회합니다.",
        produces = MediaType.APPLICATION_JSON_VALUE
    )
    @ApiImplicitParams({
        @ApiImplicitParam(name = "atelierId", value = "공방 ID", required = true, dataType = "Long", paramType = "path", defaultValue = ""),
    })
    @ApiResponses({
        @ApiResponse(code = 200, response = ReadAvgScoreResponse.class, message = "성공")
    })
    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/reviews/score/ateliers/{atelierId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public CommonApiResponse<ReadAvgScoreResponse> readAvgScore(
        @PathVariable("atelierId") Long atelierId
    ) {
        double avgScore = reviewService.getAvgScore(atelierId);

        return CommonApiResponse.ok(ReadAvgScoreResponse.of(avgScore));
    }

    @ApiOperation(
        value = "리뷰 등록",
        notes = "리뷰를 등록합니다.",
        produces = MediaType.APPLICATION_JSON_VALUE
    )
    @ApiResponses({
        @ApiResponse(code = 200, response = RegisterReviewResponse.class, message = "성공")
    })
    @ResponseStatus(HttpStatus.OK)
    @PostMapping(value = "/reviews", produces = MediaType.APPLICATION_JSON_VALUE)
    public CommonApiResponse<RegisterReviewResponse> registerReview(
        @ApiIgnore @LoginMemberId Long memberId,
        @Valid @RequestBody RegisterReviewRequest registerReviewRequest
    ) {
        Long registeredReviewId = reviewService.saveReview(registerReviewRequest, memberId);

        return CommonApiResponse
            .<RegisterReviewResponse>ok(RegisterReviewResponse.of(registeredReviewId));
    }

}
