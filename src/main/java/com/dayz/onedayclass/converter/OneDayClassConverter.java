package com.dayz.onedayclass.converter;

import com.dayz.atelier.domain.Atelier;
import com.dayz.category.domain.Category;
import com.dayz.common.enums.TimeStatus;
import com.dayz.common.util.ImageUrlUtil;
import com.dayz.common.util.TimeUtil;
import com.dayz.member.domain.Address;
import com.dayz.onedayclass.domain.Curriculum;
import com.dayz.onedayclass.domain.OneDayClass;
import com.dayz.onedayclass.domain.OneDayClassImage;
import com.dayz.onedayclass.domain.OneDayClassTime;
import com.dayz.onedayclass.dto.request.SaveOneDayClassRequest;
import com.dayz.onedayclass.dto.request.SaveOneDayClassRequest.CurriculumParam;
import com.dayz.onedayclass.dto.response.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

@Component
@RequiredArgsConstructor
public class OneDayClassConverter {

    private final ImageUrlUtil imageUrlUtil;

    private final TimeUtil timeUtil;

    public ReadOneDayClassesByCategoryResponse.OneDayClassResult convertToReadOneDayClassesByCategoryResult(
        OneDayClass oneDayClass
    ) {
        return ReadOneDayClassesByCategoryResponse.OneDayClassResult.of(
            oneDayClass.getId(),
            oneDayClass.getName(),
            oneDayClass.getIntro(),
            getFirstImageUrl(oneDayClass.getOneDayClassImages())
        );
    }

    public ReadOneDayClassDetailResponse convertToReadOneDayClassDetailResponse(
        OneDayClass oneDayClass,
        double avgScore
    ) {
        return ReadOneDayClassDetailResponse.of(
            oneDayClass.getId(),
            oneDayClass.getName(),
            oneDayClass.getIntro(),
            oneDayClass.getPrice(),
            avgScore,
            oneDayClass.getMaxPeopleNumber(),
            oneDayClass.getOneDayClassImages().stream()
                .map(this::convertToReadOneDayClassDetailOneDayClassImageResult)
                .collect(Collectors.toList()),
            oneDayClass.getCurriculums().stream()
                .map(this::convertToReadOneDayClassDetailCurriculum)
                .collect(Collectors.toList()),
            convertToReadOneDayClassDetailAtelierResult(oneDayClass.getAtelier())
        );
    }

    public ReadOneDayClassDetailResponse.OneDayClassImageResult convertToReadOneDayClassDetailOneDayClassImageResult(
        OneDayClassImage oneDayClassImage
    ) {
        return ReadOneDayClassDetailResponse.OneDayClassImageResult.of(
            imageUrlUtil.makeImageUrl(oneDayClassImage.getImageFileName()),
            oneDayClassImage.getSequence()
        );
    }

    public ReadOneDayClassDetailResponse.CurriculumResult convertToReadOneDayClassDetailCurriculum(
        Curriculum curriculum
    ) {
        return ReadOneDayClassDetailResponse.CurriculumResult.of(
            curriculum.getId(),
            curriculum.getStep(),
            curriculum.getContent()
        );
    }

    public ReadOneDayClassDetailResponse.AtelierResult convertToReadOneDayClassDetailAtelierResult(
        Atelier atelier
    ) {
        return ReadOneDayClassDetailResponse.AtelierResult.of(
            atelier.getId(),
            atelier.getName(),
            getFullAddress(atelier.getAddress(), atelier.getDetail()),
            atelier.getCallNumber(),
            timeUtil.secondToTimeString(atelier.getWorkTime().getStartTime()),
            timeUtil.secondToTimeString(atelier.getWorkTime().getEndTime()),
            atelier.getMember().getProfileImageUrl()
        );
    }

    public ReadOneDayClassesByAtelierResponse.OneDayClassResult convertToReadOneDayClassesByAtelierAtelierResult(
        OneDayClass oneDayClass
    ) {
        return ReadOneDayClassesByAtelierResponse.OneDayClassResult.of(
            oneDayClass.getId(),
            oneDayClass.getName(),
            getFirstImageUrl(oneDayClass.getOneDayClassImages())
        );
    }

    public SearchOneDayClassResponse.OneDayClassResult convertSearchOneDayClassOneDayClassResult(OneDayClass oneDayClass) {
        return SearchOneDayClassResponse.OneDayClassResult.of(
            oneDayClass.getId(),
            oneDayClass.getName(),
            oneDayClass.getIntro(),
            getFirstImageUrl(oneDayClass.getOneDayClassImages())
        );
    }

    public ReadPopularOneDayClassesResponse converToReadPopularOneDayClassesResponse(
        List<OneDayClass> oneDayClasses
    ) {
        return ReadPopularOneDayClassesResponse.of(
            oneDayClasses.stream()
                .map(this::converToReadPopularOneDayClassesOneDayClassResult)
                .collect(Collectors.toList())
        );
    }

    public ReadPopularOneDayClassesResponse.OneDayClassResult converToReadPopularOneDayClassesOneDayClassResult(
        OneDayClass oneDayClasses
    ) {
        return ReadPopularOneDayClassesResponse.OneDayClassResult.of(
            oneDayClasses.getId(),
            oneDayClasses.getName(),
            oneDayClasses.getIntro(),
            getFirstImageUrl(oneDayClasses.getOneDayClassImages())
        );
    }

    public OneDayClass convertToOneDayClass(SaveOneDayClassRequest request, Category category,
        Atelier atelier) {
        return OneDayClass.of(
            request.getName(),
            request.getIntro(),
            request.getPrice(),
            timeUtil.timeStringToSecond(request.getRequiredTime()),
            request.getMaxPeopleNumber(),
            category,
            atelier,
            request.getImages().stream()
                .map(this::convertToOneDayClassImage)
                .collect(Collectors.toList()),
            request.getCurriculums().stream()
                .map(this::convertToCurriculum)
                .collect(Collectors.toList())
        );
    }

    public OneDayClassImage convertToOneDayClassImage(
        SaveOneDayClassRequest.OneDayClassImageRequest imageRequest) {
        return OneDayClassImage.of(
            imageUrlUtil.extractFileName(imageRequest.getImageUrl()),
            imageRequest.getSequence()
        );
    }

    public Curriculum convertToCurriculum(
        CurriculumParam curriculumParam) {
        return Curriculum.of(
            curriculumParam.getStep(),
            curriculumParam.getContent()
        );
    }

    public OneDayClassTime convertToOneDayClassTime(
        SaveOneDayClassRequest.OneDayClassTimeRequest oneDayClassTimeRequest) {
        return OneDayClassTime.of(
            LocalDate
                .parse(oneDayClassTimeRequest.getDate(), DateTimeFormatter.ofPattern("yyyy-MM-dd")),
            timeUtil.timeStringToSecond(oneDayClassTimeRequest.getStartTime()),
            timeUtil.timeStringToSecond(oneDayClassTimeRequest.getEndTime()),
            TimeStatus.PROCESS
        );
    }


    private String getFullAddress(Address address, String detail) {
        String cityName = address.getCityName();
        String regionName = address.getRegionName();

        return cityName + " " + regionName + " " + detail;
    }

    private String getFirstImageUrl(List<OneDayClassImage> oneDayClassImages) {
        if (Objects.isNull(oneDayClassImages) || (oneDayClassImages.size() <= 0)) {
            return null;
        }

        String firstImageFileName = oneDayClassImages.get(0).getImageFileName();

        if (StringUtils.isEmpty(firstImageFileName)) {
            return null;
        }

        return imageUrlUtil.makeImageUrl(firstImageFileName);
    }

}
