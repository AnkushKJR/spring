package com.practice.zepto.orders;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Arrays;

public class Batching {

public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/zepto_29_june", "root", "root@123");
		
		String insertBulkRecords = "INSERT INTO orders (name, description, price, status) VALUES (?, ?, ?, ?)";
		java.sql.PreparedStatement pS = con.prepareStatement(insertBulkRecords);
		
		con.setAutoCommit(false);
		
		for(int i=1;i<=10;i++) {
			pS.setString(1, "iphone "+i);
			pS.setString(2, "description " + i);
			pS.setInt(3, 85);
			pS.setString(4, "on the way " + i);
			pS.addBatch();
		}
		
		int[] updateInfo = pS.executeBatch();
		System.out.println(Arrays.toString(updateInfo));
		con.commit();
		
		 
		
		
	}


}
