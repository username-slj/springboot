package com.example.springboot.springboot.rabbitmq.work.model2;

import com.example.springboot.springboot.common.Constant;
import com.example.springboot.springboot.common.RabbitMQUtils;
import com.rabbitmq.client.Channel;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * 工作模式-生产者
 * 生产出的消息给到同一个队列的多个消费者
 * 先运行2个消费者，然后开启生产者，消息会被2个消费者平均消费
 * @author iybwb-shaolianjie
 */
@Slf4j
public class WorkSendTest {
    public static void main(String[] args) throws IOException, TimeoutException {
        Channel channel = RabbitMQUtils.getConnection();
        channel.queueDeclare(Constant.QUEUE_WORK, false, false, false, null);

        for(int i=1; i<=Constant.FIGURE_10; i++){
            channel.basicPublish("",Constant.QUEUE_WORK,null,Constant.QUEUE_WORK_MESSAGE.getBytes());
        }
        log.info("生产消息结束");
        channel.close();
    }

}
