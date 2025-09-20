package org.boreebeko.order_history_service;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface OrderHistoryDAO extends MongoRepository<OrderHistory, UUID> {
}
