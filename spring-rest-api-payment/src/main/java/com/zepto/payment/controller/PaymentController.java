package com.zepto.payment.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zepto.payment.entity.Payment;
import com.zepto.payment.exception.EmptyOrderIdException;
import com.zepto.payment.request.CreatePaymentRequest;
import com.zepto.payment.service.PaymentService;

@Controller
public class PaymentController {
	
	
	@Autowired
	Map<String, PaymentService> paymentServiceMap;
	
	@PostMapping("/createPayment")
	@ResponseBody
	public ResponseEntity createPayment(@RequestBody CreatePaymentRequest createPaymentRequest) {
		System.out.println("PaymentController.createPayment()");
		
		if(createPaymentRequest.getOrderId().isEmpty()) {
			throw new EmptyOrderIdException("Empty order Id found");
		}else {
			PaymentService paymentService = paymentServiceMap.get(createPaymentRequest.getPaymentMethod());
			
			Payment payment = paymentService.createPayment(createPaymentRequest);
			
			return ResponseEntity.ok(payment);
		}
		
	}

}
