package com.xuxian.service.impl;

import com.xuxian.bean.City;
import com.xuxian.dao.CityDao;
import com.xuxian.service.CityService;
import com.xuxian.utils.IdWorker;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityServiceImpl implements CityService {

    @Autowired
    private CityDao cityDao;

    @Autowired
    private IdWorker idWorker;

    @Override
    public List<City> findAll() {
        return cityDao.findAll();
    }

    @Override
    public City findById(String id) {
        return cityDao.findById(id).get();
    }

    @Override
    public City add(City city) {
        if(StringUtils.isBlank(city.getId())){
            city.setId(idWorker.nextId()+"");
            return cityDao.save(city);
        }else
            return cityDao.save(city);
    }

    @Override
    public void delete(String id) {
        cityDao.deleteById(id);
    }
}
