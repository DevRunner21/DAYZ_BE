package com.dayz.common.dto;

import com.dayz.common.entity.BaseEntity;
import java.util.Arrays;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;

@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public abstract class CustomPageRequest {

    private int pageIndex;

    private int pageSize;

    private String column;

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
