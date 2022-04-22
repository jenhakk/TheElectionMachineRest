package app;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import data.Candidate;
import dao.Dao;

/**
 * Servlet implementation class ShowSpesificCandidate
 */
@WebServlet("/ShowSpesificCandidate")
public class ShowSpesificCandidate extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Dao dao;

	public void init() {
		dao = new Dao("jdbc:mysql://localhost:3306/minion", "admin", "password");
	}

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ShowSpesificCandidate() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */

	// Here we get the details of picked candidate, so the candidate_id
	// comes from browsecandidates.jsp-file
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		// This String id gets the parameter "id" from the browsecandidates.jsp-file
		String id = request.getParameter("id");
		// Object candidate is first empty
		Candidate candi = null;
		// if we get connection, then call readCandi-method, set id for a parameter to get
		// this candidates info back
		if (dao.getConnection()) {
			// send id number to readCandi-method
			candi = dao.readCandi(id);
		}
		// set this "candi" object to be sent to the candidatedetails.jsp-file
		request.setAttribute("candidate", candi);
		RequestDispatcher rd = request.getRequestDispatcher("/jsp/candidatedetails.jsp");
		rd.forward(request, response);

	}

}
