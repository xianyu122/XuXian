package com.xuxian.service;

import com.xuxian.bean.Article;

import java.util.List;

public interface ArticleService {

    /**
     * 查询所有
     * @return
     */
    List<Article> findAll();

    /**
     * 根据Id查找
     * @param id
     * @return
     */
    Article findById(String id);

    /**
     * 新增/修改
     * @param article
     * @return
     */
    Article add(Article article);

    /**
     * 删除
     * @param id
     */
    void delete(String id);

    /**
     * 点赞
     * @param userId 用户Id
     * @param articleId 文章id
     * @return
     */
    boolean clickLike(String userId,String articleId);

}
