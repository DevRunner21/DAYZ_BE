package com.dayz.category.service;

import com.dayz.category.converter.CategoryConverter;
import com.dayz.category.domain.Category;
import com.dayz.category.domain.CategoryRepository;
import com.dayz.category.dto.response.ReadCategoriesResponse;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class CategoryService {

    private final CategoryRepository categoryRepository;

    private final CategoryConverter categoryConverter;

    @Transactional(readOnly = true)
    public ReadCategoriesResponse getCategories() {
        List<Category> allCategoryList = categoryRepository.findAll();

        return categoryConverter.convertToReadCategoriesResponse(allCategoryList);
    }

}
