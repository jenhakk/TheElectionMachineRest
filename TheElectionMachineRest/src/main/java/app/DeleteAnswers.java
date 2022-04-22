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

@WebServlet("/DeleteAnswers")
public class DeleteAnswers extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Dao dao;
	
	public void init() {
		dao = new Dao("jdbc:mysql://localhost:3306/minion", "admin", "password");
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// cid = candidate id, qid = question id
		// getting both ids from the form on showanswerstocandidate.jsp
		String cid = request.getParameter("id");
		int qid = Integer.parseInt(request.getParameter("qid"));
		
		// initializing empty Answers arraylist list
		ArrayList<Answers> list = null;
			
		// if getConnection() is successful -> call deleteAnswers(cid)
		if (dao.getConnection()) {
			
			// if deleteAnswers(cid) is successful -> call insertZeroToAnswer(cid, qid)
			if (dao.deleteAnswers(cid) == true ) {
				
				// if insertZeroToAnswer is successful -> call readAnsw(cid) and set list it returns to Arraylist list
				if (dao.insertZeroToAnswer(cid, qid) == true) {
					list = dao.readAnsw(cid);
					System.out.println("readAnsw() true" + cid);
					
				} else {
					System.out.println("readAnsw() false");
				}
				System.out.println("deleteAnswers() true");
			
			} else {
				System.out.println("deleteAnswers() false");
			}
			
		} else {
			System.out.println("No connection to database");
		}

		// sending reseted candidate's answers as list to showanswerstocandidate.jsp via RequestDispatcher
		request.setAttribute("answers", list);
		
		RequestDispatcher rd = request.getRequestDispatcher("/jsp/showanswerstocandidate.jsp");
		rd.forward(request, response);
		
	}
}
