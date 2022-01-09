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
@NoArgsConstructor
public class SearchOneDayClassResponse extends CustomPageResponse<SearchOneDayClassResponse.OneDayClassResult> {

    private SearchOneDayClassResponse(Page tPage) {
        super(tPage);
    }

    public static SearchOneDayClassResponse of(Page tPage) {
        return new SearchOneDayClassResponse(tPage);
    }

    @ApiModel(value = "SearchOneDayClassResponse.OneDayClassResult")
    @Getter
    @Setter(AccessLevel.PRIVATE)
    @NoArgsConstructor
    public static class OneDayClassResult {

        @ApiModelProperty(value = "원데이클래스 ID", dataType = "number", example = "1")
        private Long classId;

        @ApiModelProperty(value = "원데이클래스 이름", dataType = "string", example = "재미이쓴 도자기 클래스")
        private String name;

        @ApiModelProperty(value = "원데이클래스 소개", dataType = "string", example = "누구나 쉽게 배울 수 있는 도자기 클래스입니다.")
        private String intro;

        @ApiModelProperty(value = "원데이클래스 소개 이미지 URL", dataType = "string", example = "https://dayz-s3.s3.ap-northeast-2.amazonaws.com/dojaki_1_1.jpeg")
        private String imageUrl;

        public static OneDayClassResult of(
            Long classId,
            String name,
            String intro,
            String imageUrl
        ) {
            OneDayClassResult oneDayClassResult = new OneDayClassResult();
            oneDayClassResult.setClassId(classId);
            oneDayClassResult.setName(name);
            oneDayClassResult.setIntro(intro);
            oneDayClassResult.setImageUrl(imageUrl);

            return oneDayClassResult;
        }

    }

}
