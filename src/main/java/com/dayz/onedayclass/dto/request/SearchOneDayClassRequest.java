package com.dayz.onedayclass.dto.request;

import com.dayz.common.dto.CustomPageRequest;
import io.swagger.annotations.ApiModelProperty;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class SearchOneDayClassRequest extends CustomPageRequest {

    @ApiModelProperty(value = "검색어", dataType = "string", example = "검색어")
    private String keyword;

}
