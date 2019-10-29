<%@page import="com.sun.xml.bind.v2.runtime.reflect.ListIterator"%>
<%@page import="java.util.List"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style>
	#container
	{
		width:50%;
		height:50%;
		margin-left:25%;
		background-color:#FFA500; 
		margin-top:2%;
	}
	#successtext
	{
		text-align:center;
		font-weight:bold;
		line-height":10%;
	}
	#linkfordashboard
	{
		float:right;
		margin-right:10px;
		list-style-type:none;
	}
	form
	{
		//border:1px solid red;
		width:24%;
		height:40%;
		margin-left:40%;
	}
	#submit
	{
		background-color:#333;
		width:100px;
		color:white;
		margin-left:40%;
		margin-top:5%;
	}
	#tid
	{
		float:left;
		margin-top:20px;
	}
	a
	{
		text-decoration:none;
	}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Transaction Result</title>
</head>
<body>

	<%
        	response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); //HTTP 1.1
        	response.setHeader("Pragma", "no-cache"); //HTTP 1.0
        	response.setHeader("Expires", "0");
        	
        	if(session.getAttribute("userid")==null)
        	{
        		response.sendRedirect("userlogin.jsp");
        	}
        %>	
		<div id="successtext">Transaction Successful !!!</div>
		<div id ="linkfordashboard"><a href="dashboard.jsp">Click here to return to dashboard</a></div>
		
		
		<form action="transactiondetails.lti" method="post">
			<div id ="tid">Enter Transaction Id :<input type="number" name="tid"></div>
			<input type="submit" value="submit" id="submit">
		</form>
		
		
	<div id="container">
		<table>
			<tr>
				<td>Transaction Id </td>
				<td>:</td>
				<td>${ transactionid }</td>
			</tr>
			<tr>
				<td>Beneficiary Account Number </td>
				<td>:</td>
				<td>${ beneficiaryaccno }</td>
			</tr>
			<tr>
				<td>Balance before Transaction was</td>
				<td>:</td>
				<td>${ balance }</td>
			</tr>
			<tr>
				<td>Transaction Amount</td>
				<td>:</td>
				<td>${ transactionamount }</td>
			</tr>
			<tr>
				<td>Available Balance</td>
				<td>:</td>
				<td>${ availablebalance }</td>
			</tr>
		</table>
	</div>
</body>
</html>