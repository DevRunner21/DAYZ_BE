package com.dayz.onedayclass.converter;

import com.dayz.atelier.domain.Atelier;
import com.dayz.category.domain.Category;
import com.dayz.member.domain.Address;
import com.dayz.onedayclass.domain.Curriculum;
import com.dayz.onedayclass.domain.OneDayClass;
import com.dayz.onedayclass.domain.OneDayClassImage;
import com.dayz.onedayclass.dto.request.RegisterOneDayClassRequest;
import com.dayz.onedayclass.dto.request.RegisterOneDayClassRequest.CurriculumParam;
import com.dayz.onedayclass.dto.request.RegisterOneDayClassRequest.OneDayClassImageParam;
import com.dayz.onedayclass.dto.response.*;
import java.time.LocalTime;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

@Component
@RequiredArgsConstructor
public class OneDayClassConverter {

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
            oneDayClassImage.getFullImageUrl(),
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
            LocalTime.ofSecondOfDay(atelier.getWorkTime().getStartTime()),
            LocalTime.ofSecondOfDay(atelier.getWorkTime().getEndTime()),
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

    public ReadPopularOneDayClassesResponse convertToReadPopularOneDayClassesResponse(
        List<OneDayClass> oneDayClasses
    ) {
        return ReadPopularOneDayClassesResponse.of(
            oneDayClasses.stream()
                .map(this::convertToReadPopularOneDayClassesOneDayClassResult)
                .collect(Collectors.toList())
        );
    }

    public ReadPopularOneDayClassesResponse.OneDayClassResult convertToReadPopularOneDayClassesOneDayClassResult(
        OneDayClass oneDayClasses
    ) {
        return ReadPopularOneDayClassesResponse.OneDayClassResult.of(
            oneDayClasses.getId(),
            oneDayClasses.getName(),
            oneDayClasses.getIntro(),
            getFirstImageUrl(oneDayClasses.getOneDayClassImages())
        );
    }

    public OneDayClass convertToOneDayClass(
        RegisterOneDayClassRequest request,
        Category category,
        Atelier atelier
    ) {
        return OneDayClass.builder()
            .name(request.getName())
            .intro(request.getIntro())
            .price(request.getPrice())
            .requiredTime((long)LocalTime.parse(request.getRequiredTime()).toSecondOfDay()) // TODO : 맘에 안듬...
            .maxPeopleNumber(request.getMaxPeopleNumber())
            .category(category)
            .atelier(atelier)
            .oneDayClassImages(
                request.getImages().stream()
                    .map(this::convertToOneDayClassImage)
                    .collect(Collectors.toList())
            )
            .curriculums(request.getCurriculums().stream()
                .map(this::convertToCurriculum)
                .collect(Collectors.toList()))
            .build();
    }

    public OneDayClassImage convertToOneDayClassImage(
        OneDayClassImageParam imageRequest) {
        return OneDayClassImage.builder()
            .sequence(imageRequest.getSequence())
            .imageFileName(imageRequest.getImageUrl())
            .build();
    }

    public Curriculum convertToCurriculum(CurriculumParam curriculumParam) {
        return Curriculum.builder()
            .step(curriculumParam.getStep())
            .content(curriculumParam.getContent())
            .build();
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

        return oneDayClassImages.get(0).getFullImageUrl();
    }

}
