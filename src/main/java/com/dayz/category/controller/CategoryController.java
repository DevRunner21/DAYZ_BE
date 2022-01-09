package com.dayz.category.controller;

import com.dayz.atelier.dto.response.ReadAteliersResponse;
import com.dayz.category.dto.response.ReadCategoriesResponse;
import com.dayz.category.service.CategoryService;
import com.dayz.common.dto.CommonApiResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "CategoryController V1", value = "카테고리 CRUD API를 제공하는 Controller입니다.")
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/categories")
public class CategoryController {

    private final CategoryService categoryService;

    @ApiOperation(
        value = "카테고리 목록 조회",
        notes = "카테고리 목록을 조회합니다.",
        produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiResponses({
        @ApiResponse(code = 200, response = ReadCategoriesResponse.class, message = "성공")
    })
    @ResponseStatus(HttpStatus.OK)
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public CommonApiResponse<ReadCategoriesResponse> readCategories() {
        ReadCategoriesResponse response = categoryService.getCategories();

        return CommonApiResponse.<ReadCategoriesResponse>ok(response);
    }

}
