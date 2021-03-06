package com.example.springboot.springboot.rabbitmq.simpleness;

import com.example.springboot.springboot.common.Constant;
import com.example.springboot.springboot.common.RabbitMQUtils;
import com.rabbitmq.client.CancelCallback;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.DeliverCallback;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * 简单模式-消费者
 *
 * @author iybwb-shaolianjie
 */
public class SimplenessRecvTest {

    public static void main(String[] args) throws IOException, TimeoutException {
        Channel channel = RabbitMQUtils.getConnection();
        channel.queueDeclare(Constant.QUEUE_SIMPLENESS, true, false, false, null);
        //收到消息后用来处理消息的回调对象
        DeliverCallback callback = (s, message) -> {
            String msg = new String(message.getBody(), "UTF-8");
            System.out.println("收到: " + msg);
        };

        //消费者取消时的回调对象
        CancelCallback cancel = consumerTag -> {
        };
        channel.basicConsume(Constant.QUEUE_SIMPLENESS, true, callback, cancel);
    }
}
