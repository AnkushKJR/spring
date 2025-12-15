package com.zepto.order.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.zepto.order.request.OrderStatusRequest;
import com.zepto.order.response.OrderStatusResponse;
import com.zepto.order.service.OrderService;

@RestController
public class OrderController {
	
	@Autowired
	OrderService orderService;
	
	@PatchMapping("/orders/{order_id}")
	public ResponseEntity updateOrderStatus(@PathVariable int order_id, @RequestBody OrderStatusRequest orderStatusRequest) {
		
		Optional<OrderStatusResponse> orderStatusResponse = orderService.updateStatus(order_id, orderStatusRequest);
		
		return ResponseEntity.ok(orderStatusResponse.get());
	}

}
