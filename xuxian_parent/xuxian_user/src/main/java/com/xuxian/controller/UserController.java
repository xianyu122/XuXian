package com.xuxian.controller;

import com.xuxian.bean.User;
import com.xuxian.entity.Result;
import com.xuxian.entity.StatusCode;
import com.xuxian.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/user")
@RestController
@CrossOrigin
public class UserController {

    @Autowired private UserService userService;

    @PostMapping("/{mobile}")
    public Object sendCode(@PathVariable("mobile") String mobile){

        userService.sendCode(mobile);
        return new Result(true, StatusCode.OK,"发送成功",null);
    }

    @PostMapping("/register/{code}")
    public Object register(@RequestBody User user,@PathVariable String code){

        int status = userService.addUser(user, code);
        if(status==StatusCode.CODEERROR){
            return new Result(false, StatusCode.ERROR,"验证码错误",null);
        }
        if(status == StatusCode.CODETIMEOUT){
            return new Result(false, StatusCode.ERROR,"验证码失效",null);
        }
        return new Result(true, StatusCode.OK,"注册成功",null);
    }

}
