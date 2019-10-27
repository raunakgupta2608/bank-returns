<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Admin View</title>
	</head>

    <body>
    <form action="adminapprovednowsendmail.lti" method="post">
    
		  <c:forEach items="${ alladmindata }" var="ayush">${ ayush.requestid }<br>
		  </c:forEach>

		<c:forEach items="${ alladmindata }" var="ayush">${ ayush.accno }<br>
		</c:forEach>

		<c:forEach items="${ alladmindata }" var="ayush">${ ayush.emailid }<br>
		</c:forEach>
		
		<input type="submit" value="submit">
	
    </form>         
    </body>
</html>

