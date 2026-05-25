package com.auditoria.servico_auditor_dlq.service;

import com.auditoria.servico_auditor_dlq.dto.OrderMessageDto;
import com.auditoria.servico_auditor_dlq.model.AuditRecord;
import com.auditoria.servico_auditor_dlq.repository.AuditRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.UUID;

@Service
public class AuditService {

    private final AuditRepository auditRepository;


    public AuditService(AuditRepository auditRepository) {
        this.auditRepository = auditRepository;
    }

    public void processAndSave(OrderMessageDto order, String rawPayload) {
        int totalItems = calcularTotalItens(order);
        String severity = calcularSeveridade(totalItems);

        AuditRecord record = new AuditRecord();
        record.setErrorId(UUID.randomUUID().toString());
        record.setQueueName(record.getOrigin());
        record.setPayload(rawPayload);
        record.setTimestamp(Instant.now());
        record.setStatus("PENDING_ANALYSIS");
        record.setSeverity(severity);

        auditRepository.save(record);

        System.out.println(" Registro salvo! Severidade: " + severity);
    }

    private int calcularTotalItens(OrderMessageDto order) {
        if (order.getOrderItems() == null) return 0;
        return order.getOrderItems().stream()
                .mapToInt(item -> item.getAmount() != null ? item.getAmount() : 0)
                .sum();
    }

    private String calcularSeveridade(int total) {
        if (total > 100) return "HIGH";
        if (total >= 50) return "MEDIUM";
        return "LOW";
    }
}