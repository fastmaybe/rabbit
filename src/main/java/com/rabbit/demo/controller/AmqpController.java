package com.rabbit.demo.controller;

import com.rabbit.demo.service.AmqpService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

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
    @GetMapping("test")
    public void map(HttpServletRequest request){
        System.out.println(request.getParameter("latitude"));
        System.out.println(request.getParameter("appstate"));
        System.out.println(request.getParameter("phone"));
        System.out.println(request.getParameter("userId"));
        System.out.println(request.getParameter("longitude"));
    }
    @RequestMapping("test2")
    public void map(String phone,String uid){
        System.out.println(phone);
        System.out.println(uid);
    }

}
