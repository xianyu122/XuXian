package com.xuxian.listener;

import com.xuxian.util.AliSendSms;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
@RabbitListener(queues = "xuxian")
public class SmsListener {

    @Autowired private AliSendSms aliSendSms;

    @Value("${aliyun.sms.signName}")
    private String signName;

    @Value("${aliyun.sms.templateCode}")
    private String templateCode;

    @RabbitHandler
    public void sendCode(Map<String,String> map){
        aliSendSms.sendMsg(map.get("mobile"),map.get("code"),signName,templateCode);
    }
}
