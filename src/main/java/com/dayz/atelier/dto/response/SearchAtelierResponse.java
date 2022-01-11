package com.dayz.atelier.dto.response;

import com.dayz.common.dto.CustomPageResponse;
import com.querydsl.core.annotations.QueryProjection;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.domain.Page;

@Getter
@Setter(AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class SearchAtelierResponse extends CustomPageResponse<SearchAtelierResponse.AtelierResult> {

    private SearchAtelierResponse(Page tPage) {
        super(tPage);
    }

    public static SearchAtelierResponse of(Page tPage) {
        return new SearchAtelierResponse(tPage);
    }

    @ApiModel(value = "SearchAtelierResponse.AtelierResult")
    @Getter
    @Setter(AccessLevel.PRIVATE)
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    public static class AtelierResult {

        @ApiModelProperty(value = "공방 ID", dataType = "long", example = "1")
        private Long atelierId;

        @ApiModelProperty(value = "공방 이름", dataType = "string", example = "지훈공방")
        private String name;

        @ApiModelProperty(value = "공방 소개", dataType = "string", example = "안녕하세요~! 지훈공방입니다.")
        private String intro;

        @ApiModelProperty(value = "공방 썸네일 이미지 URL", dataType = "string", example = "https://dayz-s3.s3.ap-northeast-2.amazonaws.com/dochi.jpg")
        private String imageUrl;

        @QueryProjection
        public AtelierResult(Long atelierId, String name, String intro, String imageUrl) {
            this.atelierId = atelierId;
            this.name = name;
            this.intro = intro;
            this.imageUrl = imageUrl;
        }

    }

}
