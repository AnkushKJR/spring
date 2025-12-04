package com.zepto.payment.service;

import com.zepto.payment.entity.Payment;
import com.zepto.payment.request.CreatePaymentRequest;

public interface PaymentService {
	public abstract Payment createPayment(CreatePaymentRequest createPaymentRequest);
}
