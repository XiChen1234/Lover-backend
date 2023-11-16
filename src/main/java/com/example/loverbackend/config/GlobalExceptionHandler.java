package com.example.loverbackend.config;

import com.example.loverbackend.common.CommonResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {
    @ExceptionHandler(BindException.class)
    public CommonResponse<Void> bindExceptionHandler(BindException e) {
        return CommonResponse.creatForErrorMessage(e.getBindingResult().getAllErrors().get(0).getDefaultMessage());
    }
}
