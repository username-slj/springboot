package com.example.springboot.springboot.models.threadpool.newfixedthreadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MyThreadTest {
    public static void main(String[] args) {

        //创建固定线程个数为十个的线程池
        ExecutorService executorService = Executors.newFixedThreadPool(10);

        MyThread1 myThread1 = new MyThread1();
        MyThread2 myThread2 = new MyThread2();
        //TODO Runnable使用execute方法，Callable使用submit方法
        //submit:有返回值，可以捕获异常，入参是一个Callable，也可以是Runnable
        //execute:无返回值，不能捕获异常，入参是一个Runnable
        executorService.execute(myThread1);
        executorService.submit(myThread2);

        //关闭线程池
        executorService.shutdown();
    }
}
