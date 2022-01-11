package com.dayz.comment.dto.request;

import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class RegisterCommentRequest {

    @ApiModelProperty(value = "개시글 ID", dataType = "number", example = "1")
    @NotNull(message = "postId must not be null.")
    private Long postId;

    @ApiModelProperty(value = "댓글 내용", dataType = "string", example = "댓글 1 입니다.")
    @NotNull(message = "comment must not be null or blank.")
    private String content;

}
