package com.dayz.onedayclass.dto.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;
import javax.validation.Valid;
import javax.validation.constraints.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class RegisterOneDayClassRequest {

    @ApiModelProperty(value = "공방 ID", dataType = "number", example = "1")
    @NotNull(message = "atelierId is not null")
    private Long atelierId;

    @ApiModelProperty(value = "원데이클래스 이름", dataType = "string", example = "재미이쓴 도자기 클래스")
    @NotBlank(message = "name is not blank")
    private String name;

    @ApiModelProperty(value = "원데이클래스 소개", dataType = "string", example = "누구나 쉽게 배울 수 있는 도자기 클래스입니다.")
    private String intro;

    @ApiModelProperty(value = "카테고리 ID", dataType = "number", example = "1")
    @NotNull(message = "categoryId is not null")
    private Long categoryId;

    @ApiModelProperty(value = "최대 예약 가능 인원수", dataType = "number", example = "5")
    @Positive(message = "maxPeopleNumber must be positive")
    @Min(1)
    private int maxPeopleNumber;

    @ApiModelProperty(value = "가격", dataType = "number", example = "10000")
    @Positive(message = "price must be positive")
    private int price;

    @ApiModelProperty(value = "소요시간", dataType = "number", example = "01:00")
    @NotBlank(message = "requiredTime is not blank")
    @Pattern(regexp = "^(([0-1]{1}[0-9]{1})|([2]{1}[0-3]{1})):(([0-5]{1}[0-9]{1}))$", message = "requiredTime must be HH:mm format")
    private String requiredTime;

    @ApiModelProperty(value = "커리큘럼 목록", dataType = "array")
    @Valid
    private List<CurriculumParam> curriculums = new ArrayList<>();

    @ApiModelProperty(value = "원데이클래스 소개 이미지 목록", dataType = "array")
    @Valid
    private List<OneDayClassImageParam> images = new ArrayList<>();

    @ApiModelProperty(value = "예약 가능 시간 목록", dataType = "array")
    @Valid
    private List<OneDayClassTimeParam> oneDayClassTimes = new ArrayList<>();

    public static RegisterOneDayClassRequest of(
        Long atelierId,
        String name,
        String intro,
        Long categoryId,
        int maxPeopleNumber,
        int price,
        String requiredTime,
        List<CurriculumParam> curriculums,
        List<OneDayClassImageParam> images,
        List<OneDayClassTimeParam> oneDayClassTimes) {
        RegisterOneDayClassRequest registerOneDayClassRequest = new RegisterOneDayClassRequest();
        registerOneDayClassRequest.setAtelierId(atelierId);
        registerOneDayClassRequest.setName(name);
        registerOneDayClassRequest.setIntro(intro);
        registerOneDayClassRequest.setCategoryId(categoryId);
        registerOneDayClassRequest.setMaxPeopleNumber(maxPeopleNumber);
        registerOneDayClassRequest.setPrice(price);
        registerOneDayClassRequest.setRequiredTime(requiredTime);
        registerOneDayClassRequest.setCurriculums(curriculums);
        registerOneDayClassRequest.setImages(images);
        registerOneDayClassRequest.setOneDayClassTimes(oneDayClassTimes);

        return registerOneDayClassRequest;
    }

    @ApiModel(value = "RegisterOneDayClassRequest.CurriculumParam")
    @Getter
    @Setter(AccessLevel.PRIVATE)
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    public static class CurriculumParam {

        @ApiModelProperty(value = "커리큘럼 단계", dataType = "number", example = "1")
        @Positive(message = "step must be positive")
        @Min(1)
        private int step;

        @ApiModelProperty(value = "커리큘럼 내용", dataType = "string", example = "도자기를 준비한다.")
        private String content;

        public static CurriculumParam of(int step, String content) {
            CurriculumParam curriculumParam = new CurriculumParam();
            curriculumParam.setStep(step);
            curriculumParam.setContent(content);

            return curriculumParam;
        }

    }

    @ApiModel(value = "RegisterOneDayClassRequest.OneDayClassImageParam")
    @Getter
    @Setter(AccessLevel.PRIVATE)
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    public static class OneDayClassImageParam {

        @ApiModelProperty(value = "원데이클래스 소개 이미지 URL", dataType = "string", example = "https://dayz-s3.s3.ap-northeast-2.amazonaws.com/dojaki_1_1.jpeg")
        @NotBlank(message = "imageUrl is not blank")
        private String imageUrl;

        @ApiModelProperty(value = "원데이클래스 소개 이미지 순번", dataType = "integer", example = "1")
        @Positive(message = "sequence must be positive")
        @Min(1)
        private int sequence;

        public static OneDayClassImageParam of(String imageUrl, int sequence) {
            OneDayClassImageParam oneDayClassImageParam = new OneDayClassImageParam();
            oneDayClassImageParam.setImageUrl(imageUrl);
            oneDayClassImageParam.setSequence(sequence);

            return oneDayClassImageParam;
        }
    }

    @ApiModel(value = "RegisterOneDayClassRequest.OneDayClassTimeParam")
    @Getter
    @Setter(AccessLevel.PRIVATE)
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    public static class OneDayClassTimeParam {

        @ApiModelProperty(value = "원데이클래스 날짜", dataType = "string", example = "2022-01-09")
        @NotBlank(message = "date is not blank")
        @Pattern(regexp = "^(19[0-9]{2}|2[0-9]{3})-(0[1-9]|1[012])-([123]0|[012][1-9]|31)$", message = "date must be YYYY-MM-DD format")
        private String date;

        @ApiModelProperty(value = "수업 시작시간", dataType = "string", example = "13:00")
        @NotBlank(message = "startTime is not blank")
        @Pattern(regexp = "^(([0-1]{1}[0-9]{1})|([2]{1}[0-3]{1})):(([0-5]{1}[0-9]{1}))$", message = "workStartTime must be HH:mm format")
        private String startTime;

        @ApiModelProperty(value = "수업 종료시간", dataType = "string", example = "14:00")
        @NotBlank(message = "endTime is not blank")
        @Pattern(regexp = "^(([0-1]{1}[0-9]{1})|([2]{1}[0-3]{1})):(([0-5]{1}[0-9]{1}))$", message = "workStartTime must be HH:mm format")
        private String endTime;

        public static OneDayClassTimeParam of(String date, String startTime, String endTime) {
            OneDayClassTimeParam oneDayClassTimeParam = new OneDayClassTimeParam();
            oneDayClassTimeParam.setDate(date);
            oneDayClassTimeParam.setStartTime(startTime);
            oneDayClassTimeParam.setEndTime(endTime);

            return oneDayClassTimeParam;
        }

    }

}
