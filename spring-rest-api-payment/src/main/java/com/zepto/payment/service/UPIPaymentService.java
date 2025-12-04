package com.zepto.payment.service;

import java.util.Date;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zepto.payment.dao.PaymentDAOImpl;
import com.zepto.payment.entity.Payment;
import com.zepto.payment.exception.NegativeAmountException;
import com.zepto.payment.request.CreatePaymentRequest;

@Service("uPIPaymentService")
public class UPIPaymentService implements PaymentService{
	@Autowired
	PaymentDAOImpl paymentDAOImpl;
	
	@Override
	public Payment createPayment(CreatePaymentRequest createPaymentRequest) {
		System.out.println("UPIPaymentService.createPayment()");
		
		Payment payment = new Payment();
		
		payment.setPaymentId(UUID.randomUUID().toString().substring(0,10));
		payment.setOrderId(createPaymentRequest.getOrderId());
		if(createPaymentRequest.getAmount() < 0) {
			throw new NegativeAmountException("Invalid! Enter positive amount");
		}else {
			payment.setAmount(createPaymentRequest.getAmount());
		}
		payment.setCurrency(createPaymentRequest.getCurrency());
		payment.setPaymentMethod(createPaymentRequest.getPaymentMethod());
		payment.setStatus("PENDING");
		payment.setCreatedAt(new Date());
		
		paymentDAOImpl.savePayment(payment);
		
		return payment;
	}

}
