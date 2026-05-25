package com.auditoria.servico_auditor_dlq.dto;

import java.util.List;

public class OrderMessageDto {

    private String zipCode;
    private Integer customerId;
    private List<OrderItemDto> orderItems;
    private String origin;
    private String occurredAt;

    public String getZipCode() { return zipCode; }
    public void setZipCode(String zipCode) { this.zipCode = zipCode; }

    public Integer getCustomerId() { return customerId; }
    public void setCustomerId(Integer customerId) { this.customerId = customerId; }

    public List<OrderItemDto> getOrderItems() { return orderItems; }
    public void setOrderItems(List<OrderItemDto> orderItems) { this.orderItems = orderItems; }

    public String getOrigin() { return origin; }
    public void setOrigin(String origin) { this.origin = origin; }

    public String getOccurredAt() { return occurredAt; }
    public void setOccurredAt(String occurredAt) { this.occurredAt = occurredAt; }

    public static class OrderItemDto {
        private Integer sku;
        private Integer amount;

        public Integer getSku() { return sku; }
        public void setSku(Integer sku) { this.sku = sku; }

        public Integer getAmount() { return amount; }
        public void setAmount(Integer amount) { this.amount = amount; }
    }
}