package com.example.springboot.springboot.models.thread.callable;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * Callable通过FutureTask.get()获取返回信息
 *  1.创建一个实现callable的实现类
 *  2.实现call方法，将此线程需要执行的操作声明在call（）中
 *  3.创建callable实现类的对象
 *  4.将callable接口实现类的对象作为传递到FutureTask的构造器中，创建FutureTask的对象
 *  5.将FutureTask的对象作为参数传递到Thread类的构造器中，创建Thread对象，并调用start方法启动（通过FutureTask的对象调用方法get获取线程中的call的返回值）
 */
public class CallableTest {
    public static void main(String[] args) {
        MyCallable myCallable = new MyCallable();

        FutureTask futureTask = new FutureTask(myCallable);

        Thread thread = new Thread(futureTask);
        thread.setName("线程1");
        thread.start();

        try {
            //拿到返回值
            Object obj = futureTask.get();
            System.out.println(Thread.currentThread().getName()+":::"+ obj);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
