package com.yao.domain;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Jack Yao on 2021/6/17 11:45 上午
 */
/*泛型左邊就是本接口要用到的實體類，右邊是主鍵*/
public interface AuthorRepository extends JpaRepository<Author,Long> {
}
