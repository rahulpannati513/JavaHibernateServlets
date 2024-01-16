package com.rahul;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/FirstServlet")
public class FirstServlet extends HttpServlet {
	static {
		System.out.println("Servlet is loaded..");
	}
       

    public FirstServlet() {
        super();
        System.out.println("Servlet is instantiated...");
        
    }


	public void init(ServletConfig config) throws ServletException {
		System.out.println("Init is initialized or invockedn");
		
	}

	public void destroy() {
		System.out.println("At the end to close the app...");
	}

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Method is handle the request and response");
		PrintWriter writer = response.getWriter();
		writer.println("<html><head> <title> First App</title> </head>");
		writer.println("<body backgroud:'cyan'> <h1><marquee>Welcome to our first app</marquee> </h1> </body>");
		writer.println("</html>");
		writer.close();
		
	}

}
