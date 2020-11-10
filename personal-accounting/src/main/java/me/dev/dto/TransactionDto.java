package me.dev.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.validation.constraints.NotNull;
import java.util.Date;

public class TransactionDto {

    private Integer id;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date transactionDate;
    private Integer transactionAmount;
    private String description;
    private Integer accountId;
    private Byte TransactionTypeId;

    public TransactionDto() {
    }

    public TransactionDto(Integer id) {
        setId(id);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    //@NotNull
    //@JsonSerialize(using = DateSerializer.class)
    //@JsonDeserialize(using = DateDeserializers.DateDeserializer.class)
    public Date getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(Date transactionDate) {
        this.transactionDate = transactionDate;
    }

    @NotNull
    public Integer getTransactionAmount() {
        return transactionAmount;
    }

    public void setTransactionAmount(Integer transactionAmount) {
        this.transactionAmount = transactionAmount;
    }

    @NotNull
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @NotNull
    public Integer getAccountId() {
        return accountId;
    }

    public void setAccountId(Integer accountId) {
        this.accountId = accountId;
    }

    @NotNull
    public Byte getTransactionTypeId() {
        return TransactionTypeId;
    }

    public void setTransactionTypeId(Byte transactionTypeId) {
        TransactionTypeId = transactionTypeId;
    }
}
