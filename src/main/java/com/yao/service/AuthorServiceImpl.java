package com.yao.service;

import com.yao.domain.Author;
import com.yao.domain.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

/**
 * Created by Jack Yao on 2021/6/18 10:19 下午
 */

@Service
public class AuthorServiceImpl implements AuthorService{

    @Autowired
    private AuthorRepository authorRepository;

    @Autowired

    @Override
    @Transactional
    public Author updateAuthor() {
        Author author = new Author();
        author.setPhone("1234567890");
        author.setNickName("自由自在");
        author.setSignDate(new Date());
        Author author1 = authorRepository.save(author);
        author1.setPhone("11111111234561");/*id值不為空就會變成更新而不是保存*/
        Author author2 = authorRepository.save(author1);
        return author2;
    }


}
