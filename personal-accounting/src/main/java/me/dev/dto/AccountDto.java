package me.dev.dto;

import me.dev.entity.Account;

public class AccountDto {

    private String name;
    private Integer balance;

    public AccountDto() {
    }

    public AccountDto(Account account) {
        this.name = account.getName();
        this.balance = account.getBalance();
    }

    public AccountDto(String name, Integer balance) {
        this.name = name;
        this.balance = balance;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getBalance() {
        return balance;
    }

    public void setBalance(Integer balance) {
        this.balance = balance;
    }
}
