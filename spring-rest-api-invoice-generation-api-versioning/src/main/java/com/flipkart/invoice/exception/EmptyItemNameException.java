package com.flipkart.invoice.exception;

public class EmptyItemNameException extends RuntimeException{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public EmptyItemNameException(String msg) {
        super(msg);
    }
}
