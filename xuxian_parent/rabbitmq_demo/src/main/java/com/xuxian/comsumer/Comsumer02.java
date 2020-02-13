package com.xuxian.comsumer;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "yuyu")
public class Comsumer02 {

    @RabbitHandler
    public void sendMsg(String msg){
        System.out.println("yuyu队列收到的消息为:"+msg);
    }

}
