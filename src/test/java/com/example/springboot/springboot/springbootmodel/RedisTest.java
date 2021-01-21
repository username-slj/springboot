package com.example.springboot.springboot.springbootmodel;

import com.example.springboot.springboot.SpringbootApplication;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringbootApplication.class)
public class RedisTest {
    @Resource
    private RedisTemplate redisTemplate;

    @Test
    public void tredis01() {
        ValueOperations valueOperations = redisTemplate.opsForValue();
        valueOperations.set("springbootRedis", "00001111");
        log.info("-=-=-=-=-=-{}", valueOperations.get("springbootRedis"));
    }
}
