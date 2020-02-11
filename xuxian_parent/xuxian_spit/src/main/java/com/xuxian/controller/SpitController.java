package com.xuxian.controller;

import com.xuxian.bean.Spit;
import com.xuxian.entity.Result;
import com.xuxian.entity.StatusCode;
import com.xuxian.service.SpitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/spit")
public class SpitController {

    @Autowired
    private SpitService spitService;

    @GetMapping
    public Object findAll(){
        return new Result(true, StatusCode.OK,"查询成功",spitService.findAll());
    }

    @GetMapping("/{id}")
    public Object findById(@PathVariable("id") String id){
        return new Result(true, StatusCode.OK,"查询成功",spitService.findById(id));
    }

    @PutMapping
    public Object update(@RequestBody Spit spit){
        return new Result(true, StatusCode.OK,"修改成功",spitService.add(spit));
    }

    @PostMapping
    public Object add(@RequestBody Spit spit){
        return new Result(true, StatusCode.OK,"添加成功",spitService.add(spit));
    }

    @DeleteMapping("/{id}")
    public Object delete(@PathVariable("id") String id){
        spitService.delete(id);
        return new Result(true, StatusCode.OK,"删除成功",null);
    }

}
