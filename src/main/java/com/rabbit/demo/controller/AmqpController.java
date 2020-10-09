package com.rabbit.demo.controller;

import com.rabbit.demo.amqp.delayExchange.MessageServiceImpl;
import com.rabbit.demo.pojo.User;
import com.rabbit.demo.service.AmqpService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.websocket.server.PathParam;

@RestController
@RequestMapping("mq")
public class AmqpController {

    @Resource
    private AmqpService amqpService;

    @Resource
    private MessageServiceImpl messageServiceImpl;

    @RequestMapping("fanout")
    public void  fanout(@PathParam("rounteKey") String rounteKey){
        amqpService.fanout(rounteKey );
    }

    @RequestMapping("topic")
    public void  topic(@PathParam("rounteKey") String rounteKey){
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

    @RequestMapping("json")
    public Object json(){
        User user = new User();
        user.setName("123");
        return  user;
    }

    @RequestMapping("delay")
    public void delay(){
        messageServiceImpl.sendMsg("test_queue_1","hello i am delay msg");
    }


    @RequestMapping("dead")
    public void retryDead(){
        amqpService.retrtDead("rounteKey" );
    }
}
