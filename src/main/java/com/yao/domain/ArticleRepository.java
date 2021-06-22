package com.yao.domain;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Jack Yao on 2021/6/21 6:07 下午
 */
public interface ArticleRepository extends JpaRepository<Article, Long> {
}
