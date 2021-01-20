package com.example.springboot.springboot.springbootmodel.model;

import lombok.Data;

import java.util.Date;

@Data
public class Tiem {
    private Integer id;

    private String code;

    private String name;

    private Date createTime;
}