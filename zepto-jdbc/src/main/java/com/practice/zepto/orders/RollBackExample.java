package com.practice.zepto.orders;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class RollBackExample {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/zepto_29_june", "root", "root@123");
		
		try {
			conn.setAutoCommit(false);
			String updateOrders = "UPDATE orders SET status=? WHERE id=? AND status = 'INIT'";
			PreparedStatement statement = conn.prepareStatement(updateOrders);
			statement.setString(1, "paid");
			statement.setInt(2, 1);
			int orderUpdateStatus = statement.executeUpdate();
			if (orderUpdateStatus == 1) {
				System.out.println(" Payment is successfull, now confirming the order....");
				//String length = null;
				String updatePayment = "UPDATE payment SET status=? WHERE id=? AND status = 'INIT'";

				PreparedStatement statementPay = conn.prepareStatement(updatePayment);
				statementPay.setString(1, "paid");
				statementPay.setInt(2, 1);
				//length.length(); //NPE
				@SuppressWarnings("unused")
				int paymentUpdateStatus = statementPay.executeUpdate();
				System.out.println(" Order placed....");
			}
			conn.commit();
		} catch (Exception e) {
			e.printStackTrace();
			conn.rollback();
			System.out.println(" Order Failed. Rollback done...");
		}
		
		
		
		
		
	}

}
