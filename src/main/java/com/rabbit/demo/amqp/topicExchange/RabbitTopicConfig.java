package com.rabbit.demo.amqp.topicExchange;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitTopicConfig {

    final static String TOP = "topic.top";

    final static String IG = "topic.ig";
    @Bean
    public Queue queueTop() {
        return new Queue(RabbitTopicConfig.TOP);
    }

    @Bean
    public Queue queueIg() {
        return new Queue(RabbitTopicConfig.IG);
    }

    /**
     * 任何发送到Fanout Exchange的消息都会被转发到与该Exchange绑定(Binding)的所有队列上。
     */
    @Bean
    TopicExchange topicExchange() {
        return new TopicExchange("topicExchange");
    }

    @Bean
    Binding bindingExchangeTOP(Queue queueTop, TopicExchange topicExchange) {
        System.out.println(queueTop);
        return BindingBuilder.bind(queueTop)
                .to(topicExchange)
                .with("topic.top");
    }

    @Bean
    Binding bindingExchangeAll(Queue queueIg, TopicExchange topicExchange) {
        return BindingBuilder.bind(queueIg)
                .to(topicExchange)
                .with("topic.#");
    }

}
