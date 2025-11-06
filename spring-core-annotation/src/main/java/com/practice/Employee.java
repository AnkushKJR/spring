package com.practice;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Employee {
	
	@Value(value = "1")
	private int id;
	
	@Value("Ankush")
	private String name;
	
	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void helloMessage() {
		System.out.println("Hello, " + name);
	}

}
