package com.xuxian.controller;

import com.xuxian.bean.Label;
import com.xuxian.entity.Result;
import com.xuxian.entity.StatusCode;
import com.xuxian.service.LabelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/label")
@CrossOrigin
public class LabelController {

    @Autowired
    private LabelService labelService;

    @GetMapping
    public Object findAll(){
        try {
            List<Label> labelList = labelService.findAll();
            return new Result(true, StatusCode.OK,"查询成功",labelList);
        }catch (Exception e){
            return new Result(false, StatusCode.ERROR,"查询失败",e.getMessage());
        }

    }

    @GetMapping("/{id}")
    public Object findById(@PathVariable("id") String id){
        try {
            Label byId = labelService.findById(id);
            return new Result(true,StatusCode.OK,"查询成功",byId);
        }catch (Exception e){
            return new Result(false, StatusCode.ERROR,"查询失败",e.getMessage());
        }

    }

    @PostMapping
    public Object add(@RequestBody Label label){
        try {
            Label add = labelService.add(label);
            return new Result(true,StatusCode.OK,"添加成功",add);
        }catch (Exception e){
            return new Result(false, StatusCode.ERROR,"添加失败",e.getMessage());
        }

    }

    @PutMapping
    public Object update(@RequestBody Label label){
        try {
            Label add = labelService.add(label);
            return new Result(true,StatusCode.OK,"修改成功",add);
        }catch (Exception e){
            return new Result(false, StatusCode.ERROR,"修改失败",e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public Object delete(@PathVariable("id") String id){
        try {
            labelService.delete(id);
            return new Result(true,StatusCode.OK,"删除成功",null);
        }catch (Exception e){
            return new Result(false, StatusCode.ERROR,"删除成功",e.getMessage());
        }
    }
}
