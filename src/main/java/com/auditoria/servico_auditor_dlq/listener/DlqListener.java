package com.auditoria.servico_auditor_dlq.listener;

import com.auditoria.servico_auditor_dlq.dto.OrderMessageDto;
import com.auditoria.servico_auditor_dlq.service.AuditService;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.awspring.cloud.sqs.annotation.SqsListener;
import org.springframework.stereotype.Component;

@Component
public class DlqListener {

    private final AuditService auditService;
    private final ObjectMapper objectMapper;

    public DlqListener(AuditService auditService, ObjectMapper objectMapper) {
        this.auditService = auditService;
        this.objectMapper = objectMapper;
    }

    @SqsListener("${app.dlq.name}")
    public void receive(String rawMessage) {
        try {
            System.out.println("📨 Mensagem recebida da DLQ: " + rawMessage);
            OrderMessageDto order = objectMapper.readValue(rawMessage, OrderMessageDto.class);
            auditService.processAndSave(order, rawMessage);
        } catch (Exception e) {
            System.err.println(" Erro: " + e.getMessage());
            throw new RuntimeException(e);
        }
    }
}