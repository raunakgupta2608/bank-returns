<%@page import="com.sun.xml.bind.v2.runtime.reflect.ListIterator"%>
<%@page import="java.util.List"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

<style>
		#container
		{
            border-radius: 20px;
            border-radius: 20px;
            background-color:#FFA500;
            width:50%;
            height:60vh; 
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
            border: 2px solid black;
            font-weight:bold;
        }
        
        #table
        {
        width:80%;
        height:50%;
        margin-left:10%;
        margin-top:5%;
        /* border: 2px solid green; */
        }
        #tab
        {
            width:80%;
            height:50%;
            margin-left:10%;
            margin-top:5%;
            //border: 2px solid green;
        }
        #buttondiv
        {
            width:80%;
            height:20%;
            margin-left:40%;
        }
        .button 
         {
            background-color: #333; 
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
        input[type=number], select 
        {
            width: 40%;
            padding: 12px 20px;
            margin: 8px 0;
            display: inline-block;
            border: 1px solid #ccc;
            border-radius: 4px;
            box-sizing: border-box;
        }
        input[type=submit] 
      {
        background-color:#333; 
        border: none;
        color: white;
        margin-top:8%;
        margin-left:0%;
        padding: 15px 32px;
        text-align: center;
        text-decoration: none;
        display: inline-block;
        font-size: 16px;
        cursor: pointer;
      }
      div.row
        {
            text-align: center;
        }
</style>
</head>
<body>

		<%
        	response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); //HTTP 1.1
        	response.setHeader("Pragma", "no-cache"); //HTTP 1.0
        	response.setHeader("Expires", "0");
        	
        	if(session.getAttribute("userid")==null)
        	{
        		response.sendRedirect("userlogin.jsp");
        	}
        %>	
		<div id="container">
		<form action="transactionresult.lti" method="post">

                <div id="upperdiv">
                        <div id="solid">IMPS</div><br><br>
                </div>
                        
			<table id="tab">
						    <tr>
                                <td>Beneficiary Account Number</td>
                                <td> 
                                        <select name="refbeneficiaryaccno" id="dropdown">
                                                <c:forEach items="${ listofbeneficiary}" var="list">
                                                    <option value="${ list}">${ list}</option>
                                                </c:forEach>
                                        </select>
                                </td>
						    </tr>
                            <tr>
                                <td>Enter Amout to be Transfered</td>
                                <td><input type ="number" name="transactionamt" >${msg }</td>
                            </tr>
						<!-- <tr>
							<td><input type="submit" value="Submit"></td>
						</tr> -->
            </table>
            <div id="buttondiv">
                    <input type="submit" value="Submit">
            </div>
         </div>
		</form>
				
		</div>

</body>
</html>