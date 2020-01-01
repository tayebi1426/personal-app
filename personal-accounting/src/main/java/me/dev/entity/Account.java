package me.dev.entity;

import me.dev.dto.AccountDto;

import javax.persistence.Column;
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
        this.balance = accountDto.getBalance();
    }

    public Account(String name, Integer initialBalance) {
        this.name = name;
        this.initialBalance = initialBalance;
        this.balance = initialBalance;
    }
    @Column
    @NotEmpty
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column
    @NotNull
    @Min(value = 0)
    public Integer getInitialBalance() {
        return initialBalance;
    }

    public void setInitialBalance(Integer initialBalance) {
        this.initialBalance = initialBalance;
    }

    @Column
    @NotNull
    @Min(value = 0)
    public Integer getBalance() {
        return balance;
    }

    public void setBalance(Integer balance) {
        this.balance = balance;
    }
}
