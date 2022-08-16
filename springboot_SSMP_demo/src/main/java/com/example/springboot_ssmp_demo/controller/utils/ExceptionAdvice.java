package com.example.springboot_ssmp_demo.controller.utils;


import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

// SpringMVC 异常处理器
@RestControllerAdvice
public class ExceptionAdvice {

    // 拦截所有的异常信息
    @ExceptionHandler(Exception.class)
    public ReturnModel doException(Exception ex){

        // 可 日志记录异常信息

        // 控制台打印详细异常信息
        ex.printStackTrace();
        return new ReturnModel("系统异常！！！");
    }

}
