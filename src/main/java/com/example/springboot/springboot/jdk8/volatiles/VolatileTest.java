package com.example.springboot.springboot.jdk8.volatiles;

public class VolatileTest extends Thread {
    //    volatile boolean flag = true;
    boolean flag = true;
    int num = 0;

    @Override
    public void run() {
        System.out.println("flag=" + flag);
        while (flag) {
            num++;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        VolatileTest volatileTest = new VolatileTest();
        Thread thread = new Thread(volatileTest);
        thread.start();
        Thread.sleep(2000);
        volatileTest.flag = false;
        System.out.println("stop=" + volatileTest.num);
    }
}
