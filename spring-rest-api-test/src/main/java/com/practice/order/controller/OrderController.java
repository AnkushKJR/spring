package com.practice.order.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.practice.order.controller.request.OrderInfo;

@RestController
public class OrderController {
	
	@PostMapping("/placeOrder")
	public ResponseEntity<OrderInfo> placeOrder(@RequestBody OrderInfo orderInfo) {
		System.out.println("placeOrder::::" + orderInfo.getItemName());
		return ResponseEntity.ok(orderInfo);
	}
	
}
