<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Error Otp Page</title>
<style>
#container {
  border-radius: 20px;
  background-color:#FFA500;
  width:50%;
  height:20vh; 
  margin-left:25%;
  margin-top:3%;
  border:1px solid black;
}
#one
{
  margin-top:7%;
  margin-left:20%;
  width:80%;
  height:10%;
  //border:1px solid red;
}
</style>
</head>
<body>
<form action="" method="post">
<div id="container">
	<div id="one">
<h2> Oops you have entered wrong otp</h2>
<a href="enterotp.jsp">Enter a new otp again.</a>
</div>
</div>
</form>
</body>
</html>