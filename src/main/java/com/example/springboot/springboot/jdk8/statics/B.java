package com.example.springboot.springboot.jdk8.statics;

public class B extends A {
    String name;
    static int b;

    static {
        b = 12;
        System.out.println("B类静态代码块：" + b);
    }

    {
        b=13;
        System.out.println("B类匿名代码块："+ b);
    }

    B(){
        System.out.println("B类无参构造");
    }

    B(String name) {
        super(name);
        this.name = name;
        System.out.println("B类有参构造：" + this.name);
    }
}
