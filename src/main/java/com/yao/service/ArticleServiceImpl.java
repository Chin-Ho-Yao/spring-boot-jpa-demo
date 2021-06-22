package com.yao.service;

import com.yao.domain.Article;
import com.yao.domain.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Jack Yao on 2021/6/21 10:12 下午
 */
@Service
public class ArticleServiceImpl implements ArticleService{


    @Autowired
    private ArticleRepository articleRepository;

    @Transactional
    @Override
    public Article saveArticle(Article article) {
        return articleRepository.save(article);
    }

    @Transactional
    @Override
    public Article updateArticle(Article article) {
        return articleRepository.save(article);
    }

    @Transactional
    @Override
    public Article findArticle(Long id) {
        return articleRepository.getById(id);
    }

    @Transactional
    @Override
    public void deleteArticle(Long id) {
        articleRepository.deleteById(id);
    }
}
