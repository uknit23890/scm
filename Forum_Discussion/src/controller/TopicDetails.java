package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import data.DAO;

import model.Comment;
import model.Topic;
import model.User;

/**
 * Servlet implementation class for Servlet: TopicDetails
 * 
 */
public class TopicDetails extends javax.servlet.http.HttpServlet implements
		javax.servlet.Servlet {
	static final long serialVersionUID = 1L;

	/*
	 * (non-Java-doc)
	 * 
	 * @see javax.servlet.http.HttpServlet#HttpServlet()
	 */
	public TopicDetails() {
		super();
	}

	/*
	 * (non-Java-doc)
	 * 
	 * @see javax.servlet.http.HttpServlet#doGet(HttpServletRequest request,
	 *      HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		User user = (User) request.getSession().getAttribute("user");
		if (user == null) {
			RequestDispatcher dispatcher = request
					.getRequestDispatcher("login.jsp");
			dispatcher.forward(request, response);
		} else {
			String resource = "topicdetails.jsp";
			Topic topic = null;
			try {
				int id = Integer.parseInt(request.getParameter("id"));
				topic = DAO.getTopic(id);
				request.setAttribute("topic", topic);
				request.setAttribute("message", null);
				List<Comment> comments = DAO.getComments(id);
				request.setAttribute("comments", comments);
				request.getSession().removeAttribute("newcomments");
				
			} catch (Exception ex) {
				request.setAttribute("message", ex.getMessage()
						+ " <br> Please select the topic through topics page");
				resource = "ListTopics";
			}
			RequestDispatcher dispatcher = request
			.getRequestDispatcher(resource);
			dispatcher.forward(request, response);
		}
	}

	/*
	 * (non-Java-doc)
	 * 
	 * @see javax.servlet.http.HttpServlet#doPost(HttpServletRequest request,
	 *      HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}
}