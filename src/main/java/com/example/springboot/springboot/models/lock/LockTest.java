package com.example.springboot.springboot.models.lock;

public class LockTest {
    public static void main(String[] args) {
        LockModel lockModel = new LockModel();

        Thread thread1 = new Thread(lockModel);
        Thread thread2 = new Thread(lockModel);
        Thread thread3 = new Thread(lockModel);
        thread1.setName("窗口1");
        thread2.setName("窗口2");
        thread3.setName("窗口3");

        thread1.start();
        thread2.start();
        thread3.start();
    }
}
