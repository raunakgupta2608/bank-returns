<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

<style>
* {
  box-sizing: border-box;
  text-align:center;
}
button{
color:white;
background-color:#333;
}

.column{
			
	float:left;
	padding:10px;
	border:2px solid black;
}
.dash{
	width:100%;
	height:50%;
	border:2px solid black;
	display:inline-block;
	margin-bottom:1%;
	}

div.h{
	text-align:center;
	
	}
.left{
	width:20%;
	justify-content:center;
	height:400px;
	display:flex;
	align-items:center;
	flex-direction:column;
	border:1px solid #ccc;
	background-color:#ff8c1a;

}
.center{
	width: 2%;
	border:none;
}
.right{
	width:76%;
	height:30%;
	background-color:#ff9933;
	border:1px solid #ccc;	
	margin-right: 2%;
}
.right button{
	outline:none;
	cursor:pointer;
	padding:14px 16px;
	transition:0.3s;
	font-size:16px;
    background-color:#333;
}

.left button
{
	width:70%;
	height:60%;
	font-size:16px;
}

#AccStat{
	margin-left:-40px;
	width:25%;
	display: inline-block;
	color:white;
}
#FundTrans{
	width:25%;
	display: inline-block;
	color:white;
}
#PersonalDetails{
	width:25%;
	display: inline-block;
	
}
#UserPass{
	width:25%;
	display: inline-block;
	color:white;
}
#logo{
	height: 25%;
	width: 100%;
	

}

#AvailBal{	
	height: 25%;
	width: 100%;	
	color:white;
}

#AccSumm{
	height: 25%;
	width: 100%;
	color:white;
}

#FundTransHist{
	height: 25%;
	width: 100%;
	color: #ccc;
}
#AddPay{
	height: 25%;
	width: 100%;
	color: #ccc;
}

.dropbtn {
 
  color: white;
  font-size: 16px;
  cursor: pointer;
}

/* The container <div> - needed to position the dropdown content */
.dropdown {
  position: relative;
  display: inline-block;
}


.dropdown-content {
  display: none;
  position: absolute;
  background-color: #f9f9f9;
  width: 100%;
  box-shadow:0px 40px 16px 0px rgba(0,0,0,0.2);
  z-index: 1;

}


.dropdown-content a {
  color: black;
  padding: 12px 16px;
  text-decoration: none;
  display: block;
}

.dropdown-content a:hover {background-color: #f1f1f1}

.dropdown:hover .dropdown-content {
  display: block;
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
<form action="" method="post">

        <div id="img">
                <img src="Auroralogo.png"/>
                
                <marquee behavior="alternate" direction="left" alt="Natural">Let's make banking simpler!!</marquee>
                <table>
                <ul>
                  <li><a href="#home">Home</a></li>
                  <li style="float:right"><a class="active" href="#logout">Logout</a></li>
                </ul>
                </table>
        </div>

<div class="row">
	<div class="column left">
		<div id="AvailBal"><button>Available Balance</button></div>	
		<div id="AccSumm"><button>Account Summary</button></div>
		<div id="FundTransHist"><button>Fund Transfer History</button></div>
		<!-- <form action="addpayee.jsp" method="post">
				<input type="submit" value="Add Payee">
		</form>	 -->
		<a href="addpayee.jsp">Add Payee</a>
	</div>
	<div class="column center"></div>
	<div class="column right">
		<div id="AccStat"><button>Account Statement</button></div>
		<div class="dropdown" id="FundTrans"><button class="dropbtn">Funds Transfer</button>
			<div class="dropdown-content">
					<a href="D:\Gladiator\imps.html">IMPS</a>
					<a href="D:\Gladiator\neft.html">NEFT</a>
					<a href="D:\Gladiator\rtgs.html">RTGS</a>
			</div>
		</div>
		<div id="PersonalDetails"><button>Personal Details</button></div>
		<div id="UserPass"><button>Change UserID Password</button></div>
</div>
</div>
</form>
</body>
</html>