package com.xuxian.controller;

import com.xuxian.entity.Result;
import com.xuxian.entity.StatusCode;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class BaseExceptionHandler {


    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Object error(Exception e){
        return new Result(false, StatusCode.ERROR,"发生异常",e.getMessage());
    }
}
