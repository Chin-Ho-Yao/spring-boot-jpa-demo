package com.yao;

import com.yao.domain.Author;
import com.yao.domain.AuthorRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

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
}
