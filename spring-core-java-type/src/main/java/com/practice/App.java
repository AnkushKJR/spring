package com.practice;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App 
{
    public static void main( String[] args )
    {
    	AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(ConfigJavaFile.class);
    	Employee employee = (Employee) applicationContext.getBean("employee");
    	System.out.println(employee.getId() + " " + employee.getName());
    	employee.helloMessage();
    }
}
