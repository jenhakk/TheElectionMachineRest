package app;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Dao;
import data.Questions;

/**
 * Servlet implementation class AnswerQuestionsUser
 */
@WebServlet("/AnswerQuestionsUser")
public class AnswerQuestionsUser extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private Dao dao = null;

	public void init() {
		dao = new Dao("jdbc:mysql://localhost:3306/minion", "admin", "password");
	}

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AnswerQuestionsUser() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// First new ArrayList for getting election machines questions from a database
		ArrayList<Questions> listq = null;
		// If connection to database is okay, call daos method "readAllQuestion" and
		// save values to a list named listq
		if (dao.getConnection()) {
			listq = dao.readAllQuestions();
		}
		// Send this listq as an attribute to a "answerquestionsuser.jsp"-file
		request.setAttribute("questions", listq);
		RequestDispatcher rd = request.getRequestDispatcher("/jsp/answerquestionuser.jsp");
		rd.forward(request, response);
	}
}