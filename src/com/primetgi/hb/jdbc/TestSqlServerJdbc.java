package com.primetgi.hb.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestSqlServerJdbc {

	public static void main(String[] args) {

		String jdbcDriver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
		String jdbcURL = "jdbc:sqlserver://user-229;databaseName=user229DB;user=sa;password=admin";
		try {
			System.out.println("Connecting to Database");
			
			Class.forName(jdbcDriver);
			Connection connection = DriverManager.getConnection(jdbcURL);
			
			System.out.println("Connection Successfull");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
