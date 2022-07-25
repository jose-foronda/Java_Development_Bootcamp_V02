<%@page import="com.protalento.DataBaseConnector.Utilities.LocalDateUtilities"%>
<%@page import="java.time.LocalDateTime"%>
<%@page import="java.time.LocalDate"%>
<%@page import="com.protalento.DataBaseConnector.enums.DocumentType"%>
<%@page import="com.protalento.DataBaseConnector.entities.Document"%>
<%@page import="com.protalento.DataBaseConnector.entities.Employee"%>
<%@page import="com.protalento.DataBaseConnector.jdbc.implementations.EmployeeImp"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="styles/styles1.css">
<link rel="stylesheet" href="styles/employeeForm.css">
</head>
<body>
	<%
	String docType = request.getParameter("docType");
	String docNumber = request.getParameter("docNumber");
	
	EmployeeImp employeeImp = new EmployeeImp();
	
	Employee employee = employeeImp.searchByKey(new Document(DocumentType.valueOf(docType), docNumber));
	
	String employeeName = employee.getName();
	String employeeLastName = employee.getLastName();
	int employeeAge = employee.getAge();
	String employeeBirthDate = employee.getBirthDate().format(LocalDateUtilities.getDateTimeFormatter(LocalDateUtilities.SQL_DATE_PATTERN));
	
		
	%>

    <h1> Employee Update Form</h1>

    <div>
        <nav>
            <a href="UserHome.jsp">Back</a> 
            <a href="SessionValidation">Close Session</a> 
        </nav>
    </div>


    <form action="EmployeeAction" method="post" id="employeeForm">

        <input type="text" name="DocumentType" id="DocumentType" value="<%=docType%>" readonly >

        <input type="text" name="DocNumber" id="DocNumber" value="<%=docNumber%>" readonly>
        <input type="text" name="employeeName" id="employeeName" placeholder="Name" value="<%=employeeName%>" required>
        <input type="text" name="employeeLastName" id="employeeLastName" placeholder="Last name" value="<%=employeeLastName%>" required>
        <input type="number" name="employeeAge" id="employeeAge" min="0" max="130" placeholder="Age" value="<%=employeeAge%>" required>
        <input type="date" name="employeeBirthDay" id="employeeBirthDay" placeholder="BirthDay" value="<%=employeeBirthDate%>" required>
        <input type="submit" name="employeeStore" id="employeeStore" value="Save"> 
    </form>
</body>
</html>