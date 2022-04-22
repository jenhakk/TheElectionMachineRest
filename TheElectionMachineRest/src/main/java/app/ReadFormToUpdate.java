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
 * Servlet implementation class ReadFormToUpdate
 */
@WebServlet("/ReadFormToUpdate")
public class ReadFormToUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Dao dao=null;
	
	@Override
	public void init() {
		dao = new Dao("jdbc:mysql://localhost:3306/minion", "admin", "password");
	}   
           
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReadFormToUpdate() {
        super();
        // TODO Auto-generated constructor stub
    }

    @Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) 
	     throws IOException {
		response.sendRedirect("/jsp/candprofile.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id = request.getParameter("id");
		System.out.println("readform" + id);
		String pic = request.getParameter("pic");
		String fname = request.getParameter("fname");
		String name = request.getParameter("lname");
		String party = request.getParameter("party");
		String municipality = request.getParameter("munic");
		String age = request.getParameter("age");
		String profession = request.getParameter("prof");
		String promo = request.getParameter("promo");
		int idst = Integer.parseInt(id);
		
		Answers can = new Answers(idst, name, fname, promo, pic, age, municipality, profession, party);
		
		Answers list = null;
		
		if (dao.getConnection()) {
			
			list = dao.UpdateCandidate(can);
			
		}
		
		request.setAttribute("candper", can);
		RequestDispatcher rd = request.getRequestDispatcher("/jsp/candpersonal.jsp");
		rd.forward(request, response);
		
		
		
	}

}
