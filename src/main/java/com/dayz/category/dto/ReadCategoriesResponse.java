package com.dayz.category.dto;

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

    private List<CategoryResult> categories = new ArrayList<>();

    public static ReadCategoriesResponse of(List<CategoryResult> categories) {
        ReadCategoriesResponse readCategoriesResponse = new ReadCategoriesResponse();
        readCategoriesResponse.setCategories(categories);

        return readCategoriesResponse;
    }

    @Getter
    @Setter(AccessLevel.PRIVATE)
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    public static class CategoryResult {

        private Long categoryId;

        private String name;

        public static CategoryResult of(Long categoryId, String name) {
            CategoryResult categoryResult = new CategoryResult();
            categoryResult.setCategoryId(categoryId);
            categoryResult.setName(name);

            return categoryResult;
        }

    }

}


