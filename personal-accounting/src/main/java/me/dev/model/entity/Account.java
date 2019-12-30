package me.dev.model.entity;

import javax.persistence.Entity;

@Entity
public class Account extends AuditEntity<Integer> {

    private String name;
    private Integer balanceAmount;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getBalanceAmount() {
        return balanceAmount;
    }

    public void setBalanceAmount(Integer balanceAmount) {
        this.balanceAmount = balanceAmount;
    }
}
