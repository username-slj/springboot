package com.example.springboot.springboot.rabbitmq.publish;

import com.example.springboot.springboot.common.Constant;
import com.example.springboot.springboot.common.RabbitMQUtils;
import com.rabbitmq.client.BuiltinExchangeType;
import com.rabbitmq.client.Channel;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * 发布/订阅
 * 生产者-交换机-消费者（广播模式）
 * 如果还没有队列绑定到交换器，消息就会丢失，可以先把消费者运行起来绑定，在运行生产者
 * @author iybwb-shaolianjie
 */
@Slf4j
public class LogsExchangeSendTest {
    public static void main(String[] args) throws IOException, TimeoutException {
        Channel channel = RabbitMQUtils.getConnection();
        //定义交换机，交换模式：direct、topic、header和fanout
        channel.exchangeDeclare(Constant.EXCHANGE_FANOUT, BuiltinExchangeType.FANOUT);

        channel.basicPublish(Constant.EXCHANGE_FANOUT, "", null, Constant.EXCHANGE_FANOUT_MESSSAGE.getBytes(Constant.UTF_8));
        log.info("发布/订阅消息已发出");
        channel.close();
    }
}
