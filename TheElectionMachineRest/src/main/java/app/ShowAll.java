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
import data.Candidate;

/**
 * Servlet implementation class Show
 */
@WebServlet("/ShowAll")
public class ShowAll extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Dao dao = null;

	@Override
	public void init() {
		dao = new Dao("jdbc:mysql://localhost:3306/minion", "admin", "password");
	}

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ShowAll() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// ArrayList Candidate first empty
		ArrayList<Candidate> list = null;
		// If connection to database is true, then use method "readAllCand" to get all
		// candidates information to a list.
		if (dao.getConnection()) {
			list = dao.readAllCand();
		} else {
			System.out.println("No connection to database");
		}
		// add this list to a parameter and sends it to "browsecandidates.jsp"-file
		request.setAttribute("candilist", list);
		RequestDispatcher rd = request.getRequestDispatcher("/jsp/browsecandidates.jsp");
		rd.forward(request, response);

	}

}
