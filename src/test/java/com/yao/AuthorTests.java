package com.yao;

import com.alibaba.fastjson.JSON;
import com.yao.domain.Author;
import com.yao.domain.AuthorRepository;
import com.yao.service.AuthorService;
import com.yao.service.AuthorServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

/**
 * Created by Jack Yao on 2021/6/17 11:57 上午
 */
@SpringBootTest
public class AuthorTests {

    @Autowired
    private AuthorRepository authorRepository;

    @Autowired
    private AuthorService authorService;

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
//        int i = authorRepository.setNickName("小龍女","1234567898");

//        System.out.println(JSON.toJSONString(authors, true));

    }

    @Test
    public void findAuthorForPageTest(){
        /*排序*/
        Sort sort = Sort.by(Sort.Direction.DESC,"id");
        /*左邊為頁數，默認0。右邊為一頁幾條默認10*/
        /*今天对一个就得项目进行重新整理，发现提示Pageable (int, int) 提示已经过时，
        替代的方法是不要new PageRequest，而是直接用 PageRequest.of这个方法 根据你的需求选择入参*/
        Pageable pageable = PageRequest.of(1,5,sort);
        Page<Author> page = authorRepository.findAll(pageable);
        System.out.println(JSON.toJSONString(page,true));
    }

    @Test
    public void transactionalTest(){
        authorService.updateAuthor();
    }
}
