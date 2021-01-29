package com.example.springboot.springboot.jdk8.entity;

import lombok.Data;
import sun.rmi.runtime.Log;

import java.util.List;

@Data
public class LossPartyDto {
    private Long uniqueNo;
    private List<A> aList;
}
