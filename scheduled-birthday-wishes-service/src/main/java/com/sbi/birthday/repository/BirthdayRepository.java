package com.sbi.birthday.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sbi.birthday.entity.Customer;

@Repository
public interface BirthdayRepository extends CrudRepository<Customer, Integer> {
	
	@Query("SELECT c FROM Customer c WHERE MONTH(c.dob) = :month AND DAY(c.dob) = :day")
	Optional<List<Customer>> findCustomersByBirthday(int month, int day);
	

}
