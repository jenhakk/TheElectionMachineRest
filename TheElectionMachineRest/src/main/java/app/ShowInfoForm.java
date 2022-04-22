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

/**
 * Servlet implementation class ShowInfoForm
 */
@WebServlet("/ShowInfoForm")
public class ShowInfoForm extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Dao dao = null;

	@Override
	public void init() {
		dao = new Dao("jdbc:mysql://localhost:3306/minion", "admin", "password");
	}

       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowInfoForm() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		Answers caninfo = null;
		if (dao.getConnection()) {
			caninfo = dao.readAns(id);
		}
		
		request.setAttribute("candform", caninfo);

		RequestDispatcher rd = request.getRequestDispatcher("/jsp/candform.jsp");
		rd.forward(request, response);
	}

	

}
