package com.example.springboot.springboot.rabbitmq.route;

import com.example.springboot.springboot.common.Constant;
import com.example.springboot.springboot.common.RabbitMQUtils;
import com.rabbitmq.client.BuiltinExchangeType;
import com.rabbitmq.client.Channel;
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
public class ErrorExchangeSendTest {
    public static void main(String[] args) throws IOException, TimeoutException, InterruptedException {
        Channel channel = RabbitMQUtils.getConnection();
        channel.exchangeDeclare(Constant.EXCHANGE_DIRECT, BuiltinExchangeType.DIRECT);
        for (int i = 1; i <= 3; i++) {
            String msg = Constant.EXCHANGE_DIRECT_MESSSAGE + i;
            channel.basicPublish(Constant.EXCHANGE_FANOUT, Constant.EXCHANGE_DIRECT_ROUTINGKEY, null, msg.getBytes());
            Thread.sleep(200);
            log.info("第"+i+"条direct生产消息结束");
        }
        channel.close();
    }
}
