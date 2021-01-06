package com.example.springboot.springboot.redis;

import lombok.extern.slf4j.Slf4j;
import redis.clients.jedis.Jedis;
import java.util.Map;
import java.util.Set;

@Slf4j
public class HashTest {
    private static Jedis jedis = new Jedis("127.0.0.1", 6379);
    private static final String key = "hash:username:001";

    /**
     * 添加商品
     */
    public static void add() {
        jedis.hset(key, "张三", "30");
        jedis.close();
    }

    /**
     * 查询商品
     */
    public static void find() {
        final Map<String, String> pFor004 = jedis.hgetAll(key);
        final Set<Map.Entry<String, String>> entrySet = pFor004.entrySet();
        for (Map.Entry<String, String> e : entrySet) {
            log.info("查询{}==={}", e.getKey(), e.getValue());
        }
        jedis.close();
    }

    /**
     * 修改商品
     */
    public static void update() {
        jedis.hset(key, "王五", "20");
        jedis.hincrBy(key, "饼干", 10);
        jedis.close();
    }

    public static void del() {
        jedis.hdel(key, "张三", "王五");
        jedis.close();
    }

    public static void main(String[] args) {
        del();
        add();
        find();
        update();
        find();
    }
}
