package com.example.springboot.springboot.models.runnable;

/**
 * Runnable
 * 1.接口实现多线程
 */
public class MyRunnable implements Runnable {
    @Override
    public void run() {
        System.out.println("===MyRunnable  run===");
    }

    public static void main(String[] args) {
        Thread thread = new Thread(new MyRunnable());
        thread.start();
    }
}
