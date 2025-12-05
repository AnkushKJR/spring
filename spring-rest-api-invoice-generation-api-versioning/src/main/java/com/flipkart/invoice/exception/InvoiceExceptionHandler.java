package com.flipkart.invoice.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.flipkart.invoice.response.ErrorResponse;

@RestControllerAdvice
public class InvoiceExceptionHandler {
	
	@ExceptionHandler(InvalidPriceException.class)
	public ResponseEntity invalidName(InvalidPriceException ex) {
		ErrorResponse errorResponse = new ErrorResponse();
		errorResponse.setStatus("FPT001INVP");
		errorResponse.setMessage(ex.getMessage());
		return ResponseEntity.badRequest().body(errorResponse);
	}
	
	@ExceptionHandler(EmptyItemNameException.class)
    public ResponseEntity emptyName(EmptyItemNameException ex) {
        ErrorResponse err = new ErrorResponse();
        err.setStatus("FPT002EMPN");
        err.setMessage(ex.getMessage());
        return ResponseEntity.badRequest().body(err);
    }

}
