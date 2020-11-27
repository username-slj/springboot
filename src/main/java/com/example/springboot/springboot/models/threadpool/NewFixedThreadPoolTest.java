package com.example.springboot.springboot.models.threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Executors.newFixedThreadPool(int n)：
 * 创建一个可重用固定线程数的线程池
 */
public class NewFixedThreadPoolTest {
    public static void main(String[] args) {
        //获取系统资源大小，创建对应线程数
        int i1 = Runtime.getRuntime().availableProcessors();
        System.out.println("系统资源大小："+ i1);
        ExecutorService executorService = Executors.newFixedThreadPool(i1);
        for(int i=0; i<9; i++){
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName()+"正在执行中");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
    }
}
