package com.protalento.servlets;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.protalento.entities.WebTextSearch;
import com.protalento.jdbc.implementations.WebTextSearchImp;

/**
 * Servlet implementation class SearchText
 */
public class SearchText extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchText() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		RequestDispatcher dispatcher = request.getRequestDispatcher("index.html");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		doGet(request, response);
		RequestDispatcher dispatcher = request.getRequestDispatcher("searchAnswer.jsp");
		
		WebTextSearch webSearch = new WebTextSearch();
		webSearch.setText(request.getParameter("searchedText"));
		webSearch.setUrl(request.getParameter("searchedURL"));
		webSearch.setHtmlContent(requestURLBodyResponse( webSearch.getUrl() ));
		
		insertIntoDataBase(webSearch);
		
		request.setAttribute("webSearch", webSearch);
		
		dispatcher.forward(request, response);
		System.out.println("From Post");
	}
	
	private boolean insertIntoDataBase(WebTextSearch webSearch) {
		WebTextSearchImp webSearchImp = new WebTextSearchImp();
		
		return webSearchImp.insert(webSearch);
	}
	
	public String requestURLBodyResponse(String searchedURL) {
		HttpClient client = HttpClient.newHttpClient();
		   
		HttpRequest request = HttpRequest.newBuilder()
			         .uri(URI.create(searchedURL))
			         .build();
		   
		HttpResponse<String> response = null;
		try {
			response = client.send(request, BodyHandlers.ofString());
		} catch (IOException e) { 
			e.printStackTrace();
		} catch (InterruptedException e) { 
			e.printStackTrace();
		} 
		
		return response.body();
	}

}
