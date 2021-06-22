package com.yao;

import com.alibaba.fastjson.JSON;
import com.yao.domain.*;
import com.yao.service.ArticleService;
import com.yao.service.AuthorService;
import com.yao.service.CommentService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.Date;
import java.util.concurrent.Callable;

/**
 * Created by Jack Yao on 2021/6/17 11:57 上午
 */

@SpringBootTest
public class CommentTests {


    @Autowired
    private CommentService commentService;

    @Autowired
    private ArticleService articleService;

    @Test
    public void saveComment(){
        Article article = articleService.findArticle(1L);
        Comment comment = new Comment();
        comment.setContent("關於互聯網思維.........");
        comment.setArticle(article);

        commentService.saveComment(comment);
    }

    @Test
    @Transactional
    public void deleteComment(){
        commentService.deleteComment(10L);
    }
}
