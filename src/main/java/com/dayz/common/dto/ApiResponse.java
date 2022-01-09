package com.dayz.common.dto;

import com.dayz.common.enums.ErrorInfo;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import java.time.LocalDateTime;
import lombok.Getter;

@Getter
public class ApiResponse<T> {

    @ApiModelProperty(value = "통신성공여부", dataType = "boolean", example = "true")
    private boolean success;

    @ApiModelProperty(value = "응답데이터", dataType = "object")
    private T data;

    @ApiModelProperty(value = "응답시간", dataType = "string", example = "2021-11-0 16:55:37")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Seoul")
    private LocalDateTime serverDatetime;

    protected ApiResponse(boolean success, T data) {
        this.success = success;
        this.data = data;
        this.serverDatetime = LocalDateTime.now();
    }

    public static <T> ApiResponse<T> ok(T response) {
        return new ApiResponse<>(true, response);
    }

    public static ApiResponse error(ErrorInfo errorInfo) {
        return new ApiResponse<>(false, ApiError.of(errorInfo));
    }

    public static ApiResponse error(String code, Object messages) {
        return new ApiResponse<>(false, ApiError.of(code, messages));
    }

    public static ApiResponse noContent(){
        return new ApiResponse<>(true,null);
    }

}
