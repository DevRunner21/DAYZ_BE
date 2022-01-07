package com.dayz.post.dto.response;

import com.dayz.common.dto.CustomPageResponse;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.time.LocalDateTime;
import java.util.List;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.domain.Page;

public class ReadPostDetailsResponse extends CustomPageResponse<ReadPostDetailsResponse.PostDetailResult> {

    private ReadPostDetailsResponse(Page tPage) {
        super(tPage);
    }

    public static ReadPostDetailsResponse of(Page tPage) {
        return new ReadPostDetailsResponse(tPage);
    }

    @Getter
    @Setter(AccessLevel.PRIVATE)
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    public static class PostDetailResult {

        private Long postId;

        private String content;

        private List<PostDetailResult.PostImageResult> images;

        private PostDetailResult.AtelierResult atelierResult;

        private Long oneDayClassId;

        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Seoul")
        private LocalDateTime createdAt;

        public static PostDetailResult of(Long postId,
            String content,
            List<PostDetailResult.PostImageResult> images,
            PostDetailResult.AtelierResult atelierResult,
            Long oneDayClassId,
            LocalDateTime createdAt) {
            PostDetailResult postDetailResult = new PostDetailResult();
            postDetailResult.setPostId(postId);
            postDetailResult.setContent(content);
            postDetailResult.setImages(images);
            postDetailResult.setAtelierResult(atelierResult);
            postDetailResult.setOneDayClassId(oneDayClassId);
            postDetailResult.setCreatedAt(createdAt);

            return postDetailResult;
        }

        @Getter
        @Setter(AccessLevel.PRIVATE)
        @NoArgsConstructor(access = AccessLevel.PROTECTED)
        public static class PostImageResult {

            private String imageUrl;

            private int sequence;

            public static PostImageResult of(String imageUrl, int sequence) {
                PostImageResult postImageResult = new PostImageResult();
                postImageResult.setImageUrl(imageUrl);
                postImageResult.setSequence(sequence);

                return postImageResult;
            }

        }

        @Getter
        @Setter(AccessLevel.PRIVATE)
        @NoArgsConstructor(access = AccessLevel.PROTECTED)
        public static class AtelierResult {

            private Long atelierId;

            private String name;

            private String imageUrl;

            public static AtelierResult of(Long atelierId, String name, String imageUrl) {
                AtelierResult atelierResult = new AtelierResult();
                atelierResult.setAtelierId(atelierId);
                atelierResult.setName(name);
                atelierResult.setImageUrl(imageUrl);

                return atelierResult;
            }

        }

    }

}
