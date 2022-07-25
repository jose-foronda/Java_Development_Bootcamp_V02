<%@page import="com.protalento.DataBaseConnector.entities.SystemUser"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="styles/welcome.css">
</head>
<body>
<%
	SystemUser systemUser = (SystemUser) session.getAttribute("SystemUser");
%>
 <h1>Welcome</h1> 
 <h1> User: 
 	<%=systemUser.getEmail()%>
 </h1>
 
 <h1>
	You are going to be redirected in 5 seconds. Please wait.
 </h1>
	
	<div class="screen-box">
	   <div class="wrapper-box ">
			   <div class="time-wrapper grid-element"> 
				   <div id="seconds" class="orangeDefault">
					   5
				   </div>
			   </div> 
		</div>
   </div> 

<script src="scripts/chronometerBehavior.js"></script>

</body>
</html>