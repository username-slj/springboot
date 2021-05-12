package com.example.springboot.springboot.rabbitmq.work.model4;

import com.example.springboot.springboot.common.Constant;
import com.example.springboot.springboot.common.RabbitMQUtils;
import com.rabbitmq.client.CancelCallback;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.DeliverCallback;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * 消费者：每次消费一个，防止一个消费者占用大量消息导致消息不均匀
 * @author iybwb-shaolianjie
 */
@Slf4j
public class BasicQosRecvTest {
    public static void main(String[] args) throws IOException, TimeoutException {
        Channel channel = RabbitMQUtils.getConnection();
        //TODO 第二个参数是否持久化：false，true
        channel.queueDeclare(Constant.QUEUE_BASICQOS, true, false, false, null);
        //一次只消费一条消息
        channel.basicQos(1);
        DeliverCallback callback = (s, message) -> {
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
