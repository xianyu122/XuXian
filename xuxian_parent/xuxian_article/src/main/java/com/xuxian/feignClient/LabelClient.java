package com.xuxian.feignClient;

import com.xuxian.feignClient.impl.LabelClientImpl;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "xuxian-base",fallback = LabelClientImpl.class)
public interface LabelClient {

    @GetMapping("/label/{id}")
    public Object findById(@PathVariable("id") String id);

}
