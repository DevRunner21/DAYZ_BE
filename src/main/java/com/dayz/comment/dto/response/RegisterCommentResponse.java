package com.dayz.comment.dto.response;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter(AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class RegisterCommentResponse {

    private Long commentId;

    public static RegisterCommentResponse of(Long commentId) {
        RegisterCommentResponse registerCommentResponse = new RegisterCommentResponse();
        registerCommentResponse.setCommentId(commentId);

        return registerCommentResponse;
    }

}
