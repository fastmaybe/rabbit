package com.rabbit.demo.amqp.fanoutExchange;

import com.rabbit.demo.pojo.RabbitParams;
import com.rabbitmq.client.Channel;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

//@Component
public class FanoutReceiver3 {


    @RabbitListener(queues =RabbitFanoutConfig.PENGLEI)
    public void process(RabbitParams params, Message message, Channel channel) {
        System.out.println(RabbitFanoutConfig.PENGLEI);
        System.out.println("接收者1 FanoutReceiver1," + params);
    }

    @RabbitListener(queues = RabbitFanoutConfig.SOUYUNKU+"2")
    public void process2(RabbitParams params, Message message, Channel channel) {
        System.out.println(RabbitFanoutConfig.SOUYUNKU+"2");
        System.out.println("接收者1 FanoutReceiver2," + params);
    }
}
