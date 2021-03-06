package com.rabbit.demo.amqp.fanoutExchange;

import com.rabbit.demo.pojo.RabbitParams;
import com.rabbitmq.client.Channel;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class FanoutReceiver2 {


    @RabbitListener(queues =RabbitFanoutConfig.PENGLEI)
    public void process(RabbitParams params, Message message, Channel channel) {
        System.out.println("接收者2  " + params);
        System.out.println("接收者2  " + message);
    }

    @RabbitListener(queues = RabbitFanoutConfig.SOUYUNKU)
    public void process2(RabbitParams params, Message message, Channel channel) {
        System.out.println("接收者2  " + params);
        System.out.println("接收者2  " + message);
    }
}

