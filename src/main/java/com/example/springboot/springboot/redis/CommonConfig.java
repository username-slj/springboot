package com.example.springboot.springboot.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.serializer.JdkSerializationRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

@Configuration
public class CommonConfig {
    @Autowired
    private RedisConnectionFactory redisConnectionFactory;

    //RedisTemplate实例
    @Bean
    public RedisTemplate<String, Object> redisTemplate(){
        RedisTemplate<String, Object> redisTemplate = new RedisTemplate<>();
        redisTemplate.setConnectionFactory(redisConnectionFactory);
        //TODO 指定大key序列化策略为String序列化
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        //TODO value为JDK自带的序列化策略
        redisTemplate.setValueSerializer(new JdkSerializationRedisSerializer());
        //TODO 指定HashKey序列化策略为String序列化-针对hash散列存储
        redisTemplate.setHashKeySerializer(new StringRedisSerializer());
        return redisTemplate;
    }

    //缓存操作组件
    @Bean
    public StringRedisTemplate stringRedisTemplate(){
        StringRedisTemplate stringRedisTemplate = new StringRedisTemplate();
        stringRedisTemplate.setConnectionFactory(redisConnectionFactory);
        return stringRedisTemplate;
    }




}
