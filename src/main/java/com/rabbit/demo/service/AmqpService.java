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
        String context = "此消息在，默认的交换机模式队列下，有 DirectReceiver 可以收到";

        String exchange = "fanoutExchange";

        context = "context:" + exchange + ",routeKey:" + routeKey + ",context:" + context;

        System.out.println("sendDirectTest : " + context);

        // 推荐使用 sendHello（） 方法写法，这种方式在 Direct Exchange 多此一举，没必要这样写
        this.rabbitTemplate.convertAndSend(exchange, routeKey, context);
    }


    public void topic(String routekey){
        RabbitParams params = new RabbitParams();
        params.setContent("你好");
        params.setPhone("18672793611");
        params.setName("topic");
        this.rabbitTemplate.convertAndSend("topicExchange" , ExchangeRouteKey.TOPIC_ROUTEKEY_NAME_ONE, params);
    }


}
