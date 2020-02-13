package com.xuxian.rabbitmqtest;

import com.xuxian.RabbitmqApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest(classes = RabbitmqApplication.class)
@RunWith(SpringRunner.class)
public class RabbitmqTest {

    @Autowired private RabbitTemplate rabbitTemplate;

    @Test
    public void test1(){
        rabbitTemplate.convertAndSend("xianyu","测试3！！！");
    }

    @Test
    public void test2(){
        rabbitTemplate.convertAndSend("family","","郁郁是只猪!!");
    }

    @Test
    public void test3(){
        rabbitTemplate.convertAndSend("familytopic","yuyu.xxx","郁郁是只猪!!");
    }

    @Test
    public void test4(){
        rabbitTemplate.convertAndSend("familytopic","xxx.zzz.haohao","豪豪是只猪!!");
    }

    @Test
    public void test5(){
        rabbitTemplate.convertAndSend("familytopic","yuyu.haohao","磊磊是只猪!!");
    }
}
