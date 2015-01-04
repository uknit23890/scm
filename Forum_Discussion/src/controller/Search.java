package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import data.DAO;
import data.DataException;

import model.Topic;
import model.User;

/**
 * Servlet implementation class for Servlet: Search
 *
 */
 public class Search extends javax.servlet.http.HttpServlet implements javax.servlet.Servlet {
   static final long serialVersionUID = 1L;
   
    /* (non-Java-doc)
	 * @see javax.servlet.http.HttpServlet#HttpServlet()
	 */
	public Search() {
		super();
	}   	
	
	/* (non-Java-doc)
	 * @see javax.servlet.http.HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		User user = (User) request.getSession().getAttribute("user");
		if(user == null){
			RequestDispatcher dispatcher = request
			.getRequestDispatcher("login.jsp");
			request.setAttribute("message", "Please Login to Access Data");
			dispatcher.forward(request, response);
		}else{
			RequestDispatcher dispatcher = request
			.getRequestDispatcher("search.jsp");
			dispatcher.forward(request, response);
		}
	}  	
	
	/* (non-Java-doc)
	 * @see javax.servlet.http.HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		User user = (User) request.getSession().getAttribute("user");
		if(user == null){
			RequestDispatcher dispatcher = request
			.getRequestDispatcher("login.jsp");
			request.setAttribute("message", "Please Login to Access Data");
			dispatcher.forward(request, response);
		}else{
			String message = null;
			String searchtext = request.getParameter("searchtext");
			String resource = "search.jsp";
			if (searchtext == null || searchtext.trim().equals("")) {
				message = "Please enter Search Text";
				request.setAttribute("message", message);
			}
			else{
				try {
					List<Topic> topics = DAO.searchTopics(searchtext);
					request.setAttribute("topics", topics);
					request.setAttribute("message", null);
			
				} catch (DataException e) {
					// TODO Auto-generated catch block
					request.setAttribute("message", e.getMessage());
				
				}
				
			}
			
			RequestDispatcher dispatcher = request
			.getRequestDispatcher(resource);
			dispatcher.forward(request, response);

			
			
		}
	}   	  	    
}