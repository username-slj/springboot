package com.example.springboot.springboot.redis;

import lombok.extern.slf4j.Slf4j;
import redis.clients.jedis.Jedis;
import java.util.Map;
import java.util.Set;

/**
 * 1	HDEL key field1 [field2] * 删除一个或多个哈希表字段
 * 2	HEXISTS key field  * 查看哈希表 key 中，指定的字段是否存在。
 * 3	HGET key field  * 获取存储在哈希表中指定字段的值。
 * 4	HGETALL key  * 获取在哈希表中指定 key 的所有字段和值
 * 5	HINCRBY key field increment  * 为哈希表 key 中的指定字段的整数值加上增量 increment 。
 * 6	HINCRBYFLOAT key field increment  * 为哈希表 key 中的指定字段的浮点数值加上增量 increment 。
 * 7	HKEYS key  * 获取所有哈希表中的字段
 * 8	HLEN key  * 获取哈希表中字段的数量
 * 9	HMGET key field1 [field2]  * 获取所有给定字段的值
 * 10	HMSET key field1 value1 [field2 value2 ]  * 同时将多个 field-value (域-值)对设置到哈希表 key 中。
 * 11	HSET key field value  * 将哈希表 key 中的字段 field 的值设为 value 。
 * 12	HSETNX key field value  * 只有在字段 field 不存在时，设置哈希表字段的值。
 * 13	HVALS key  * 获取哈希表中所有值。
 * 14	HSCAN key cursor [MATCH pattern] [COUNT count]  * 迭代哈希表中的键值对。
 */
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
