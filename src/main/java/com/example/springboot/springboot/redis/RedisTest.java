package com.example.springboot.springboot.redis;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.Transaction;
import redis.clients.jedis.params.SetParams;

import java.util.Arrays;
import java.util.Collections;

/**
 * 主从复制-https://www.cnblogs.com/wangzhenzhou/p/6134847.html
 */
@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisTest {
    private static Jedis jedis = new Jedis("127.0.0.1", 6379);

    /**
     * 事务
     * 开启multi
     * 多命令
     * 执行exec
     */
    @Test
    public void test01() {
        jedis.flushDB();
        Transaction transaction = jedis.multi();
        transaction.set("stringName", "xxxxxxx");
        transaction.sadd("setNema", "666666");
        transaction.exec();
        transaction.keys("*");
    }

    @Test
    public void test02() {
        for (int i = 0; i < 10; i++) {
            test03();
        }
    }

    /**
     * 加锁
     */
    @Test
    public void test04() throws InterruptedException {


    }

    public void test03() {
        try {
            StringBuilder lua = new StringBuilder();
            lua.append("local num = redis.call('incr', KEYS[1])\n");
            lua.append("if tonumber(num) == 1 then\n");
            lua.append("\tredis.call('expire', KEYS[1], ARGV[1])\n");
            lua.append("\treturn 1\n");
            lua.append("elseif tonumber(num) > tonumber(ARGV[2]) then\n");
            lua.append("\treturn 0\n");
            lua.append("else \n");
            lua.append("\treturn 1\n");
            lua.append("end\n");
            Object result = jedis.evalsha(jedis.scriptLoad(lua.toString()), Arrays.asList("127.0.0.1"), Arrays.asList("10", "2"));
            System.out.println("===============================" + result);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (jedis != null) {
                try {
                    jedis.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
