package com.zepto.password.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.zepto.password.response.ErrorResponse;

@RestControllerAdvice
public class ZeptoExceptionHandler {
	
	@ExceptionHandler(RecentPasswordUsedException.class)
	public ResponseEntity RecentPasswordUsed(RecentPasswordUsedException ex) {
		ErrorResponse errorResponse = new ErrorResponse();
		errorResponse.setStatus("ZEP01RECPASS");
		errorResponse.setMessage(ex.getMessage());
		return ResponseEntity.ok(errorResponse);
	}

}
