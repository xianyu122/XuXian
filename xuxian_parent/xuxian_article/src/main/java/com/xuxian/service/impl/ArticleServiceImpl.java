package com.xuxian.service.impl;

import com.xuxian.bean.Article;
import com.xuxian.dao.ArticleDao;
import com.xuxian.service.ArticleService;
import com.xuxian.utils.IdWorker;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.concurrent.TimeUnit;

@Service
@Transactional
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    private ArticleDao articleDao;

    @Autowired
    private IdWorker idWorker;

    @Autowired
    private RedisTemplate redisTemplate;

    @Override
    public List<Article> findAll() {
        List<Article> list  = (List<Article>) redisTemplate.opsForValue().get("article_all");
        if(list == null || list.isEmpty()){
            list = articleDao.findAll();
            redisTemplate.opsForValue().set("article_all",list,1, TimeUnit.MINUTES);
        }
        return list;
    }

    @Override
    public Article findById(String id) {
        Article article = (Article)redisTemplate.opsForValue().get("article_" + id);
        if(article == null){
            article = articleDao.findById(id).get();
            redisTemplate.opsForValue().set("article_" + id,article);
        }
        return article;
    }

    @Override
    public Article add(Article article) {
        if(StringUtils.isBlank(article.getId())){
            article.setId(idWorker.nextId()+"");
            Article save = articleDao.save(article);
            redisTemplate.opsForValue().set("article_" + save.getId(),save);
            return save;
        }else{
            Article save = articleDao.save(article);
            redisTemplate.opsForValue().set("article_" + save.getId(),save);
            return save;
        }
    }

    @Override
    public void delete(String id) {
        redisTemplate.delete("article_" + id);
        articleDao.deleteById(id);
    }

    @Override
    public boolean clickLike(String userId, String articleId) {
        boolean flag = false;
        String res = (String)redisTemplate.opsForValue().get("thumbsup_"+userId+"_"+articleId);
        if(res == null){
            articleDao.thumbsUp(articleId);
            redisTemplate.opsForValue().set("thumbsup_"+userId+"_"+articleId,"点赞成功",30,TimeUnit.SECONDS);
            flag = true;
        }
        return flag;
    }
}
