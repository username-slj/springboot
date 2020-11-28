package com.example.springboot.springboot.models.lock.model1;

import lombok.SneakyThrows;

import java.util.concurrent.locks.ReentrantLock;

/**
 * 相同：二者都可以解决线程安全问题
 * 不同：synchronized机制在执行完相应的代码逻辑以后，自动的释放同步监视器
 * lock需要手动的启动同步（lock（）），同时结束同步也需要手动的实现（unlock（））（同时以为着lock的方式更为灵活）
 */
public class LockModel implements Runnable {
    private int sum = 10;
    private ReentrantLock reentrantLock = new ReentrantLock();

    @SneakyThrows
    @Override
    public void run() {
        while (true) {
            //为什么只有一个窗口执行全部售票
            reentrantLock.lock();
            //为什么三个窗口都可以执行售票
//            synchronized (this) {
                if (sum > 0) {
                    Thread.sleep(1000);
                } else {
                    break;
                }
                System.out.println(Thread.currentThread().getName() + "售出第" + sum + "票");
                sum--;
//            }
        }
    }
}
