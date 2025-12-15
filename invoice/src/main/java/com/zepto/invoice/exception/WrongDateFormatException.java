package com.zepto.invoice.exception;

public class WrongDateFormatException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public WrongDateFormatException(String message) {
		super(message);
	}

}
