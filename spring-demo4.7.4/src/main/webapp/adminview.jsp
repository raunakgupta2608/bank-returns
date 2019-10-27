<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Admin View</title>
	</head>

    <body>
    <form action="adminapprovednowsendmail.lti" method="post">
   
   		<c:forEach items="${ alladmindata }" var="ayush">${ ayush.accno } 
		</c:forEach>

		<c:forEach items="${ alladmindata }" var="ayush">${ ayush.emailid }
		</c:forEach>
   
   		
   
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

		<input type="submit" value="submit">
	
    </form>         
    </body>
</html>

