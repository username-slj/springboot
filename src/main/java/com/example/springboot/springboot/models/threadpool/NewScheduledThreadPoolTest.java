package com.example.springboot.springboot.models.threadpool;

import com.example.springboot.springboot.common.Utils;

import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Executors.newScheduledThreadPool(int n)：
 * 创建一个定长线程池，支持定时及周期性任务执行
 *
 * @author shaolianjie
 */
public class NewScheduledThreadPoolTest {
    public static void main(String[] args) {
        int i1 = Runtime.getRuntime().availableProcessors();
        System.out.println("系统资源大小：" + i1);
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(i1);
        scheduledExecutorService.schedule(() -> System.out.println("延迟3秒执行" + Utils.formatDateToString(new Date(), Utils.DATE_LONG_FORMAT)), 3, TimeUnit.SECONDS);
        scheduledExecutorService.scheduleAtFixedRate(() -> System.out.println("延迟1秒后每3秒执行一次" + Utils.formatDateToString(new Date(), Utils.DATE_LONG_FORMAT)), 1, 3, TimeUnit.SECONDS);
    }
}
