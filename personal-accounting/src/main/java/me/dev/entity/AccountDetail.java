package me.dev.entity;

import javax.persistence.*;

@Entity
public class AccountDetail {
    private Integer id;
    private Account account;


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @OneToOne
    @PrimaryKeyJoinColumn
    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }
}
