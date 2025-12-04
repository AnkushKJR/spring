package com.zepto.password.exception;

public class RecentPasswordUsedException extends RuntimeException{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public RecentPasswordUsedException(String msg) {
		super(msg);
	}
	
}
