package com.practice;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App 
{
    public static void main( String[] args )
    {
        
    	//AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(Config.class);
    	AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext("\\com\\practice");
    	Employee employee = applicationContext.getBean(Employee.class);   	 	
    	System.out.println(employee.getId() + " " + employee.getName());
    	employee.helloMessage();
    	
    }
}
