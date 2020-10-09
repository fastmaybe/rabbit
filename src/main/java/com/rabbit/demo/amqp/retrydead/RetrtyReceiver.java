package com.rabbit.demo.amqp.retrydead;

import com.rabbit.demo.amqp.delayExchange.QueueConfig;
import com.rabbit.demo.amqp.fanoutExchange.RabbitFanoutConfig;
import com.rabbit.demo.pojo.RabbitParams;
import com.rabbitmq.client.Channel;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * 重试机制 以及 重试后失败 将消息加入死信队列
 * 可以再监听死信队列  对失败信息 进行人工补偿等措施
 *
 * 1 配置文件开启重试机制
 * spring.rabbitmq.listener.simple.retry.enabled=true
 * #spring.rabbitmq.listener.simple.retry.max-attempts=3
 * #spring.rabbitmq.listener.simple.retry.initial-interval=4000
 * #spring.rabbitmq.listener.simple.retry.max-interval=8000
 * spring.rabbitmq.listener.simple.acknowledge-mode=auto
 * #重试次数超过上面的设置之后是否丢弃（false不丢弃时需要写相应代码将该消息加入死信队列）
 * spring.rabbitmq.listener.simple.default-requeue-rejected=false
 *
 * 2 RetryQueueConfig 两组交换机 两组队列
 *
 *
 * //
 */
@Component
public class RetrtyReceiver {


    @RabbitListener(queues = RetryQueueConfig.queue_normal)
    public void process(RabbitParams params, Message message, Channel channel) {

        System.out.println("正常业务逻辑," + params);

        int a= 10/0;
    }


}
