package com.example.springboot.springboot.jdk8.statics;

/**
 * class加载：当前类找到上一级父类（如果还有一直找最终找到最上面的父类加载）
 * 父类静态代码块--子类静态代码块--父类匿名代码块--父类无参构造方法--子类匿名代码块--子类无参构造方法
 */
public class Test {
    public static void main(String[] args) {
        B b = new B();

    }
}
