package com.StudentPortal.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Model {

	private String userName;
	private String city;
	private String country;
	private String Password;
	private Connection connect;
	private PreparedStatement pstmnt;
	private int row;
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
	
	public int register() {
		try {
			System.out.println("control is register");
			 connect = JdbcUtility.getDBConnection();
			String sql="INSERT INTO studentportal (id,username,city,country,password)" + 
			 " values(?,?,?,?,?)";
			if(connect!=null)
				pstmnt=connect.prepareStatement(sql);
			if(pstmnt!=null) {
				pstmnt.setInt(1,1 );//for first placeholder we are placing 1 id
				pstmnt.setString(2,userName );
				pstmnt.setString(3,city );
				pstmnt.setString(4,country );
				pstmnt.setString(5,Password);
				row=pstmnt.executeUpdate();
				System.out.print(row+"Checking row is in jdbc model");
				
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		catch (Exception e) {
			
			e.printStackTrace();
		}
		finally {
			ResultSet rs = null;
			try {
				JdbcUtility.closeResource(connect,pstmnt,rs);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			finally {
				try {
					JdbcUtility.closeResource(connect, pstmnt, rs);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			return row;
		}
	}
	
	
}
