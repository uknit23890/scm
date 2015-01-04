package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Comment;
import model.User;
import data.DAO;
import data.DataException;

/**
 * Servlet implementation class for Servlet: AddComment
 *
 */
 public class AddComment extends javax.servlet.http.HttpServlet implements javax.servlet.Servlet {
   static final long serialVersionUID = 1L;
   
    /* (non-Java-doc)
	 * @see javax.servlet.http.HttpServlet#HttpServlet()
	 */
	public AddComment() {
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

	private void processRequest(HttpServletRequest request,	HttpServletResponse response)  throws ServletException, IOException {
		// TODO Auto-generated method stub
		 int topicId = Integer.parseInt(request.getParameter("topicId"));
	    HttpSession session = request.getSession();
	    ArrayList<Comment> newComments = (ArrayList<Comment>)session.getAttribute("newcomments");
		 
	    if(newComments == null){
	    	newComments = new ArrayList<Comment>();
	    	
	    }
	    session.setAttribute("newcomments", newComments);
	    User user = (User)request.getSession().getAttribute("user");
	    Comment comment = new Comment();
	    
	      comment.setUserid(user.getUserid());
	      comment.setComment(request.getParameter("comment"));
	      comment.setTopicid(topicId);
	      comment.setTime(new java.util.Date());
	      
	  	try {
			DAO.saveComment(comment);
			newComments.add(comment);
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("newcomments.jsp");
			dispatcher.forward(request, response);
			
		} catch (DataException e) {
			// TODO Auto-generated catch block
			response.getWriter().println("false");
		}
	
	}   	  	    
}