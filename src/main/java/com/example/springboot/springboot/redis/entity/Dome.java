package com.example.springboot.springboot.redis.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class Dome implements Serializable {
    private int id;
    private String name;
    private Date time;
}
