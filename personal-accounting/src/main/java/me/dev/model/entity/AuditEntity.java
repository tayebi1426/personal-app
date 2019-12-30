package me.dev.model.entity;

import org.springframework.data.domain.Auditable;
import org.springframework.lang.Nullable;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Transient;
import java.time.LocalDate;
import java.util.Optional;

@MappedSuperclass
public abstract class AuditEntity<PK> implements Auditable<User, Long, LocalDate> {

    private PK id;

    @Override
    @Id
    @GeneratedValue()
    public Long getId() {
        return null;
    }

    @Override
    public Optional<User> getCreatedBy() {
        return Optional.empty();
    }

    @Override
    public void setCreatedBy(User createdBy) {

    }

    @Override
    public Optional<LocalDate> getCreatedDate() {
        return Optional.empty();
    }

    @Override
    public void setCreatedDate(LocalDate creationDate) {

    }

    @Override
    public Optional<User> getLastModifiedBy() {
        return Optional.empty();
    }

    @Override
    public void setLastModifiedBy(User lastModifiedBy) {

    }

    @Override
    public Optional<LocalDate> getLastModifiedDate() {
        return Optional.empty();
    }

    @Override
    public void setLastModifiedDate(LocalDate lastModifiedDate) {

    }

    @Transient
    @Override
    public boolean isNew() {
        return getId() == null;
    }
}
