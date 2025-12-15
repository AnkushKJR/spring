package com.zepto.order.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.zepto.order.response.OrderStatusErrorResponse;

@RestControllerAdvice
public class ZeptoGlobalExceptions {
	
	@ExceptionHandler(InvalidOrderIdException.class)
	public ResponseEntity<OrderStatusErrorResponse> invalidOrderId(InvalidOrderIdException ex){
		
		OrderStatusErrorResponse errorResponse = new OrderStatusErrorResponse();
		
		errorResponse.setStatusCode("ZEPINVORDID002");
		errorResponse.setMessage(ex.getMessage());
		
		return ResponseEntity.badRequest().body(errorResponse);
	}

}
