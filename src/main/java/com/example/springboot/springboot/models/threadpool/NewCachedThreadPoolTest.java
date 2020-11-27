package com.example.springboot.springboot.models.threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Executors.newCacheThreadPool()：
 * 创建一个可根据需要创建新线程的线程池
 */
public class NewCachedThreadPoolTest {
    public static void main(String[] args) {
        // 创建一个可缓存线程池
        ExecutorService executorService = Executors.newCachedThreadPool();
        for(int i=0; i<10; i++){
            try {
                // sleep可明显看到使用的是线程池里面以前的线程，没有创建新的线程
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName()+"正在被执行");
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
    }
}
