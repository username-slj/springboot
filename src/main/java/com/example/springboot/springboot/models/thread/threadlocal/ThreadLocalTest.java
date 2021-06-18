package com.example.springboot.springboot.models.thread.threadlocal;

import lombok.extern.slf4j.Slf4j;

/**
 * threadlocal 作用和使用场景
 * https://www.cnblogs.com/ConstXiong/p/12014739.html
 *
 * @author iybwb-shaolianjie
 */
@Slf4j
public class ThreadLocalTest {
    //ThreadLocal:保证每个线程使用的是自己的INTEGER_THREAD_LOCAL，如果不使用ThreadLocal打印的count会一直追加。
    //使用ThreadLocal后每个线程只打印自己的5个数字出来
    private static final ThreadLocal<Integer> INTEGER_THREAD_LOCAL = ThreadLocal.withInitial(() -> 0);

    public static void main(String[] args) {
        for (int i = 0; i < 3; i++) {
            new Thread(() -> {
                add();
            }).start();
        }
    }

    private static void add() {
        for (int j = 0; j < 5; j++) {
            Integer count = INTEGER_THREAD_LOCAL.get();
            count++;
            INTEGER_THREAD_LOCAL.set(count);
            log.info("线程名称={}，数量={}", Thread.currentThread().getName(), count);
        }
    }
}
