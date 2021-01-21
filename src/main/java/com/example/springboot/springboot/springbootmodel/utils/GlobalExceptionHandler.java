package com.example.springboot.springboot.springbootmodel.utils;

import lombok.extern.slf4j.Slf4j;
import org.apache.tomcat.util.http.ResponseUtil;
import org.springframework.web.HttpRequestHandler;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

/**
 * 全局异常处理
 * ControllerAdvice注解： 获取requestmapper
 * RestControllerAdvice: 合并了 @ControllerAdvice，@ResponseBody
 */
@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = Exception.class)
    public Object defultErrorHandler(Exception e, HttpRequestHandler req) throws Exception {
//        Map<String, String> map = new HashMap<>(6);
//        map.put("code", "400");
//        map.put("message", "全局异常");
//        map.put("data", "");
        return "全局异常"+e.getMessage();
    }
}
