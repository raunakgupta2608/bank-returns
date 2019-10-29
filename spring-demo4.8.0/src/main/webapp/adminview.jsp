<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Admin View</title>
<style>

#container {
  border-radius: 20px;
  background-color:#FFA500;
  width:50%;
  height:50vh; 
  margin-left:25%;
  margin-top:5%;
  border:1px solid black;
}
#lowerdiv
{
  height:40%;
  width:80%;
  margin-top:15%;	
  margin-left:10%;
  //border:1px solid red;
}
input[type=submit]
{
  background-color:#333; 
  border: none;
  color: white; 
  margin-top:5%;
  margin-left:35%;
  padding: 5px 15px;
  text-align: center;
  text-decoration: none;
  display: inline-block;
  font-size: 16px;
  cursor: pointer;
}



</style>

</head>
<body>

<div id="container">

	<div id="lowerdiv">
        	<form action="adminapprovednowsendmail.lti" method="post">
		<c:forEach items="${ alladmindata }" var="ayush">
			
				<table>
					<tr>
						<td>Account Number</td>
						<td>:</td>
						<td><input type="text" value="${ ayush.accno }" disabled></td>
						<td>Email Id</td>
						<td>:</td>
						<td><input type="text" value="${ ayush.emailid }" name="emailid" disabled></td>
						<td><input type="submit" id="submit" value="Submit"></td>
					</tr>	
				</table>
		</c:forEach>
		</form>
</div>
</div>

      
</body>
</html>

<!-- 
<script type="text/javascript">
   
    		for(let i=1; i<=${size}; i++)
    		{
    			var firstcontainer = document.createElement('div');
    			firstcontainer.id = 'firstcontainer'+i;
    			firstcontainer.name = 'firstcontainer'+i;
    			firstcontainer.style = "height:50px; width:30%;/*  border:1px solid black; */";
    			document.getElementsByTagName('body')[0].appendChild(firstcontainer);
    			
    			var firstdiv = document.createElement('div');
    			firstdiv.id = 'first'+i;
        		firstdiv.name = 'first'+i;
        		firstdiv.style =  "height:50px; width:max-width; border:1px solid red;";
        		firstcontainer.appendChild(firstdiv);
 
    		}
    		for(let i=1; i<=${size}; i++)
    		{
    			var secondcontainer = document.createElement('div');
    			secondcontainer.id = 'firstcontainer'+i;
    			secondcontainer.name = 'firstcontainer'+i;
    			secondcontainer.style = "height:50px; width:30%; border:1px solid green;";
    			document.getElementsByTagName('body')[0].appendChild(secondcontainer);
    			
    			var seconddiv = document.createElement('div');
        		seconddiv.id = 'second'+i;
        		seconddiv.name = 'second'+i;
        		seconddiv.style = "height:50px; width:max-width;border:1px solid blue; ";
        		secondcontainer.appendChild(seconddiv);
    		}
    		for(let i=1; i<=${size}; i++)
    		{
    			var x = 'second'+i;
    			document.getElementById(x).value=${ ayush.accno } ;
    		}
    	</script>

 -->
