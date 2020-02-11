package com.xuxian.dao;

import com.xuxian.bean.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface ArticleDao extends JpaRepository<Article,String>, JpaSpecificationExecutor<Article> {

    // 点赞
    @Modifying
    @Query(value = "update tb_article set thumbs_up = thumbs_up + 1 where id = ?1" ,nativeQuery = true)
    public void thumbsUp(String id);

}
