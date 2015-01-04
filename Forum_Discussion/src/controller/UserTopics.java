package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Topic;
import model.User;
import data.DAO;
import data.DataException;

/**
 * Servlet implementation class for Servlet: UserTopics
 * 
 */
public class UserTopics extends javax.servlet.http.HttpServlet implements
		javax.servlet.Servlet {
	static final long serialVersionUID = 1L;

	/*
	 * (non-Java-doc)
	 * 
	 * @see javax.servlet.http.HttpServlet#HttpServlet()
	 */
	public UserTopics() {
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
		// TODO Auto-generated method stub
		/*User user = (User) request.getSession().getAttribute("user");
		if (user == null) {
			RequestDispatcher dispatcher = request
					.getRequestDispatcher("login.jsp");
			request.setAttribute("message", "Please Login to Access Data");

			dispatcher.forward(request, response);
		} else {

			String message = null;
			String resource = "home.jsp";

			try {
				List<Topic> topics = DAO.getTopics(user.getUserid());

				request.setAttribute("topics", topics);
				resource = "usertopics.jsp";
			} catch (DataException e) {
				// TODO Auto-generated catch block
				message = e.getMessage();

			}

			request.setAttribute("message", message);

			RequestDispatcher dispatcher = request
					.getRequestDispatcher(resource);
			dispatcher.forward(request, response);
		}*/
		doPost(request,response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			// TODO Auto-generated method stub
			// TODO Auto-generated method stub
			// TODO Auto-generated method stub
			User user = (User) request.getSession().getAttribute("user");
			if (user == null) {
				RequestDispatcher dispatcher = request
						.getRequestDispatcher("login.jsp");
				request.setAttribute("message", "Please Login to Access Data");

				dispatcher.forward(request, response);
			} else {

				String message = null;
				String resource = "home.jsp";

				try {
					List<Topic> topics = DAO.getTopics(user.getUserid());

					request.setAttribute("topics", topics);
					resource = "usertopics.jsp";
				} catch (DataException e) {
					// TODO Auto-generated catch block
					message = e.getMessage();

				}

				request.setAttribute("message", message);
				RequestDispatcher dispatcher = request
						.getRequestDispatcher(resource);
				dispatcher.forward(request, response);
				
		}	
		 
}
	
	
	

}