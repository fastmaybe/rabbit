package com.rabbit.demo.amqp.topicExchange;

import com.rabbit.demo.pojo.RabbitParams;
import com.rabbitmq.client.Channel;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class TopicReceiverOne {

    private static int num=3;

    @RabbitListener(queues = RabbitTopicConfig.IG)
    public void process1(RabbitParams params, Message message, Channel channel) {
//        System.out.println(params);
        System.out.println("接收者1  " + params);
//        System.out.println("接收者2  " + message);
    }

    @RabbitListener(queues = RabbitTopicConfig.IG)
    public void process2(RabbitParams params, Message message, Channel channel) {
        try {
            System.out.println(num);
            num-=1;
            int a=10/num;
            System.out.println("接收者2  " + params);

        } catch (Exception e) {
            try {
                //  当  num=0; 发生异常  重新入队列  立马就被监听消费。
                channel.basicNack(message.getMessageProperties().getDeliveryTag(), false, true);
            } catch (IOException e1) {
                e1.printStackTrace();
            }
            e.printStackTrace();
        }
//        System.out.println("接收者2  " + message);
    }

}
