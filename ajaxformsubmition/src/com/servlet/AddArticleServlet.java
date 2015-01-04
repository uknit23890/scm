package com.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
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
 * Servlet implementation class CrudServlet
 * 
 * @author Vinay Singh Rawat
 */
public class AddArticleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		try {
			HttpSession session = request.getSession();
			List<Article> articles = getArticle();
			session.setAttribute("articles", articles);
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("error", e.getMessage());
		}
		request.getRequestDispatcher("article.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		try {
			String title = request.getParameter("title");
			String content = request.getParameter("content");
			Article article = new Article(title, content);
			// Validating article data for null or empty
			if (title == null || title.equals("")) {
				request.setAttribute("error", "Title required!");
			} else if (content == null || content.equals("")) {
				request.setAttribute("error", "Content required!");
			} else {
				// Saving article in database
				boolean isSaved = saveArticle(article);
				if (isSaved) {
					request.setAttribute("msg", "Article saved successfuly");
					List<Article> articles = getArticle();
					session.setAttribute("articles", articles);

				} else {
					request.setAttribute("msg", "Article failed to save!");
				}
			}
		} catch (Exception e) {
			request.setAttribute("error", e.getMessage());
			e.printStackTrace();
		}
		request.getRequestDispatcher("result.jsp").forward(request, response);
	}

	/**
	 * This method is to save article in database
	 * 
	 * @param title
	 * @param content
	 * @return boolean
	 * @throws Exception
	 */
	private boolean saveArticle(Article article) throws Exception {
		Connection con = null;
		try {
			con = DBManager.getConnection();
			String query = "insert into article (title,content) values(?,?)";
			PreparedStatement stmt = con.prepareStatement(query);
			stmt.setString(1, article.getTitle());
			stmt.setString(2, article.getContent());
			int result = stmt.executeUpdate();
			if (result == 1) {
				return true;
			} else {
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		} finally {
			if (con != null)
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}
	}

	/**
	 * To get all articles from database
	 * 
	 * @return List<Article>
	 * @throws Exception
	 */
	private List<Article> getArticle() throws Exception {
		Connection con = null;
		List<Article> articles = new ArrayList<Article>();
		try {
			con = DBManager.getConnection();
		} catch (Exception e) {
			throw e;
		}
		try {
			Statement stmt = con.createStatement();
			ResultSet rs = stmt
					.executeQuery("select * from article order by id desc");
			while (rs.next()) {
				Article article = new Article();
				article.setId(rs.getInt("id"));
				article.setTitle(rs.getString("title"));
				article.setContent(rs.getString("content"));
				articles.add(article);
			}
		} catch (SQLException se) {
			throw new Exception(se.getMessage());
		} finally {
			if (con != null)
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}
		return articles;
	}

}
