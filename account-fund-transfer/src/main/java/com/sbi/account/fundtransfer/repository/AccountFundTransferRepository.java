package com.sbi.account.fundtransfer.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sbi.account.fundtransfer.entity.Account;

@Repository
public interface AccountFundTransferRepository extends CrudRepository<Account, Integer>{
	
	Optional<Account> findByAccountNo(int accountNo);
	
}
