package com.xuxian.service;

import com.xuxian.bean.Label;

import java.util.List;

public interface LabelService {

    /**
     * 查询所有
     * @return
     */
    List<Label> findAll();

    /**
     * 根据Id查找
     * @param id
     * @return
     */
    Label findById(String id);

    /**
     * 新增
     * @param label
     * @return
     */
    Label add(Label label);

//    /**
//     * 修改
//     * @param label
//     * @return
//     */
//    Label update(Label label);

    /**
     * 删除
     * @param id
     */
    void delete(String id);
}
