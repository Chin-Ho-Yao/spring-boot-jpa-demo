package com.yao.service;

import com.yao.domain.Comment;

/**
 * Created by Jack Yao on 2021/6/22 11:48 上午
 */
public interface CommentService {
    Comment saveComment(Comment comment);
    void deleteComment(Long id);
}
