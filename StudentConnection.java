package com.jspider.jdbc_prepared_curd_architecture.connection;

import java.sql.Connection;

import java.sql.DriverManager;

import com.mysql.cj.jdbc.Driver;

public class StudentConnection {
	
	public static Connection getStudentConnection() {
		try {
			
			Driver d = new Driver();
			DriverManager.registerDriver(d);
			
			String url = "jdbc:mysql://localhost:3307/prince";
			String user = "root";
			String pass = "prince";
			
			return DriverManager.getConnection(url, user, pass);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
