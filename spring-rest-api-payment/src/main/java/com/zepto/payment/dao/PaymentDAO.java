package com.zepto.payment.dao;

import com.zepto.payment.entity.Payment;

public interface PaymentDAO {
	public abstract void savePayment(Payment payment);
}
