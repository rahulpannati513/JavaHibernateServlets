package com.StudentPortal.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.StudentPortal.model.Model;


@WebServlet("/reg")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String userName=request.getParameter("uname");
		String city=request.getParameter("city");
		String country=request.getParameter("country");
		String password=request.getParameter("password");
		String confirmPassword=request.getParameter("cpassword");
		
		if(password.equals(confirmPassword)) {
			Model model= new Model();
			model.setCity(userName);
			model.setCity(city);
			model.setCity(country);
			model.setCity(confirmPassword);
			int row = model.register();
			if(row!=0) {
				System.out.println(row+"Checking row in servlet ");
				response.sendRedirect("/MVCProject/login.html");
			}else {
				response.sendRedirect("/MVCProject/failregister.html");
			}
			
		}else {
			response.sendRedirect("/MVCProject/reregister.html");
		}
	}

}
