package com.example.springboot.springboot.redis.service;

import com.example.springboot.springboot.redis.entity.Item;
import com.fasterxml.jackson.core.JsonProcessingException;

public interface ItemService {
    Item selectByCode(String itemCode) throws JsonProcessingException;
}
