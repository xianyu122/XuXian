package com.xuxian.service.impl;

import com.xuxian.bean.Admin;
import com.xuxian.dao.AdminDao;
import com.xuxian.service.AdminService;
import com.xuxian.utils.IdWorker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class AdminServiceImpl implements AdminService {

    @Autowired private AdminDao adminDao;
    @Autowired private IdWorker idWorker;
    @Autowired private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public void register(Admin admin) {
        admin.setId(idWorker.nextId()+"");
        String encode = bCryptPasswordEncoder.encode(admin.getPassword());
        admin.setPassword(encode);
        adminDao.save(admin);
    }

    @Override
    public Admin login(Admin admin) {
        Admin loginName = adminDao.getAdminByLoginName(admin.getLoginName());
        if(loginName == null){
            return null;
        }
        boolean matches = bCryptPasswordEncoder.matches(admin.getPassword(), loginName.getPassword());
        if(!matches){
            return null;
        }
        return loginName;
    }
}
