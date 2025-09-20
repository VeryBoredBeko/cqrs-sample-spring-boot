package org.boreebeko.order_service;

import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CreateOrderCommandHandler {

    private final static String orderHistoryServiceURI =
            "http://localhost:8082/events/orders";

    // Метод был сильно упрощен для демонстрационных целей
    public void handleCreateOrderCommand(Order order) {
        // Тут должна была быть логика хранения агрегата в БД,
        // но мы скрыли эту деталь

        // В полноценном CQRS метод публикации так не вызывается,
        // а используются готовые CDC-решения, которые следят за изменениями в БД
        publishOrderCreatedEvent(order);
    }

    // В полноценном CQRS мы должны публиковать события с помощью
    // событийных шин (event bus)
    // можно использовать Kafka, RabbitMQ и т.д.
    private void publishOrderCreatedEvent(Order order) {
        // Публикуем событие

        // Используется HTTP-протокол,
        // но помните в CQRS для доставки событий используются
        // протоколы наподобие AMQP
        RestTemplate httpClient = new RestTemplate();

        HttpEntity<Order> requestBody =
                new HttpEntity<>(order);

        // Мы не будем обрабатывать ответ от сервиса
        httpClient
                .postForEntity(orderHistoryServiceURI, requestBody, Void.class);
    }
}
