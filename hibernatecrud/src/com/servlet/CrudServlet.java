package com.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bean.Article;
import com.bean.Entity;
import com.dao.BackEndDao;

/**
 * Servlet implementation class CrudServlet
 * @author Vinay Singh Rawat
 */
public class CrudServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private HttpSession session = null;
	private HttpServletRequest request;
	private BackEndDao backEndDao = null;

	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		backEndDao = new BackEndDao();
		super.init();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("btnValue", "Add Article");
		request.setAttribute("action", "add");
		request.setAttribute("cancelUpdate", "none");
		try {
			session = request.getSession();
			List<Entity> list = backEndDao.getEntityList(Article.class);
			session.setAttribute("list", list);
			request.getRequestDispatcher("article.jsp").forward(request,
					response);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		this.request = request;
		session = request.getSession();
		// get the operation to be performed
		String action = request.getParameter("action");
		if (action != null && action.equals("add")) {
			// Get the form parameters
			String title = request.getParameter("title");
			String content = request.getParameter("content");

			// Instantiate an article object
			Article article = new Article(title, content);
			if (!validate(article)) {
				request.setAttribute("action", "add");
				request.setAttribute("btnValue", "Add Article");
				request.setAttribute("cancelUpdate", "none");
				request.getRequestDispatcher("article.jsp").forward(request,
						response);
				return;
			}
			try {
				// Add article in data base.
				backEndDao.addEntity(article);
				request.setAttribute("msg", "Successfuly added");
			} catch (Exception e) {
				request.setAttribute("msg", "Some error!");
				e.printStackTrace();
			} finally {
				request.setAttribute("action", "add");
				request.setAttribute("btnValue", "Add Article");
				request.setAttribute("cancelUpdate", "none");
			}
		} else if (action != null && action.equals("delete")) {
			String id = request.getParameter("id");
			try {
				// Add article in data base.
				backEndDao.deleteEntity(Long.parseLong(id), Article.class);
				request.setAttribute("msg", "Article deleted");

			} catch (Exception e) {
				request.setAttribute("msg", "Some error!");
				e.printStackTrace();
			} finally {
				request.setAttribute("action", "add");
				request.setAttribute("btnValue", "Add Article");
				request.setAttribute("cancelUpdate", "none");
			}

		} else if (action != null && action.equals("edit")) {
			String id = request.getParameter("id");
			try {
				// get article from data base.
				Article article = (Article) backEndDao.getEntity(
						Long.parseLong(id), Article.class);
				request.setAttribute("article", article);
				request.setAttribute("action", "update");
				request.setAttribute("btnValue", "Update Article");

			} catch (Exception e) {
				request.setAttribute("msg", "Some error!");
				request.setAttribute("action", "add");
				request.setAttribute("btnValue", "Add Article");
				e.printStackTrace();
			}

		} else if (action != null && action.equals("update")) {
			// Get the form parameters
			String id = request.getParameter("id");
			String title = request.getParameter("title");
			String content = request.getParameter("content");
			// Instantiate an article object
			Article article = new Article(Long.parseLong(id), title, content);
			if (!validate(article)) {
				request.setAttribute("article", article);
				request.setAttribute("action", "update");
				request.setAttribute("btnValue", "Update Article");
				request.getRequestDispatcher("article.jsp").forward(request,
						response);
				return;
			}
			try {
				// updating article into data base.
				backEndDao.updateEntity(Article.class, article);
				request.setAttribute("action", "add");
				request.setAttribute("btnValue", "Add Article");
				request.setAttribute("msg", "Article updated");
				request.setAttribute("cancelUpdate", "none");

			} catch (Exception e) {
				request.setAttribute("msg", "Some error!");
				request.setAttribute("article", article);
				request.setAttribute("action", "update");
				request.setAttribute("btnValue", "Update Article");
				e.printStackTrace();
			}

		}
		try {
			List<Entity> list = backEndDao.getEntityList(Article.class);
			session.setAttribute("list", list);
			request.getRequestDispatcher("article.jsp").forward(request,
					response);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private boolean validate(Article article) {
		request.setAttribute("article", article);
		if (article.getTitle() == null || article.getTitle().equals("")) {
			request.setAttribute("error", "Article title required");
			return false;
		} else if (article.getContent() == null
				|| article.getContent().equals("")) {
			request.setAttribute("error", "Article content required");
			return false;
		} else {
			return true;
		}
	}
}
