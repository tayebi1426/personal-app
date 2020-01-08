package me.dev.entity;

import me.dev.dto.CustomUserDetails;
import org.springframework.security.core.context.SecurityContextHolder;

import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import java.time.LocalDate;

public class AuditEntityListener {

    @PrePersist
    public void touchForCreate(AuditEntity entity) {
        entity.setCreatedBy(getCurrentUser());
        entity.setCreatedDate(LocalDate.now());
        touchForUpdate(entity);
    }

    @PreUpdate
    public void touchForUpdate(AuditEntity entity) {
        entity.setLastModifiedBy(getCurrentUser());
        entity.setLastModifiedDate(LocalDate.now());
    }

    private User getCurrentUser() {
        CustomUserDetails principal = (CustomUserDetails)
                SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User currentUser = new User();
        currentUser.setId(principal.getId());
        return currentUser;
    }
}
