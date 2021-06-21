package com.yao.service;

import com.yao.domain.Author;

/**
 * Created by Jack Yao on 2021/6/18 10:18 下午
 */
public interface AuthorService {
    Author updateAuthor();
    Author saveAuthor(Author author);
    Author updateAuthor(Author author);
    Author findAuthor(Long id);
    void deleteAuthor(Long id);
}
