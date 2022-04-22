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

/**
 * Servlet implementation class CandidateLoginBack
 */
@WebServlet("/CandidateLoginBack")
public class CandidateLoginBack extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Dao dao;
	
	public void init() {
		dao = new Dao("jdbc:mysql://localhost:3306/minion", "admin", "password");
	}
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CandidateLoginBack() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		
		ArrayList<Answers> list = null;
		
		if (dao.getConnection()) {
			list = dao.readAnsw(id);
		}
		
		request.setAttribute("answers", list);

		RequestDispatcher rd = request.getRequestDispatcher("/jsp/answerquestioncand.jsp");
		RequestDispatcher rds = request.getRequestDispatcher("/SaveValueButtons");
		rd.forward(request, response);
		rds.forward(request, response);
	}

	
}
