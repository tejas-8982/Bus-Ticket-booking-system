package com.login;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Login")
public class Login extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String uname = request.getParameter("uname");
		String pass = request.getParameter("pass");
		String db = "jdbc:mysql://localhost:3306/Userdata";
		String Query ="Select * from Login_Info Where uname=? and pass=?";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(db,"root","Root");
			PreparedStatement ps = con.prepareStatement(Query);
			ps.setString(1, uname);
			ps.setString(2, pass);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				response.sendRedirect("Home.jsp");
			}
			else {
				out.print("Incorrect username or password.");
				response.sendRedirect("login.jsp");
			}
			
		}catch(Exception e) {
			
		}
		
	}
}
