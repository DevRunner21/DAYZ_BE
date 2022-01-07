package com.dayz.follow.converter;

import com.dayz.follow.domain.Follow;
import com.dayz.follow.dto.response.ReadFollowsResponse;
import org.springframework.stereotype.Component;

@Component
public class FollowConverter {

    public ReadFollowsResponse.FollowResult convertToReadFollowsFollowResult(Follow follow) {
        return ReadFollowsResponse.FollowResult.of(
            follow.getAtelier().getId(),
            follow.getAtelier().getName(),
            follow.getAtelier().getMember().getProfileImageUrl(),
            follow.getAtelier().getIntro()
        );
    }

}
