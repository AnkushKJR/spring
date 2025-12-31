package com.sbi.birthday.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

	@Autowired
	JavaMailSender mailSender;

	public void sendBirthdayMail(String to, String name) {

		SimpleMailMessage mailMessage = new SimpleMailMessage();

		mailMessage.setTo(to);
		mailMessage.setSubject("Happy Birthday!");
		mailMessage.setText("Dear " + name + "\n\nHappy Birthday!\n\nRegards,\nSBI Team");

		mailSender.send(mailMessage);

		System.out.println("Hello, " + name + ", Email sent to : " + to);

	}

}
