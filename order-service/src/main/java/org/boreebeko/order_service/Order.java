package org.boreebeko.order_service;

import java.util.List;
import java.util.UUID;

public class Order {
    private final UUID orderId;
    private final List<String> items;

    public Order(List<String> items) {
        this.orderId = UUID.randomUUID();
        this.items = items;
    }

    public UUID getOrderId() {
        return orderId;
    }

    public List<String> getItems() {
        return items;
    }
}
