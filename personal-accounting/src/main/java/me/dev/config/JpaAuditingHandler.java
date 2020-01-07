package me.dev.config;

import org.springframework.data.auditing.AuditingHandler;
import org.springframework.data.mapping.context.PersistentEntities;

public class JpaAuditingHandler extends AuditingHandler {

    public JpaAuditingHandler(PersistentEntities entities) {
        super(entities);
    }
}
