package com.zepto.order.service;

import java.util.concurrent.ExecutionException;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zepto.order.entity.Order;
import com.zepto.order.repository.OrderRepository;
import com.zepto.order.request.OrderRequest;
import com.zepto.order.response.OrderKafkaResponse;

import tools.jackson.databind.ObjectMapper;


@Service
public class OrderService {
	
	@Autowired
	OrderRepository orderRepository;
	
	@Autowired
	private KafkaProducer<String, String> producer;
	
	@Autowired
    private ObjectMapper objectMapper;
	
	public void createOrder(OrderRequest orderRequest) throws InterruptedException, ExecutionException {
		
		
		Order order = new Order();
		
		order.setCustomerId(orderRequest.getCustomerId());
		order.setProducts(orderRequest.getProducts());
		order.setPrices(orderRequest.getPrices());
		order.setTotalPrice(orderRequest.getTotalPrice());
		order.setPaymentStatus(orderRequest.getPaymentStatus());
		
		Order persistedOrder = orderRepository.save(order);
		
		Long orderId = persistedOrder.getOrderId();
		String customerId = persistedOrder.getCustomerId();
		String paymentStatus = persistedOrder.getPaymentStatus();
		
		OrderKafkaResponse kafkaResponse = new OrderKafkaResponse();
		kafkaResponse.setOrderId(orderId);
		kafkaResponse.setCustomerId(customerId);
		kafkaResponse.setPaymentStatus(paymentStatus);
		
	 	   	
		// Convert Response Object to JSON String
        String jsonValue = objectMapper.writeValueAsString(kafkaResponse);
        
        // Fix: Convert Long orderId to String to match Producer generics <String, String>
        String kafkaKey = String.valueOf(persistedOrder.getOrderId());
        
        ProducerRecord<String, String> record = 
                new ProducerRecord<>("order-events", kafkaKey, jsonValue);
		
		producer.send(record);
		System.out.println("message sent to kafka");  	
    	
    }
		
	
	
	

}
