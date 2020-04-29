package com.example.springboot.springboot.jdk8;

import com.example.springboot.springboot.aop.entity.MyObj;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class Test {
    public static void main(String[] args) {
        //->写法
//        test1();
        //无参应用::
//        test2();


    }




    private static void test1(){
        List list=new ArrayList();
        list.add("admin");
        list.add("wangwu");
        list.add("zhangsan");

        list.stream().forEach(item -> {
            System.out.println(item);
        });
        Consumer<String> consumer = (str) -> System.out.println(str);
        consumer.accept("lisi");
    }
}
