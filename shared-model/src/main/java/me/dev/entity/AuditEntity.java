package me.dev.entity;

import org.springframework.data.domain.Auditable;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@MappedSuperclass
@EntityListeners(AuditEntityListener.class)
public abstract class AuditEntity<PK>  {

    private PK id;
    private User createdBy;
    private User lastModifiedBy;
    private LocalDate createdDate;
    private LocalDate lastModifiedDate;

    @Id
    @GeneratedValue
    public PK getId() {
        return id;
    }

    public void setId(PK id) {
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
