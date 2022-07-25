package com.protalento.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.protalento.DataBaseConnector.entities.Document;
import com.protalento.DataBaseConnector.entities.Employee;
import com.protalento.DataBaseConnector.enums.DocumentType;
import com.protalento.DataBaseConnector.jdbc.implementations.EmployeeImp;
import com.protalento.enums.BackFrontAlerts;

/**
 * Servlet implementation class EmployeeRegisterClean
 */
public class EmployeeRegisterClean extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static final Logger logger = LogManager.getLogger();  
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmployeeRegisterClean() {
        super(); 
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String docType = request.getParameter("DocumentType");
		String docNumber = request.getParameter("DocNumber");
		
		//Document to search in data base. 
		Document doc = new Document(DocumentType.valueOf(docType), docNumber);
		Employee employee = new Employee(doc, null, null, 0, null);
		
		String redirectPage = "UserHome.jsp";
		
		//Access to Employee implementation.
		EmployeeImp employeeImp = new EmployeeImp();
		
		BackFrontAlerts alert = employeeImp.delete(employee) ? BackFrontAlerts.USER_DELETED : BackFrontAlerts.USER_NO_DELETED;
		
		request.setAttribute("BackFrontAlerts", alert);
		
		RequestDispatcher requestDispatcher = request.getRequestDispatcher(redirectPage);
		requestDispatcher.forward(request, response);
	}

}
