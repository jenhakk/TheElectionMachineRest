package rest;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import dao.Daojpa;
import datarest.Questions;


@Path("/questions")
public class Rest {
	
	
	@GET
	@Path("/getquestions")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public void getQuestions(@Context HttpServletRequest request, @Context HttpServletResponse response) {
		List list=Daojpa.getQuestions();
		request.setAttribute("questions", list);
		RequestDispatcher rd = request.getRequestDispatcher("/jsp/browsequestions.jsp");
		
		try {
			rd.forward(request, response);
		} catch (ServletException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	@POST
	@Path("/addquestion")
	@Produces(MediaType.APPLICATION_XHTML_XML)
	@Consumes("application/x-www-form-urlencoded") //Method can receive POSTed data from a html form
	public List<Questions> addQuestion(@FormParam("question") String question, @Context HttpServletRequest request, @Context HttpServletResponse response) {	
		Questions q = new Questions(question);
		System.out.println("happens");
		request.setAttribute("questions", Daojpa.addQuestion(q));
		RequestDispatcher rd = request.getRequestDispatcher("/jsp/browsequestions.jsp");
		try {
			rd.forward(request, response);
		} catch (ServletException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return Daojpa.addQuestion(q);
				
	}
}
