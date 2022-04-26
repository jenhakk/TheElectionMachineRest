package rest;

import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
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
		List list = Daojpa.getQuestions();
		request.setAttribute("questions", list);
		RequestDispatcher rd = request.getRequestDispatcher("/jsp/browsequestions.jsp");

		try {
			rd.forward(request, response);
		} catch (ServletException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	// ************************Methods for editing questions*******************************
	//Gets question-to-edit id from browsequestions.jsp, sends it to Daojpa and gets the question object back. Sends it to editquestion.jsp in to a textfield
	@GET
	@Path("/showquestion/{question_id}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public void getOneQuestion(@PathParam("question_id") int ques_id, @Context HttpServletRequest request,
			@Context HttpServletResponse response) {

		Questions quesid = Daojpa.readQuestion(ques_id);
		request.setAttribute("question", quesid);
		RequestDispatcher rd = request.getRequestDispatcher("/jsp/editquestion.jsp");

		try {
			rd.forward(request, response);
		} catch (ServletException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//Reads form from editquestion.jsp with POST-method and FormParams, makes a new object from it and sends it to Daojpa for updating the question. 
	//Gets back all the questions from database into a list and sends it to browsequestions.jsp 
	@POST
	@Path("/updatequestion")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes("application/x-www-form-urlencoded")
	public void updateQuestionWithForm(@FormParam("question_id") int quesid, @FormParam("question") String question, @Context HttpServletRequest request,
			@Context HttpServletResponse response) {
				
		Questions ques = new Questions(quesid, question);
		List queslist = Daojpa.updateQuestion(ques);
		
		request.setAttribute("questions", queslist);
		RequestDispatcher rd = request.getRequestDispatcher("/jsp/browsequestions.jsp");

		try {
			rd.forward(request, response);
		} catch (ServletException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	// ***************************************************************************************
}
