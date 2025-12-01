package com.zepto.search.exception;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.zepto.search.response.ErrorResponse;

@RestControllerAdvice
public class ZeptoExceptions {
	
	@ExceptionHandler(ProductNotFound.class)
	public ResponseEntity productNotFound(ProductNotFound ex) {
		ErrorResponse errorResponse = new ErrorResponse();
		errorResponse.setErrorCode("zpt-001");
		errorResponse.setMsg(ex.getMessage());
		return ResponseEntity.ok(errorResponse);
	}
	

}
