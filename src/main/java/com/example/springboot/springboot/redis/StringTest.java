package com.example.springboot.springboot.redis;

import com.example.springboot.springboot.redis.entity.Dome;
import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import redis.clients.jedis.Jedis;

import java.io.*;
import java.util.Date;

/**https://blog.csdn.net/qq_36290794/article/details/78430355
 * 1	SET key value  * 设置指定 key 的值
 * 2	GET key  * 获取指定 key 的值。
 * 3	GETRANGE key start end  * 返回 key 中字符串值的子字符
 * 4	GETSET key value * 将给定 key 的值设为 value ，并返回 key 的旧值(old value)。
 * 5	GETBIT key offset * 对 key 所储存的字符串值，获取指定偏移量上的位(bit)。
 * 6	MGET key1 [key2..] * 获取所有(一个或多个)给定 key 的值。
 * 7	SETBIT key offset value * 对 key 所储存的字符串值，设置或清除指定偏移量上的位(bit)。
 * 8	SETEX key seconds value * 将值 value 关联到 key ，并将 key 的过期时间设为 seconds (以秒为单位)。
 * 9	SETNX key value * 只有在 key 不存在时设置 key 的值。
 * 10	SETRANGE key offset value * 用 value 参数覆写给定 key 所储存的字符串值，从偏移量 offset 开始。
 * 11	STRLEN key * 返回 key 所储存的字符串值的长度。
 * 12	MSET key value [key value ...] * 同时设置一个或多个 key-value 对。
 * 13	MSETNX key value [key value ...]  * 同时设置一个或多个 key-value 对，当且仅当所有给定 key 都不存在。
 * 14	PSETEX key milliseconds value * 这个命令和 SETEX 命令相似，但它以毫秒为单位设置 key 的生存时间，而不是像 SETEX 命令那样，以秒为单位。
 * 15	INCR key * 将 key 中储存的数字值增一。
 * 16	INCRBY key increment * 将 key 所储存的值加上给定的增量值（increment） 。
 * 17	INCRBYFLOAT key increment * 将 key 所储存的值加上给定的浮点增量值（increment） 。
 * 18	DECR key * 将 key 中储存的数字值减一。
 * 19	DECRBY key decrement * key 所储存的值减去给定的减量值（decrement） 。
 * 20	APPEND key value * 如果 key 已经存在并且是一个字符串， APPEND 命令将指定的 value 追加到该 key 原来值（value）的末尾。
 * */
@Slf4j
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class StringTest {
    private static Jedis jedis=new Jedis("127.0.0.1",6379);

    /**
     * string字符串
     */
    @Test
    public void string(){
        jedis.set("user:001:name1","dance");
        jedis.set("user:002:name1","G-Dragon");
        jedis.set("user:003:name1","xiaoming");
        jedis.set("user:004:name1","xiaofang");
        String username001 = jedis.get("user:001:name1");
        String username002 = jedis.get("user:002:name1");
        String username003 = jedis.get("user:003:name1");
        String username004 = jedis.get("user:004:name1");
        System.out.println(username001);
        System.out.println(username002);
        System.out.println(username003);
        System.out.println(username004);
    }

    /**
     * 将对象缓存到String数据结构中
     */
    @Test
    public void test02() throws IOException, ClassNotFoundException {
        final Dome dome = new Dome();
        dome.setId(100);
        dome.setName("水瓶");
        dome.setTime(new Date());
        //将对象序列化成byte数组
        final ByteArrayOutputStream bos = new ByteArrayOutputStream();
        final ObjectOutputStream oos = new ObjectOutputStream(bos);
        //用对象序列化的方式将pro实例序列化并写入流中
        oos.writeObject(dome);
        //将bos转换成字节数组
        final byte[] pByte = bos.toByteArray();
        //将序列化后的对象缓存到string数据结构中
        jedis.set("dome:001".getBytes(), pByte);
        //获取数据
        final byte[] pByteRes = jedis.get("dome:001".getBytes());
        //将获取的数据反序列化
        final ByteArrayInputStream bis = new ByteArrayInputStream(pByteRes);
        final ObjectInputStream ois = new ObjectInputStream(bis);
        //读取对象流中的ProductInfo对象
        final Dome readObject = (Dome) ois.readObject();
        System.out.println(readObject);
    }

    /**
     * 将对象转换成json格式的字符串缓存到String数据结构中
     */
    @Test
    public void test03(){
        final Dome pro = new Dome();
        pro.setId(200);
        pro.setName("星星之火");
        pro.setTime(new Date());
        //把对象转换成json格式
        Gson gson = new Gson();
        String json = gson.toJson(pro);
        //将json字符串缓存到Redis
        jedis.set("dome:002",json);
        //获取数据
        String jsonRes = jedis.get("dome:002");
        //将json字符串转换成对象
        Dome productInfo = gson.fromJson(jsonRes, Dome.class);
        System.out.println(jsonRes);
        System.out.println(productInfo);
    }


}
