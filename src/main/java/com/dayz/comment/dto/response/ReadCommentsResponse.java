package com.dayz.comment.dto.response;

import com.dayz.common.dto.CustomPageResponse;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
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

    @ApiModel(value = "ReadCommentsResponse.CommentResult")
    @Getter
    @Setter(AccessLevel.PRIVATE)
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    public static class CommentResult {

        @ApiModelProperty(value = "댓글 내용", dataType = "string", example = "댓글 1 입니다.")
        @NotBlank(message = "content must not be null.")
        private String content;

        @ApiModelProperty(value = "댓글 생성일자", dataType = "string", example = "2022-01-09 12:30:30")
        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Seoul")
        @NotNull(message = "createdAt must not be null.")
        private LocalDateTime createdAt;

        @ApiModelProperty(value = "댓글 작성자 정보", dataType = "object")
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

    @ApiModel(value = "ReadCommentsResponse.CommentResult.MemberResult")
    @Getter
    @Setter(AccessLevel.PRIVATE)
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    public static class MemberResult {

        @ApiModelProperty(value = "작성자 이름", dataType = "string", example = "김지훈")
        @NotBlank(message = "name must not be null.")
        private String name;

        @ApiModelProperty(value = "작성자 썸네일 URL", dataType = "string", example = "https://dayz-s3.s3.ap-northeast-2.amazonaws.com/e6c6194d-93e1-4d39-b0c4-8ab2bc8b71e7-KakaoTalk_20210616_220854417.jpg")
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
