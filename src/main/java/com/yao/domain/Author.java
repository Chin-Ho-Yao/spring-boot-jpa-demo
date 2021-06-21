package com.yao.domain;

import org.hibernate.annotations.GeneratorType;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Jack Yao on 2021/6/17 11:39 上午
 */
@Entity/*數據模型類，不加就不會創建表*/

public class Author {

    @Id/*主鍵*/
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nickName;
    private String phone;
    @Temporal(TemporalType.DATE)
    private Date signDate;

    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE}, optional = false ,fetch = FetchType.EAGER)
    @JoinColumn(name = "author_wallet_id",referencedColumnName = "balance")/*指定外鍵鍵；指定被關聯的名稱**/
    private Wallet wallet;

    /*空的建構子一定要有不然會有問題*/
    public Author() {
    }

    public Wallet getWallet() {
        return wallet;
    }

    public void setWallet(Wallet wallet) {
        this.wallet = wallet;
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
