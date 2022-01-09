package com.dayz.common.dto;

import com.dayz.common.entity.BaseEntity;
import io.swagger.annotations.ApiModelProperty;
import java.util.Arrays;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;

@Getter
@Setter(AccessLevel.PROTECTED)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public abstract class CustomPageRequest {

    @ApiModelProperty(value = "페이지 인덱스", dataType = "integer", example = "0")
    private int pageIndex;

    @ApiModelProperty(value = "한 페이지 크기", dataType = "integer", example = "10")
    private int pageSize;

    @ApiModelProperty(value = "정렬대상 컬럼명", dataType = "string", example = "createdAt")
    private String column;

    @ApiModelProperty(value = "정렬방식", dataType = "string", example = "DESC")
    private String order;

    public PageRequest convertToPageRequest(Class entityClass) {
        return PageRequest.of(pageIndex, pageSize, convertToSort(entityClass));
    }

    public Sort convertToSort(Class entityClass) {
        Direction direction = Direction.DESC;

        if (order.equals(Direction.ASC.name())) {
            direction = Direction.ASC;
        }

        // entityClass에 해당하는 필드가 맞는지 검사하고 맞는 경우에만 Sort 객체를 반환한다.
        if (Arrays.stream(entityClass.getDeclaredFields())
            .anyMatch(field -> field.getName().equals(column))
            || Arrays.stream(BaseEntity.class.getDeclaredFields())
            .anyMatch(field -> field.getName().equals(column))
        ) {
            return Sort.by(direction, column);
        }

        return Sort.unsorted();
    }

}
