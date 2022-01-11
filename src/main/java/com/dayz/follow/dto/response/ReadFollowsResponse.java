package com.dayz.follow.dto.response;

import com.dayz.common.dto.CustomPageResponse;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
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

    @ApiModel(value = "ReadFollowsResponse.FollowResult")
    @Getter
    @Setter(AccessLevel.PRIVATE)
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    public static class FollowResult {

        @ApiModelProperty(value = "공방 ID", dataType = "number", example = "1")
        @NotNull(message = "atelierId must not be null.")
        private Long atelierId;

        @ApiModelProperty(value = "공방 이름", dataType = "string", example = "지훈공방")
        @NotBlank(message = "name must not be null.")
        private String name;

        @ApiModelProperty(value = "공방 썸네일 이미지 URL", dataType = "string", example = "https://dayz-s3.s3.ap-northeast-2.amazonaws.com/dochi.jpg")
        @NotBlank(message = "imageFileName must not be null.")
        private String imageFileName;

        @ApiModelProperty(value = "공방 소개", dataType = "string", example = "안녕하세요~! 지훈공방입니다.")
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
