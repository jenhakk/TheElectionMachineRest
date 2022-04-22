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
import data.Answers;
import data.Candidate;
import data.Questions;

/**
 * Servlet implementation class EditQuestionsCand
 */
@WebServlet("/EditQuestionsCand")
public class EditQuestionsCand extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Dao dao = null;

	public void init() {
		dao = new Dao("jdbc:mysql://localhost:3306/minion", "admin", "password");
	}
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditQuestionsCand() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");

		ArrayList<Answers> list = null;
		ArrayList<Questions> listq = null;
		Candidate can = null;
		Questions q = null;
		Answers a = null;
		

		if (dao.getConnection()) {
			list = dao.readAnsw(id);
			a = dao.readAns(id);
			listq = dao.readAllQuestions();
			can = dao.readCandi(id);

		}
		// System.out.println(list);
		System.out.println("listQ" + listq);

		request.setAttribute("ans", a);
		request.setAttribute("candi", can);
		request.setAttribute("answers", list);
		request.setAttribute("oikea", listq);

		RequestDispatcher rd = request.getRequestDispatcher("/jsp/editquestionscand.jsp");
		rd.forward(request, response);
	}

}
