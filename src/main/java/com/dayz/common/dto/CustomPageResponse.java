package com.dayz.common.dto;

import java.util.List;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.domain.Page;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public abstract class CustomPageResponse<T> {

    private Long totalCount;

    private int pageIndex;

    private int pageSize;

    private List<T> list;

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
