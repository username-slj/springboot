package com.example.springboot.springboot.models.threadpool;

import com.example.springboot.springboot.common.Utils;

import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Executors.newScheduledThreadPool(int n)：
 * 创建一个固定线程池，支持定时及周期性任务执行
 */
public class NewScheduledThreadPoolTest {
    public static void main(String[] args) {
        int i1 = Runtime.getRuntime().availableProcessors();
        System.out.println("系统资源大小：" + i1);
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(i1);
        //延迟一秒
        scheduledExecutorService.schedule(new Runnable() {
            @Override
            public void run() {
                System.out.println("延迟一秒执行");
            }
        }, 1, TimeUnit.SECONDS);

        //第一次开始执行是5s后，假如执行耗时1s，执行完成时间是6s后，那么下次开始执行是8s后，再下次开始执行是10s后
        System.out.println("===开始时间" + Utils.formatDateToString(new Date(), Utils.DATE_LONG_FORMAT));
        scheduledExecutorService.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                System.out.println("延迟5秒后每2秒执行一次" + Utils.formatDateToString(new Date(), Utils.DATE_LONG_FORMAT));
            }
        }, 5, 2, TimeUnit.SECONDS);

        //第一次开始执行是5s后，假如执行耗时1s，执行完成时间是6s后，那么下次开始执行是8s后，再下次开始执行是11s后
        scheduledExecutorService.scheduleWithFixedDelay(new Runnable() {
            @Override
            public void run() {
                System.out.println("延迟5秒后每2秒执行一次" + Utils.formatDateToString(new Date(), Utils.DATE_LONG_FORMAT));
            }
        }, 5, 2, TimeUnit.SECONDS);
    }
}
