package com.example.springboot.springboot.jdk8;

import com.example.springboot.springboot.jdk8.entity.MyEntity;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

@Slf4j
public class Test {
    public static void main(String[] args) {
        //->写法
//        test1();
        //无参应用::
//        test2();
        //arrays
//        test2();


    }


    private static void test2(){
        String[] strarray={"d","b","c","a"};
        List<String> abcd = Arrays.asList(strarray);
        System.out.println("asList数组转list：");
        abcd.forEach(item ->{
            System.out.println(item);
        });

        Arrays.sort(strarray);
        System.out.print("sort排序：");
        for(int i=0; i < strarray.length ;i++){
            System.out.print(strarray[i]);
        }
        System.out.println();
        Arrays.fill(strarray,"a");
        System.out.print("fill替换数组中所有元素：");
        for(int i=0; i < strarray.length ;i++){
            System.out.print(strarray[i]);
        }
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
