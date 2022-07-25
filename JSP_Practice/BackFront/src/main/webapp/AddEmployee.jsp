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

    <h1> Employee Register Form</h1>

    <div>
        <nav>
            <a href="UserHome.jsp">Back</a> 
            <a href="SessionValidation">Close Session</a> 
        </nav>
    </div>


    <form action="EmployeeAction" method="post" id="employeeForm">

        <select name="DocumentType" id="DocumentType" required>
            <option value="CC">CC - Cedula de ciudadania</option>
            <option value="TI">TI - Tarjeta de identidad</option>
            <option value="PAS">PAS - Pasaporte</option>
            <option value="CE">CE - Cedula extranjería</option>
            <option value="RC">RC - Registro civil</option>
        </select>

        <input type="text" name="DocNumber" id="DocNumber" placeholder="Document number" required>
        <input type="text" name="employeeName" id="employeeName" placeholder="Name" required>
        <input type="text" name="employeeLastName" id="employeeLastName" placeholder="Last name" required>
        <input type="number" name="employeeAge" id="employeeAge" min="0" max="130" placeholder="Age" required>
        <input type="date" name="employeeBirthDay" id="employeeBirthDay" placeholder="BirthDay" required>
        <input type="submit" name="employeeStore" id="employeeStore" value="Save">
        <input type="reset" name="employeeReset" id="employeeReset" value="Reset form">
    </form>
</body>
</html>