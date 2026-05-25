package com.auditoria.servico_auditor_dlq.repository;

import com.auditoria.servico_auditor_dlq.model.AuditRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuditRepository extends JpaRepository<AuditRecord, String> {
}