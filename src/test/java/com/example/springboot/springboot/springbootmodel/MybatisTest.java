package com.example.springboot.springboot.springbootmodel;

import com.example.springboot.springboot.SpringbootApplication;
import com.example.springboot.springboot.springbootmodel.dao.SUserMapper;
import com.example.springboot.springboot.springbootmodel.model.SUser;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@MapperScan("com.example.springboot.springboot.springbootmodel.dao")
@SpringBootTest(classes = SpringbootApplication.class)
public class MybatisTest {
    @Resource
    private SUserMapper sUserMapper;

    @Test
    public void mybatis01(){
        SUser sUser = new SUser();
        sUser.setId("00002");
        sUser.setUsername("zhangsan");
        sUser.setPassword("123456");
        sUserMapper.insert(sUser);
    }
}
