<%@page import="com.sun.xml.bind.v2.runtime.reflect.ListIterator"%>
<%@page import="java.util.List"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

<style>
		#container
		{
			width:50%;
			height:50%;
			margin-left:25%;
			border:1px solid black;
			margin-top:10%;
		}
</style>
</head>
<body>
		<div id="container">
		<form action="transactionresult.lti" method="post">
			<table id="table">
						<tr>
							<td>Beneficiary Account Number</td>
							<td> 
									<select name="refbeneficiaryaccno" id="dropdown">
											  <c:forEach items="${ listofbeneficiary}" var="list">
											  	<option value="${ list}">${ list}</option>
		 									 </c:forEach>
									</select>
							</td>
						</tr>
						<tr>
							<td>Enter Amout to be Transfered</td>
							<td><input type ="number" name="transactionamt">${msg }</td>
						</tr>
						<tr>
							<td><input type="submit" value="Submit"></td>
						</tr>
			</table>
		</form>
				
		</div>

</body>
</html>