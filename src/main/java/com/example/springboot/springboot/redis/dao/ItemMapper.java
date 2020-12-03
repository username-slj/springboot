package com.example.springboot.springboot.redis.dao;

import com.example.springboot.springboot.redis.entity.Item;
import io.lettuce.core.dynamic.annotation.Param;

public interface ItemMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Item record);

    int insertSelective(Item record);

    Item selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Item record);

    int updateByPrimaryKey(Item record);

    Item selectByCode(@Param("code") String code);
}