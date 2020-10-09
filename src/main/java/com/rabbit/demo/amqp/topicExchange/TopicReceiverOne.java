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

//    @RabbitListener(queues = RabbitTopicConfig.IG)
    public void process1(RabbitParams params, Message message, Channel channel) {
//        System.out.println(params);
        System.out.println("接收者1  " + params);
//        System.out.println("接收者2  " + message);
    }

    @RabbitListener(queues = RabbitTopicConfig.IG)
    public void process2(RabbitParams params, Message message, Channel channel) throws IOException {
        try {
            num-=1;
            System.out.println(num);
            int a=10/0;
            System.out.println("接收者2  " + params);
            channel.basicAck(message.getMessageProperties().getDeliveryTag(),true);
        } catch (Exception e) {
            System.out.println("error");
//            try {
                //  当  num=0; 发生异常  重新入队列  立马就被监听消费。
                /**
                 * 当在yml 配置了 重试机制后 这里重新入队就不要配置了 新入队后 又会重试  导致无限先死循环
                 */
//                channel.basicNack(message.getMessageProperties().getDeliveryTag(), false, true);
//            } catch (IOException e1) {
//                System.out.println("1111111111");
//                e1.printStackTrace();
//            }
            System.out.println("消息丢弃了.................."+params);
            throw e;
        }
//        System.out.println("接收者2  " + message);
    }

}
