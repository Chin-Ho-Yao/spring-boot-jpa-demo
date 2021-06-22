package com.yao.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Jack Yao on 2021/6/21 6:08 下午
 */
public interface CommentRepository extends JpaRepository<Comment,Long> {

    @Transactional
    @Modifying/*更新刪除要加*/
    @Query("delete from Comment c where c.id = ?1 ")
    void deleteBy(Long id);
}
