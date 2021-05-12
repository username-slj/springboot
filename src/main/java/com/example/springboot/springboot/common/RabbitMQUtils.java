package com.example.springboot.springboot.common;

import com.rabbitmq.client.CancelCallback;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.DeliverCallback;
import com.rabbitmq.client.Delivery;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @author iybwb-shaolianjie
 */
@Slf4j
public class RabbitMQUtils {

    public static Channel getConnection() throws IOException, TimeoutException {
        //创建连接工厂
        ConnectionFactory connectionFactory = new ConnectionFactory();

        //主机地址;默认为 localhost
        connectionFactory.setHost("172.20.170.56");

        //连接端口;默认为 5672(url登录是的15672.代码中是5672)
        connectionFactory.setPort(5672);

        //虚拟主机名称;默认为 /
        connectionFactory.setVirtualHost("/");

        //连接用户名；默认为guest
        connectionFactory.setUsername("guest");

        //连接密码；默认为guest
        connectionFactory.setPassword("guest");

        //创建连接
        Connection connection = connectionFactory.newConnection();

        //建立信道
        Channel channel = connection.createChannel();
        return channel;
    }
}
