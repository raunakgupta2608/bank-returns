<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home</title>
<style>
            .site-header
            {
                width: 100%;
                height: 100vh;
                background-image: linear-gradient(to top left,#806e5e,#FFA500);
                clip-path: polygon(0 0, 100% 0, 75% 100%, 0 100%);
            }
            .logo
            {
                border-radius: 10px;
                padding:1%;
                margin-left:0%;
                /* width:27%;
                height:150%; */
                margin-right: 20%;
            }

            nav
            {
                width: 200%; height: 100px;
                text-align: right;
                /* background-color:  red; */
                display: flex;
                color:#333;
            }

            .menu
            {
                width: 50%; height: 100px;
            }

            .menu ul
            {
                width: 200px;
                height: 100px;
                display: flex;
                flex-direction: row;
                justify-content: space-around;
                float:left;
            }
            .menu ul li
            {
                list-style: none;
                font-size: 13px;
                color: #333;
                font-weight: bold;
                text-transform: uppercase;
                display: inline;
                
            }
            .menu ul li a 
            {
            display: block;
            color:#333;
            text-decoration: none;
            text-align: center;
            /* text-align:right; */
            padding: 14px 16px;
            /* text-decoration: none; */
            }
            section
            {
                display: flex;  
                margin-top: 10%;
            }
            .rightside
            {
                width: 100%; height:250px; text-align: right; margin-top:100px
            }
            .rightside h1
            {
                text-align: center;
                color: #333;
                font-size: 50px;
                text-transform: uppercase;
            } 
        </style>
</head>
<body>
  <!--   <a href="login.jsp">Login</a>
    <br>
	<a href="opensavingaccount.jsp">Open Saving Account</a>
	<br>
	<a href="checkaccountnumber.jsp">Register for internet banking</a>
	<br>
	<a href="adminlogin.jsp">Admin Page</a> -->
	   <!-- FORM starts HERE -->
            <form action="home.lti" method="post">

        <header class="site-header clearfix">
        <nav>
            <div class="logo">
                <img src="${pageContext.request.contextPath }/img/Auroralogo.png" height="200px" width="250px">
            </div>
            <div class="menu"> 
                <ul>
                    <li><a href="checkaccountnumber.jsp">Register for internet banking</a></li>
                    <li><a href="opensavingaccount.jsp">Open Saving Account</a></li>
                    <li><a href="userlogin.jsp">Login</a></li>
                    <li><a href="adminlogin.jsp">Admin Page</a></li>
                </ul> 
            </div>
        </nav>

        <section>
            <div class="rightside"> 
                <h1> Aurora Bank </h1>
            </div>
        </section>
</header>
</form>
</body>
</html>