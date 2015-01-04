package controller;

import java.io.IOException;
import java.util.Calendar;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.User;
import data.DAO;
import data.DataException;

/**
 * Servlet implementation class for Servlet: Registration
 * 
 */
public class Registration extends javax.servlet.http.HttpServlet implements
		javax.servlet.Servlet {
	static final long serialVersionUID = 1L;

	/*
	 * (non-Java-doc)
	 * 
	 * @see javax.servlet.http.HttpServlet#HttpServlet()
	 */
	public Registration() {
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
				.getRequestDispatcher("registration.jsp");
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
		char gender = 0;
		boolean validRegister = false;
		String resource = "registration.jsp";
		String userid = request.getParameter("userid");
		String password = request.getParameter("password");
		String confirmPassword = request.getParameter("confirmPassword");
		String name = request.getParameter("name");
		String day=request.getParameter("day");

		String month=request.getParameter("month");

		String year=request.getParameter("year");
		if (request.getParameter("gender") != null) {
			gender = request.getParameter("gender").charAt(0);
		}
		String city = request.getParameter("city");
		if (userid.equals("Enter valid mail Id")||userid == null || userid.trim().equals("")) {
			message = "<b>Please Enter Userid";
		}

		else if (password == null || password.trim().equals("")) {
			message = "<b>Please Enter Password";
		} else if (confirmPassword == null || confirmPassword.trim().equals("")) {
			message = "<b>Please Enter Confirm Password";
		}else if(!password.equals(confirmPassword)) {
			message = "<b>Both passwords must be same";
		}
		else if (name == null || name.trim().equals("")) {
			message = "<b>Please Enter Name";
		} else if (request.getParameter("gender") == null) {
			message = "<b>Please Select Gender";
		}
		else if (day == null || day.trim().equals("")) {
			message = "<b>Please Select day";
		}
		else if (month == null || month.trim().equals("")) {
			message = "<b>Please Select Month";
		}
		else if (year == null || year.trim().equals("")) {
			message = "<b>Please Select Year";
		}
		else if (city == null || city.trim().equals("")) {
			message = "<b>Please Enter City";
		}else {
			
			
			
			int age=Calendar.getInstance().get(Calendar.YEAR)-Integer.parseInt(year);
			User user = new User();
			user.setUserid(userid);
			user.setPassword(password);
			user.setName(name);
			user.setAge(age);
			user.setGender(gender);
			user.setCity(city);

			try {
				DAO.saveUser(user);
				validRegister = true;

			} catch (DataException e) {
				// TODO Auto-generated catch block
				message = e.getMessage();

			}
		}
			if (validRegister) {
				message = "<B>Registered successfully, Please Login";
				resource = "login.jsp";
			}
			request.setAttribute("message", message);
			RequestDispatcher dispatcher = request.getRequestDispatcher(resource);
			dispatcher.forward(request, response);

		
	}
}