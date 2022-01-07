package com.dayz.review.dto.response;

import com.dayz.common.dto.CustomPageResponse;
import com.fasterxml.jackson.annotation.JsonFormat;
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
public class ReadReviewsByOneDayClassResponse extends
    CustomPageResponse<ReadReviewsByOneDayClassResponse.ReviewResult> {

    private ReadReviewsByOneDayClassResponse(Page tPage) {
        super(tPage);
    }

    public static ReadReviewsByOneDayClassResponse of(Page tPage) {
        return new ReadReviewsByOneDayClassResponse(tPage);
    }

    @Getter
    @Setter(AccessLevel.PRIVATE)
    @NoArgsConstructor
    public static class ReviewResult {

        private Long id;

        private String content;

        private int score;

        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "Asia/Seoul")
        private LocalDateTime createdAt;

        private OneDayClassMemberResult member;

        private List<OneDayClassReviewImageResult> reviewImage;

        public static ReviewResult of(
            Long id,
            String content,
            int score,
            LocalDateTime createdAt,
            OneDayClassMemberResult member,
            List<OneDayClassReviewImageResult> reviewImages
        ) {
            ReviewResult reviewResponse = new ReviewResult();
            reviewResponse.setId(id);
            reviewResponse.setContent(content);
            reviewResponse.setScore(score);
            reviewResponse.setCreatedAt(createdAt);
            reviewResponse.setMember(member);
            reviewResponse.setReviewImage(reviewImages);

            return reviewResponse;
        }

        @Getter
        @Setter(AccessLevel.PRIVATE)
        public static class OneDayClassMemberResult {

            private Long id;

            private String username;

            private String profileImageUrl;

            public static OneDayClassMemberResult of(
                Long id,
                String username,
                String profileImageUrl
            ) {
                OneDayClassMemberResult memberResult = new OneDayClassMemberResult();
                memberResult.setId(id);
                memberResult.setUsername(username);
                memberResult.setProfileImageUrl(profileImageUrl);

                return memberResult;
            }

        }

        @Getter
        @Setter(AccessLevel.PRIVATE)
        public static class OneDayClassReviewImageResult {

            private String imageUrl;

            private int sequence;

            public static OneDayClassReviewImageResult of(
                String imageUrl,
                int sequence
            ) {
                OneDayClassReviewImageResult reviewImageResult = new OneDayClassReviewImageResult();
                reviewImageResult.setImageUrl(imageUrl);
                reviewImageResult.setSequence(sequence);
                return reviewImageResult;
            }

        }

    }

}



