package com.yao.service;

import com.yao.domain.Article;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Jack Yao on 2021/6/21 6:09 下午
 */
public interface ArticleService {
    Article saveArticle(Article article);
    Article updateArticle(Article article);
    Article findArticle(Long id);
    void deleteArticle(Long id);

}
