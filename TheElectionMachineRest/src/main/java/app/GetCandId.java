//Servlet for getting all info from particular candidate by id
//Gets the id from answerquestioncand.jsp from upper left corner form
//with Personal Information button

//Sends info to candpersonal.jsp
package app;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Dao;
import data.Answers;
import data.Candidate;

/**
 * Servlet implementation class GetCandId
 */
@WebServlet("/GetCandId")
public class GetCandId extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Dao dao = null;

	@Override
	public void init() {
		dao = new Dao("jdbc:mysql://localhost:3306/minion", "admin", "password");
	}

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public GetCandId() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("id");
		
		Answers caninfo = null;
		if (dao.getConnection()) {
			caninfo = dao.readAns(id);
		}
		
		request.setAttribute("candper", caninfo);

		RequestDispatcher rd = request.getRequestDispatcher("/jsp/candpersonal.jsp");
		rd.forward(request, response);
	}
}
