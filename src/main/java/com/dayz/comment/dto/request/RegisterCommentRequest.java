package com.dayz.comment.dto.request;

import javax.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class RegisterCommentRequest {

    @NotNull(message = "postId must not be null.")
    private Long postId;

    @NotNull(message = "atelierId must not be null.")
    private Long atelierId;

    @NotNull(message = "comment must not be null or blank.")
    private String content;

}
