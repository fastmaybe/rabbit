package com.rabbit.demo.amqp.fanoutExchange;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitFanoutConfig {

    final static String PENGLEI = "fanout.penglei.net";

    final static String SOUYUNKU = "fanout.souyunku.com";
    @Bean
    public Queue queuePenglei() {
        return new Queue(RabbitFanoutConfig.PENGLEI);
    }

    @Bean
    public Queue queueSouyunku() {
        return new Queue(RabbitFanoutConfig.SOUYUNKU);
    }

    /**
     * 任何发送到Fanout Exchange的消息都会被转发到与该Exchange绑定(Binding)的所有队列上。
     */
    @Bean
    FanoutExchange fanoutExchange() {
        return new FanoutExchange("fanoutExchange");
    }

    @Bean
    FanoutExchange fanoutExchange2() {
        return new FanoutExchange("fanoutExchange2");
    }

    @Bean
    Binding bindingExchangeQueuePenglei(Queue queuePenglei, FanoutExchange fanoutExchange) {
        return BindingBuilder.bind(queuePenglei).to(fanoutExchange);
    }

    @Bean
    Binding bindingExchangeQueueSouyunku(Queue queueSouyunku, FanoutExchange fanoutExchange2) {
        return BindingBuilder.bind(queueSouyunku).to(fanoutExchange2);
    }

}
