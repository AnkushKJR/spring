package com.sbi.birthday;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class ScheduledBirthdayWishesServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ScheduledBirthdayWishesServiceApplication.class, args);
	}

}
