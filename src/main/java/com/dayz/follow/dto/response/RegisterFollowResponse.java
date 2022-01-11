package com.dayz.follow.dto.response;

import io.swagger.annotations.ApiModelProperty;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter(AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class RegisterFollowResponse {

    @ApiModelProperty(value = "팔로우 결과", dataType = "boolean", example = "true")
    private boolean followFlag;

    public static RegisterFollowResponse of (boolean followFlag) {
        RegisterFollowResponse registerFollowResponse = new RegisterFollowResponse();
        registerFollowResponse.setFollowFlag(followFlag);

        return registerFollowResponse;
    }

}
