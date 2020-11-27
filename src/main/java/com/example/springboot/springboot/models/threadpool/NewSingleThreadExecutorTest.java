package com.example.springboot.springboot.models.threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Executors.newSingleThreadExecutor()：
 * 创建一个只有一个线程的线程池
 * 创建一个单线程化的线程池，它只会用唯一的工作线程来执行任务，保证所有任务按照指定顺序(FIFO, LIFO, 优先级)执行。
 */
public class NewSingleThreadExecutorTest {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        for(int i=0; i<10; i++){
            final int inedx=i;
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println("===="+Thread.currentThread().getName()+"打印的值="+inedx);
                }
            });
        }
    }
}