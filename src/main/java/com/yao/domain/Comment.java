package com.yao.domain;

import org.springframework.data.repository.cdi.Eager;

import javax.persistence.*;

/**
 * Created by Jack Yao on 2021/6/21 5:52 下午
 */
@Entity
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String content;

    @ManyToOne
    private Article article;

    /*用來清除關係*/
    public void clearComment(){
        this.getArticle().getComments().remove(this);
    }

    public Comment() {
    }

    public Comment(String content) {
        this.content = content;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Article getArticle() {
        return article;
    }

    public void setArticle(Article article) {
        this.article = article;
    }
}
