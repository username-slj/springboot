package com.example.springboot.springboot.jdk8;

import com.example.springboot.springboot.common.Utils;
import com.example.springboot.springboot.jdk8.entity.A;
import com.example.springboot.springboot.jdk8.entity.A2;
import com.example.springboot.springboot.jdk8.entity.B;
import com.example.springboot.springboot.jdk8.entity.MyEntity;
import lombok.extern.slf4j.Slf4j;
import org.apache.logging.log4j.core.util.JsonUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
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
        //i++先引用在计算，++i先计算在引用
//        test3();
        //== 和 equals
//        test04();
//        jdk8循环非空判断
//        test05();
//        jdk8的forEach不能使用break,continue, 可以使用return代替continue（return和continue是一样的效果）
//        test06();
//          字符串内存模型
//        test07();
//        BeanUtils.copyProperties
//        test08();
//        list(BO)转List(BO):硬编码
//        test09();
//        对象转json
//        test10();
        test11();
    }

    private static void test11() {
        log.info("================");
        log.info("================");



    }

    private static void test10() {
        A a=new A();
        a.setUniqueNo(111l);
        a.setName("zhangsan");
        System.out.println(Utils.objectToJson(null));
    }

    private static void test09(){
        A a = new A();
        a.setName("lisi");
        a.setStatus("1");
        a.setUniqueNo(000002l);
        List<A> aList=new ArrayList<>();
        aList.add(a);

        A2 a2 = new A2();
        List<A2> a2List=new ArrayList<>();
        if(!CollectionUtils.isEmpty(aList)){
            for(A aLists : aList){
                BeanUtils.copyProperties(aLists, a2);
                a2List.add(a2);
            }
            System.out.println(a2List.get(0).getName()+"==="+a2List.get(0).getStatus()+"==="+a2List.get(0).getUniqueNo());
        }
    }

    private static void test08(){
        A a = new A();
        a.setName("zhangsan");
        a.setStatus("2");
        a.setUniqueNo(0000001l);
        A2 a2 = new A2();
        BeanUtils.copyProperties(a, a2);
        System.out.println("==="+a2.getName()+"==="+a2.getStatus()+"==="+a2.getUniqueNo());

    }

    private static void test07() {
        //String是不可变的，“1”符号保存先判断常量池三方存在1，存在1就返回1的引用，不存在就保存后返回引用
        //new String("1") 首先在常量池中判断是否存在1存在就在堆中开辟一块内存存放1，返回堆内存引用
        //                不存在就在常量池中存放，在在堆内存中开辟一块内存存放返回堆内存的引用
        String a="1";
        String b="1";
        //引用类型+字符串属于运行时创建（a存放在常量池中，“”存放常量池中是两块所以引用地址不一样）
        System.out.println(a+"" == b);
        //字符串量直接保存在常量池中，“1”不是引用类型直接相加“”所以最后引用是一样
        System.out.println("1"+"" == b);
    }

    private static void test06() {
        List<String> list = new ArrayList<>();
        list.add("112");
        list.add("1133");
        list.add("115555");

        Optional.ofNullable(list).orElse(new ArrayList<>()).forEach(s -> {
            if(s.length() == 4){
                return;
            }
            System.out.println(s);
        });
    }

    private static void test05() {
//        List<String> list = null;
        List<String> list = new ArrayList<>();
        list.add("11111");
        list.add("22222");
        list.add("33333");
        //普通写法
        if (!CollectionUtils.isEmpty(list)) {
            for (String str : list) {
                System.out.println(str);
                continue;
            }
        }
        //jdk8写法
        Optional.ofNullable(list).orElse(new ArrayList<>()).forEach(o -> {
            System.out.println(o);
        });
    }

    private static void test04() {
        /**
         * https://zhuanlan.zhihu.com/p/121603364
         * ==
         * 基本数据类型则直接比较其存储的 值是否相等，
         * 引用类型的变量则比较的是所指向的对象的地址是否相等
         *
         *equals 不重写和==相同作用
         *       重写后比较的是两个对象的值
         *       https://www.cnblogs.com/fangfuhai/p/5500065.html
         */
        int sums1 = 1;
        int sums2 = 1;
        String str1 = "str1";
        String str2 = "str1";
        String str3 = new String("str1");
        String str4 = new String("str1");
        String str5 = str1 + str4;
        String str6 = "str1str1";
        System.out.println(sums1 == sums2);//true
        System.out.println(str1 == str2);//true
        System.out.println(str3 == str4);//false 指向的地址不同
        System.out.println(str5 == str6);//false
        System.out.println(str1.equals(str2));//true
        System.out.println(str3.equals(str4));//true 地址不同值一样
        System.out.println(str1.equals(str4));//true 同上
        System.out.println(str1.equals(str4));//true
        System.out.println(str5.equals(str6));//true
    }

    private static void test3() {
        int i1 = 10;
        int i11 = i1++;
        int i2 = 10;
        int i22 = ++i2;
        System.out.println(i11);
        System.out.println(i22);
    }

    private static void test2() {
        String[] strarray = {"d", "b", "c", "a"};
        List<String> abcd = Arrays.asList(strarray);
        System.out.println("asList数组转list：");
        abcd.forEach(item -> {
            System.out.println(item);
        });

        Arrays.sort(strarray);
        System.out.print("sort排序：");
        for (int i = 0; i < strarray.length; i++) {
            System.out.print(strarray[i]);
        }
        System.out.println();
        Arrays.fill(strarray, "a");
        System.out.print("fill替换数组中所有元素：");
        for (int i = 0; i < strarray.length; i++) {
            System.out.print(strarray[i]);
        }
    }

    private static void test1() {
        List list = new ArrayList();
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

























