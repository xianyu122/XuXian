package com.xuxian.controller;

import com.xuxian.bean.Admin;
import com.xuxian.entity.Result;
import com.xuxian.entity.StatusCode;
import com.xuxian.service.AdminService;
import com.xuxian.utils.JwtUtil;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@CrossOrigin
@RequestMapping("/admin")
public class AdminController {

    @Autowired private AdminService adminService;
    @Autowired private JwtUtil jwtUtil;

    @PostMapping("/register")
    public Result register(@RequestBody Admin admin){
        adminService.register(admin);
        return new Result(true, StatusCode.OK,"注册成功",null);
    }

    @PostMapping("/login")
    public Result login(@RequestBody Admin admin){
        Admin login = adminService.login(admin);
        if(login == null){
            return new Result(false, StatusCode.LOGINERROR,"账号或密码错误",null);
        }
        String token = jwtUtil.createJWT(login.getId(), login.getLoginName(), "admin");
        Map<String,String> map = new HashMap<>();
        map.put("token",token);
        map.put("name",login.getLoginName());
        return new Result(true, StatusCode.OK,"登录成功",map);
    }

}
