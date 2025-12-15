package com.zepto.order.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zepto.order.entity.Order;
import com.zepto.order.exception.InvalidOrderIdException;
import com.zepto.order.repository.OrderRepository;
import com.zepto.order.request.OrderStatusRequest;
import com.zepto.order.response.OrderStatusResponse;

@Service
public class OrderService {
	
	@Autowired
	OrderRepository orderRepository;
	
	public Optional<OrderStatusResponse> updateStatus(int order_id, OrderStatusRequest orderStatusRequest) {
		
		Optional<Order> order = orderRepository.findById(order_id);
		
			
		if(order.isPresent()) {
			order.get().setStatus(orderStatusRequest.getStatus());
			orderRepository.save(order.get());
			OrderStatusResponse orderStatusResponse = new OrderStatusResponse();
			orderStatusResponse.setMessage("Order status of " + order_id + " has been successfully changed to " + orderStatusRequest.getStatus());
			return Optional.of(orderStatusResponse);
		}else {
			throw new InvalidOrderIdException("Invalid Order Id. Please Enter Correct Order Id.");
		}
		
	}
	
}
