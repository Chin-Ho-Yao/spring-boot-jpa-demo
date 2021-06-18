package com.yao.domain;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Jack Yao on 2021/6/17 11:45 上午
 */
/*泛型左邊就是本接口要用到的實體類，右邊是主鍵*/
public interface AuthorRepository extends JpaRepository<Author,Long> {

    List<Author> findByPhoneAndNickName(String phone, String nickName);

    List<Author> findDistinctByNickNameIgnoreCaseOrPhoneOrderBySignDateDesc(String nickName, String phone);

    @Query("select a from Author a where a.phone like %:phone%")
    List<Author> findByPhone(@Param("phone") String phone);
    @Query("select a.nickName,length(a.nickName) from Author a where a.nickName like %?1%")
    List<Object[]> findArry(String nickName);
    @Query("select a from Author a where a.nickName like ?1%")
    List<Author> findByNickName(String nickName,Sort signDate);

    /*sql語句查詢，就不用別名了*/
    @Query(value = "select * from author where nick_name like %?1%", nativeQuery = true)
    List<Author> findbySql(String nickName);

    /*update 需要加上@Modifying才會識別這個操作，而且更新刪除都要加上@Transactional*/
    @Transactional
    @Modifying
    @Query("update Author a set a.nickName = ?1 where a.phone = ?2")
    int setNickName(String nickName,String phone);



}
