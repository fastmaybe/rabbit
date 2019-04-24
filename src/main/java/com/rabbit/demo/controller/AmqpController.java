package com.rabbit.demo.controller;

import com.rabbit.demo.service.AmqpService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("mq")
public class AmqpController {

    @Resource
    private AmqpService amqpService;

    @RequestMapping("fanout")
    public void  fanout(String rounteKey){
        amqpService.fanout(rounteKey );
    }

    @RequestMapping("topic")
    public void  topic(String rounteKey){
        amqpService.topic(rounteKey );
    }


}
