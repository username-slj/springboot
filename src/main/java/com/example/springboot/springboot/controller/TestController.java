package com.example.springboot.springboot.controller;

import com.example.springboot.springboot.controller.dto.ConfigInfo;
import com.example.springboot.springboot.controller.dto.TestDto;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.couchbase.CouchbaseProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;

@Slf4j
@RestController
@RequestMapping(value = "/test", produces = "application/json")
public class TestController {
    private static final Logger logger = LoggerFactory.getLogger(TestController.class);

    @Resource
    private Environment environment;
    @Resource
    private ConfigInfo configInfo;

    /**
     * 接口调通
     * @param name 入参
     * @return 信息
     */
    @RequestMapping(value = "/fingInfo/{name}", method = RequestMethod.GET)
    public String fingInfo(@PathVariable String name) {
        logger.info(">>>>>>>>>>>欢迎：{}", name);
        return "hello " + name;
    }

    /**
     * 对象打印入参信息
     * @param testDto 入参对象
     * @return 信息
     */
    @RequestMapping(value = "/getInfo/", method = RequestMethod.POST)
    public String fingInfo(@RequestBody @Valid TestDto testDto) {
        return "hello " + testDto.getName();
    }

    /**
     * 获取属性文件内容
     * 1.实体类获取
     * 2.environment工具类获取
     * @return 信息
     */
    @RequestMapping(value = "/getPropertiesInfo", method = RequestMethod.GET)
    public String getPropertiesInfo(){
        //映射在实体类中
//        return configInfo.getName()+"=="+configInfo.getAge()+"=="+configInfo.getMessage();
        //使用environment直接获取属性文件中的信息
        return environment.getProperty("test.name")+"=="+environment.getProperty("test.age")+"=="+environment.getProperty("test.message");
    }



}
