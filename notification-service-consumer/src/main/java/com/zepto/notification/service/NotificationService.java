package com.zepto.notification.service;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.zepto.notification.entity.Order;

@Service
public class NotificationService {

	@KafkaListener(topics = "orders", groupId = "notification-service-1")
	public void processOrders(Order order) {
		System.out.println(order.getOrderId());
		System.out.println(order.getCustomerId());
		System.out.println(order.getPaymentStatus());
		System.out.println("send email::::::::");
	}
	
}
