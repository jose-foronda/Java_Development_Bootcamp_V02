<%@page import="com.protalento.DataBaseConnector.entities.SystemUser"%>
<%@page import="com.protalento.enums.BackFrontAlerts"%>
<%@page import="java.util.Objects"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1"> 
<title>Insert title here</title>

<link rel="stylesheet" href="styles/styles1.css">
<link rel="stylesheet" href="styles/alert.css">

</head>
<body>
    <%
    BackFrontAlerts backFrontAlert = (BackFrontAlerts) request.getAttribute("BackFrontAlerts");
    %>
	
	<%
		if(Objects.nonNull(backFrontAlert)){
			
	%>	
		<div id="alert">
            <a class="alert customColor" href="#alert"><%=backFrontAlert.getMessage()%></a>
		</div>
	<%
		}
	%>
	
    <%
    	SystemUser systemUser = (SystemUser) session.getAttribute("SystemUser");
    
    	String resource = "";
        if( Objects.nonNull(systemUser) ){
        	resource = "UserHome.jsp";
        	RequestDispatcher requestDispatcher = request.getRequestDispatcher(resource);
        	requestDispatcher.forward(request, response);
        }
    %>

    <form action="SessionValidation" method="post" id="form">
        <input type="email" name="email" id="email" placeholder="user@domain.com" required>
        <input type="password" name="password" id="password" placeholder="your password" required>
        <input type="submit" name="validateCredentials" id="validateCredentials" value="login">
        <input type="reset" name="reset" id="reset" value="reset form">
    </form>

</body>
</html>