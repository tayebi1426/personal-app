package me.dev.entity;

import me.dev.dto.AccountDto;

import javax.persistence.Entity;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
public class Account extends AuditEntity<Integer> {

    private String name;
    private Integer initialBalance;
    private Integer balance;

    public Account() {
    }

    public Account(AccountDto accountDto) {
        this.name = accountDto.getName();
        this.initialBalance = accountDto.getInitialBalance();
        this.balance = initialBalance;
    }

    public Account(String name, Integer initialBalance) {
        this.name = name;
        this.initialBalance = initialBalance;
        this.balance = initialBalance;
    }

    @NotEmpty
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @NotNull
    @Min(value = 0)
    public Integer getInitialBalance() {
        return initialBalance;
    }

    public void setInitialBalance(Integer initialBalance) {
        this.initialBalance = initialBalance;
    }

    @NotNull
    @Min(value = 0)
    public Integer getBalance() {
        return balance;
    }

    public void setBalance(Integer balance) {
        this.balance = balance;
    }
}
