package com.sbi.account.fundtransfer.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.sbi.account.fundtransfer.response.AccountFundTransferErrorResponse;

@RestControllerAdvice
public class AccountFundTransferGlobalException {
	
	@ExceptionHandler(InvalidAmountException.class)
	public ResponseEntity<AccountFundTransferErrorResponse> invalidAmountException(InvalidAmountException ex) {
		
		AccountFundTransferErrorResponse errorResponse = new AccountFundTransferErrorResponse();
		
		errorResponse.setStatusCode("SBIINAMT001");
		errorResponse.setMessage(ex.getMessage());
		
		return ResponseEntity.badRequest().body(errorResponse);
	}
	
}
