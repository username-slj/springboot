package com.example.springboot.springboot.springbootmodel.dao;

import com.example.springboot.springboot.springbootmodel.model.SUser;

public interface SUserMapper {
    int insert(SUser record);

    int insertSelective(SUser record);
}