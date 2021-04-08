package com.example.springboot.springboot.models.threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Executors.newFixedThreadPool(int n)：
 * 创建一个定长线程池，可控制线程最大并发数，超出的线程会在队列中等待
 *
 * @author shaolianjie
 */
public class NewFixedThreadPoolTest {
    private final static int POOL_MAX = 100;

    public static void main(String[] args) {
        //获取系统资源大小，创建对应线程数
        int i1 = Runtime.getRuntime().availableProcessors();
        System.out.println("系统资源大小：" + i1);
        ExecutorService executorService = Executors.newFixedThreadPool(i1);
        for (int i = 0; i < POOL_MAX; i++) {
            executorService.execute(() -> {
                System.out.println(Thread.currentThread().getName() + "正在执行中");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }
    }
}
