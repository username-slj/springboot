package com.example.springboot.springboot.models.threadpool;

import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * 1.同时放入三个不同调度的线程。从结果中可以看出每个线程按照自己的调度互不干扰的运行
 * 2.线程2被阻塞后，后面的线程都会被阻塞，不过依然都会按照自身调度来执行，但是会存在阻塞延迟
 * @author shaolianjie
 */
public class NewSingleThreadScheduledExecutor {
    private static long start = System.currentTimeMillis();
    private static final ScheduledExecutorService excutor = Executors.newSingleThreadScheduledExecutor();

    public static void main(String[] args) {
        Thread thread1 = new Thread(() -> {
            long end = System.currentTimeMillis();
            System.out.println("time wait:" + (end - start) + ",this is 线程1");
        }, "线程1");

        Thread thread2 = new Thread(() -> {
            long end = System.currentTimeMillis();
            //线程2被阻塞后，后面的线程都会被阻塞，重启启动后后面线程还会按照顺序执行
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("time wait:" + (end - start) + ",this is 线程2");
        }, "线程2");

        Thread thread3 = new Thread(() -> {
            long end = System.currentTimeMillis();
            System.out.println("time wait:" + (end - start) + ",this is 线程3");
        }, "线程3");
        excutor.scheduleWithFixedDelay(thread1, 0, 1, TimeUnit.SECONDS);
        excutor.scheduleWithFixedDelay(thread2, 0, 2, TimeUnit.SECONDS);
        excutor.scheduleWithFixedDelay(thread3, 0, 3, TimeUnit.SECONDS);
    }
}
