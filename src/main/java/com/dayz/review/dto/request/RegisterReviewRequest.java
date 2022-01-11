package com.dayz.review.dto.request;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;
import javax.validation.Valid;
import javax.validation.constraints.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter(AccessLevel.PRIVATE)
@NoArgsConstructor
public class RegisterReviewRequest {

    @ApiModelProperty(value = "예약 ID", dataType = "number", example = "1")
    @NotNull(message = "reservationId must be not null")
    private Long reservationId;

    @ApiModelProperty(value = "리뷰 내용", dataType = "string", example = "너무 즐거운 시간이었습니다. 다음에 또 오고싶어요!!")
    @NotBlank(message = "reservationId must be not blank")
    private String content;

    @ApiModelProperty(value = "평점", dataType = "number", example = "4")
    @Positive(message = "score must be positive.")
    @Max(5)
    private int score;

    @ApiModelProperty(value = "리뷰 이미지 목록", dataType = "array")
    @Valid
    private List<ReviewImageParam> images = new ArrayList<>();

    public static RegisterReviewRequest of(Long reservationId, String content, int score,
        List<ReviewImageParam> images) {
        RegisterReviewRequest registerReviewRequest = new RegisterReviewRequest();
        registerReviewRequest.setReservationId(reservationId);
        registerReviewRequest.setContent(content);
        registerReviewRequest.setScore(score);
        registerReviewRequest.setImages(images);

        return registerReviewRequest;
    }

    @ApiModel(value = "RegisterReviewRequest.ReviewImageParam")
    @Getter
    @Setter(AccessLevel.PRIVATE)
    public static class ReviewImageParam {

        @ApiModelProperty(value = "리뷰 이미지 URL", dataType = "string", example = "https://dayz-s3.s3.ap-northeast-2.amazonaws.com/dojaki_1_1.jpeg")
        @NotBlank(message = "파일 이름이 null이 될 수 없습니다.")
        private String imageUrl;

        @ApiModelProperty(value = "리뷰 이미지 순번", dataType = "integer", example = "1")
        @Min(value = 1, message = "sequence는 1이상이어야 합니다.")
        private int sequence;

        public static ReviewImageParam of(String imageUrl, int sequence) {
            ReviewImageParam reviewImageParam = new ReviewImageParam();
            reviewImageParam.setImageUrl(imageUrl);
            reviewImageParam.setSequence(sequence);

            return reviewImageParam;
        }

    }

}
