package com.dayz.category.converter;

import com.dayz.category.domain.Category;
import com.dayz.category.dto.ReadCategoriesResponse;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Component;

@Component
public class CategoryConverter {

    public ReadCategoriesResponse convertToReadCategoriesResponse(List<Category> categories) {
        return ReadCategoriesResponse.of(
            categories.stream()
                .map(category -> convertToCategoryResult(category))
                .collect(Collectors.toList())
        );
    }

    public ReadCategoriesResponse.CategoryResult convertToCategoryResult(Category category) {
        return ReadCategoriesResponse.CategoryResult.of(category.getId(), category.getName());
    }

}
