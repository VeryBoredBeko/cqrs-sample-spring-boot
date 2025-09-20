package org.boreebeko.order_history_service;

import java.util.UUID;

public record OrderPickedUpEvent (UUID orderId,
                                  String deliveryStatus,
                                  String approximateTimeToDeliver) {
}
