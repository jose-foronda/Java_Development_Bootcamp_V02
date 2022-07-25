<%@page import="com.protalento.DataBaseConnector.entities.SystemUser"%>
<%@page import="java.util.Objects"%>
<%@page import="com.protalento.enums.BackFrontAlerts"%>
<%@page import="com.protalento.DataBaseConnector.Utilities.LocalDateUtilities"%>
<%@page import="com.protalento.DataBaseConnector.entities.Employee"%>
<%@page import="java.util.List"%>
<%@page import="com.protalento.DataBaseConnector.jdbc.implementations.EmployeeImp"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="styles/styles1.css">
<link rel="stylesheet" href="styles/button.css">
<link rel="stylesheet" href="styles/table.css">
<link rel="stylesheet" href="styles/alert.css">
</head>
<body>

    <%
    	SystemUser systemUser = (SystemUser) session.getAttribute("SystemUser");
    
    	String resource = "";
        if( Objects.isNull(systemUser) ){
        	resource = "index.jsp";
        	RequestDispatcher requestDispatcher = request.getRequestDispatcher(resource);
        	requestDispatcher.forward(request, response);
        }
    %>

	<%
	EmployeeImp employeeImp = new EmployeeImp();
	List<Employee> employeeList = employeeImp.list();
	%>

    <h1> List of Employees </h1>
    <!-- <nav>
        <div id="searchHistoryContainer">
            <a id="searchHistory" href="searchesHistory.jsp">List Search History</a>
        </div>
    </nav> -->
    
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

    <div>
        <nav>
            <a href="SessionValidation"> Close Session</a>
            <a href="AddEmployee.jsp"> Add Employee</a>
            <a href="GenerateCSV"> Export to CSV</a>
        </nav>
    </div>
    
    <div id="tableContainer">
        <section>
            <h2>Current Employees</h2>  
            <table>
                <thead>
                    <tr>
                        <th>Doc Type</th>
                        <th>Doc Number</th> 
                        <th>Name</th>
                        <th>Last Name</th> 
                        <th>Age</th>
                        <th>Birthday</th>  
                        <th>Action</th>
                    </tr>
                </thead>
                <tbody>
                <% 
                    for(Employee employee : employeeList){
                        
                        String doctType = employee.getDocument().getType().toString();
                        String docNumber = employee.getDocument().getNumber();
                %>
                    <tr>
                        <td><%=doctType%></td> 
                        <td><%=docNumber%></td> 
                        <td><%=employee.getName()%></td>
                        <td><%=employee.getLastName()%></td>
                        <td><%=employee.getAge()%></td>
                        <td><%=employee.getBirthDate().format(LocalDateUtilities.getDateTimeFormatter(LocalDateUtilities.SYS_FORMATTER))%></td>
                        <td>
                            <button class="warning" onclick="redirectGET('EmployeeUpdate.jsp?docType=<%=doctType%>&docNumber=<%=docNumber%>')"> Edit</button>
                            <button class="danger" onclick="redirectGET('EmployeeDelete.jsp?docType=<%=doctType%>&docNumber=<%=docNumber%>')"> Delete</button>
                        </td>
                    </tr> 
                 <%
                     }
                 %>
                </tbody>
            </table>
        </section>
    </div>

    <script src="scripts/utilitiesMethods.js"></script>
</body>
</html>