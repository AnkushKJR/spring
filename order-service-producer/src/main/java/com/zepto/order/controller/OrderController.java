package com.zepto.order.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.zepto.order.request.OrderCreateRequest;
import com.zepto.order.service.OrderService;

@RestController
public class OrderController {
	
	@Autowired
	OrderService orderService;
	
	@PostMapping("/orders")
	public void order(@RequestBody OrderCreateRequest orderCreateRequest) {
		orderService.createOrder(orderCreateRequest);
	}
	
}
