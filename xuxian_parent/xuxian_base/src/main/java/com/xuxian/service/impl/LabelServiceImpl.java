package com.xuxian.service.impl;

import com.xuxian.bean.Label;
import com.xuxian.dao.LabelDao;
import com.xuxian.service.LabelService;
import com.xuxian.utils.IdWorker;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LabelServiceImpl implements LabelService {


    @Autowired
    private LabelDao labelDao;

    @Autowired
    private IdWorker idWorker;

    @Override
    public List<Label> findAll() {
        return labelDao.findAll();
    }

    @Override
    public Label findById(String id) {
        return labelDao.findById(id).get();
    }

    @Override
    public Label add(Label label) {
        if(StringUtils.isBlank(label.getId())){
            label.setId(idWorker.nextId()+"");
            return labelDao.save(label);
        }else
            return labelDao.save(label);
    }

//    @Override
//    public Label update(Label label) {
//        return null;
//    }

    @Override
    public void delete(String id) {
        labelDao.deleteById(id);
    }
}
