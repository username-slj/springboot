package com.example.springboot.springboot.jdk8;

import com.example.springboot.springboot.jdk8.entity.A;
import com.example.springboot.springboot.jdk8.entity.B;
import com.example.springboot.springboot.jdk8.entity.MyCurrency;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.CollectionUtils;

import javax.sound.midi.Soundbank;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.*;
import java.util.function.Consumer;
import java.util.stream.Collectors;

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
        test05();
    }

    private static void test05() {
        List<A> listA = new ArrayList<>();
        List<B> listB = new ArrayList<>();
        List<B> list = new ArrayList();
        Set<B> staffsSet = new HashSet<>();

        A a1 = new A();
        a1.setUniqueNo(1l);
        a1.setStatus("01");
        listA.add(a1);

        a1 = new A();
        a1.setUniqueNo(2l);
        a1.setStatus("00");
        listA.add(a1);

        B b = new B();
        b.setUniqueNo(1l);
        b.setStatus("01");
        listB.add(b);

        b = new B();
        b.setUniqueNo(3l);
        b.setStatus("00");
        listB.add(b);

        b = new B();
        b.setUniqueNo(4l);
        b.setStatus("00");
        listB.add(b);

        b = new B();
        b.setUniqueNo(5l);
        b.setStatus("00");
        listB.add(b);

        for (A alist : listA) {
            for (B blist : listB) {
                Long uniqueNo = alist.getUniqueNo() == null ? 0l : alist.getUniqueNo();
                if (uniqueNo.equals(blist.getUniqueNo())) {
                    if ("01".equals(alist.getStatus()) || "02".equals(alist.getStatus())) {
                        list.add(blist);
                    }
                } else {
                    for (B bblist : list) {
                        if (!bblist.getUniqueNo().equals(blist.getUniqueNo())) {
                            staffsSet.add(blist);
                            break;
                        }
                    }
                }
            }
        }

        for (B bbb : list) {
            System.out.println("===" + bbb.getUniqueNo() + "===" + bbb.getStatus());
        }
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
        System.out.println(str3 == str4);//false
        System.out.println(str1.equals(str2));//true
        System.out.println(str3.equals(str4));//true
        System.out.println(str1.equals(str4));//true
        System.out.println(str1.equals(str4));//true
        System.out.println(str5.equals(str6));//true
        System.out.println(str5 == str6);//false
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

























