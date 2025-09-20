package org.boreebeko.order_history_service;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public class OrderCreatedEvent {

    private final UUID orderId;
    private final List<String> items;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private final LocalDateTime createdAt;

    public OrderCreatedEvent(UUID orderId, List<String> items) {
        this.orderId = orderId;
        this.items = items;
        this.createdAt = LocalDateTime.now();
    }

    public UUID getOrderId() {
        return orderId;
    }

    public List<String> getItems() {
        return items;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
}
