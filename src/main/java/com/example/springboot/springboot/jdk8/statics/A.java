package com.example.springboot.springboot.jdk8.statics;

public class A {
    static int a;
    String name;
    int id;

    static {
        a = 10;
        System.out.println("A类的静态代码块：" + a);
    }

    {
        id = 11;
        System.out.println("A类的匿名代码块：" + id);
    }

    A() {
        System.out.println("A类无参构造");
    }

    A(String name) {
        System.out.println("A类有参构造：" + name);
    }
}
