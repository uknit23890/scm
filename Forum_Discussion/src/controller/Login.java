package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.User;
import data.DAO;
import data.DataException;

/**
 * Servlet implementation class for Servlet: Login
 * 
 */
public class Login extends javax.servlet.http.HttpServlet implements
		javax.servlet.Servlet {
	static final long serialVersionUID = 1L;

	/*
	 * (non-Java-doc)
	 * 
	 * @see javax.servlet.http.HttpServlet#HttpServlet()
	 */
	public Login() {
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
		RequestDispatcher dispatcher = request
				.getRequestDispatcher("login.jsp");
		dispatcher.forward(request, response);
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
		String message = null;
		String userid = request.getParameter("userid");
		String password = request.getParameter("password");
		String resource = "login.jsp";
		boolean validLogin = false;

		if (userid == null || userid.trim().equals("")) {
			message = "<b>Please Enter Userid";
		}

		else if (password == null || password.trim().equals("")) {
			message = "<b>Please Enter Password";
		} else {

			try {

				User user = DAO.getUser(userid);

				if (user.getPassword().equals(password)) {
					validLogin = true;
					request.getSession().setAttribute("user", user);
					resource = "home.jsp";
				} else {
					message = "<b>The password is not valid";
				}
			} catch (DataException e) {
			    message = "<b>"+e.getMessage();
			}

		}

		if (!validLogin)
			request.setAttribute("message", message);

		RequestDispatcher dispatcher = request.getRequestDispatcher(resource);
		dispatcher.forward(request, response);
	}
}