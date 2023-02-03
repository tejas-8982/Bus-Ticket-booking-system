package com.login;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Signup")
public class Signup extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("user");
		String password = request.getParameter("password");
		String email = request.getParameter("email");
		String phone = request.getParameter("mobile");
		String db = "jdbc:mysql://localhost:3306/Userdata";
		String query = "INSERT INTO Login_Info (uname,pass,email,Phone) VALUES(?,?,?,?)";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(db,"root","Root");
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1,username);
			ps.setString(2, password);
			ps.setString(3, email);
			ps.setString(4, phone);
			int rowsAffected = ps.executeUpdate();
			System.out.println(rowsAffected+"rows affected");
			if(rowsAffected>0) {
				 response.sendRedirect("Home.jsp");
			}else {
				response.sendRedirect("signup.jsp");
			}
			
		}catch(Exception e) {
			System.out.println("Error");
			e.printStackTrace();
		}
		
	}
}
