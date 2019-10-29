<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Logout</title>
</head>
<body>
<div style="margin:left:25%"> You have logged out successfully!!</div>
		<%
			session.removeAttribute("userid");
			session.invalidate();
			response.sendRedirect("userlogin.jsp");
		%>

</body>
</html>