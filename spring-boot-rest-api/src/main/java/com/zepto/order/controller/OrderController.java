package com.zepto.order.controller;

import java.util.Arrays;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zepto.order.request.OrderRequest;

@Controller
@ResponseBody
public class OrderController {
	
	@PostMapping("/order")
	public ResponseEntity createOrder(@RequestBody OrderRequest orderRequest) {
		
		System.out.println("OrderController.createOrder()");
		System.out.println(orderRequest.getProductList());
		System.out.println(Arrays.toString(orderRequest.getPriceList()));
		System.out.println(orderRequest.getStatus());
		
		return ResponseEntity.ok("Details recieved...order under processing");
		
	}
	
}
