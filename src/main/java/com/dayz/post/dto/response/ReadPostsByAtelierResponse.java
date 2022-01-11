package com.dayz.post.dto.response;

import com.dayz.common.dto.CustomPageResponse;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.time.LocalDateTime;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.domain.Page;

public class ReadPostsByAtelierResponse extends CustomPageResponse<ReadPostsByAtelierResponse.PostResult> {

    private ReadPostsByAtelierResponse(Page tPage) {
        super(tPage);
    }

    public static ReadPostsByAtelierResponse of(Page tPage) {
        return new ReadPostsByAtelierResponse(tPage);
    }

    @ApiModel(value = "ReadPostsByAtelierResponse.PostResult")
    @Getter
    @Setter(AccessLevel.PRIVATE)
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    public static class PostResult {

        @ApiModelProperty(value = "게시글 ID", dataType = "number", example = "1")
        private Long postId;

        @ApiModelProperty(value = "게시글 이미지 URL", dataType = "string", example = "https://dayz-s3.s3.ap-northeast-2.amazonaws.com/dojaki_1_1.jpeg")
        private String imageUrl;

        @ApiModelProperty(value = "작성일자", dataType = "string", example = "2022-01-09")
        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "Asia/Seoul")
        private LocalDateTime createdAt;

        public static PostResult of(Long postId, String imageUrl, LocalDateTime createdAt) {
            PostResult postResult = new PostResult();
            postResult.setPostId(postId);
            postResult.setImageUrl(imageUrl);
            postResult.setCreatedAt(createdAt);

            return postResult;
        }

    }

}
