package com.zepto.payment.exception;

public class EmptyOrderIdException extends RuntimeException{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public EmptyOrderIdException(String msg) {
		super(msg);
	}

}
