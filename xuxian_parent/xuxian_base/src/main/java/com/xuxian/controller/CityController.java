package com.xuxian.controller;


import com.xuxian.bean.City;
import com.xuxian.entity.Result;
import com.xuxian.entity.StatusCode;
import com.xuxian.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/city")
@CrossOrigin
public class CityController {

    @Autowired
    private CityService cityService;

    @GetMapping
    public Object findAll(){
        return new Result(true, StatusCode.OK,"查询成功",cityService.findAll());
    }

    @GetMapping("/{id}")
    public Object findById(@PathVariable String id){
        return new Result(true, StatusCode.OK,"查询成功",cityService.findById(id));
    }

    @PostMapping
    public Object add(@RequestBody City city){
        return new Result(true, StatusCode.OK,"添加成功",cityService.add(city));
    }

    @PutMapping
    public Object update(@RequestBody City city){
        return new Result(true, StatusCode.OK,"修改成功",cityService.add(city));
    }

    @DeleteMapping("/{id}")
    public Object delete(@PathVariable("id") String id){
        cityService.delete(id);
        return new Result(true, StatusCode.OK,"删除成功",null);
    }
}
