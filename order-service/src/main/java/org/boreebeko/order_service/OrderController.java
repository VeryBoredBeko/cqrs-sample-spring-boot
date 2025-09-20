package org.boreebeko.order_service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {

    private final CreateOrderCommandHandler commandHandler;

    @Autowired
    public OrderController(CreateOrderCommandHandler commandHandler) {
        this.commandHandler = commandHandler;
    }

    @PostMapping("/orders")
    public ResponseEntity<Void> createOrder(@RequestBody Order order) {
        commandHandler.handleCreateOrderCommand(order);
        return ResponseEntity.accepted().build();
    }
}
