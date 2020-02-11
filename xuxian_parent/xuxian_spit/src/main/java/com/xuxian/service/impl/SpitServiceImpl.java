package com.xuxian.service.impl;

import com.xuxian.bean.Spit;
import com.xuxian.dao.SpitDao;
import com.xuxian.service.SpitService;
import com.xuxian.utils.IdWorker;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class SpitServiceImpl implements SpitService {

    @Autowired
    private SpitDao spitDao;

    @Autowired private MongoTemplate mongoTemplate;

    @Autowired private IdWorker idWorker;

    @Override
    public List<Spit> findAll() {
        return spitDao.findAll();
    }

    @Override
    public Spit findById(String id) {
        return spitDao.findById(id).get();
    }

    @Override
    public Spit add(Spit spit) {
        if(StringUtils.isBlank(spit.getId())){
            spit.setId(idWorker.nextId()+"");
            return spitDao.save(spit);
        }else
            return spitDao.save(spit);
    }

    @Override
    public void delete(String id) {
        spitDao.deleteById(id);
    }
}
