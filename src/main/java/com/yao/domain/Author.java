package com.yao.domain;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Jack Yao on 2021/6/17 11:39 上午
 */
@Entity/*數據模型類，不加就不會創建表*/
public class Author {

    @Id/*主鍵*/
    @GeneratedValue/*自動生成規則*/
    private Long id;
    private String nickName;
    private String phone;
    @Temporal(TemporalType.DATE)
    private Date signDate;

    /*空的建構子一定要有不然會有問題*/
    public Author() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Date getSignDate() {
        return signDate;
    }

    public void setSignDate(Date signDate) {
        this.signDate = signDate;
    }

}
