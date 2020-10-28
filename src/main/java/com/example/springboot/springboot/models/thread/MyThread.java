package com.example.springboot.springboot.models.thread;

/**
 * Thread
 * 1.需要继承实现多线程
 */
public class MyThread extends Thread {

    public void run() {
        System.out.println("===MyThread   run===" + Thread.currentThread().getName());
    }


    public static void main(String[] args) {
        MyThread myThread1 = new MyThread();
        MyThread myThread2 = new MyThread();
        myThread1.start();
        myThread2.start();
    }
}
