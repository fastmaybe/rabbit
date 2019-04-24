package com.rabbit.demo.amqp.directExchange;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class DirectReceiver {


    @RabbitListener(queues = "hello")
    public void hello(String message) {
        System.out.println("接收者 helloReceiver," + message);
    }


    @RabbitListener(queues = "direct")
    public void process(String message) {
        System.out.println("接收者 helloReceiver," + message);
    }
}
