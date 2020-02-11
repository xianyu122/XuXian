package com.xuxian.controller;

import com.xuxian.bean.Article;
import com.xuxian.entity.Result;
import com.xuxian.entity.StatusCode;
import com.xuxian.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/article")
@CrossOrigin
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    @GetMapping
    public Object findAll(){
        List<Article> list = articleService.findAll();
        return new Result(true, StatusCode.OK,"查询成功",list);
    }

    @GetMapping("/{id}")
    public Object findById(@PathVariable("id") String id){
        return new Result(true, StatusCode.OK,"查询成功",articleService.findById(id));
    }

    @PutMapping
    public Object update(@RequestBody Article article){
        return new Result(true, StatusCode.OK,"修改成功",articleService.add(article));
    }

    @PostMapping
    public Object add(@RequestBody Article article){
        return new Result(true, StatusCode.OK,"添加成功",articleService.add(article));
    }

    @DeleteMapping("/{id}")
    public Object delete(@PathVariable("id") String id){
        articleService.delete(id);
        return new Result(true, StatusCode.OK,"删除成功",null);
    }

    @PutMapping("/{uId}/{aId}")
    public Object clickLike(@PathVariable("uId") String uId,
                            @PathVariable("aId") String aId){
        boolean flag = articleService.clickLike(uId, aId);
        if(flag){
            return new Result(true, StatusCode.OK,"点赞成功",null);
        }
        return new Result(false, StatusCode.ERROR,"重复点赞",null);
    }
}
