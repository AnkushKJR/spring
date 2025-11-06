package com.practice.zepto.orders;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CSVInsert {

	public static void main(String[] args) throws ClassNotFoundException, SQLException, IOException {

		Class.forName("com.mysql.cj.jdbc.Driver");

		String filepath = "C:\\Users\\akanj\\Desktop\\KODEWALA\\Resources\\csv-files\\employee_data.csv";
		int batchSize = 20;

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee_db", "root", "root@123");
		conn.setAutoCommit(false);

		String query = "INSERT INTO employee (id, name, address, salary) VALUES (?, ?, ?, ?);";

		PreparedStatement statement = conn.prepareStatement(query);

		BufferedReader bf = new BufferedReader(new FileReader(filepath));

		// --- ADD THIS LINE TO SKIP THE HEADER ---
		bf.readLine();
		// --- --------------------------------- ---

		String lineText = null;
		int count = 0;

		while ((lineText = bf.readLine()) != null) {
			String[] data = lineText.split(",");
			String id = data[0];
			String name = data[1];
			String address = data[2];
			String salary = data[3];

			statement.setInt(1, Integer.parseInt(id));
			statement.setString(2, name);
			statement.setString(3, address);
			statement.setInt(4, Integer.parseInt(salary));
			statement.addBatch();

			count++; // Increment count inside the loop
			if (count % batchSize == 0) {
				statement.executeBatch();
			}
		}

		bf.close();
		statement.executeBatch(); // Execute any remaining statements
		conn.commit();
//        conn.close();
	}
}
