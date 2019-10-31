<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Admin View</title>
<style>

#container {
  border-radius: 20px;
  background-color:#FFA500;
  width:95%;
  height:50vh; 
  margin-left:2%;
  margin-top:5%;
  border:1px solid black;
}
#lowerdiv
{
  height:40%;
  width:96%;
  margin-left:2%;
  margin-right:2%;
  //border:1px solid red;
}
input[type=submit]
{
  background-color:#333; 
  border: none;
  color: white; 
  
  margin-left:35%;
  padding: 5px 15px;
  text-align: center;
  text-decoration: none;
  display: inline-block;
  font-size: 16px;
  cursor: pointer;
}
table
{
	width:100%;	
}
 td
{
	overflow:hidden;
}
#link
{
	
}



</style>

</head>
<body>
<a href="home.jsp" id ="homelink">Home</a>
<div id="container">
	
	<div id="lowerdiv">
        	
		<c:forEach items="${ alladmindata }" var="ayush">
			
				<table>
				
					<tr>
					<form action="adminapprovednowsendmail.lti" method="post">
						<td>Account Number</td>
						<td>:</td>
						<td><input type="text" value="${ ayush.accno }" name="accno"></td>
						<td>Email Id</td>
						<td>:</td>
						<td><input type="text" value="${ ayush.emailid }" name="emailid" ></td>
						<td><input type="text"  name="msg" ></td>
						<td><input type="submit" id="submit" value="Submit"></td>
						<td id="link"><a href="customerdetailsforadmin.lti">View Full Details</a></td>
					</form>	
					</tr>	
					
				</table>
		</c:forEach>
		
</div>
</div>

      
</body>
</html>
