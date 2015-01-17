package com.servlet;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.bean.Paper;
import com.bean.Question;
import com.dao.BackEndDao;
import com.dao.IGenericBackEndDao;

/**
 * Servlet implementation class AddPaperServlet
 */
public class AddPaperServlet extends HttpServlet {
	private static final long serialVersionUID = -1397627319584608501L;
	private IGenericBackEndDao<Paper> backEndDao = null;

	@Override
	public void init() throws ServletException {
		backEndDao = new BackEndDao();
		super.init();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// Getting data from post request
		String paperName = request.getParameter("paperName");
		String description = request.getParameter("description");
		String ques1 = request.getParameter("question1");
		String answer1 = request.getParameter("answer1");
		String ques2 = request.getParameter("question2");
		String answer2 = request.getParameter("answer2");
		// Preparing Object of paper.
		Paper paper = new Paper(paperName, description);
		// Preparing Objects of questions.
		Question question1 = new Question(ques1, answer1);
		Question question2 = new Question(ques2, answer2);
		// Preparing Set of questions.
		Set<Question> questions = new HashSet<Question>();
		questions.add(question1);
		questions.add(question2);
		// Adding set of questions in paper
		paper.setQuestions(questions);

		try {
			/***
			 * Adding paper along with question here: following queries will be
			 * executed here : Hibernate: select max(PID) from PAPER Hibernate:
			 * select max(QID) from QUESTIONS Hibernate: insert into PAPER
			 * (PAPERNAME, DESCRIPTION, PID) values (?, ?, ?) Hibernate: insert
			 * into QUESTIONS (QUESTION, ANSWER, QID) values (?, ?, ?)
			 * Hibernate: insert into QUESTIONS (QUESTION, ANSWER, QID) values
			 * (?, ?, ?) Hibernate: update QUESTIONS set PID=? where QID=?
			 * Hibernate: update QUESTIONS set PID=? where QID=?
			 ***/
			backEndDao.addEntity(paper);
			request.setAttribute("msg",
					"Paper along with questions has been added successfuly");
		} catch (Exception e) {
			request.setAttribute("msg", e.getMessage());
			e.printStackTrace();
		}
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

}
