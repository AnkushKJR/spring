package com.zepto.payment.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.zepto.payment.response.ErrorResponse;

@RestControllerAdvice
public class ZeptoExceptionHandler{
	
	@ExceptionHandler(EmptyOrderIdException.class)
	public ResponseEntity emptyOrder(EmptyOrderIdException ex) {
		ErrorResponse errorResponse = new ErrorResponse();
		errorResponse.setStatus("ZPTEMP0987");
		errorResponse.setMsg(ex.getMessage());
		return ResponseEntity.badRequest().body(errorResponse);
	}
	
	@ExceptionHandler(NegativeAmountException.class)
	public ResponseEntity negativeAmount(NegativeAmountException ex) {
		ErrorResponse errorResponse = new ErrorResponse();
		errorResponse.setStatus("ZPTNEGAMT10");
		errorResponse.setMsg(ex.getMessage());
		return ResponseEntity.badRequest().body(errorResponse);
	}
	
}
