package com.yao;

import com.alibaba.fastjson.JSON;
import com.yao.domain.Author;
import com.yao.domain.AuthorRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Sort;

import java.util.Date;
import java.util.List;

/**
 * Created by Jack Yao on 2021/6/17 11:57 上午
 */
@SpringBootTest
public class AuthorTests {

    @Autowired
    private AuthorRepository authorRepository;

    @Test
    public void saveAuthorTest(){
        Author author = new Author();
        author.setNickName("Arvin");
        author.setPhone("1234567890");
        author.setSignDate(new Date());
        authorRepository.save(author);
    }
    @Test
    public void findAuthorTest(){
//        List<Author> authors = authorRepository.findByPhoneAndNickName("1234567890","Arvin");
//        List<Author> authors = authorRepository.findDistinctByNickNameIgnoreCaseOrPhoneOrderBySignDateDesc("Arvin","1234567890");
//        List<Author> authors = authorRepository.findByNickName("楊", Sort.by(Sort.Direction.ASC,"signDate"));

//        List<Author> authors = authorRepository.findbySql("楊");
        int i = authorRepository.setNickName("小龍女","1234567898");

//        System.out.println(JSON.toJSONString(authors, true));

    }
}
