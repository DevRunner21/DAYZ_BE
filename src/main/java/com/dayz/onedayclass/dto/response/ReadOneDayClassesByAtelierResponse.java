package com.dayz.onedayclass.dto.response;

import com.dayz.common.dto.CustomPageResponse;
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
public class ReadOneDayClassesByAtelierResponse extends CustomPageResponse<ReadOneDayClassesByAtelierResponse.OneDayClassResult> {

    private ReadOneDayClassesByAtelierResponse(Page tPage) {
        super(tPage);
    }

    public static ReadOneDayClassesByAtelierResponse of(Page tPage) {
        return new ReadOneDayClassesByAtelierResponse(tPage);
    }

    @ApiModel(value = "ReadOneDayClassesByAtelierResponse.OneDayClassResult")
    @Getter
    @Setter(AccessLevel.PRIVATE)
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    public static class OneDayClassResult {

        @ApiModelProperty(value = "원데이클래스 ID", dataType = "number", example = "1")
        private Long classId;

        @ApiModelProperty(value = "원데이클래스 이름", dataType = "string", example = "재미이쓴 도자기 클래스")
        private String name;

        @ApiModelProperty(value = "원데이클래스 소개 이미지 URL", dataType = "string", example = "https://dayz-s3.s3.ap-northeast-2.amazonaws.com/dojaki_1_1.jpeg")
        private String imageUrl;

        public static OneDayClassResult of(Long oneDayClassId, String name, String imageUrl) {
            OneDayClassResult oneDayClassResult = new OneDayClassResult();
            oneDayClassResult.setClassId(oneDayClassId);
            oneDayClassResult.setName(name);
            oneDayClassResult.setImageUrl(imageUrl);

            return oneDayClassResult;
        }

    }

}
