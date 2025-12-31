package com.sbi.account.fundtransfer.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sbi.account.fundtransfer.entity.Account;
import com.sbi.account.fundtransfer.repository.AccountFundTransferRepository;
import com.sbi.account.fundtransfer.request.AccountFundTransferRequest;
import com.sbi.account.fundtransfer.response.AccountFundTransferSuccessResponse;

import jakarta.transaction.Transactional;

@Service
public class AccountFundTransferService {

	@Autowired
	AccountFundTransferRepository accountFundTransferRepository;

	@Transactional
	public AccountFundTransferSuccessResponse fundTransfer(AccountFundTransferRequest fundTransferRequest) {

		Optional<Account> fromAccount = accountFundTransferRepository
				.findByAccountNo(fundTransferRequest.getFromAccountNo());

		if (fromAccount.isPresent()) {
			int updatedBalance = fromAccount.get().getBalance() - fundTransferRequest.getAmount();
			fromAccount.get().setBalance(updatedBalance);
		}

		accountFundTransferRepository.save(fromAccount.get());
		
//		String s = null;
//		s.length();

		Optional<Account> toAccount = accountFundTransferRepository
				.findByAccountNo(fundTransferRequest.getToAccountNo());

		if (toAccount.isPresent()) {
			int updatedBalance = toAccount.get().getBalance() + fundTransferRequest.getAmount();
			toAccount.get().setBalance(updatedBalance);
		}

		accountFundTransferRepository.save(toAccount.get());
		
		AccountFundTransferSuccessResponse successResponse = new AccountFundTransferSuccessResponse();
		successResponse.setMessage("Balance Updated Successfully...");
		
		return successResponse;

	}

}
