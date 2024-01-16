

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/reg")
public class Register extends HttpServlet {
	
       
    
    public Register() 
    {
       
       System.out.println("Register obj is created");
    }

	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	String name =request.getParameter("uname");
	String city =request.getParameter("ucity");
	String number =request.getParameter("unumber");
	
	
	PrintWriter writer=response.getWriter();
//	writer.println("<!DOCTYPE html>\n"
//			+ "<html>\n"
//			+ "<head>\n"
//			+ "<meta charset=\"UTF-8\">\n"
//			+ "<title>Registration</title>\n"
//			+ "</head>\n"
//			+ "<body style=\"align-content:center\">\n"
//			+ "<h1>Welcome to our app</h1>\n"
//			+ "<h2> Kindly Register to proceed further!</h2>\n"
//			+ "<form action=\"./reg\">\n"
//			+ "<table>\n"
//			+ "<tr> \n"
//			+ "<td>  User Name</td>\n"
//			+ "<td><intput type=\"text\" name=\"uname\"></td>\n"
//			+ "</tr>\n"
//			+ "<tr> \n"
//			+ "<td > User City</td>\n"
//			+ "<td><intput type=\"text\" name=\"ucity\"></td>\n"
//			+ "</tr>\n"
//			+ "<tr> \n"
//			+ "<td> User PhoneNumber</td>\n"
//			+ "<td><intput type=\"text\" name=\"unumber\"></td>\n"
//			+ "</tr>\n"
//			+ "\n"
//			+ "\n"
//			+ "</table>\n"
//			+ "<button>signup</button>\n"
//			+ "\n"
//			+ "</form>\n"
//			+ "</body>\n"
//			+ "</html>");
	writer.println("<html> <head> <title> First App </title></head>");
	writer.println("<body bgcolor='cyan'> <h1><marquee>Welcome to our dynamic app</marquee></h1></body>");
	writer.println("<table>");
	writer.println("<tr> <th> Name</th> <th> CITY </th> <th>NUMBER</th> </tr>");
	writer.println("<tr> <td> "+name+"</td> <td> "+city+"</td> <td> "+number+"</td> </tr>");	
	writer.println("</table>");
	writer.println("</html>");
	writer.close();
	
	}

} 
