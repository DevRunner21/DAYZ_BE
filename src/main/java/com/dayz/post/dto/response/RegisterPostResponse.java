package com.dayz.post.dto.response;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter(AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class RegisterPostResponse {

    private Long postId;

    public static RegisterPostResponse of(Long postId) {
        RegisterPostResponse registerPostResponse = new RegisterPostResponse();
        registerPostResponse.setPostId(postId);

        return registerPostResponse;
    }

}
