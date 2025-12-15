package com.zepto.invoice.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.zepto.invoice.response.ErrorResponse;

@RestControllerAdvice
public class ZeptoGlobalExceptions {
	
	@ExceptionHandler(WrongDateFormatException.class)
	public ResponseEntity<ErrorResponse> wrongDateFormat(WrongDateFormatException ex) {
		ErrorResponse errorResponse = new ErrorResponse();
		errorResponse.setStatusCode("ZPTDATEEX001");
		errorResponse.setMessage(ex.getMessage());
		return ResponseEntity.badRequest().body(errorResponse);
	}

}
