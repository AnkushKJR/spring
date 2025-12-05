package com.flipkart.invoice.exception;

public class InvalidPriceException extends RuntimeException{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public InvalidPriceException(String msg) {
        super(msg);
    }
}
