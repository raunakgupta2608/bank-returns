<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Set Passwords</title>
    <script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.8.3/jquery.min.js"></script>
    <script type="text/javascript">
		$(document).ready(function () {
        $("#submit").click(function(){
        var password = $("#lpass").val();
    var confirmPassword = $("#clpass").val();
    var tpassword = $("#tpass").val();
    var tconfirmPassword = $("#ctpass").val();
   /*  var chk=/^[a-zA-Z0-9._-@*]$/
    var bol = chk.test(password);
			 if(!bol)
			{
				$('#msg').html("** Enter valid Password");
				$('#msg').css('color', 'red');
				return false;
			}  */ 
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

     if(tpassword=="")
{
  $("#msgg1").html("** The Transaction Password must be filled.");
  $('#msgg1').css('color', 'red');
  
}

else if((tpassword.length<=5) || (tpassword.length>15))
{
  $("#msgg1").html(" Password must be between 5-15 characters.");
  $('#msgg1').css('color', 'red');

} 
    if (tpassword != tconfirmPassword)
    {
        $('#msg1').html("Passwords do not match!");
        $('#msg1').css('color', 'red');
    }
    else
    {
        $('#msg1').html("Passwords match.");
        $('#msg1').css('color', 'green');
    }
}); 
});

        </script>
<style>

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
.button {
  background-color: #008CBA; 
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


</style>

</head>
<body>
<div id="container">
  <div id="upperdiv">
      <div id="solid">SET NEW PASSWORD</div><br><br>
  </div>
  <div id="lowerdiv">
  
  														<!-- form starts here  -->
  	<form action ="enterotp.lti" method="post">
  			<table id="tab">
         
          <tr>
            <td class="one">Login Password</td>
            <td class="two">-</td>
            <td class="third"><input type="password" id="lpass" name="loginpass" required ></td>
            <td class="fourth"><span id="msgg"></span></td>
          </tr>
          
          <tr>
            <td class="one">Confirm Login Password</td>
            <td class="two">-</td>
            <td class="third"><input type="password" id="clpass"  required ></td>
            <td class="fourth"><span id="msg"></span></td>
          </tr>
          <tr>
            <td class="one">Transaction password</td>
            <td class="two">-</td>
            <td class="third"><input type="password" id="tpass" name="transpass" required></td>
            <td class="fourth"><span id="msgg1"></span></td>
          </tr>
	<tr>
            <td class="one">Confirm Transaction password</td>
            <td class="two">-</td>
            <td class="third"><input type="password" id="ctpass" required ></td>
            <td class="fourth"><span id="msg1"></span></td>
          </tr>
        </table>
        
        <div id="buttondiv">
             <input type="submit" id="submit" value="Submit" required> 
        </div>
  	</form>
  </div>
</div>
</body>
</html>
