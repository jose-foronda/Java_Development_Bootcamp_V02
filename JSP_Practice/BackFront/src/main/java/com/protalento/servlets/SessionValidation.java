package com.protalento.servlets;

import java.io.IOException;
import java.util.Objects;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.protalento.DataBaseConnector.entities.SystemUser;
import com.protalento.DataBaseConnector.jdbc.implementations.SystemUserImp;
import com.protalento.enums.BackFrontAlerts;

/**
 * Servlet implementation class SessionValidation
 */
public class SessionValidation extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private Logger logger = LogManager.getLogger();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SessionValidation() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getSession().invalidate();
		
		BackFrontAlerts alert = BackFrontAlerts.SESSION_CLOSED;
		request.setAttribute("BackFrontAlerts", alert);
		
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("index.jsp");
		requestDispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String resource = "index.jsp";
		String userEmail = request.getParameter("email");
		String userPassword = request.getParameter("password");
		
		//Implementation for SystemUser
		SystemUserImp systemUserImp = new SystemUserImp();
		
		SystemUser systemUser = systemUserImp.searchByKey(userEmail);
		
		boolean correctEmail = false;
		boolean correctPassword = false;
		if (Objects.nonNull(systemUser)) {
			correctEmail = true;
			correctPassword = systemUser.getPassword().equals(userPassword);
		}
		
		byte sel = (byte) ( (correctEmail ? 0b10 : 0b00) | (correctPassword? 0b01 : 0b00) );

		switch (sel) {
		case 2:
			request.setAttribute("BackFrontAlerts", BackFrontAlerts.INCORRECT_PASSWORD);
			break;
		
		case 3:
			resource = "welcome.jsp";
			request.setAttribute("BackFrontAlerts", BackFrontAlerts.CORRECT_CREDENTIALS);
			HttpSession session = request.getSession();
			session.setAttribute("SystemUser", new SystemUser(userEmail, userPassword));
			break;
		
		default:
			request.setAttribute("BackFrontAlerts", BackFrontAlerts.USER_NO_REGISTERED);
			break;
		}
		
		RequestDispatcher requestDispatcher = request.getRequestDispatcher(resource);
		requestDispatcher.forward(request, response);
	}

}
