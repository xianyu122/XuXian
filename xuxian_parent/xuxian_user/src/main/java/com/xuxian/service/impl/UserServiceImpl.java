package com.xuxian.service.impl;

import com.xuxian.bean.User;
import com.xuxian.dao.UserDao;
import com.xuxian.entity.StatusCode;
import com.xuxian.service.UserService;
import com.xuxian.utils.IdWorker;
import com.xuxian.utils.IdentifyUtil;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired private IdWorker idWorker;

    @Autowired private UserDao userDao;

    @Autowired private RedisTemplate redisTemplate;

    @Autowired private RabbitTemplate rabbitTemplate;

    @Override
    public void sendCode(String mobile) {
        String code = IdentifyUtil.randomStr();
        System.out.println("手机号:"+mobile+"验证码为:"+code);
        redisTemplate.opsForValue().set("smscode_"+mobile,code,1, TimeUnit.MINUTES);
        Map<String,String> map = new HashMap<>();
        map.put("mobile",mobile);
        map.put("code",code);
        rabbitTemplate.convertAndSend("xuxian",map);
    }

    @Override
    public int addUser(User user, String code) {
        String codeRedis = (String)redisTemplate.opsForValue().get("smscode_"+user.getMobile());
        if(codeRedis == null){
            return StatusCode.CODETIMEOUT;
        }
        if(!codeRedis.equals(code)){
            return StatusCode.CODEERROR;
        }
        user.setId(idWorker.nextId()+"");
        userDao.save(user);
        return StatusCode.OK;
    }
}
