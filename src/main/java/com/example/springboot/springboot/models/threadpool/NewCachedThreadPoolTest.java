package com.example.springboot.springboot.models.threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Executors.newCacheThreadPool()：
 * 可缓存线程池，先查看池中有没有以前建立的线程，如果有，就直接使用。
 * 如果没有，就建一个新的线程加入池中，缓存型池子通常用于执行一些生存期很短的异步型任务
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
