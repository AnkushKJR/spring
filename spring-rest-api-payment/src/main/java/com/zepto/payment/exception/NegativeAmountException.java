package com.zepto.payment.exception;

public class NegativeAmountException extends RuntimeException{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public NegativeAmountException(String msg) {
		super(msg);
	}
	
}
