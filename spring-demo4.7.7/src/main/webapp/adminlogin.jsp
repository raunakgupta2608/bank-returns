<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">


<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.8.3/jquery.min.js"></script>
      <script type="text/javascript">
        $(document).ready(function () 
        {
            $("#submit").click(function()
    {
		var username = $("#user").val();
		var password = $("#pass").val();

             if ( (username=="admin") && (password=="admin"))
	        {
               return true;    
	        }
	        else
            {
	        	$('#msg1').html("Invalid username or Password!");
                $('#msg1').css('color', 'red');
                return false;
            }
        }); 
    });
</script>

<style>

#img{
	width="150px";
	height="150px";
}

#container {
  border-radius: 20px;
  background-color:#FFA500;
  width:50%;
  height:50vh; 
  margin-left:25%;
  margin-top:5%;
  border:1px solid black;
}
#upperdiv
{
  margin-top:5%;
  margin-left:10%;
  width:80%;
  height:3%;
  /* border:1px solid red; */
}
#solid
{
  border-style: solid;
  box-sizing: border-box; 
  text-align: center;
  padding:10px;
  /* border: 2px solid black; */
  font-weight:bold;
}
#lowerdiv
{
  height:80%;
  width:80%;	
  margin-left:10%;
  /* border:1px solid red; */
}
#tab
{
  width:80%;
  height:50%;
  margin-left:10%;
  margin-top:10%;
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
div.row{
text-align: center;
}

</style>

</head>
<body>

<form action="adminview.lti" method="post">

<!-- 	Enter username : <input type="text" name ="adminusername"><br>
	Enter password : <input type="text" name="adminpassword"><br> 
	<input type="submit" value="Submit">-->
	
  
  
  <div id="container">
  <div id="upperdiv">
      <div id="solid">Login To Admin Account</div><br><br>
  </div>

  <div id="lowerdiv">
      <table id="tab">

          <tr>
            <td class="one">Enter User Name</td>
            <td class="two">-</td>
            <td class="third"><input type="text" id="user" name ="adminusername" required></td>
          </tr>

          <tr>
            <td class="one">Enter Password</td>
            <td class="two">-</td>
            <td class="third"><input type="password"  id="pass" name="adminpassword" required></td>
            </tr>
            <tr>
            <td class="fourth"><span id="msg1"></span></td>
          </tr>
	    </table>   
          <div id="buttondiv">
            <input type="submit" id="submit" value="Submit">
          </div>
  </div>
</div>
</form>

</body>
</html>