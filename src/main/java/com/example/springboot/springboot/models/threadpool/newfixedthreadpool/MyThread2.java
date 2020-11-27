package com.example.springboot.springboot.models.threadpool.newfixedthreadpool;

public class MyThread2 implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i <= 100; i++) {
            if (i % 2 == 0)
                System.out.println("MyThread2="+Thread.currentThread().getName() + ":" + i);
        }
    }
}
