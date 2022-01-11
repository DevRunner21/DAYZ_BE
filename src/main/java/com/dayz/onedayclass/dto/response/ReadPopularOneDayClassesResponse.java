package com.dayz.onedayclass.dto.response;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter(AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ReadPopularOneDayClassesResponse {

    @ApiModelProperty(value = "우너데이클래스 목록", dataType = "array")
    private List<OneDayClassResult> oneDayClasses = new ArrayList<>();

    public static ReadPopularOneDayClassesResponse of(List<OneDayClassResult> oneDayClasses) {
        ReadPopularOneDayClassesResponse readPopularOneDayClassesResponse = new ReadPopularOneDayClassesResponse();
        readPopularOneDayClassesResponse.setOneDayClasses(oneDayClasses);

        return readPopularOneDayClassesResponse;
    }

    @ApiModel(value = "ReadPopularOneDayClassesResponse.OneDayClassResult")
    @Getter
    @Setter(AccessLevel.PRIVATE)
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    public static class OneDayClassResult {

        @ApiModelProperty(value = "원데이클래스 ID", dataType = "number", example = "1")
        private Long classId;

        @ApiModelProperty(value = "원데이클래스 이름", dataType = "string", example = "재미이쓴 도자기 클래스")
        private String name;

        @ApiModelProperty(value = "원데이클래스 소개", dataType = "string", example = "누구나 쉽게 배울 수 있는 도자기 클래스입니다.")
        private String intro;

        @ApiModelProperty(value = "원데이클래스 소개 이미지 URL", dataType = "string", example = "https://dayz-s3.s3.ap-northeast-2.amazonaws.com/dojaki_1_1.jpeg")
        private String imageUrl;

        public static OneDayClassResult of(Long oneDayClassId, String name, String intro, String imageUrl) {
            OneDayClassResult oneDayClassResult = new OneDayClassResult();
            oneDayClassResult.setClassId(oneDayClassId);
            oneDayClassResult.setName(name);
            oneDayClassResult.setIntro(intro);
            oneDayClassResult.setImageUrl(imageUrl);

            return oneDayClassResult;
        }

    }

}
