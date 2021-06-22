package com.yao;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.yao.domain.*;
import com.yao.service.ArticleService;
import com.yao.service.AuthorService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Jack Yao on 2021/6/17 11:57 上午
 */
@SpringBootTest
public class ArticleTests {

    @Autowired
    private ArticleService articleService;

    @Test
    public void saveArticle(){
        Article article = new Article();
//        article.setId(1L);   id通常都自動生成
        article.setTitle("關於創業");
        article.setContent("關於創業的一些想法.....");
        /*還要加上comment*/
//        List<Comment> comments = new ArrayList<>();       /*改用addComment()*/
        Comment comment1 = new Comment("評論內容1");
//        comment1.setArticle(article);/*指定comment關聯的article這樣保存才會把關聯設置進去才會有外鍵*/
        Comment comment2 = new Comment("評論內容2");
        article.addComment(comment1);       /*改成這樣就不用setArticle()了*/
        article.addComment(comment2);
//        comments.add(comment1);                          /*改用addComment()*/
//        comments.add(comment2);                          /*改用addComment()*/
//        article.setComment(comments);                    /*改用addComment()*/
        articleService.saveArticle(article);
    }

    @Test
    @Transactional
    public void updateArticle(){
        /*改內容就好，級聯不用改*/
        Article article = articleService.findArticle(2L);
        article.setContent("猶記得一些所見所聞");
        articleService.saveArticle(article);
        System.out.println(JSON.toJSONString(article.getContent(),true));
    }

    @Test
    @Transactional
    public void findArticle(){
        Article article = articleService.findArticle(2L);
        /*只有這樣執行會拋錯，因為打印json會調用article，但拿list又沒調用get方法所以報出錯誤*/
        /*所以在article默認不會顯示，因為是lazy只有在get的時候才會顯示*/
        /*這邊就是沒有get請求的情況下因為是lazy所以無法輸出*/
        System.out.println(JSON.toJSONString(article,true));
        /*把comment一起查詢出來*/
    }

    @Test
    @Transactional
    public void deleteArticle(){
        articleService.findArticle(2L);
        articleService.deleteArticle(2L);

    }

}
