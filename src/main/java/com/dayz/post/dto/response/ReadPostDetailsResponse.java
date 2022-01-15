package com.dayz.post.dto.response;

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

public class ReadPostDetailsResponse extends CustomPageResponse<ReadPostDetailsResponse.PostDetailResult> {

    private ReadPostDetailsResponse(Page tPage) {
        super(tPage);
    }

    public static ReadPostDetailsResponse of(Page tPage) {
        return new ReadPostDetailsResponse(tPage);
    }

    @ApiModel(value = "ReadPostDetailsResponse.PostDetailResult")
    @Getter
    @Setter(AccessLevel.PRIVATE)
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    public static class PostDetailResult {

        @ApiModelProperty(value = "게시글 ID", dataType = "long", example = "1")
        private Long postId;

        @ApiModelProperty(value = "게시글 내용", dataType = "string", example = "내일 토우 모양 도자기를 만들껍니다!! 너무 이쁘죠??")
        private String content;

        @ApiModelProperty(value = "게시글 이미지 목록", dataType = "array")
        private List<PostDetailResult.PostImageResult> images;

        @ApiModelProperty(value = "게시글 작성 공방 정보", dataType = "object")
        private PostDetailResult.AtelierResult atelier;

        @ApiModelProperty(value = "원데이클래스 ID", dataType = "number", example = "1")
        private Long oneDayClassId;

        @ApiModelProperty(value = "작성일자", dataType = "string", example = "2022-01-09")
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
            postDetailResult.setAtelier(atelierResult);
            postDetailResult.setOneDayClassId(oneDayClassId);
            postDetailResult.setCreatedAt(createdAt);

            return postDetailResult;
        }

        @ApiModel(value = "ReadPostDetailsResponse.PostDetailResult.PostImageResult")
        @Getter
        @Setter(AccessLevel.PRIVATE)
        @NoArgsConstructor(access = AccessLevel.PROTECTED)
        public static class PostImageResult {

            @ApiModelProperty(value = "게시글 이미지 URL", dataType = "string", example = "https://dayz-s3.s3.ap-northeast-2.amazonaws.com/dojaki_1_1.jpeg")
            private String imageUrl;

            @ApiModelProperty(value = "게시글 이미지 순번", dataType = "integer", example = "1")
            private int sequence;

            public static PostImageResult of(String imageUrl, int sequence) {
                PostImageResult postImageResult = new PostImageResult();
                postImageResult.setImageUrl(imageUrl);
                postImageResult.setSequence(sequence);

                return postImageResult;
            }

        }

        @ApiModel(value = "ReadPostDetailsResponse.PostDetailResult.AtelierResult")
        @Getter
        @Setter(AccessLevel.PRIVATE)
        @NoArgsConstructor(access = AccessLevel.PROTECTED)
        public static class AtelierResult {

            @ApiModelProperty(value = "공방 ID", dataType = "number", example = "1")
            private Long atelierId;

            @ApiModelProperty(value = "공방 이름", dataType = "string", example = "지훈공방")
            private String name;

            @ApiModelProperty(value = "공방 썸네일 이미지 URL", dataType = "string", example = "https://dayz-s3.s3.ap-northeast-2.amazonaws.com/dochi.jpg")
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
