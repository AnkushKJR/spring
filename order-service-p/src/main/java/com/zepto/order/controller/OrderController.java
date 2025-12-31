package com.zepto.order.controller;

import java.util.concurrent.ExecutionException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.zepto.order.request.OrderRequest;
import com.zepto.order.service.OrderService;

@RestController
public class OrderController {
	
	@Autowired
	OrderService orderService;
	
	@PostMapping("/orders")
	public void createOrder(@RequestBody OrderRequest orderRequest) throws InterruptedException, ExecutionException {
		orderService.createOrder(orderRequest);
		System.out.println("OrderController.createOrder()::::");
	}
	

}
