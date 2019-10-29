<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head> 
<meta charset="ISO-8859-1">
<title>Enter account number</title>
<style>
#img
        {
          width="150px";
          height="190px";
          font-size:125%; 
          margin-left:10;
          //border:1px solid black;
        }
	#container {
	  border-radius: 20px;
	  background-color:#FFA500;
	  width:50%;
	  height:70vh; 
	  margin-left:25%;
	  margin-top:5%;
	  border:1px solid black;
	}
	#upperdiv
	{
	  margin-top:5%;
	  margin-left:10%;
	  width:80%;
	  height:10%;
	  //border:1px solid red;
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
	  margin-top:8%;
/* 	  border:1px solid red; */
	  
	}
	#tab
	{
	  width:80%;
	  height:50%;
	  margin-left:10%;
	  margin-top:5%;
	  //border: 2px solid green;
	}
	#tab h3
	{
	  width:100%;
	  margin-left:60%;
	 // border: 2px solid red;
	}
	#tab .one
	{
	  padding-left:10%;
	  //border: 1px solid red;
	}
	#tab .two
	{
	  //border: 1px solid red;
	}
	#tab .third
	{
	  padding-left:5%;
	  //border: 1px solid red;
	}
	#tab .fourth
	{
	padding-left:5%;
	}
	#chechbox
	{
	  width:80%;
	  margin-left:10%;
	  padding-top:7%;
	  //border: 1px solid red;
	}
	#buttondiv
{
  width:80%;
  height:15%;
  margin-left:10%;
  //border: 1px solid purple;
}
.button {
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
	div.row{
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
<form action="enterotp.forgotuser" method="post">
<div id="img">
<img src="Auroralogo.png" width="150px"height="100px">
<marquee behavior="alternate" direction="left" alt="Natural">Let's make banking simpler!!</marquee>
<table>
<ul>
  <li><a href="home.jsp">Home</a></li>
<!--   <li style="float:right"><a class="active" href="logout.jsp">Logout</a></li> -->
</ul>
</table>
</div>
	<div id="container">
	  <div id="upperdiv">
	      <div id="solid">CHECK ACCOUNT NUMBER</div><br><br>
	  </div>
	  <div id="lowerdiv">
	  		<table id="tab">
	          <tr>
	            <td class="one">Enter Account Number</td>
	            <td class="two">-</td>
	            <td class="third"><input type="text" name ="accno" required ></td>
	            <td class="fourth"><span id="msgg"></span></td>
	          </tr>
	      	</table>
	      <div id="buttondiv">
	           <input type="submit" class="button" id="submit" value="Submit" required> 
	      </div>
	  </div>
	</div>
	</form>
</body>
</html>
