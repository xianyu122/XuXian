package com.xuxian.comsumer;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "leilei")
public class Comsumer04 {

    @RabbitHandler
    public void sendMsg(String msg){
        System.out.println("leilei队列收到的消息为:"+msg);
    }

}
