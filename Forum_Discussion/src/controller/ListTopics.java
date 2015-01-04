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
 * Servlet implementation class for Servlet: ListTopics
 *
 */
 public class ListTopics extends javax.servlet.http.HttpServlet implements javax.servlet.Servlet {
   static final long serialVersionUID = 1L;
   
    /* (non-Java-doc)
	 * @see javax.servlet.http.HttpServlet#HttpServlet()
	 */
	public ListTopics() {
		super();
	}   	
	
	/* (non-Java-doc)
	 * @see javax.servlet.http.HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		processRequest(request, response);
	}  	
	
	/* (non-Java-doc)
	 * @see javax.servlet.http.HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
			processRequest(request, response);
	} 
	
	private void processRequest(HttpServletRequest request,
			HttpServletResponse response)throws ServletException, IOException {
		// TODO Auto-generated method stub
		User user = (User) request.getSession().getAttribute("user");
		if(user == null){
			RequestDispatcher dispatcher = request
			.getRequestDispatcher("login.jsp");
			dispatcher.forward(request, response);
		}else{
			try {
				List<Topic> topics = DAO.getTopics();
				request.setAttribute("topics", topics);
				request.getSession().removeAttribute("newcomments");
				RequestDispatcher dispatcher = request
				.getRequestDispatcher("listtopics.jsp");
				dispatcher.forward(request, response);
			} catch (DataException e) {
				// TODO Auto-generated catch block
				request.setAttribute("message", e.getMessage());
				RequestDispatcher dispatcher = request
				.getRequestDispatcher("home.jsp");
				dispatcher.forward(request, response);
			}
			
		}
	}   
}