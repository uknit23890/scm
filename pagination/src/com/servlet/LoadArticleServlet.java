package com.servlet;

import java.io.IOException;
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

	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

	private static final long serialVersionUID = -1127893502059913768L;
	private List<Article> list;
	private HttpSession session;
	private int size;
	private Integer pageNumber = 1;
	// Number of article per page you want to diplay
	private final int perPagesArticles = 5;

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
		String action = request.getParameter("action");
		session = request.getSession();
		// load the list and display first page.
		if (action.equals("load")) {
			// Get the list
			list = prepareList();
			session = request.getSession();
			/*
			 * Have to set some variables in session for pagination.
			 * 
			 * @pageNumber will use to diplay the current page number.
			 * 
			 * @list is the list of article.
			 * 
			 * @startIndex and @endIndex the to display the sub list of article
			 * from main @list
			 * 
			 * @btnNext is for next button @btnPrevious is for previous button.
			 */
			session.setAttribute("pageNumber", pageNumber);
			session.setAttribute("list", list);
			session.setAttribute("startIndex", 0);
			session.setAttribute("endIndex", perPagesArticles);
			session.setAttribute("btnNext", "Next");
			session.setAttribute("btnPrevious", "Previous Disabled");
			if (perPagesArticles >= list.size() || list.size() == 0) {
				session.setAttribute("btnNext", "");
				session.setAttribute("btnPrevious", "");
			}

		}
		// next-is for next page to display
		else if (action.equals("next") && list != null) {
			list = (List<Article>) session.getAttribute("list");
			size = list.size();
			// get current page number
			pageNumber = (Integer) session.getAttribute("pageNumber");
			// Increment current page number
			session.setAttribute("pageNumber", ++pageNumber);
			if (((String) session.getAttribute("btnNext")).equals("Next")) {
				/*
				 * Have to set some variables in session for pagination.
				 * 
				 * @pageNumber will use to diplay the current page number.
				 * 
				 * @list is the list of article.
				 * 
				 * @startIndex and @endIndex the to display the sub list of
				 * article from main @list
				 * 
				 * @btnNext is for next button @btnPrevious is for previous
				 * button.
				 */
				session.setAttribute("btnPrevious", "Previous");
				session.setAttribute("startIndex",
						(Integer) session.getAttribute("endIndex"));
				session.setAttribute("endIndex",
						(Integer) session.getAttribute("endIndex")
								+ perPagesArticles);
				if ((Integer) session.getAttribute("endIndex") >= size) {
					session.setAttribute("btnNext", "Next Disabled");
					session.setAttribute("btnPrevious", "Previous");
					session.setAttribute("endIndex", size);
				}
			}

		}
		// previous- is for previous page to display
		else if (action.equals("previous") && list != null) {

			list = (List<Article>) session.getAttribute("list");
			size = list.size();
			// get current page number
			pageNumber = (Integer) session.getAttribute("pageNumber");
			// Decrement current page number
			session.setAttribute("pageNumber", --pageNumber);
			if (((String) session.getAttribute("btnPrevious"))
					.equals("Previous")) {
				/*
				 * Have to set some variables in session for pagination.
				 * 
				 * @pageNumber will use to diplay the current page number.
				 * 
				 * @list is the list of article.
				 * 
				 * @startIndex and @endIndex the to display the sub list of
				 * article from main @list
				 * 
				 * @btnNext is for next button @btnPrevious is for previous
				 * button.
				 */
				session.setAttribute("btnNext", "Next");
				session.setAttribute("endIndex",
						(Integer) session.getAttribute("startIndex"));
				session.setAttribute("startIndex",
						(Integer) session.getAttribute("startIndex")
								- perPagesArticles);
				if ((Integer) session.getAttribute("startIndex") <= 0) {
					session.setAttribute("btnPrevious", "Previous Disabled");
					session.setAttribute("btnNext", "Next");
					session.setAttribute("startIndex", 0);
				} else {
					session.setAttribute("btnNext", "Next");
				}
			}
		}
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

	/**
	 * @return List<Article>
	 * @Description This method will prepare the list of article you may right
	 *              the code to get the list from database or some other
	 *              sources.
	 */
	private List<Article> prepareList() {
		list = new ArrayList<Article>();
		list.add(new Article(1, "Winters in India", "Winters in India"));
		list.add(new Article(2, "Winters in India", "Winters in India"));
		list.add(new Article(3, "Winters in India", "Winters in India"));
		list.add(new Article(4, "Winters in India", "Winters in India"));
		list.add(new Article(5, "Winters in India", "Winters in India"));
		list.add(new Article(6, "Winters in India", "Winters in India"));
		list.add(new Article(7, "Winters in India", "Winters in India"));
		list.add(new Article(8, "Winters in India", "Winters in India"));
		list.add(new Article(9, "Winters in India", "Winters in India"));
		list.add(new Article(10, "Winters in India", "Winters in India"));
		list.add(new Article(11, "Winters in India", "Winters in India"));
		list.add(new Article(12, "Winters in India", "Winters in India"));
		list.add(new Article(13, "Winters in India", "Winters in India"));
		list.add(new Article(14, "Winters in India", "Winters in India"));
		list.add(new Article(15, "Winters in India", "Winters in India"));
		list.add(new Article(16, "Winters in India", "Winters in India"));
		list.add(new Article(17, "Winters in India", "Winters in India"));
		list.add(new Article(18, "Winters in India", "Winters in India"));
		list.add(new Article(19, "Winters in India", "Winters in India"));
		list.add(new Article(20, "Winters in India", "Winters in India"));
		return list;
	}

}
