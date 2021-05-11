package com.example.springboot.springboot.rabbitmq.model3;

import com.example.springboot.springboot.common.Constant;
import com.example.springboot.springboot.common.RabbitMQUtils;
import com.rabbitmq.client.Channel;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * ACK消息确认
 *
 * @author iybwb-shaolianjie
 */
@Slf4j
public class AckSendTest {
    public static void main(String[] args) throws IOException, TimeoutException {
        Channel channel = RabbitMQUtils.getConnection();
        channel.queueDeclare(Constant.QUEUE_ACK, false, false, false, null);

        channel.basicPublish("", Constant.QUEUE_ACK, null, Constant.QUEUE_ACK_MESSAGE.getBytes());
        log.info("ACK生产消息结束");
        channel.close();
    }
}
