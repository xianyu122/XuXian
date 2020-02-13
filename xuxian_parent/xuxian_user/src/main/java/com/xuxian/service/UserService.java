package com.xuxian.service;

import com.xuxian.bean.User;

public interface UserService {

    void sendCode(String mobile);

    int addUser(User user,String code);
}
