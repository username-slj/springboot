package com.example.springboot.springboot.redis.service.impl;

import com.example.springboot.springboot.redis.dao.ItemMapper;
import com.example.springboot.springboot.redis.entity.Item;
import com.example.springboot.springboot.redis.service.ItemService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

@Slf4j
@Service
public class ItemServiceImpl implements ItemService {
    @Resource
    private ItemMapper itemMapper;
    @Resource
    private RedisTemplate redisTemplate;
    @Resource
    private ObjectMapper objectMapper;

    private static final String keyPrefix="item:";


    @Override
    public Item selectByCode(String code) throws JsonProcessingException {
        Item item=null;
        final String key=keyPrefix+code;
        ValueOperations valueOperations = redisTemplate.opsForValue();
        if(redisTemplate.hasKey(key)){
            Object object = valueOperations.get(key);
            if(object != null && !StringUtils.isEmpty(object)){
                item = objectMapper.readValue(object.toString(), Item.class);
            }
        }else{
            item = itemMapper.selectByCode(code);
            if(item != null){
                valueOperations.set(key, objectMapper.writeValueAsString(item));
            }else{
                valueOperations.set(key, "", 30L, TimeUnit.MINUTES);
            }
        }
        return item;
    }
}
