package com.dayz.follow.dto.request;

import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter(AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class FollowRequest {

    @ApiModelProperty(value = "사용자 ID", dataType = "number", example = "1")
    @NotNull(message = "memberId must not be null.")
    private Long memberId;

    @ApiModelProperty(value = "팔로우 할 공방 ID", dataType = "number", example = "1")
    @NotNull(message = "atelierId must not be null.")
    private Long atelierId;

    public static FollowRequest of(Long memberId, Long atelierId) {
        FollowRequest followRequest = new FollowRequest();
        followRequest.setMemberId(memberId);
        followRequest.setAtelierId(atelierId);

        return followRequest;
    }

}
