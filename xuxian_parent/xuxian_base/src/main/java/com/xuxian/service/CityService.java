package com.xuxian.service;


import com.xuxian.bean.City;

import java.util.List;

public interface CityService {

    /**
     * 查询所有
     * @return
     */
    List<City> findAll();

    /**
     * 根据Id查找
     * @param id
     * @return
     */
    City findById(String id);

    /**
     * 新增
     * @param city
     * @return
     */
    City add(City city);

//    /**
//     * 修改
//     * @param city
//     * @return
//     */
//    City update(City city);

    /**
     * 删除
     * @param id
     */
    void delete(String id);

}
