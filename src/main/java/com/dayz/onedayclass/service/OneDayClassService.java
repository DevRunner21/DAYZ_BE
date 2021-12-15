package com.dayz.onedayclass.service;

import com.dayz.common.dto.CustomPageResponse;
import com.dayz.common.enums.ErrorInfo;
import com.dayz.common.exception.BusinessException;
import com.dayz.member.domain.Member;
import com.dayz.onedayclass.converter.OneDayClassConverter;
import com.dayz.onedayclass.domain.OneDayClass;
import com.dayz.onedayclass.domain.OneDayClassRepository;
import com.dayz.onedayclass.dto.ReadOneDayClassDetailResponse;
import com.dayz.onedayclass.dto.ReadOneDayClassesByCategoryResult;
import com.dayz.review.domain.ReviewRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class OneDayClassService {

    private final OneDayClassRepository oneDayClassRepository;

    private final ReviewRepository reviewRepository;

    private final OneDayClassConverter oneDayClassConverter;

    public CustomPageResponse<ReadOneDayClassesByCategoryResult> getOneDayClassesByCategory(Member member, Long categoryId, Pageable pageRequest) {
        Page<ReadOneDayClassesByCategoryResult> readOneDayClassesByCategoryResultPage = oneDayClassRepository.findOneDayClassByCategoryId(
                categoryId,
                member.getAddress().getCityId(),
                member.getAddress().getRegionId(),
                pageRequest
        ).map(oneDayClassConverter::convertToReadOneDayClassesByCategoryResult);

        return CustomPageResponse.of(readOneDayClassesByCategoryResultPage);
    }

    public ReadOneDayClassDetailResponse getOneDayClassDetail(Long classId) {
        OneDayClass foundOneDayClass = oneDayClassRepository.findOneDayClassById(classId)
                .orElseThrow(() -> new BusinessException(ErrorInfo.ONE_DAY_CLASS_NOT_FOUND));

        double avgScore = reviewRepository.getReviewAverageByOneDayClass(classId);

        return oneDayClassConverter.convertToReadOneDayClassDetailResponse(foundOneDayClass, avgScore);
    }

}