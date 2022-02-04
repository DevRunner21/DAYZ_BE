package com.dayz.common.dto;

import com.dayz.common.enums.ErrorInfo;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import java.time.LocalDateTime;
import lombok.Getter;

@Getter
public class CommonApiResponse<T> {

    @ApiModelProperty(value = "통신성공여부", dataType = "boolean", example = "true")
    private final boolean success;

    @ApiModelProperty(value = "응답데이터", dataType = "object")
    private final T data;

    @ApiModelProperty(value = "응답시간", dataType = "string", example = "2021-11-0 16:55:37")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Seoul")
    private final LocalDateTime serverDatetime;

    protected CommonApiResponse(boolean success, T data) {
        this.success = success;
        this.data = data;
        this.serverDatetime = LocalDateTime.now();
    }

    public static <T> CommonApiResponse<T> ok(T response) {
        return new CommonApiResponse<>(true, response);
    }

    public static CommonApiResponse<ApiError> error(ErrorInfo errorInfo) {
        return new CommonApiResponse<>(false, ApiError.of(errorInfo));
    }

    public static CommonApiResponse<ApiError> error(String code, Object messages) {
        return new CommonApiResponse<>(false, ApiError.of(code, messages));
    }

    public static CommonApiResponse<Object> noContent(){
        return new CommonApiResponse<>(true,null);
    }

}
