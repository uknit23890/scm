package com.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bean.Article;

/**
 * @author Vinay Singh Rawat Servlet implementation class
 *         LoadArticleServlet->This servlet is the implementation of pagination.
 */
public class LoadArticleServlet extends HttpServlet {
	private static final long serialVersionUID = -9219651106472679495L;

	// JDBC driver name and database URL
	private final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	private final String DB_URL = "jdbc:mysql://localhost/pagination";

	// Database credentials
	private final String USER = "root";
	private final String PASS = "root";
	private Connection conn = null;
	private Statement stmt = null;

	private List<Article> list;
	private HttpSession session;

	// Number of article per page you wnat to diplay
	public final int perPagesArticles = 2;
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 * @RequestParameters action (load,next,previous)
	 * @Description load-load the list and display first page. next-is for next
	 *              page to display previous- is for previous page to display
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("Get");
		request.getRequestDispatcher("index.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 * @RequestParameters action (load,next,previous)
	 * @Description load-load the list and display first page. next-is for next
	 *              page to display previous- is for previous page to display
	 */
	@Override
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Post");
		String action = request.getParameter("action");
		session = request.getSession();
		// load first page of list to display.
		if (action!=null&&action.equals("load")) {
			// Get the list
			// list = prepareList();
			session = request.getSession();
			/*
			 * Have to set some variables in session for pagination.
			 * 
			 * @pageNumber will use to display the current page number.
			 * 
			 * @list is the list of article which will be displayed in page.
			 * 
			 * @startIndex is the index of database from where the list will be
			 * start.
			 * 
			 * @perPagesArticles is maximum number of article to
			 * be fetched from database.
			 * 
			 * @btnNext is for next button
			 * 
			 * @btnPrevious is for previous button.
			 */
			session.setAttribute("pageNumber", 1);
			list = getList(0, perPagesArticles);
			session.setAttribute("list", list);
			session.setAttribute("startIndex", 0);
			session.setAttribute("btnNext", "Next");
			session.setAttribute("btnPrevious", "Previous Disabled");
			if (list!=null&&list.size() < perPagesArticles
					|| list.size() == 0) {
				session.setAttribute("btnNext", "");
				session.setAttribute("btnPrevious", "");
			}

		}
		// next-is for next page to display
		else if (action!=null&&action.equals("next")) {

			/*
			 * Have to set some variables in session for pagination.
			 * 
			 * @pageNumber will use to display the current page number.
			 * 
			 * @list is the list of article which will be displayed in page.
			 * 
			 * @startIndex is the index of database from where the list will be
			 * start.
			 * 
			 * @perPagesArticles is maximum number of article to
			 * be fetched from database.
			 * 
			 * @btnNext is for next button @btnPrevious is for previous button.
			 */
			session.setAttribute("btnPrevious", "Previous");
			session.setAttribute("startIndex",
					(Integer) session.getAttribute("startIndex")
							+ perPagesArticles);
			list = getList((Integer) session.getAttribute("startIndex"),
					perPagesArticles);
			// Calculating and setting page number
			int startIndex = (Integer) session.getAttribute("startIndex");
			int pageNumber = startIndex / perPagesArticles;
			session.setAttribute("pageNumber", ++pageNumber);
			// Set list in session to display in page
			session.setAttribute("list", list);
			int size1 = getList(
					(Integer) session.getAttribute("startIndex")
							+ perPagesArticles,
					perPagesArticles).size();
			// logic to disable Next button.
			if (list!=null&&list.size() < perPagesArticles || size1 == 0) {
				session.setAttribute("btnNext", "Next Disabled");
				session.setAttribute("btnPrevious", "Previous");
			}
		}
		// previous- is for previous page to display
		else if (action!=null&&action.equals("previous")) {
			/*
			 * Have to set some variables in session for pagination.
			 * 
			 * @pageNumber will use to display the current page number.
			 * 
			 * @list is the list of article which will be displayed in page.
			 * 
			 * @startIndex is the index of database from where the list will be
			 * start.
			 * 
			 * @perPagesArticles is maximum number of article to
			 * be fetched from database.
			 * 
			 * @btnNext is for next button
			 * 
			 * @btnPrevious is for previous button.
			 */
			session.setAttribute("btnNext", "Next");
			session.setAttribute("startIndex",
					(Integer) session.getAttribute("startIndex")
							- perPagesArticles);
			list = getList((Integer) session.getAttribute("startIndex"),
					perPagesArticles);
			// Calculating and setting page number
			int startIndex = (Integer) session.getAttribute("startIndex");
			int pageNumber = startIndex / perPagesArticles;
			session.setAttribute("pageNumber", ++pageNumber);
			// Set list in session to display in page
			session.setAttribute("list", list);
			// logic to disable Previous button.
			if ((Integer) session.getAttribute("startIndex") <= 0) {
				session.setAttribute("btnPrevious", "Previous Disabled");
				session.setAttribute("btnNext", "Next");
				session.setAttribute("startIndex", 0);
			} else {
				session.setAttribute("btnNext", "Next");
			}
		}
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

	/**
	 * @return List<Article>
	 * @Description This method will fetch the list of article from data base
	 *              with given limit of number of articles.
	 */
	private List<Article> getList(int startIndex, int numberOfArticlePerpage) {
		List<Article> list = new ArrayList<Article>();
		try {
			Class.forName(JDBC_DRIVER);
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			stmt = conn.createStatement();
			String sql;
			sql = "SELECT * FROM article LIMIT " + startIndex + ","
					+ numberOfArticlePerpage;
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {

				int id = rs.getInt("id");
				String title = rs.getString("title");
				String content = rs.getString("content");
				list.add(new Article(id, title, content));
			}
		} catch (SQLException se) {
			se.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (stmt != null)
					stmt.close();
			} catch (SQLException se2) {
			}
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException se) {
				se.printStackTrace();
			}
		}
		return list;
	}

}
