package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import data.DAO;

import model.Topic;

/**
 * Servlet implementation class for Servlet: EditTopic
 *
 */
 public class EditTopic extends javax.servlet.http.HttpServlet implements javax.servlet.Servlet {
   static final long serialVersionUID = 1L;
   
    /* (non-Java-doc)
	 * @see javax.servlet.http.HttpServlet#HttpServlet()
	 */
	public EditTopic() {
		super();
	}   	
	
	/* (non-Java-doc)
	 * @see javax.servlet.http.HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		RequestDispatcher dispatcher = request
		.getRequestDispatcher("UserTopics");
		request.setAttribute("message", "Please Access through User Topics page");

		dispatcher.forward(request, response);
	}  	
	
	/* (non-Java-doc)
	 * @see javax.servlet.http.HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		int id = Integer.parseInt(request.getParameter("id"));
		Topic topic = null;
		try{
			topic = DAO.getTopic(id);
			request.setAttribute("topic", topic);
			RequestDispatcher dispatcher = request
			.getRequestDispatcher("edittopic.jsp");
			dispatcher.forward(request, response);
		}catch(Exception ex){
			request.setAttribute("message",ex.getMessage() +" <br> Please select the topic through MyTopics page");
			RequestDispatcher dispatcher = request
			.getRequestDispatcher("UserTopics");
	
			dispatcher.forward(request, response);
		}
	}   	  	    
}