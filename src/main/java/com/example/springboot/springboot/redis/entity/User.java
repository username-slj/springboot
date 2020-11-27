package com.example.springboot.springboot.redis.entity;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class User {
    private Integer id;
    private String userName;
    private String name;
}
