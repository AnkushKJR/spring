package com.practice.zepto.orders;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PreparedStatement {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/zepto_29_june", "root", "root@123");
		
		String query = "SELECT * FROM orders WHERE price > ? AND status = ?";
		java.sql.PreparedStatement pS = con.prepareStatement(query);
		
		pS.setInt(1, 60000);
		pS.setString(2, "paid");
		
		ResultSet res = pS.executeQuery();
		
		 
		
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
