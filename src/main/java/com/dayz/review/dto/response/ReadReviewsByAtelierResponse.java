package com.dayz.review.dto.response;

import com.dayz.common.dto.CustomPageResponse;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.time.LocalDateTime;
import java.util.List;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.domain.Page;

@Getter
@Setter(AccessLevel.PRIVATE)
@NoArgsConstructor
public class ReadReviewsByAtelierResponse extends CustomPageResponse<ReadReviewsByAtelierResponse.ReviewResult> {

    private ReadReviewsByAtelierResponse(Page tPage) {
        super(tPage);
    }

    public static ReadReviewsByAtelierResponse of(Page tPage) {
        return new ReadReviewsByAtelierResponse(tPage);
    }

    @ApiModel(value = "ReadReviewsByAtelierResponse.ReviewResult")
    @Getter
    @Setter(AccessLevel.PRIVATE)
    @NoArgsConstructor
    public static class ReviewResult {

        @ApiModelProperty(value = "리뷰 ID", dataType = "number", example = "1")
        private Long id;

        @ApiModelProperty(value = "리뷰 내용", dataType = "string", example = "너무 즐거운 시간이었습니다. 다음에 또 오고싶어요!!")
        private String content;

        @ApiModelProperty(value = "평점", dataType = "number", example = "4")
        private int score;

        @ApiModelProperty(value = "작성일자", dataType = "string", example = "2022-01-09")
        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "Asia/Seoul")
        private LocalDateTime createdAt;

        @ApiModelProperty(value = "리뷰 작성자 정보", dataType = "object")
        private MemberResult member;

        @ApiModelProperty(value = "원데이클래스 정보", dataType = "object")
        private OneDayClassResult oneDayClass;

        @ApiModelProperty(value = "리뷰 이미지 목록", dataType = "array")
        private List<ReviewImageResult> reviewImages;

        public static ReviewResult of(
            Long id,
            String content,
            int score,
            LocalDateTime createdAt,
            MemberResult member,
            OneDayClassResult oneDayClass,
            List<ReviewImageResult> reviewImages
        ) {
            ReviewResult reviewResponse = new ReviewResult();
            reviewResponse.setId(id);
            reviewResponse.setContent(content);
            reviewResponse.setScore(score);
            reviewResponse.setCreatedAt(createdAt);
            reviewResponse.setMember(member);
            reviewResponse.setOneDayClass(oneDayClass);
            reviewResponse.setReviewImages(reviewImages);

            return reviewResponse;
        }

        @ApiModel(value = "ReadReviewsByAtelierResponse.ReviewResult.MemberResult")
        @Getter
        @Setter(AccessLevel.PRIVATE)
        public static class MemberResult {

            @ApiModelProperty(value = "작성자 ID", dataType = "number", example = "1")
            private Long id;

            @ApiModelProperty(value = "작성자 이름", dataType = "string", example = "김지훈")
            private String username;

            @ApiModelProperty(value = "작성자 썸네일 이미지 URL", dataType = "string", example = "https://dayz-s3.s3.ap-northeast-2.amazonaws.com/dochi.jpg")
            private String profileImageUrl;

            public static MemberResult of(Long id, String username, String profileImageUrl) {
                MemberResult memberResult = new MemberResult();
                memberResult.setId(id);
                memberResult.setUsername(username);
                memberResult.setProfileImageUrl(profileImageUrl);

                return memberResult;
            }

        }

        @ApiModel(value = "ReadReviewsByAtelierResponse.ReviewResult.OneDayClassResult")
        @Getter
        @Setter(AccessLevel.PRIVATE)
        public static class OneDayClassResult {

            @ApiModelProperty(value = "원데이클래스 ID", dataType = "number", example = "1")
            private Long id;

            @ApiModelProperty(value = "원데이클래스 이름", dataType = "string", example = "재미이쓴 도자기 클래스")
            private String name;

            public static OneDayClassResult of(Long id, String name) {
                OneDayClassResult oneDayClassResult = new OneDayClassResult();
                oneDayClassResult.setId(id);
                oneDayClassResult.setName(name);

                return oneDayClassResult;
            }

        }

        @ApiModel(value = "ReadReviewsByAtelierResponse.ReviewResult.ReviewImageResult")
        @Getter
        @Setter(AccessLevel.PRIVATE)
        public static class ReviewImageResult {

            @ApiModelProperty(value = "리뷰 이미지 URL", dataType = "string", example = "https://dayz-s3.s3.ap-northeast-2.amazonaws.com/dojaki_1_1.jpeg")
            private String imageurl;

            @ApiModelProperty(value = "리뷰 이미지 순번", dataType = "integer", example = "1")
            private int sequence;

            public static ReviewImageResult of(String imageurl, int sequence) {
                ReviewImageResult reviewImageResult = new ReviewImageResult();
                reviewImageResult.setImageurl(imageurl);
                reviewImageResult.setSequence(sequence);
                return reviewImageResult;
            }

        }

    }

}



