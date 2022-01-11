package com.dayz.category.dto.response;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter(AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ReadCategoriesResponse {

    @ApiModelProperty(value = "카테고리 목록", dataType = "array")
    private List<CategoryResult> categories = new ArrayList<>();

    public static ReadCategoriesResponse of(List<CategoryResult> categories) {
        ReadCategoriesResponse readCategoriesResponse = new ReadCategoriesResponse();
        readCategoriesResponse.setCategories(categories);

        return readCategoriesResponse;
    }

    @ApiModel(value = "ReadCategoriesResponse.CategoryResult")
    @Getter
    @Setter(AccessLevel.PRIVATE)
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    public static class CategoryResult {

        @ApiModelProperty(value = "카테고리 ID", dataType = "number", example = "1")
        private Long categoryId;

        @ApiModelProperty(value = "카테고리 이름", dataType = "string", example = "도자기")
        private String name;

        public static CategoryResult of(Long categoryId, String name) {
            CategoryResult categoryResult = new CategoryResult();
            categoryResult.setCategoryId(categoryId);
            categoryResult.setName(name);

            return categoryResult;
        }

    }

}


