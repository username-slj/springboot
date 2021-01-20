package com.example.springboot.springboot.springbootmodel.dao;

import com.example.springboot.springboot.springbootmodel.model.Tiem;

public interface TiemMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Tiem record);

    int insertSelective(Tiem record);

    Tiem selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Tiem record);

    int updateByPrimaryKey(Tiem record);
}