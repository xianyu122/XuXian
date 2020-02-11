package com.xuxian.service;

import com.xuxian.bean.Spit;

import java.util.List;

public interface SpitService {

    /**
     * 查询所有
     * @return
     */
    List<Spit> findAll();

    /**
     * 根据Id查找
     * @param id
     * @return
     */
    Spit findById(String id);

    /**
     * 新增/修改
     * @param spit
     * @return
     */
    Spit add(Spit spit);

    /**
     * 删除
     * @param id
     */
    void delete(String id);
}
