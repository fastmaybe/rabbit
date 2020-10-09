package com.rabbit.demo.service;

import com.rabbit.demo.amqp.ExchangeRouteKey;
import com.rabbit.demo.pojo.RabbitParams;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class AmqpService {

    @Resource
    private AmqpTemplate rabbitTemplate;

    public void fanout(String routeKey){
        RabbitParams params = new RabbitParams();
        params.setContent("你好");
        params.setPhone("18672793611");
        params.setName("topic");

        // 推荐使用 sendHello（） 方法写法，这种方式在 Direct Exchange 多此一举，没必要这样写
        this.rabbitTemplate.convertAndSend("fanoutExchange2", null, params);
    }

    public void retrtDead(String routeKey){
        RabbitParams params = new RabbitParams();
        params.setContent("你好");
        params.setPhone("18672793611");
        params.setName("topic");

        // 推荐使用 sendHello（） 方法写法，这种方式在 Direct Exchange 多此一举，没必要这样写
        this.rabbitTemplate.convertAndSend("exchangge_normal", "key", params);
    }



    public void topic(String routekey){
        RabbitParams params = new RabbitParams();
        params.setContent("你好");
        params.setPhone("18672793611");
        params.setName("topic");
        this.rabbitTemplate.convertAndSend("topicExchange" , routekey, params);
    }

    public void sas(){
        System.out.println();
    }

}
