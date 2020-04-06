package me.dev.dto;

public class AccountDto {

    private String name;
    private Integer initialBalance;
    private Integer balance;

    public AccountDto() {
    }

    public AccountDto(String name, Integer initBalance) {
        this.name=name;
        this.initialBalance=initBalance;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getInitialBalance() {
        return initialBalance;
    }

    public void setInitialBalance(Integer initialBalance) {
        this.initialBalance = initialBalance;
    }

    public Integer getBalance() {
        return balance;
    }

    public void setBalance(Integer balance) {
        this.balance = balance;
    }
}
