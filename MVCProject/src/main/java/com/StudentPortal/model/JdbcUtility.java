package com.StudentPortal.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JdbcUtility
{
	static {
		try {
			
			// load and register the driver
				Class.forName("com.mysql.cj.jdbc.Driver");
				
		}
		catch(ClassNotFoundException e) {
			e.printStackTrace();
			
		}
		System.out.println("Driver is registered");
		
	}
	public static Connection getDBConnection() throws SQLException {
		
		String url="jdbc:mysql://localhost:3306/studentDB";
		String username="root";
		String password="Rahul@123";
		//this is the method giving me the connection obj 
		
		
		
			return DriverManager.getConnection(url, username, password);
		
		
		
	}
	public static void closeResource(Connection connect, PreparedStatement stmt, ResultSet rs) throws SQLException {
	   
		if (rs != null) {
	        rs.close();
	    }
	    if (stmt != null) {
	        stmt.close(); // Close the Statement
	    }
	    if (connect != null) {
	        connect.close();
	    }
	}

	

}
