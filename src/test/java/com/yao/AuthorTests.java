package com.yao;

import com.alibaba.fastjson.JSON;
import com.yao.domain.Author;
import com.yao.domain.AuthorRepository;
import com.yao.domain.WallerRepository;
import com.yao.domain.Wallet;
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

import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by Jack Yao on 2021/6/17 11:57 上午
 */
@SpringBootTest
public class AuthorTests {

    @Autowired
    private AuthorRepository authorRepository;

    @Autowired
    private WallerRepository wallerRepository;

    @Autowired
    private AuthorService authorService;

    @Test
    public void saveAuthorTest(){
        Author author = new Author();
        author.setNickName("Arvin");
        author.setPhone("1234567890");
        author.setSignDate(new Date());
        author.setWallet(new Wallet(new BigDecimal(188.23)));
        authorRepository.save(author);
    }

    @Test
    @Transactional
    public void updateAuthor(){
        Author author = authorService.findAuthor(1L);
        author.setPhone("11111111111");
        authorRepository.save(author);

    }


    @Test
    @Transactional
    public void findAuthorTest(){
        Author author = authorService.findAuthor(4L);
        System.out.println(JSON.toJSONString(author,true));
    }



    @Test
    @Transactional
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
    public void deleteAuthorTest(){
        authorService.deleteAuthor(4L);
    }

    @Test
    public void transactionalTest(){
        authorService.updateAuthor();
    }

    @Test
    public void findWalletTest(){
        Wallet wallet = wallerRepository.findById(1L).get();
        System.out.println(JSON.toJSONString(wallet,true));
    }
}
