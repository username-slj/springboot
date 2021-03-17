package com.example.springboot.springboot.jdk8.imports;

import com.example.springboot.springboot.SpringbootApplication;
import lombok.extern.slf4j.Slf4j;
import org.junit.runner.RunWith;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringbootApplication.class)
@MapperScan("com.example.springboot.springboot.springbootmodel")
public class Test {
    @Autowired
    private Model1 model1;

    /**
     * Model1普通类，由于使用ImportConfig类中的Import导入后，model1就可以实例化出来
     */
    @org.junit.Test
    public void test01(){
        model1.print();
    }
}
