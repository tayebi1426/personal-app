package me.dev.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@MappedSuperclass
@EntityListeners(AuditEntityListener.class)
public abstract class AuditEntity<T extends Number>  {

    private T id;
    private User createdBy;
    private User lastModifiedBy;
    private LocalDate createdDate;
    private LocalDate lastModifiedDate;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public T getId() {
        return id;
    }

    public void setId(T id) {
        this.id = id;
    }

    @NotNull
    @ManyToOne
    public User getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(User createdBy) {
        this.createdBy = createdBy;
    }

    @NotNull
    @ManyToOne
    public User getLastModifiedBy() {
        return lastModifiedBy;
    }

    public void setLastModifiedBy(User lastModifiedBy) {
        this.lastModifiedBy = lastModifiedBy;
    }

    @NotNull
    public LocalDate getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDate createdDate) {
        this.createdDate = createdDate;
    }

    @NotNull
    public LocalDate getLastModifiedDate() {
        return lastModifiedDate;
    }

    public void setLastModifiedDate(LocalDate lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }

    @Transient
    public boolean isNew() {
        return getId() == null;
    }

}
