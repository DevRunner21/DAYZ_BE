package com.dayz.post.dto.response;

import com.dayz.common.dto.CustomPageResponse;
import com.fasterxml.jackson.annotation.JsonFormat;
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

    @Getter
    @Setter(AccessLevel.PRIVATE)
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    public static class PostResult {

        private Long postId;

        private String imageUrl;

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
