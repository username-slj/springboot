package com.example.springboot.springboot.jdk8.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Builder;
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
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date gmtModified;
    private Long accountId;
    private String type;
}
