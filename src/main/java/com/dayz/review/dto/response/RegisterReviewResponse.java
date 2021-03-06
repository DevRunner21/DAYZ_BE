package com.dayz.review.dto.response;

import io.swagger.annotations.ApiModelProperty;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter(AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class RegisterReviewResponse {

    @ApiModelProperty(value = "리뷰 ID", dataType = "number", example = "1")
    private Long reviewId;

    public static RegisterReviewResponse of(Long reviewId) {
        RegisterReviewResponse registerReviewResponse = new RegisterReviewResponse();
        registerReviewResponse.setReviewId(reviewId);

        return registerReviewResponse;
    }

}
