package com.xuxian.feignClient.impl;

import com.xuxian.entity.Result;
import com.xuxian.entity.StatusCode;
import com.xuxian.feignClient.LabelClient;
import org.springframework.stereotype.Component;

@Component
public class LabelClientImpl implements LabelClient {
    @Override
    public Object findById(String id) {
        return new Result(false, StatusCode.ERROR,"服务器炸了",null);
    }
}
