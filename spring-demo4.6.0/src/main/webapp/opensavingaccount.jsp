<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Open Savings Account</title>
<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.8.3/jquery.min.js"></script>
<script>
  $(document).ready(function(){
    $("#filladdress").click(function(){
         if (this.checked) { 
                $("#postaddrln1").val($("#preaddrln1").val());
                $("#postaddrln2").val($("#preaddrln2").val());
                $("#postlndmark").val($("#prelndmark").val());  
                $("#postcity").val($("#precity").val());
                $("#poststate").val($("#prestate").val());
                $("#postpincode").val($("#prepincode").val());                         
    }
    else{
      $("#postaddrln1").val('');
      $("#postaddrln2").val('');
      $("#postlndmark").val('');
      $("#postcity").val('');
      $("#poststate").val('');
      $("#postpincode").val('');
    }
    });
});
</script>
<style>

#img{
	width="150px";
	height="150px";
}
#imgtab{
	font-size:125%; 
        margin-left:20;
	//border:1px solid black;
}


#container {
  border-radius: 20px;
  background-color:#FFA500;
  width:50%;
  height:175vh; 
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
  //border:1px solid red;
}
#solid
{
  border-style: solid;
  box-sizing: border-box; 
  text-align: center;
  padding:7px;
  //border: 2px solid black;
  font-weight:bold;
}
#lowerdiv1
{
  height:45%;
  width:80%;	
  margin-left:10%;
  //border:1px solid red;
}
#tab
{
  width:80%;
  height:50%;
  margin-left:10%;
  margin-top:1%;
  //border: 2px solid purple;
}
#tab h3
{
  width:100%;
  margin-left:60%;
  //border: 2px solid red;
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
#lowerdiv2
{
  height:40%;
  width:80%;	
  margin-left:10%;
  //border:1px solid brown;
}

#checkbox
{
  width:80%;
  margin-left:10%;
  padding-top:3%;
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
}
</style>
</head>

<body>
<form method="post" action="opensavingaccount.lti">
<div id="imgtab">
<div id="img">
<img src="Auroralogo.png" width="150px"height="100px"; >
</div>
<marquee behavior="alternate" direction="left" alt="Natural">Let's make banking simpler!!</marquee>
</div>


<ul>
  <li><a href="#home">Home</a></li>
  <li><a href="#news">About</a></li>
  <li><a href="#contact">Contact</a></li>
  <li style="float:right"><a class="active" href="#about">Logout</a></li>
</ul>



<div id="container">
  <div id="upperdiv">
      <div id="solid">OPEN A SAVINGS ACCOUNT</div><br><br>
  </div>
  <div id="lowerdiv1">

      <table id="tab">
          <tr>
            <td><h3>Personal Details</h3></td>
          </tr>
<tr>
	<td class="one">Enter Title</td>
	<td class="two">-</td>
	<td class="third">
	<select name="title">
          <option selected="selected" value="Mr.">Mr.</option>
          <option value="Mrs.">Mrs.</option>
          <option value="Ms">Ms</option>
	  <option value="Ms">Mr</option> 
        </select></td>
</tr>
          <tr>
            <td class="one">Enter your First Name</td>
            <td class="two">-</td>
            <td class="third"><input type="text" name="fname" required></td>
          </tr>
          <tr>
            <td class="one">Enter your Middle Name</td>
            <td class="two">-</td>
            <td class="third"><input type="text" name="mname" required></td>
          </tr>
          <tr>
            <td class="one">Enter your Last Name</td>
            <td class="two">-</td>
            <td class="third"><input type="text" name="lname" required></td>
          </tr>
        
        
          <tr>
            <td class="one">Enter your Father's Name</td>
            <td class="two">-</td>
            <td class="third"><input type="text" name="fathername" required></td>
          </tr>
          <tr>
            <td class="one">Enter your Phone number</td>
            <td class="two">-</td>
            <td class="third"><input type="number" name="mobileno" pattern="[0-9]{10}-[0-9]{3}-[0-9]{4}" required></td>
          </tr>
          <tr>
            <td class="one">Enter your Email ID</td>
            <td class="two">-</td>
            <td class="third"><input type="email" name="emailid" required></td>
          </tr>

          <tr>
            <td class="one">Enter your Aadhar Card Number</td>
            <td class="two">-</td>
            <td class="third"><input type="number" name="aadharno" required></td>
          </tr>
          
          <tr>
            <td class="one">Enter Date of Birth</td>
            <td class="two">-</td>
            <td class="third"><input type="date" name="dob" required></td>
          </tr>

	<tr>
            <td><h3>Residential Address</h3></td>
          </tr>
          <tr>
            <td class="one">Address Line 1</td>
            <td class="two">-</td>
            <td class="third"><input type="text" id="preaddrln1" name="raddressln1" required></td>
          </tr>
          <tr>
            <td class="one">Address Line 2</td>
            <td class="two">-</td>
            <td class="third"><input type="text" id="preaddrln2" name="raddressln2" required></td>
          </tr>
          <tr>
            <td class="one">Landmark</td>
            <td class="two">-</td>
            <td class="third"><input type="text" id="prelndmark" name="landmark" required></td>
          </tr>
          <tr>
            <td class="one">State</td>
            <td class="two">-</td>
            <td class="third"><input type="text" id="prestate" name="state" required></td>
          </tr>
          <tr>
            <td class="one">City</td>
            <td class="two">-</td>
            <td class="third"><input type="text"  id="precity" name="city" required></td>
          </tr>
          <tr>
            <td class="one">Pincode</td>
            <td class="two">-</td>
            <td class="third"><input type="number" id="prepincode" name="pincode" required></td>
          </tr>
 </table>  
</div>  
	<div id="checkbox">
            <input type="checkbox" id="filladdress">Permanent Address same as Mailing Address<br>
        </div>
<div id="lowerdiv2">
  <table id="tab">
            <tr>
                <td class="one">Address Line 1</td>
                <td class="two">-</td>
                <td class="third"><input type="text" id="postaddrln1" name="praddressln1" required></td>
              </tr>
              <tr>
                <td class="one">Address Line 2</td>
                <td class="two">-</td>
                <td class="third"><input type="text" id="postaddrln2" name="praddressln2" required></td>
              </tr>
              <tr>
                <td class="one">Landmark</td>
                <td class="two">-</td>
                <td class="third"><input type="text" id="postlndmark" name="plandmark" required></td>
              </tr>
              <tr>
                <td class="one">State</td>
                <td class="two">-</td>
                <td class="third"><input type="text" id="poststate" name="pstate" required></td>
              </tr>
              <tr>
                <td class="one">City</td>
                <td class="two">-</td>
                <td class="third"><input type="text" id="postcity" name="pcity" required></td>
              </tr>
              <tr>
                <td class="one">Pincode</td>
                <td class="two">-</td>
                <td class="third"><input type="number" id="postpincode" name="ppincode" required></td>
              </tr> 

          <tr>
            <td><h3>Occupation Details</h3></td>
          </tr>
          <tr>
            <td class="one">Occupation Type</td>
            <td class="two">-</td>
            <td class="third"><input type="text" name="occtype" required></td>
          </tr>
          
          <tr>
            <td class="one">Source of Income</td>
            <td class="two">-</td>
            <td class="third"><input type="text" name="sourceincome" required></td>
          </tr>
          <tr>
            <td class="one">Gross Annual Income</td>
            <td class="two">-</td>
            <td class="third"><input type="text" name="annualincome" required></td>
          </tr>
        </table>  
        
         <div id="buttondiv">
            <button type="submit" class="button" required>Submit</button>
        </div>   
  </div>

</div>
</form>
</body>
</html>



          <!-- <script>
          function f1()
          {
            var x = document.getElementById('d').value;
              alert(x);
          }
          </script> -->