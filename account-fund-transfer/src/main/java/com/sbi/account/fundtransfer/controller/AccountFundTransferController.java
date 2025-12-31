package com.sbi.account.fundtransfer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sbi.account.fundtransfer.exception.InvalidAmountException;
import com.sbi.account.fundtransfer.request.AccountFundTransferRequest;
import com.sbi.account.fundtransfer.response.AccountFundTransferSuccessResponse;
import com.sbi.account.fundtransfer.service.AccountFundTransferService;

@RestController
public class AccountFundTransferController {
	
	@Autowired
	AccountFundTransferService accountFundTransferService;
	
	//POST is for actions or creating resources
	//PATCH is for partial updates to a specific resource
	@PostMapping("/accounts/fundtransfer")
	public ResponseEntity accountFundTransfer(@RequestBody AccountFundTransferRequest fundTransferRequest) {
		
		if(!(fundTransferRequest.getAmount() <= 0)) {
			AccountFundTransferSuccessResponse successResponse = accountFundTransferService.fundTransfer(fundTransferRequest);
			return ResponseEntity.ok(successResponse);
		}else {
			throw new InvalidAmountException("Invalid Amount! Amount shouble be greater than 0");
		}
		
	}

}
