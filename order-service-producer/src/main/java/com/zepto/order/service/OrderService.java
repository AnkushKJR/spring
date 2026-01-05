package com.zepto.order.service;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.zepto.order.entity.Order;
import com.zepto.order.request.OrderCreateRequest;

@Service
public class OrderService {
	
	private final KafkaTemplate<String, Order> kafkaTemplate;
	
	public OrderService(KafkaTemplate<String, Order> kafkaTemplate) {
		this.kafkaTemplate = kafkaTemplate;
	}
	
	public void createOrder(OrderCreateRequest orderRequest) {
		Order order = new Order(orderRequest.getCustomerId(), orderRequest.getPaymentStatus());
		kafkaTemplate.send("orders", order.orderId() , order);
		System.out.println("Order sent to kafka:::::::::::");
	}
	
}
