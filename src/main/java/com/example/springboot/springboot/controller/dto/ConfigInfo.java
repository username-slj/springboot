package com.example.springboot.springboot.controller.dto;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Data
@Component
@PropertySource("classpath:application.properties")
public class ConfigInfo {
    @Value("${test.name}")
    private String name;

    @Value("${test.age}")
    private String age;

    @Value("${test.message}")
    private String message;

    @Override
    public String toString() {
        return "ConfigInfo{" +
                "name='" + name + '\'' +
                ", age='" + age + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
}
