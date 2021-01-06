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
