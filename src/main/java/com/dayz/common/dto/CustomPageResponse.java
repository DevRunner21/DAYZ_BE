package com.dayz.common.dto;

import io.swagger.annotations.ApiModelProperty;
import java.util.List;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.domain.Page;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public abstract class CustomPageResponse<T> {

    @ApiModelProperty(value = "전체 데이터 수", dataType = "integer", example = "100")
    private Long totalCount;

    @ApiModelProperty(value = "페이지 인덱스", dataType = "integer", example = "0")
    private int pageIndex;

    @ApiModelProperty(value = "한 페이지 크기", dataType = "integer", example = "10")
    private int pageSize;

    @ApiModelProperty(value = "조회 목록", dataType = "array")
    private List<T> list;

    @ApiModelProperty(value = "다음 페이지 여부", dataType = "boolean", example = "true")
    private boolean hasNext;

    protected CustomPageResponse(Page tPage) {
        this.totalCount = tPage.getTotalElements();
        this.pageIndex = tPage.getNumber();
        this.pageSize = tPage.getSize();
        this.list = tPage.getContent();
        this.hasNext = tPage.hasNext();
    }
//
//    public static CustomPageResponse of(Page tPage) {
//        CustomPageResponse customPageResponse = new CustomPageResponse();
//        customPageResponse.setTotalCount(tPage.getTotalElements());
//        customPageResponse.setPageIndex(tPage.getNumber());
//        customPageResponse.setPageSize(tPage.getSize());
//        customPageResponse.setList(tPage.getContent());
//        customPageResponse.setHasNext(tPage.hasNext());
//
//        return customPageResponse;
//    }

}
