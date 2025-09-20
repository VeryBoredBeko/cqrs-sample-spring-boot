package org.boreebeko.order_history_service;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Document("OrderHistory")
public class OrderHistory {

    @Id
    private UUID orderId;

    private List<String> items;
    private final LocalDateTime processedAt = LocalDateTime.now();

    private String deliveryStatus;
    private String approximateTimeToDeliver;

    public OrderHistory(UUID orderId, List<String> items) {
        this.orderId = orderId;
        this.items = items;
    }

    public UUID getOrderId() {
        return orderId;
    }

    public String getDeliveryStatus() {
        return deliveryStatus;
    }

    public void setDeliveryStatus(String deliveryStatus) {
        this.deliveryStatus = deliveryStatus;
    }

    public String getApproximateTimeToDeliver() {
        return approximateTimeToDeliver;
    }

    public void setApproximateTimeToDeliver(String approximateTimeToDeliver) {
        this.approximateTimeToDeliver = approximateTimeToDeliver;
    }

    public void setOrderId(UUID orderId) {
        this.orderId = orderId;
    }

    public List<String> getItems() {
        return items;
    }

    public void setItems(List<String> items) {
        this.items = items;
    }
}
