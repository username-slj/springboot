package com.example.springboot.springboot.models.volatiles;

/**
 * volatile:  多线程中变量存在主内存中，每个线程执行中会把变量从主内存中赋值一份到本地内存中，
 *            线程执行后会把最新的值写入主内存中，其他线程在使用；
 * 问题： 线程1和线程2同时拿到变量为0， 线程1加1后把值写到主内存，线程2同样操作，最终结果=1，但是正确结果应该是2
 *        线程把变量值改变后，volatile会把值写入到主内存中
 */
public class ThreadShop implements Runnable {
//    private volatile int product = 5; // 直接内存操作
    private int product = 5; // 直接内存操作

    @Override
    public void run() {
//        synchronized (this){
            while (product > 0){
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName()+"商品处理，product = "+product--);
            }
//        }
    }

    public static void main(String[] args) {
        ThreadShop threadShop1 = new ThreadShop();
        ThreadShop threadShop2 = new ThreadShop();
        ThreadShop threadShop3 = new ThreadShop();
        new Thread(threadShop1,"店铺1").start();
        new Thread(threadShop2,"店铺2").start();
        new Thread(threadShop3,"店铺3").start();
    }
}
