package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import data.DAO;

import model.Topic;

/**
 * Servlet implementation class for Servlet: UpdateTopic
 *
 */
 public class UpdateTopic extends javax.servlet.http.HttpServlet implements javax.servlet.Servlet {
   static final long serialVersionUID = 1L;
   
    /* (non-Java-doc)
	 * @see javax.servlet.http.HttpServlet#HttpServlet()
	 */
	public UpdateTopic() {
		super();
	}   	
	
	/* (non-Java-doc)
	 * @see javax.servlet.http.HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		RequestDispatcher dispatcher = request
		.getRequestDispatcher("EditTopic");
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
		String resource = "UserTopics";
		try{
			topic = DAO.getTopic(id);
			topic.setComment(request.getParameter("comments"));
			DAO.updateTopic(topic);
			request.setAttribute("message", "Update successful");
			
		}catch(Exception ex){
			request.setAttribute("message",ex.getMessage() +" <br> Please select the topic through topics page");
			resource = "edittopic.jsp";
			request.setAttribute("topic", topic);
		}
		RequestDispatcher dispatcher = request
		.getRequestDispatcher(resource);
		dispatcher.forward(request, response);
	}   	  	    
}