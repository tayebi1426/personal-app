package me.dev.entity;


import org.hibernate.annotations.Immutable;

import javax.persistence.Entity;

@Entity
@Immutable
public class TransactionType extends ImmutableEntity<Byte>{

    private String code;
    private String title;

    public TransactionType(Byte id) {
        setId(id);
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
