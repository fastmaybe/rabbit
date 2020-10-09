package com.rabbit.demo.amqp.retrydead;

import com.rabbit.demo.amqp.fanoutExchange.RabbitFanoutConfig;
import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: liulang
 * @Date: 2020/10/9 14:14
 */

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
@Configuration
@SuppressWarnings("all")
public class RetryQueueConfig {

    //交换机
    final static String exchangge_normal = "exchangge_normal";

    final static String exchangge_failure = "exchangge_failure";

    //dui列
    final static String queue_normal = "queue_normal";
    final static String queue_failure = "queue_failure";

    //正常队列
    @Bean
    public Queue queueNormal() {
        Map<String, Object> args = new HashMap<>();
        args.put("x-dead-letter-exchange", "exchangge_failure");
        return new Queue(queue_normal,true,false,true,args);
    }

    //死信队列
    @Bean
    public Queue queueFailure() {
        return new Queue(queue_failure);
    }

    //正常交换机
    @Bean
    TopicExchange exchanggeNormal() {
        return new TopicExchange(exchangge_normal);
    }

    //死信交换机
    @Bean
    TopicExchange exchanggeFailure() {
        return new TopicExchange(exchangge_failure);
    }

    //正常交换机 绑定 正常队列
    @Bean
    Binding bindingExchangeRetryNomol(Queue queueNormal, TopicExchange exchanggeNormal) {
        return BindingBuilder.bind(queueNormal)
                .to(exchanggeNormal)
                .with("key");
    }

    //死信交换机 绑定 死信队列
    @Bean
    Binding bindingExchangeRetrtDead(Queue queueFailure, TopicExchange exchanggeFailure) {
        return BindingBuilder.bind(queueFailure)
                .to(exchanggeFailure)
                .with("key");
    }
}
