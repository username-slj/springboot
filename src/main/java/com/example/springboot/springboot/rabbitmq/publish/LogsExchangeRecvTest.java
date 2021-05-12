package com.example.springboot.springboot.rabbitmq.publish;

import com.example.springboot.springboot.common.Constant;
import com.example.springboot.springboot.common.RabbitMQUtils;
import com.rabbitmq.client.CancelCallback;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.DeliverCallback;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * 发布/订阅
 * 消费者
 *
 * @author iybwb-shaolianjie
 */
@Slf4j
public class LogsExchangeRecvTest {
    public static void main(String[] args) throws IOException, TimeoutException {
        Channel channel = RabbitMQUtils.getConnection();
        channel.exchangeDeclare(Constant.EXCHANGE_FANOUT, Constant.FANOUT);

        //自动队列名
        String queueName = channel.queueDeclare().getQueue();

        //队列绑定到交换机
        channel.queueBind(queueName, Constant.EXCHANGE_FANOUT, "");

        DeliverCallback callback = (s, message) -> {
            String msg = new String(message.getBody(), Constant.UTF_8);
            log.info("收到: {}" ,msg);
        };

        //消费者取消时的回调对象
        CancelCallback cancel = consumerTag -> {
        };

        channel.basicConsume(queueName, true, callback, cancel);
    }
}
