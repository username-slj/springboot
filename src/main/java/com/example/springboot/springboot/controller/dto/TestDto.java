package com.example.springboot.springboot.controller.dto;

import lombok.Data;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@Validated
public class TestDto {

    @NotBlank(message = "名称不能为空")
    private String name;

    @NotNull(message = "ObjTest不能为空")
    @Valid
    private ObjTest objTest;
}
