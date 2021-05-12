package com.example.springboot.springboot.rabbitmq.route;

import com.example.springboot.springboot.common.Constant;
import com.example.springboot.springboot.common.RabbitMQUtils;
import com.rabbitmq.client.BuiltinExchangeType;
import com.rabbitmq.client.CancelCallback;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.DeliverCallback;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * 路由模式
 * 生产者-交换机-（关键字匹配）队列-消费者
 *
 * @author iybwb-shaolianjie
 */
@Slf4j
public class ErrorExchangeRecvTest {
    public static void main(String[] args) throws IOException, TimeoutException {
        Channel channel = RabbitMQUtils.getConnection();
        channel.exchangeDeclare(Constant.EXCHANGE_DIRECT, BuiltinExchangeType.DIRECT);

        //队列名
        String queueName = channel.queueDeclare().getQueue();
        //把队列绑定到交换机
        channel.queueBind(queueName, Constant.EXCHANGE_DIRECT, Constant.EXCHANGE_DIRECT_ROUTINGKEY);

        //回调
        DeliverCallback callback = (s, message) -> {
            String msg = new String(message.getBody(), Constant.UTF_8);
            String routingKey = message.getEnvelope().getRoutingKey();
            log.info("收到: {}-{}", routingKey, msg);
        };

        //消费者取消时的回调对象
        CancelCallback cancel = consumerTag -> {
        };
        channel.basicConsume(queueName, false, callback, cancel);
    }
}
