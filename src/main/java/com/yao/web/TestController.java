package com.yao.web;

import com.yao.domain.Author;
import com.yao.domain.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Jack Yao on 2021/6/18 6:24 下午
 */

@RestController
@RequestMapping("/authors")
public class TestController {

    @Autowired
    private AuthorRepository authorRepository;

    /*Pageable會根據前端傳送的數據自動封裝*/
    /*@PageableDefault()指定默認屬性質*/
    @GetMapping
    public Object findAuthorForPage(@PageableDefault(size = 5,page = 0,sort = {"id"}, direction = Sort.Direction.DESC) Pageable pageable){
        return authorRepository.findAll(pageable);
    }
}
