package com.dayz.atelier.dto.request;

import com.dayz.common.dto.CustomPageRequest;
import io.swagger.annotations.ApiModelProperty;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class SearchAtelierRequest extends CustomPageRequest {

    @ApiModelProperty(value = "검색 키워드", dataType = "string", example = "공방이름")
    private String keyword;

}
