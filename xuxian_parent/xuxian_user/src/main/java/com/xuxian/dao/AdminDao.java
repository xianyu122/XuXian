package com.xuxian.dao;

import com.xuxian.bean.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface AdminDao extends JpaRepository<Admin,String>, JpaSpecificationExecutor<Admin> {

    /**
     * 根据用户名获取用户admin
     * @param loginName
     * @return
     */
    Admin getAdminByLoginName(String loginName);
}
