package org.boreebeko.order_history_service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class QueryHandler {

    private final OrderHistoryRepository repository;

    @Autowired
    public QueryHandler(OrderHistoryRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/orders")
    public ResponseEntity<List<OrderHistory>> getOrdersHistory() {
        return new ResponseEntity<>(repository.findAll(), HttpStatus.OK);
    }
}
