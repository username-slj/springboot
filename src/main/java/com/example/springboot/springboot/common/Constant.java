package com.example.springboot.springboot.common;

/**
 * @author shaolianjie
 * 常量类
 */
public class Constant {
    /**
     * 简单模式
     */
    public static String QUEUE_SIMPLENESS="queue_simpleness";
    public static String QUEUE_SIMPLENESS_MESSAGE="条消息";

    /**
     * 工作模式
     */
    public static String QUEUE_WORK="queue_work";
    public static String QUEUE_WORK_MESSAGE="工作模式内容";

    /**
     * ACK消息确认
     */
    public static String QUEUE_ACK="queue_ack";
    public static String QUEUE_ACK_MESSAGE="ACK模式内容";

    /**
     * BasicQos消费者只能消费一条数据后才能继续消费（解决消息平均在个个消费者来消费）
     */
    public static String QUEUE_BASICQOS="queue_BasicQos";
    public static String QUEUE_BASICQOS_MESSAGE="BasicQos防止消息被消费的不均匀";

    /**
     * 发布/订阅
     */
    public static String EXCHANGE_FANOUT="logs";
    public static String EXCHANGE_FANOUT_MESSSAGE="发布/订阅内容";


    /**
     * 交换类型:direct、topic、header、fanout
     */
    public static String DIRECT="direct";
    public static String TOPIC="topic";
    public static String HEADER="header";
    public static String FANOUT="fanout";
    public static int FIGURE_1=1;
    public static int FIGURE_10=10;
    public static String UTF_8="UTF-8";
}
