package com.primetgi.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestMySqlJdbc {

	public static void main(String[] args) {
		String jdbcUrl = "jdbc:mysql://localhost:3306/hb_student_tracker?useSSL=false";
		String user = "hbstudent";
		String password = "hbstudent";
		try {
			System.out.println("Connecting to Database: " + jdbcUrl);
			Connection connection = DriverManager.getConnection(jdbcUrl, user, password);
			System.out.println("Connection Successfull");
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
