package com.protalento.servlets;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Objects;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.protalento.DataBaseConnector.Utilities.LocalDateUtilities;
import com.protalento.DataBaseConnector.entities.Document;
import com.protalento.DataBaseConnector.entities.Employee;
import com.protalento.DataBaseConnector.enums.DocumentType;
import com.protalento.DataBaseConnector.jdbc.implementations.EmployeeImp;
import com.protalento.enums.BackFrontAlerts;

/**
 * Servlet implementation class EmployeeAction
 */
public class EmployeeAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	/**
	 * Logger
	 */
    private static final Logger logger = LogManager.getLogger();  
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmployeeAction() {
        super();
        // TODO Auto-generated constructor stub
    }  

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String docType = request.getParameter("DocumentType");
		String docNumber = request.getParameter("DocNumber");
		String employeeName = request.getParameter("employeeName");
		String employeeLastName = request.getParameter("employeeLastName");
		int employeeAge = Integer.valueOf(request.getParameter("employeeAge"));
		
		String employeeBirthdayString = request.getParameter("employeeBirthDay");
		logger.debug("birthDay " + employeeBirthdayString);
		// The format of the <input type= "date"> is always "yyyy-MM-dd" for that reason I chose SQL_DATE_PATTERN
		LocalDate employeeBirthDay = LocalDate.parse(employeeBirthdayString, LocalDateUtilities.getDateTimeFormatter(LocalDateUtilities.SQL_DATE_PATTERN));
		
		//Document to search in data base. 
		Document doc = new Document(DocumentType.valueOf(docType), docNumber);
		Employee employee = new Employee(doc, employeeName, employeeLastName, employeeAge, employeeBirthDay);
		
		String redirectPage = "UserHome.jsp";
		
		//Access to Employee implementation.
		EmployeeImp employeeImp = new EmployeeImp();
		Employee searchedEmployee = employeeImp.searchByKey(doc);
		
		BackFrontAlerts alert;
		if (Objects.nonNull(searchedEmployee)) { 
			alert = employeeImp.modify(employee) ? BackFrontAlerts.USER_MODIFIED : BackFrontAlerts.USER_MODIFIED_PROBLEM;
			request.setAttribute("BackFrontAlerts", alert);
		}else {
			alert = employeeImp.insert(employee) ? BackFrontAlerts.USER_ADDED : BackFrontAlerts.USER_NO_ADDED;
			request.setAttribute("BackFrontAlerts", alert);
		}
		
		RequestDispatcher requestDispatcher = request.getRequestDispatcher(redirectPage);
		requestDispatcher.forward(request, response);
		
	}

}
