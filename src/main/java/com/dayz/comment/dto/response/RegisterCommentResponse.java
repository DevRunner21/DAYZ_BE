package com.dayz.comment.dto.response;

import io.swagger.annotations.ApiModelProperty;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter(AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class RegisterCommentResponse {

    @ApiModelProperty(value = "작성된 댓글 ID", dataType = "number", example = "1")
    private Long commentId;

    public static RegisterCommentResponse of(Long commentId) {
        RegisterCommentResponse registerCommentResponse = new RegisterCommentResponse();
        registerCommentResponse.setCommentId(commentId);

        return registerCommentResponse;
    }

}
