package com.example.springboot.springboot.rabbitmq.model1;

import com.example.springboot.springboot.common.Constant;
import com.example.springboot.springboot.common.RabbitMQUtils;
import com.rabbitmq.client.Channel;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * 简单模式-生产者
 *
 * @author iybwb-shaolianjie
 */
@Slf4j
public class SendTest {
    public static void main(String[] args) throws IOException, TimeoutException {
        Channel channel = RabbitMQUtils.getConnection();

//        声明队列,会在rabbitmq中创建一个队列
//        参数含义:
//        queue: 队列名称
//        durable: 队列持久化,true表示RabbitMQ重启后队列仍存在
//        exclusive: 排他,true表示限制仅当前连接可用
//        autoDelete: 当最后一个消费者断开后,是否删除队列
//        arguments: 其他参数
        channel.queueDeclare(Constant.QUEUE_KEY, true, false, false, null);

        /*
         * 发布消息
         * 这里把消息向默认交换机发送.
         * 默认交换机隐含与所有队列绑定,routing key即为队列名称
         *
         * 参数含义:
         * 	-exchange: 交换机名称,空串表示默认交换机"(AMQP default)",不能用 null
         * 	-routingKey: 对于默认交换机,路由键就是目标队列名称
         * 	-props: 其他参数,例如头信息
         * 	-body: 消息内容byte[]数组
         */
        for (int i = Constant.FIGURE_1; i <= Constant.FIGURE_10; i++) {
            channel.basicPublish("", Constant.QUEUE_KEY, null, String.valueOf("第" + i + "条消息").getBytes());
            log.info("ProducerTest 已发送" + i + "条");
        }
        channel.close();
    }

}
