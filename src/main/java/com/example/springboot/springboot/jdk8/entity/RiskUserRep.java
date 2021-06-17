package com.example.springboot.springboot.jdk8.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.Date;

/**
 * 用户中台获取代理人全量信息
 * @author iybwb-shaolianjie
 */
@Data
@ToString
public class RiskUserRep {
    private Date gmtModified;
    private String accountId;
}
