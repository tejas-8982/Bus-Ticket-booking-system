<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
welcome to home page
<%
	if(session.getAttribute("username")==null){
		response.sendRedirect("login.jsp");
	}
%>
</body>
</html>