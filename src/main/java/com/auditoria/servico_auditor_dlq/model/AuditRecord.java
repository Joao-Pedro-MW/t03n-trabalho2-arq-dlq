package com.auditoria.servico_auditor_dlq.model;

import jakarta.persistence.*;
import java.time.Instant;

@Entity
@Table(name = "audit_records")
public class AuditRecord {

    @Id
    private String errorId;
    private String queueName;

    @Column(columnDefinition = "TEXT")
    private String payload;
    private String origin;
    private Instant timestamp;
    private String status;
    private String severity;

    public String getErrorId() { return errorId; }
    public void setErrorId(String errorId) { this.errorId = errorId; }

    public String getOrigin() { return origin; }
    public void setOrigin(String origin) { this.origin = origin; }

    public String getQueueName() { return queueName; }
    public void setQueueName(String queueName) { this.queueName = queueName; }

    public String getPayload() { return payload; }
    public void setPayload(String payload) { this.payload = payload; }

    public Instant getTimestamp() { return timestamp; }
    public void setTimestamp(Instant timestamp) { this.timestamp = timestamp; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public String getSeverity() { return severity; }
    public void setSeverity(String severity) { this.severity = severity; }
}