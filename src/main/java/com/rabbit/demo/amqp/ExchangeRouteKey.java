package com.rabbit.demo.amqp;

public interface ExchangeRouteKey {

    /**
     * direct 模式下  交换机名称
     */
    String DIRECT_EXCHANGE_NAME = "DIRECT_EXCHANGE";
    String DIRECT_ROUTEKEY_NAME = "direct_route";


    /**
     * direct 模式下  交换机名称
     */
    String FANOUT_EXCHANGE_NAME_ONE = "fanout.penglei.net";
    String FANOUT_EXCHANGE_NAME_TWO = "fanout.souyunku.com";
    String FANOUT_ROUTEKEY_NAME_ONE = "penglei.net";
    String FANOUT_ROUTEKEY_NAME_TWO = "souyunku.com";


    String TOPIC_ROUTEKEY_NAME_ONE = "topic.top";
    String TOPIC_ROUTEKEY_NAME_TWO = "topic.ig";

}
