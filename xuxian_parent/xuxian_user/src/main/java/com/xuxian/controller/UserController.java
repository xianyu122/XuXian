package com.xuxian.controller;

import com.xuxian.bean.User;
import com.xuxian.entity.Result;
import com.xuxian.entity.StatusCode;
import com.xuxian.service.UserService;
import com.xuxian.utils.JwtUtil;
import io.jsonwebtoken.Claims;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RequestMapping("/user")
@RestController
@CrossOrigin
public class UserController {

    @Autowired private UserService userService;
    @Autowired private HttpServletRequest request;
    @Autowired private JwtUtil jwtUtil;

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

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable("id") String id){
//        String authToken = request.getHeader("AuthToken");
//        if(StringUtils.isBlank(authToken)){
//            return new Result(false,StatusCode.ACCESSERROR,"权限不足",null);
//        }
//        if(!authToken.startsWith("CeShi ")){
//            return new Result(false,StatusCode.ACCESSERROR,"权限不足",null);
//        }
//        String token = authToken.substring(6);
//        Claims claims = jwtUtil.parseJWT(token);
//        if(claims==null){
//            return new Result(false,StatusCode.ACCESSERROR,"权限不足",null);
//        }
//        if(!"admin".equals(claims.get("roles"))){
//            return new Result(false,StatusCode.ACCESSERROR,"权限不足",null);
//        }

        Claims claims = (Claims)request.getAttribute("admin_claims");
        if(claims == null){
            return new Result(false,StatusCode.ACCESSERROR,"权限不足",null);
        }
        userService.delete(id);
        return new Result(true,StatusCode.OK,"删除成功",null);
    }

}
