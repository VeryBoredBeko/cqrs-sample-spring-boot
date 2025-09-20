package org.boreebeko.order_history_service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class OrderHistoryQuery {

    private final OrderHistoryDAO repository;

    @Autowired
    public OrderHistoryQuery(OrderHistoryDAO repository) {
        this.repository = repository;
    }

    @GetMapping("/orders")
    public ResponseEntity<List<OrderHistory>> findOrderHistory() {
        return new ResponseEntity<>(repository.findAll(), HttpStatus.OK);
    }
}
