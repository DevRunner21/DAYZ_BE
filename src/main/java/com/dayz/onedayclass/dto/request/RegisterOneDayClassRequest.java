package com.dayz.onedayclass.dto.request;

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

    @NotNull(message = "atelierId is not null")
    private Long atelierId;

    @NotBlank(message = "name is not blank")
    private String name;

    private String intro;

    @NotNull(message = "categoryId is not null")
    private Long categoryId;

    @Positive(message = "maxPeopleNumber must be positive")
    @Min(1)
    private int maxPeopleNumber;

    @Positive(message = "price must be positive")
    private int price;

    @NotBlank(message = "requiredTime is not blank")
    @Pattern(regexp = "^(([0-1]{1}[0-9]{1})|([2]{1}[0-3]{1})):(([0-5]{1}[0-9]{1}))$", message = "requiredTime must be HH:mm format")
    private String requiredTime;

    @Valid
    private List<CurriculumParam> curriculums = new ArrayList<>();

    @Valid
    private List<OneDayClassImageRequest> images = new ArrayList<>();

    @Valid
    private List<OneDayClassTimeRequest> oneDayClassTimes = new ArrayList<>();

    public static RegisterOneDayClassRequest of(
        Long atelierId,
        String name,
        String intro,
        Long categoryId,
        int maxPeopleNumber,
        int price,
        String requiredTime,
        List<CurriculumParam> curriculums,
        List<OneDayClassImageRequest> images,
        List<OneDayClassTimeRequest> oneDayClassTimes) {
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

    @Getter
    @Setter(AccessLevel.PRIVATE)
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    public static class CurriculumParam {

        @Positive(message = "step must be positive")
        @Min(1)
        private int step;

        private String content;

        public static CurriculumParam of(int step, String content) {
            CurriculumParam curriculumParam = new CurriculumParam();
            curriculumParam.setStep(step);
            curriculumParam.setContent(content);

            return curriculumParam;
        }

    }

    @Getter
    @Setter(AccessLevel.PRIVATE)
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    public static class OneDayClassImageRequest {

        @NotBlank(message = "imageUrl is not blank")
        private String imageUrl;

        @Positive(message = "sequence must be positive")
        @Min(1)
        private int sequence;

        public static OneDayClassImageRequest of(String imageUrl, int sequence) {
            OneDayClassImageRequest oneDayClassImageRequest = new OneDayClassImageRequest();
            oneDayClassImageRequest.setImageUrl(imageUrl);
            oneDayClassImageRequest.setSequence(sequence);

            return oneDayClassImageRequest;
        }
    }

    @Getter
    @Setter(AccessLevel.PRIVATE)
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    public static class OneDayClassTimeRequest {

        @NotBlank(message = "date is not blank")
        @Pattern(regexp = "^(19[0-9]{2}|2[0-9]{3})-(0[1-9]|1[012])-([123]0|[012][1-9]|31)$", message = "date must be YYYY-MM-DD format")
        private String date;

        @NotBlank(message = "startTime is not blank")
        @Pattern(regexp = "^(([0-1]{1}[0-9]{1})|([2]{1}[0-3]{1})):(([0-5]{1}[0-9]{1}))$", message = "workStartTime must be HH:mm format")
        private String startTime;

        @NotBlank(message = "endTime is not blank")
        @Pattern(regexp = "^(([0-1]{1}[0-9]{1})|([2]{1}[0-3]{1})):(([0-5]{1}[0-9]{1}))$", message = "workStartTime must be HH:mm format")
        private String endTime;

        public static OneDayClassTimeRequest of(String date, String startTime, String endTime) {
            OneDayClassTimeRequest oneDayClassTimeRequest = new OneDayClassTimeRequest();
            oneDayClassTimeRequest.setDate(date);
            oneDayClassTimeRequest.setStartTime(startTime);
            oneDayClassTimeRequest.setEndTime(endTime);

            return oneDayClassTimeRequest;
        }

    }

}
