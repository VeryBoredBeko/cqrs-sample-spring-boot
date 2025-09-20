package org.boreebeko.order_history_service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EventHandler {

    private final OrderHistoryRepository repository;

    @Autowired
    public EventHandler(OrderHistoryRepository repository) {
        this.repository = repository;
    }

    @PostMapping("/events/orders")
    public ResponseEntity<Void> handleOrderCreatedEvent(
            @RequestBody OrderCreatedEvent event) {

        OrderHistory order = new OrderHistory(
                event.getOrderId(), event.getItems());

        order.setDeliveryStatus("Finding a courier..");
        order.setApproximateTimeToDeliver("Calculating..");

        repository.save(order);

        return ResponseEntity.ok().build();
    }

    @PostMapping("/events/deliveries")
    public ResponseEntity<Void> handleOrderPickedUpEvent(
            @RequestBody OrderPickedUpEvent orderEvent) {

        OrderHistory orderDocument = repository
                .findById(orderEvent.orderId()).orElseThrow();

        orderDocument.setDeliveryStatus(orderEvent.deliveryStatus());
        orderDocument.setApproximateTimeToDeliver(orderEvent.approximateTimeToDeliver());

        repository.save(orderDocument);

        return ResponseEntity.ok().build();
    }
}
