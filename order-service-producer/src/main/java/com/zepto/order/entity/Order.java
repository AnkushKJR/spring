package com.zepto.order.entity;

import java.util.UUID;

public record Order(String orderId, String customerId, String paymentStatus) {
	public Order(String customerId, String paymentStatus) {
        this(UUID.randomUUID().toString(), customerId, paymentStatus);
    }
}
