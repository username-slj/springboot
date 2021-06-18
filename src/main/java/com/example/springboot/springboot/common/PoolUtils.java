package com.example.springboot.springboot.common;

import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;

/**
 * 线程工具类
 *
 * @author iybwb-shaolianjie
 */
public class PoolUtils {
    /**
     * 核心线程池大小
     */
    private int corePoolSize;
    /**
     * 最大线程池大小
     */
    private int maximumPoolSize;
    /**
     * 线程最大空闲时间
     */
    private long keepAliveTime;
    /**
     * 时间单位
     */
    private TimeUnit unit;
    /**
     * 线程等待队列
     */
    private int workQueue;
    /**
     * 线程创建工厂
     */
    private ThreadFactory threadFactory;
    /**
     * 拒绝策略
     */
    private RejectedExecutionHandler handler;


}
