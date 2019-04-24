package com.rabbit.demo.amqp.topicExchange;

import com.rabbit.demo.pojo.RabbitParams;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class TopicReceiverOne {

    @RabbitListener(queues = RabbitTopicConfig.TOP)
    public void process1(RabbitParams params) {
        System.out.println(params);
//        System.out.println("接收者2  " + params);
//        System.out.println("接收者2  " + message);
    }

    @RabbitListener(queues = RabbitTopicConfig.IG)
    public void process2(RabbitParams params) {
        System.out.println("b");
        System.out.println("接收者2  " + params);
//        System.out.println("接收者2  " + message);
    }

}
