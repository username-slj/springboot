package com.example.springboot.springboot.redis.controller;

import com.example.springboot.springboot.redis.service.ItemService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * 穿透
 */
@RestController
@Slf4j
@RequestMapping(value = "/redisController")
public class RedisController {
    @Autowired
    private ItemService itemService;

    @RequestMapping(value = "/selectByCode", method = RequestMethod.GET)
    public Map<String, Object> selectByCode(@RequestParam String itemCode){
        Map<String, Object> map=new HashMap<>();
        map.put("code",200);
        map.put("msg","成功");
        try{
            map.put("data", itemService.selectByCode(itemCode));
        }catch (Exception e){
            map.put("code",-1);
            map.put("msg","失败");
        }
        return map;
    }
}
