package com.rabbit.demo.amqp.fanoutExchange;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class FanoutReceiver {


    @RabbitListener(queues =RabbitFanoutConfig.PENGLEI)
    public void process(String message) {
        System.out.println("接收者1 FanoutReceiver1," + message);
    }

    @RabbitListener(queues = RabbitFanoutConfig.SOUYUNKU)
    public void process2(String message) {
        System.out.println("接收者1 FanoutReceiver2," + message);
    }
}
