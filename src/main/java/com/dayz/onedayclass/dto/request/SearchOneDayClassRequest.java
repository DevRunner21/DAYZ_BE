package com.dayz.onedayclass.dto.request;

import com.dayz.common.dto.CustomPageRequest;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class SearchOneDayClassRequest extends CustomPageRequest {

    private String keyword;

}
