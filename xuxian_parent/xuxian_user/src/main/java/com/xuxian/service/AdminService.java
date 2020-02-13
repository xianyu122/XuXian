package com.xuxian.service;

import com.xuxian.bean.Admin;

public interface AdminService {

    /**
     * 注册
     * @param admin
     */
    void register(Admin admin);

    /**
     * 登录
     * @param admin
     * @return
     */
    Admin login(Admin admin);
}
