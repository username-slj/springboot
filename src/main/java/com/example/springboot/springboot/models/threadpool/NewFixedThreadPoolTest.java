package com.example.springboot.springboot.models.threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Executors.newFixedThreadPool(int n)：
 * 创建一个固定个数的线程池，以共享的无界队列方式来运行这些线程。
 * 因为线程池大小为为系统资源大小，每个任务输出打印结果后sleep 1秒，所以每1秒打印系统资源数结果。
 */
public class NewFixedThreadPoolTest {
    public static void main(String[] args) {
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
