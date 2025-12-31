package com.sbi.birthday.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.mail.SimpleMailMessage;
//import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.sbi.birthday.entity.Customer;
import com.sbi.birthday.repository.BirthdayRepository;

@Service
public class BirthdayService {
	
//	@Autowired
//	JavaMailSender mailSender;
	
	@Autowired
	BirthdayRepository birthdayRepository;
	
	@Autowired
	EmailService emailService;
	
	
	@Scheduled(cron = "0 50 17 * * ?")
	public void getCustomersByDOB() {
		
		LocalDate today = LocalDate.now();
		int month = today.getMonthValue();
		int day = today.getDayOfMonth();
		
		Optional<List<Customer>> customers = birthdayRepository.findCustomersByBirthday(month, day);
		
		for(Customer c : customers.get()) {
			emailService.sendBirthdayMail(c.getEmailId(), c.getFirstName());
		}
		
	}

}
