package com.dayz.common.exception;

import com.dayz.common.dto.ApiError;
import com.dayz.common.dto.CommonApiResponse;
import com.dayz.common.enums.ErrorInfo;
import java.util.stream.Collectors;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public CommonApiResponse<ApiError> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex) {
        log.error("{0}", ex); /* todo: 에러 로그를 얼마나 찍어야하는지? */
        return CommonApiResponse.error("METHOD_ARG_NOT_VALID", ex.getBindingResult().getAllErrors().stream()
                .collect(Collectors.toMap(error -> ((FieldError) error).getField(), ObjectError::getDefaultMessage)));
    }

    @ExceptionHandler(BusinessException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public CommonApiResponse<ApiError> handleBusinessExceptionException(BusinessException ex) {
        log.error("{0}", ex);

        return CommonApiResponse.error(ex.getErrorInfo());
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public CommonApiResponse<ApiError> handleException(Exception ex) {
        log.error("{0}", ex);

        return CommonApiResponse.error(ErrorInfo.UNKNOWN);
    }

}
