package com.dayz.common.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.domain.PageRequest;

@Getter
@Setter
@NoArgsConstructor
public class CustomPageRequest {

    private int pageIndex;

    private int pageSize;

    private CustomSort sort;

    public static CustomPageRequest of(int pageIndex, int pageSize, CustomSort sort) {
        CustomPageRequest pageRequest = new CustomPageRequest();
        pageRequest.setPageIndex(pageIndex);
        pageRequest.setPageSize(pageSize);
        pageRequest.setSort(sort);

        return pageRequest;
    }

    public static CustomPageRequest of(int pageIndex, int pageSize) {
        CustomPageRequest pageRequest = new CustomPageRequest();
        pageRequest.setPageIndex(pageIndex);
        pageRequest.setPageSize(pageSize);

        return pageRequest;
    }

    public PageRequest convertToPageRequest(Class entityClass) {
        return PageRequest.of(pageIndex, pageSize, sort.convertToSort(entityClass));
    }

}