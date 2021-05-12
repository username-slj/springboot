package com.example.springboot.springboot.rabbitmq.work.model4;

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
public class BasicQosSendTest {
    public static void main(String[] args) throws IOException, TimeoutException {
        Channel channel = RabbitMQUtils.getConnection();
        //TODO 第二个参数是否持久化：false，true
        channel.queueDeclare(Constant.QUEUE_BASICQOS, true, false, false, null);

        channel.basicPublish("", Constant.QUEUE_BASICQOS, null, Constant.QUEUE_BASICQOS_MESSAGE.getBytes());
        log.info("BasicQos生产消息结束");
        channel.close();
    }
}
