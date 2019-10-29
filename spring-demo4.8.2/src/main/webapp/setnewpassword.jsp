<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
 <script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.8.3/jquery.min.js"></script>
    <script type="text/javascript">
	$(document).ready(function () {
        $("#submit").click(function(){
        var password = $("#lpass").val();
   	var confirmPassword = $("#clpass").val();
    	var tpassword = $("#tpass").val();
    	var tconfirmPassword = $("#ctpass").val();
    if(password=="")
{
  $("#msgg").html("** The Login Password must be filled.");
  $('#msgg').css('color', 'red');
  
}
      else if((password.length<=5) || (password.length>15))
{
  $("#msgg").html(" Password must be between 5-15 characters.");
  $('#msgg').css('color', 'red');

}
    if (password != confirmPassword)
    {
        $('#msg').html("Passwords do not match!");
        $('#msg').css('color', 'red');
    }
    else
    {
        $('#msg').html("Passwords match.");
        $('#msg').css('color', 'green');
    }

   
});
	});
	</script>
	<style>
	#img{
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
  margin-top:3%;
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
  margin-top:2%;
  //border:1px solid red;
  
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
  height:20%;
  margin-left:10%;
  //border: 1px solid green;
}
input[type=submit] {
  background-color:#333; 
  border: none;
  color: white;
  margin-top:8%;
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
ul{

  list-style-type: none;
  margin: 0;
  padding: 0;
  overflow: hidden;
  background-color:#333;
}

li {
  float: left;
}

li a {
  display: block;
  color: white;
  text-align: center;
  padding: 14px 16px;
  text-decoration: none;
}

li a:hover:not(.active) {
  background-color:#ff8c1a;
}

.active {
  background-color:#ff8c1a;
}

</style>
	</style>
</head>
<body>
<form action="loginpassword.setpass" method="post">                 <!--Form starts here-->
<div id="img">
<img src="Auroralogo.png" width="150px"height="100px"; >
<marquee behavior="alternate" direction="left" alt="Natural">Let's make banking simpler!!</marquee>
<table>
<ul>
  <li><a href="#home">Home</a></li>
  <li style="float:right"><a class="active" href="#logout">Logout</a></li>
</ul>
</table>
</div>


<div id="container">
  <div id="upperdiv">
      <div id="solid">SET NEW PASSWORD</div><br><br>
  </div>
  <div id="lowerdiv">
      <table id="tab">
         
          <tr>
            <td class="one">Login Password</td>
            <td class="two">-</td>
            <td class="third"><input type="password" id="lpass"  name="lpass" required ></td>
            <td class="fourth"><span id="msgg"></span></td>
          </tr>
          
          <tr>
            <td class="one">Confirm Login Password</td>
            <td class="two">-</td>
            <td class="third"><input type="password" id="clpass"  required ></td>
            <td class="fourth"><span id="msg"></span></td>
          </tr>
          
        </table>
        <div id="buttondiv">
             <input type="submit" value="submit" id="submit">
            
        </div>
  </div>
</div>
</form>
</body>
</html>