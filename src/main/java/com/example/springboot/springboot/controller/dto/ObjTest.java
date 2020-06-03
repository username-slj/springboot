package com.example.springboot.springboot.controller.dto;

import lombok.Data;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotBlank;

@Data
@Validated
public class ObjTest {

    @NotBlank(message = "年龄不能为空")
    private String age;
}
