package com.dayz.atelier.dto.response;

import com.dayz.common.dto.CustomPageResponse;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import org.springframework.data.domain.Page;

@Getter
@Setter(AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class ReadAteliersResponse extends CustomPageResponse<ReadAteliersResponse.AtelierResult> {

    private ReadAteliersResponse(Page tPage) {
        super(tPage);
    }

    public static ReadAteliersResponse of(Page tPage) {
        return new ReadAteliersResponse(tPage);
    }

    @ApiModel(value = "ReadAteliersResponse.AtelierResult")
    @Getter
    @Setter(AccessLevel.PRIVATE)
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    public static class AtelierResult {

        @ApiModelProperty(value = "공방 ID", dataType = "number", example = "1")
        private Long atelierId;

        @ApiModelProperty(value = "공방 이름", dataType = "string", example = "지훈공방")
        private String name;

        @ApiModelProperty(value = "공방 썸네일 이미지 URL", dataType = "string", example = "https://dayz-s3.s3.ap-northeast-2.amazonaws.com/dochi.jpg")
        private String imageUrl;

        @ApiModelProperty(value = "공방 소개", dataType = "string", example = "안녕하세요~! 지훈공방입니다.")
        private String intro;

        public static AtelierResult of(Long atelierId, String name, String imageUrl, String intro) {
            AtelierResult atelierResult = new AtelierResult();
            atelierResult.setAtelierId(atelierId);
            atelierResult.setName(name);
            atelierResult.setIntro(intro);
            atelierResult.setImageUrl(imageUrl);

            return atelierResult;
        }

    }

}
