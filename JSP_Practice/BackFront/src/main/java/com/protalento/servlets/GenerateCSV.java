package com.protalento.servlets;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.protalento.DataBaseConnector.Utilities.LocalDateUtilities;
import com.protalento.DataBaseConnector.entities.SystemUser;
import com.protalento.DataBaseConnector.jdbc.implementations.EmployeeImp;
import com.protalento.enums.BackFrontAlerts;

/**
 * Servlet implementation class GenerateCSV
 */
public class GenerateCSV extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GenerateCSV() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		SystemUser systemUser = (SystemUser) session.getAttribute("SystemUser");
		
		BackFrontAlerts alert;
		if (Objects.nonNull(systemUser)) {
			EmployeeImp employeeImp = new EmployeeImp();
			String systemUserEmail = systemUser.getEmail();
			
			LocalDateTime dateTime = LocalDateTime.now();
			String CSVdate = dateTime.format(DateTimeFormatter.ofPattern(LocalDateUtilities.CSV_DATE_TIME_FORMAT));
			
			employeeImp.saveListToCSV(systemUserEmail + "_" + CSVdate + ".csv");
			
			alert = BackFrontAlerts.CSV_FILE_GENERATED;
			request.setAttribute("BackFrontAlerts", alert);
		}
		
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("UserHome.jsp");
		requestDispatcher.forward(request, response);
	} 

}
