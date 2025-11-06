package com.practice;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigJavaFile {

	@Bean("employee")
	public Employee createEmployee() {
		Employee employee = new Employee();
		employee.setId(1);
		employee.setName("Ankush");
		return employee;
	}

}
