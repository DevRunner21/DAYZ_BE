package com.dayz.comment.dto.response;

import com.dayz.common.dto.CustomPageResponse;
import java.time.LocalDateTime;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.domain.Page;

@Getter
@Setter(AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ReadCommentsResponse extends CustomPageResponse<ReadCommentsResponse.CommentResult> {

    private ReadCommentsResponse(Page tPage) {
        super(tPage);
    }

    public static ReadCommentsResponse of(Page tPage) {
        return new ReadCommentsResponse(tPage);
    }

    @Getter
    @Setter(AccessLevel.PRIVATE)
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    public static class CommentResult {

        @NotBlank(message = "content must not be null.")
        private String content;

        @NotNull(message = "createdAt must not be null.")
        private LocalDateTime createdAt;

        @NotNull(message = "member must not be null.")
        private ReadCommentsResponse.MemberResult member;

        public static CommentResult of(
            String content,
            LocalDateTime createdAt,
            ReadCommentsResponse.MemberResult member
        ) {
            CommentResult commentResult = new CommentResult();
            commentResult.setContent(content);
            commentResult.setCreatedAt(createdAt);
            commentResult.setMember(member);

            return commentResult;
        }

    }

    @Getter
    @Setter(AccessLevel.PRIVATE)
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    public static class MemberResult {

        @NotBlank(message = "name must not be null.")
        private String name;

        @NotBlank(message = "imageUrl must not be null.")
        private String imageUrl;

        public static ReadCommentsResponse.MemberResult of(String name, String imageUrl) {
            ReadCommentsResponse.MemberResult memberResult = new ReadCommentsResponse.MemberResult();
            memberResult.setName(name);
            memberResult.setImageUrl(imageUrl);

            return memberResult;
        }

    }

}
