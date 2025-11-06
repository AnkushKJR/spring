package com.practice.zepto.orders;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class App 
{
    public static void main( String[] args ) throws ClassNotFoundException, SQLException
    {
        // Load Driver, creates instance and registers it with Driver Manager
    	// Not required now, SPI automatically does it
    	Class.forName("com.mysql.cj.jdbc.Driver");
    	
    	// establish connection
    	Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/zepto_29_june", "root", "root@123");
    	
    	// create statement
    	Statement stmt = connection.createStatement();
    	
    	// execute query
    	String readQuery = "SELECT * FROM orders";
    	
    	ResultSet res = stmt.executeQuery(readQuery);
    	
    	while(res.next()) {
    		String name = res.getString(1);
    		String desc = res.getString(2);
    		int price = res.getInt(3);
    		String status = res.getString(4);
    		System.out.println("name: " + name);
    		System.out.println("desc: " + desc);
    		System.out.println("price: " + price);
    		System.out.println("status: " + status);
    	}
    	
    }
}
