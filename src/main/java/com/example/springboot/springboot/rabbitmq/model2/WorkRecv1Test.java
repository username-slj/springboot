package com.example.springboot.springboot.rabbitmq.model2;

import com.example.springboot.springboot.common.Constant;
import com.example.springboot.springboot.common.RabbitMQUtils;
import com.rabbitmq.client.CancelCallback;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.DeliverCallback;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * 工作模式-消费者1
 *
 * @author iybwb-shaolianjie
 */
@Slf4j
public class WorkRecv1Test {
    public static void main(String[] args) throws IOException, TimeoutException {
        Channel channel = RabbitMQUtils.getConnection();
        channel.queueDeclare(Constant.QUEUE_WORK, false, false, false, null);
        DeliverCallback deliverCallback = (s, message) -> {
            String msg = new String(message.getBody(), "UTF-8");
            log.info("消费者1收到: " + msg);

            //遍历字符串中的字符,每个点使进程暂停一秒
            for (int i = 0; i < msg.length(); i++) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                }
            }
            log.info("消费者1处理结束");
        };

        //消费者取消时的回调对象
        CancelCallback cancel = consumerTag -> {
        };
        channel.basicConsume(Constant.QUEUE_WORK, true, deliverCallback, cancel);
    }


}
