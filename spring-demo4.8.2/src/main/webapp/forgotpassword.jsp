<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Forgot Password</title>
<style>
#img
{
	width="150px";
	height="190px";
	font-size:125%; 
    margin-left:10;
  /*border:1px solid black; */
}
#container 
{
  border-radius: 20px;
  background-color:#FFA500;
  width:50%;
  height:60vh; 
  margin-left:25%;
  margin-top:3%;
  border:1px solid black;
}
#upperdiv
{
  margin-top:5%;
  margin-left:10%;
  width:80%;
  height:10%;
  /* border:1px solid red; */
}
#solid
{
  border-style: solid;
  box-sizing: border-box; 
  text-align: center;
  padding:10px;
  border: 2px solid black;
  font-weight:bold;
}
#lowerdiv
{
  height:80%;
  width:80%;
  margin-left:10%;
  margin-top:1%;
  /* border:1px solid red; */
}
#tab
{
  width:80%;
  height:50%;
  margin-left:10%;
  margin-top:3%;
  text-align: center;
  /* border: 2px solid green; */
}
#tab h3
{
  width:100%;
  margin-left:60%;
  /* border: 2px solid red; */
}
#tab .one
{
  padding-left:10%;
  /* border: 1px solid red; */
}
#tab .two
{
  /* border: 1px solid red; */
}
#tab .third
{
  padding-left:5%;
  /* border: 1px solid red; */
}
#tab .fourth
{
  padding-left:5%;
}
#buttondiv
{
  width:80%;
  height:20%;
  margin-left:15%;
}
input[type=submit]
{
  background-color:#333; 
  border: none;
  color: white; 
  margin-top:5%;
  margin-left:35%;
  padding: 15px 32px;
  text-align: center;
  text-decoration: none;
  display: inline-block;
  font-size: 16px;
  cursor: pointer;
}
.left
 {
  float: left;
  margin-right:10px;
  margin-left: 25px;
}
.right
{
  float: left;
  margin-left: 10px;
  margin-top: 1px;
  padding-left:3px;
}
div.row
{
  text-align: center;
}
ul
{
  list-style-type: none;
  margin: 0;
  padding: 0;
  overflow: hidden;
  background-color:#333;
}
li 
{
  float: left;
}
li a
{
  display: block;
  color: white;
  text-align: center;
  padding: 14px 16px;
  text-decoration: none;
}
li a:hover:not(.active)
{
  background-color:#ff8c1a;
}
.active 
{
  background-color:#ff8c1a;
}
</style>
</head>
<body>

  <!--form starts here-->
  <form action="enterotp.forgotpass" method="post">      
		<div id="img">
			<img src="Auroralogo.png" width="150px"height="100px"; >
			<marquee behavior="alternate" direction="left" alt="Natural">Let's make banking simpler!!</marquee>
				<table>
          <ul>
            <li><a href="home.jsp">Home</a></li>
            <li style="float:right"><a class="active" href="#logout">Logout</a></li>
          </ul>
				</table>
		</div>
<div id= "container">
	<div id="upperdiv">
    <div id="solid">Forgot Password</div><br><br>
  </div>
	<div id="lowerdiv">
			<table id="tab">
				<tr>
					<td><h3>Enter Details</h3></td>
				</tr>	
        <tr>
          <td class="one">Enter User ID</td>
          <td class="two">-</td>
          <td class="third"><input type="text" name="userid"  ></td>
        </tr>
    <!--<tr>
          <td class="one">Enter OTP</td>
          <td class="two">-</td>
          <td class="third"><input type="text" name="otp"></td>
        <tr> -->
		  </table>
    <div id="buttondiv">
        <div class="left">      
          <input type="submit" value="Proceed">
        </div>
  <!--       <div class="right"> 
          <input type="submit" onclick="login.jsp"value="Back"> 
        </div> -->
    </div> 
  </div>
</div>
</form>
</body>
</html>