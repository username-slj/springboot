package com.example.springboot.springboot.redis;

import com.example.springboot.springboot.redis.entity.User;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@Slf4j
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class RedisTest {
    @Autowired
    private RedisTemplate redisTemplate;
    //java序列化反序列化
    @Autowired
    private ObjectMapper objectMapper;
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    /**
     * redisTemplate:将字符串写入内存，并读取出来
     */
    @Test
    public void one() {
        final String content = "redisTemplate实战字符串信息";
        final String key = "redis:template:string";

        ValueOperations valueOperations = redisTemplate.opsForValue();
        valueOperations.set(key, content);

        Object result = valueOperations.get(key);
        System.out.println("====" + result);
    }

    /**
     * redisTemplate:json序列化框架对这个对象进行序列化于反序列化操作
     *
     * @throws Exception
     */
    @Test
    public void two() throws Exception {
        User user = new User();
        user.setId(001);
        user.setUserName("张三");
        user.setName("zhangsna");
        ValueOperations valueOperations = redisTemplate.opsForValue();
        final String content = objectMapper.writeValueAsString(user);
        final String key = "redis:template:objdect";
        valueOperations.set(key, content);

        Object result = valueOperations.get(key);
        if (result != null) {
            User user1 = objectMapper.readValue(result.toString(), User.class);
            System.out.println("====" + user1);
        }
    }

    /**
     * stringRedisTemplate:将字符串写入内存，并读取出来
     */
    @Test
    public void three() {
        final String content = "stringRedisTemplate";
        final String key = "redis:three";

        ValueOperations<String, String> stringStringValueOperations = stringRedisTemplate.opsForValue();
        stringStringValueOperations.set(key, content);

        String result = stringStringValueOperations.get(key);
        System.out.println("----" + result);


    }

    /**
     * stringRedisTemplate:json序列化框架对这个对象进行序列化于反序列化操作
     */
    @Test
    public void four() throws Exception {
        User user = new User();
        user.setId(002);
        user.setUserName("李四");
        user.setName("lisi");

        final String key = "redis:object";
        final String content = objectMapper.writeValueAsString(user);
        ValueOperations<String, String> stringStringValueOperations = stringRedisTemplate.opsForValue();
        stringStringValueOperations.set(key, content);
        String result = stringStringValueOperations.get(key);
        if (result != null) {
            User readValue = objectMapper.readValue(result.toString(), User.class);
            System.out.println("----" + readValue);
        }
    }

}
