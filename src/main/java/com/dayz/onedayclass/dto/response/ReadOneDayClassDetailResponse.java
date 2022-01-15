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
public class ReadOneDayClassDetailResponse {

    @ApiModelProperty(value = "원데이클래스 ID", dataType = "number", example = "1")
    private Long classId;

    @ApiModelProperty(value = "원데이클래스 이름", dataType = "string", example = "재미이쓴 도자기 클래스")
    private String name;

    @ApiModelProperty(value = "원데이클래스 소개", dataType = "string", example = "누구나 쉽게 배울 수 있는 도자기 클래스입니다.")
    private String intro;

    @ApiModelProperty(value = "가격", dataType = "number", example = "10000")
    private int price;

    @ApiModelProperty(value = "평균 평점", dataType = "number", example = "4")
    private double avgScore;

    @ApiModelProperty(value = "최대 예약 가능 인원수", dataType = "number", example = "5")
    private int maxPeopleNumber;

    @ApiModelProperty(value = "원데이클래스 소개 이미지 목록", dataType = "array")
    private List<OneDayClassImageResult> images = new ArrayList<>();

    @ApiModelProperty(value = "커리큘럼 목록", dataType = "array")
    private List<CurriculumResult> curriculums = new ArrayList<>();

    @ApiModelProperty(value = "공방 정보", dataType = "object")
    private AtelierResult atelier;

    public static ReadOneDayClassDetailResponse of(Long classId,
            String name,
            String intro,
            int price,
            double avgScore,
            int maxPeopleNumber,
            List<OneDayClassImageResult> images,
            List<CurriculumResult> curriculums,
            AtelierResult atelier
    ) {

        ReadOneDayClassDetailResponse readOneDayClassDetailResponse = new ReadOneDayClassDetailResponse();
        readOneDayClassDetailResponse.setClassId(classId);
        readOneDayClassDetailResponse.setName(name);
        readOneDayClassDetailResponse.setIntro(intro);
        readOneDayClassDetailResponse.setPrice(price);
        readOneDayClassDetailResponse.setAvgScore(avgScore);
        readOneDayClassDetailResponse.setMaxPeopleNumber(maxPeopleNumber);
        readOneDayClassDetailResponse.setImages(images);
        readOneDayClassDetailResponse.setCurriculums(curriculums);
        readOneDayClassDetailResponse.setAtelier(atelier);

        return readOneDayClassDetailResponse;
    }

    @ApiModel(value = "ReadOneDayClassDetailResponse.OneDayClassImageResult")
    @Getter
    @Setter(AccessLevel.PRIVATE)
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    public static class OneDayClassImageResult {

        @ApiModelProperty(value = "원데이클래스 소개 이미지 URL", dataType = "string", example = "https://dayz-s3.s3.ap-northeast-2.amazonaws.com/dojaki_1_1.jpeg")
        private String imageUrl;

        @ApiModelProperty(value = "원데이클래스 소개 이미지 순번", dataType = "integer", example = "1")
        private int sequence;

        public static OneDayClassImageResult of(String imageUrl, int sequence) {
            OneDayClassImageResult oneDayClassImageResult = new OneDayClassImageResult();
            oneDayClassImageResult.setImageUrl(imageUrl);
            oneDayClassImageResult.setSequence(sequence);

            return oneDayClassImageResult;
        }

    }

    @ApiModel(value = "ReadOneDayClassDetailResponse.CurriculumResult")
    @Getter
    @Setter(AccessLevel.PRIVATE)
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    public static class CurriculumResult {

        @ApiModelProperty(value = "커리큘럼 ID", dataType = "number", example = "1")
        private Long curriculumId;

        @ApiModelProperty(value = "커리큘럼 단계", dataType = "number", example = "1")
        private int step;

        @ApiModelProperty(value = "커리큘럼 내용", dataType = "string", example = "도자기를 준비한다.")
        private String content;

        public static CurriculumResult of(Long curriculumId, int step, String content) {
            CurriculumResult curriculumResult = new CurriculumResult();
            curriculumResult.setCurriculumId(curriculumId);
            curriculumResult.setStep(step);
            curriculumResult.setContent(content);

            return curriculumResult;
        }

    }

    @ApiModel(value = "ReadOneDayClassDetailResponse.AtelierResult")
    @Getter
    @Setter(AccessLevel.PRIVATE)
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    public static class AtelierResult {

        @ApiModelProperty(value = "공방 ID", dataType = "number", example = "1")
        private Long atelierId;

        @ApiModelProperty(value = "공방 이름", dataType = "string", example = "지훈공방")
        private String name;

        @ApiModelProperty(value = "공방 주소", dataType = "string", example = "강남구 자곡동 율암빌딩 2층 201호")
        private String address;

        @ApiModelProperty(value = "공방 전화번호", dataType = "string", example = "0312234544")
        private String callNumber;

        @ApiModelProperty(value = "공방 오픈시간", dataType = "string", example = "09:30")
        private String startTime;

        @ApiModelProperty(value = "공방 마감시간", dataType = "string", example = "19:30")
        private String endTime;

        @ApiModelProperty(value = "공방 썸네일 이미지 URL", dataType = "string", example = "https://dayz-s3.s3.ap-northeast-2.amazonaws.com/dochi.jpg")
        private String imageUrl;

        public static AtelierResult of(Long atelierId, String name, String address, String callNumber, String startTime, String endTime, String imageUrl) {
            AtelierResult atelierResult = new AtelierResult();
            atelierResult.setAtelierId(atelierId);
            atelierResult.setName(name);
            atelierResult.setAddress(address);
            atelierResult.setCallNumber(callNumber);
            atelierResult.setStartTime(startTime);
            atelierResult.setEndTime(endTime);
            atelierResult.setImageUrl(imageUrl);

            return atelierResult;
        }

    }

}
