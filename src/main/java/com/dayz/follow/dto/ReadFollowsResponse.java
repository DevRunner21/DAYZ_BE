package com.dayz.follow.dto;

import com.dayz.common.dto.CustomPageResponse;
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
public class ReadFollowsResponse extends CustomPageResponse<ReadFollowsResponse.FollowResult> {

    private ReadFollowsResponse(Page tPage) {
        super(tPage);
    }

    public static ReadFollowsResponse of(Page tPage) {
        return new ReadFollowsResponse(tPage);
    }

    @Getter
    @Setter(AccessLevel.PRIVATE)
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    public static class FollowResult {

        @NotNull(message = "atelierId must not be null.")
        private Long atelierId;

        @NotBlank(message = "name must not be null.")
        private String name;

        @NotBlank(message = "imageFileName must not be null.")
        private String imageFileName;

        @NotBlank(message = "intro must not be null.")
        private String intro;

        public static FollowResult of(
            Long atelierId,
            String name,
            String imageFileName,
            String intro
        ) {
            FollowResult followResult = new FollowResult();
            followResult.setAtelierId(atelierId);
            followResult.setName(name);
            followResult.setImageFileName(imageFileName);
            followResult.setIntro(intro);

            return followResult;
        }

    }

}
