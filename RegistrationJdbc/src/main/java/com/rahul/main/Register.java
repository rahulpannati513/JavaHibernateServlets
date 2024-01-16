package com.rahul.main;

import java.io.IOException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

import com.rahul.util.JdbcUtility;


@WebServlet("/Register")
public class Register extends HttpServlet {
	private static final long serialVersionUID =1L;
	
	
protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//storing the webpage insering values to here 
		String vaccineName=request.getParameter("vname");
		String vaccineCompany=request.getParameter("vcompany");
		String cost=request.getParameter("cost");
		
		PrintWriter writer = response.getWriter(); 
		
		System.out.println(vaccineName+","+vaccineCompany+","+cost);
		//now here we need to write jdbc connection
		Connection connect=null;
		PreparedStatement pstmnt=null;
		
		ResultSet rs=null;
		//query giving
		String query = "INSERT INTO vaccines (id,vaccinename,vaccinecompany,price)+"
				+ "values(?,?,?,?)";
		//
		try {
			connect=JdbcUtility.getDBConnection();
			if(connect!=null) {
				
				pstmnt=connect.prepareStatement(query);
				pstmnt.setInt(1,14);
				pstmnt.setString(2,vaccineName);
				pstmnt.setString(3,vaccineCompany);
				pstmnt.setInt(4,Integer.parseInt(cost));
				
				int row = pstmnt.executeUpdate();
				
				writer.println("<html> <head> <title> Vaccine Registration</title></head>");

				if(row!=0) {
					
					
					writer.println("<body bgcolor='cyan'> <h1><marquee>Registration Form </marquee></h1></body>");
					
				} else {
					writer.println("<body bgcolor='cyan' > <h1> <marquee> Fail to Register </marquee> </h1> </body>");
				}
				writer.println("</html> ");
			
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
		
			try {
				JdbcUtility.closeResource(connect, pstmnt,rs );
				 if (writer != null) { // Check if writer is not null before closing
		                writer.close();
		            }
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

}
