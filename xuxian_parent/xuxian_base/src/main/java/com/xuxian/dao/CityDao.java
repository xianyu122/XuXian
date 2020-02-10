package com.xuxian.dao;

import com.xuxian.bean.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface CityDao extends JpaRepository<City,String>, JpaSpecificationExecutor<City> {
}
