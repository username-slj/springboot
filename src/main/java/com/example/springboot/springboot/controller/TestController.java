package com.example.springboot.springboot.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value = "/test", produces = "application/json")
public class TestController {
    private static final Logger logger=  LoggerFactory.getLogger(TestController.class);

    @RequestMapping(value = "/fingInfo/{name}", method = RequestMethod.GET)
    public String fingInfo(@PathVariable String name) {
        logger.info(">>>>>>>>>>>欢迎：{}", name);
        return "hello "+name;
    }

}
