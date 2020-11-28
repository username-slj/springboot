package com.example.springboot.springboot.models.designmode23.singleton;

/**
 * 单例模式
 */
public class SingletonTest {
    private static SingletonTest singletonTest;
    private static SingletonTest instence = new SingletonTest();


    //懒汉式:顾名思义就是实例在用到的时候才去创建，“比较懒”，用的时候才去检查有没有实例，如果有则返回，没有则新建。
    //      有线程安全和线程不安全两种写法，区别就是synchronized关键字
    public SingletonTest getInstence(){
        if(singletonTest == null){
            singletonTest = new SingletonTest();
        }
        return singletonTest;
    }

    //饿汉式:就是“比较勤”，实例在初始化的时候就已经建好了，不管你有没有用到，都先建好了再说。
    //      好处是没有线程安全的问题，坏处是浪费内存空间。
    public SingletonTest getSingletonTest(){
        return instence;
    }

    //双检锁，综合了懒汉式和饿汉式两者的优缺点整合而成。看上面代码实现中，特点是在synchronized关键字内外都加了一层 if 条件判断，
    //      这样既保证了线程安全，又比直接上锁提高了执行效率，还节省了内存空间。
    public SingletonTest SingletonTest(){
        if(singletonTest == null){
            synchronized (this){
                if(singletonTest == null){
                 this.singletonTest = new SingletonTest();
                }
            }
        }
        return this.singletonTest;
    }


}
