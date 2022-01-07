package com.dayz.follow.dto.response;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter(AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class RegisterFollowResponse {

    private boolean followFlag;

    public static RegisterFollowResponse of (boolean followFlag) {
        RegisterFollowResponse registerFollowResponse = new RegisterFollowResponse();
        registerFollowResponse.setFollowFlag(followFlag);

        return registerFollowResponse;
    }

}
