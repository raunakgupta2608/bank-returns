<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Imps</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<style>
p.solid {border-style: solid; box-sizing: border-box; height:50px;
  width: 500px;border: 3px solid black;}
* {
  box-sizing: border-box;
}

input[type=text], select, textarea {
  width: 100%;
  padding: 12px;
  border: 1px solid #ccc;
  border-radius: 4px;
  resize: vertical;
  
}
input[type=Date]
{
 width: 100%;
  padding: 12px;
  border: 1px solid #ccc;
  border-radius: 4px;
  resize: vertical;
}
label {
  padding: 12px 12px 12px 0;
  display: inline-block;
}

input[type=submit] {
  background-color: #4CAF50;
  color: white;
  padding: 12px 20px;
  border: none;
  border-radius: 4px;
  cursor: pointer;
  float: right;
}

input[type=submit]:hover {
  background-color: #45a049;
}

.container {
  border-radius: 20px;
  background-color: #ff9933;
  padding: 20px;
  width:50%;
 height:50%; 
 margin: 0 auto;
  text-align: left;
  margin-top: 10px;
 
}

.col-25 {
  float: left;
  width: 25%;
  margin-top: 6px;
}

.col-75 {
  float: left;
  width: 75%;
  margin-top: 6px;
}

.button {
  background-color:#333; 
  border: none;
  color: white;
  padding: 15px 32px;
  text-align: center;
  text-decoration: none;
  display: inline-block;
  font-size: 16px;
  float: right;
  cursor: pointer;

}
div.row{
text-align: center;

}

ul{
	list-style-type:none;
	margin:0;
	padding:0;
	display:flex;
	flex-direction:row;
	justify-content:center;
}

li{
	padding:0.5em;
}

#addNew{
	background-color:#333;
	border:none;
	color: white;
	padding:5%;
	margin:5%;
	width:150%;
	height:170%;
}

@media screen and (max-width: 600px) {
  .col-25, .col-75, input[type=submit] {
    width: 100%;
    margin-top: 0;
  }
}

#img{
	width:"150px";
	height:"190px";
	font-size:125%; 
    margin-left:10;
/*border:1px solid black;*/
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
</head>
<body>

        <div id="img">
                <img src="Auroralogo.png" style="height:100px;"/>
                
                <marquee behavior="alternate" direction="left" alt="Natural">Let's make banking simpler!!</marquee>
                <table>
                <ul>
                  <li><a href="#home">Home</a></li>
                  <li style="float:right"><a class="active" href="#logout">Logout</a></li>
                </ul>
                </table>
        </div>

<div class="container">
<h2><center><p class="solid">Initiate IMPS Payment</p></center></h2>
 <center>

  /* FORM Starts HERE*/
  
  <form action="dashboardafterimps.lti" method="post">
    <table>
    <div class="row">
      <div class="col-25">
            <tr><td>  
        <label for="fromAccount">From Account <td>-</td></label></td>
      </div>
      <div class="col-75">
        <td>      <input type="text" id="fromAccount" name="fromAccount" placeholder="Enter Account Number"></td></tr>
      </div>
    </div>
    <div class="row">
      <div class="col-25">
            <tr><td>
        <label for="toAccount">To Account <td>-</td></label></td>
      </div>
      <div class="col-75">
      <td>  <input type="text" id="to acc" name="toAccount" placeholder="Enter Account Number"></td>
	  <td><button id="addNew">Add New</button> </td>
	  </tr>
      </div>
    </div>
    <div class="row">
      <div class="col-25">
            <tr><td>
        <label for="Amt">Amount<td>-</td></label> </td>
      </div>
      <div class="col-75">
     <td> <input type="text" id="Amt" name="Amt" placeholder="Enter Amount"></td></tr>
        
      </div>
    </div>
    <div class="row">
      <div class="col-25">
            <tr><td>
      <label for="transactionDate">Transaction Date<td>-</td></label></td>
      </div>
      <div class="col-75">
        <td> <input type="Date" id="transactionDate" name="transactionDate" placeholder="Enter Date" ></td></tr>
      </div>
       <div class="row">

      <div class="col-25">
            <tr><td>
      <label for=" remark">Remark<td>-</td></label></td>
      </div>
      <div class="col-75">
        <td> <input type="text" id="remark" name="remark" placeholder="Remarks"></td></tr>
      </div>
	</table>
	<!-- <div>
		<ul style="background-color:#ff9933;">
			<li><input type="submit" value="Submit" class="button" style=" background-color:#333;"></li>
			<li><input type="submit" value="Reset" class="button" style=" background-color:#333;"></li>
			<li><input type="submit" value="Save As Template" class="button" style=" background-color:#333;"></li>
			<li><input type="submit" value="Continue" class="button" style=" background-color:#333;"></li>
		</ul>
    </div> -->
    <input type="submit" value="Submit">
 </form>
</div>
</center>
</body>
</html>
