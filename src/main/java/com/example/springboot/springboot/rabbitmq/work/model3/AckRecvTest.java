package com.example.springboot.springboot.rabbitmq.work.model3;

import com.example.springboot.springboot.common.Constant;
import com.example.springboot.springboot.common.RabbitMQUtils;
import com.rabbitmq.client.CancelCallback;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.DeliverCallback;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * ACK消费者（消费后返回确认码，生产者确认后删除消息）
 * TODO 是关键代码
 * @author iybwb-shaolianjie
 */
@Slf4j
public class AckRecvTest {
    public static void main(String[] args) throws IOException, TimeoutException {
        Channel channel = RabbitMQUtils.getConnection();
        channel.queueDeclare(Constant.QUEUE_ACK, false, false, false, null);
        DeliverCallback callback = (ss, message) -> {
            String msg = new String(message.getBody(), Constant.UTF_8);
            log.info("消费者收到: " + msg);

            for (int i = 0; i < msg.length(); i++) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                }
            }
            log.info("消费者处理结束");
            //TODO 发送回执
            channel.basicAck(message.getEnvelope().getDeliveryTag(), false);
        };

        //消费者取消时的回调对象
        CancelCallback cancel = consumerTag -> {
        };
        //TODO autoAck设置为false,则需要手动确认发送回执
        channel.basicConsume(Constant.QUEUE_ACK, false, callback, cancel);
    }
}
