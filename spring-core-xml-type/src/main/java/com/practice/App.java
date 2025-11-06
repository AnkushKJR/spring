package com.practice;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App 
{
    public static void main( String[] args )
    
    {
    	
    	String xmlConfig = "com\\practice\\Resources\\config.xml";
        
    	ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext(xmlConfig);
    	
    	Account account = (Account) applicationContext.getBean("acc");
    	
    	System.out.println(account.getAccountNumber() + " " + account.getAccountType() + " " + account.getIfsc() );
    	
    	
    }
}
