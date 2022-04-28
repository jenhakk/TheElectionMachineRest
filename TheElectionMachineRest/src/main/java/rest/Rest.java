package rest;

import java.io.IOException;
import java.util.ArrayList;
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

import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import dao.Daojpa;
import datarest.Candidates;
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
	
//	//Reads form from editquestion.jsp with POST-method and FormParams, makes a new object from it and sends it to Daojpa for updating the question. 
//	//Gets back all the questions from database into a list and sends it to browsequestions.jsp 
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

	@POST
	@Path("/addquestion")
	@Produces(MediaType.APPLICATION_XHTML_XML)
	@Consumes("application/x-www-form-urlencoded") //Method can receive POSTed data from a html form
	public void addQuestion(@FormParam("question") String question, @Context HttpServletRequest request, @Context HttpServletResponse response) {	
		Questions q = new Questions(question);
		System.out.println("happens");
		List questions = Daojpa.addQuestion(q);
		Daojpa.addAnswerZeroToNewQuestion();
		request.setAttribute("questions", questions);
		RequestDispatcher rd = request.getRequestDispatcher("/jsp/browsequestions.jsp");
		try {
			rd.forward(request, response);
		} catch (ServletException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}			
	}
	
	// Removes a question and answers related to given question id. Lastly refreshes the page by reading questions from the database and sending them to browsequestions.jsp.
	// Gets question id from browsequestions.jsp and uses it as a parameter for daojpa.deleteQuestion().
	// If question is deleted successfully, is daojpa.getQuestions() called and it's returned value ('list') is saved to a 'list' (created earlier).
	// Then the list is forwarded by RequestDispatcher as request back to browsequestions.jsp 
	@GET
	@Path("/deletequestion/{question_id}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public void deleteQuestion(@PathParam("question_id") int question_id,
			@Context HttpServletRequest request,
			@Context HttpServletResponse response) {
		
		List<Questions> list = new ArrayList<Questions>();
		
		if (Daojpa.deleteQuestion(question_id) == true) {
			 list = Daojpa.getQuestions();
		
		} else {
			System.out.println("Failed to delete the question.");
		}
		
		RequestDispatcher rd = request.getRequestDispatcher("/jsp/browsequestions.jsp");
		request.setAttribute("questions", list);
		
		try {
			rd.forward(request, response);
			
		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}
	}
	
	// ************************Methods for editing candidates*******************************
	
	//Gets all candidates from database with Daojpa's getCandidates() into a list and sends it to adminbrowse.jsp
	@GET
	@Path("/getcandidates")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public void getCandidates(@Context HttpServletRequest request, @Context HttpServletResponse response) {
		List list = Daojpa.getCandidates();
		request.setAttribute("candidates", list);
		RequestDispatcher rd = request.getRequestDispatcher("/jsp/adminbrowse.jsp");

		try {
			rd.forward(request, response);
		} catch (ServletException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	//Gets candidate's id by @PathParam from adminbrowse.jsp, gets the candidate's info from database with Daojpa's readCandidate()
	//and sends it forward to adminviewcand.jsp
	@GET
	@Path("/showcandidate/{candidate_id}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public void getOneCandidate(@PathParam("candidate_id") int cand_id, @Context HttpServletRequest request,
			@Context HttpServletResponse response) {

		Candidates candid = Daojpa.readCandidate(cand_id);
		request.setAttribute("candidate", candid);
		RequestDispatcher rd = request.getRequestDispatcher("/jsp/adminviewcand.jsp");

		try {
			rd.forward(request, response);
		} catch (ServletException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	//Gets candidate's id by @PathParam from adminviewcand.jsp, gets the candidate's info from database with Daojpa's readCandidate()
		//and sends it forward to editcandidate.jsp
	@GET
	@Path("/editcandidate/{candidate_id}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public void getOneCandidatetoForm(@PathParam("candidate_id") int cand_id, @Context HttpServletRequest request,
			@Context HttpServletResponse response) {

		Candidates candid = Daojpa.readCandidate(cand_id);
		request.setAttribute("candform", candid);
		RequestDispatcher rd = request.getRequestDispatcher("/jsp/editcandidate.jsp");

		try {
			rd.forward(request, response);
		} catch (ServletException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//Gets candidates edited info by @FormParams from editcandidate.jsp, 
	//saves them to new Candidates object and sends it to Daojpa which makes the update to database and returns updated info from database
	//and sends it to adminviewcand.jsp
	
	@POST
	@Path("/updatecandidate")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes("application/x-www-form-urlencoded")
	public void updateCandidateWithForm(@FormParam("id") int candid, @FormParam("pic") String pic,@FormParam("fname") String fname, @FormParam("lname") String lname, 
			@FormParam("party") String party, @FormParam("munic") String munic, @FormParam("age") String age, @FormParam("prof") String prof, @FormParam("promo") String promo,@Context HttpServletRequest request,
			@Context HttpServletResponse response) {
				
		System.out.println(candid + lname + fname + pic + party + munic + age + prof + party);
		Candidates cand = new Candidates(candid, lname, fname, pic, party, munic, age, promo, prof);
		cand = Daojpa.updateCandidate(cand);
		
		request.setAttribute("candidate", cand);
		RequestDispatcher rd = request.getRequestDispatcher("/jsp/adminviewcand.jsp");

		try {
			rd.forward(request, response);
		} catch (ServletException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//********************************************************************************************************************
	
	// Removes a candidate and answers related to given question id. Lastly refreshes the page by reading questions from the database and sending them to adminbrowse.jsp.
		// Gets candidate id from browsecandidates.jsp and uses it as parameter for daojpa.deleteCandidate().
		// If a candidate is deleted successfully, is daojpa.getCandidates() called and it's returned value ('list') is saved to a 'list' (created earlier).
		// Then the list is forwarded by RequestDispatcher as request back to adminbrowse.jsp 
		@GET
		@Path("/deletecandidate/{candidate_id}")
		@Produces(MediaType.APPLICATION_JSON)
		@Consumes(MediaType.APPLICATION_JSON)
		public void deleteCandidate(@PathParam("candidate_id") int candidate_id,
				@Context HttpServletRequest request,
				@Context HttpServletResponse response) {
				
			List<Candidates> list = new ArrayList<Candidates>();
			
			if (Daojpa.deleteCandidate(candidate_id) == true) {
				list = Daojpa.getCandidates();
			
			} else {
				System.out.println("Failed to delete the candidate.");
			}
			
			RequestDispatcher rd = request.getRequestDispatcher("/jsp/adminbrowse.jsp");
			request.setAttribute("candidates", list);
			
			try {
				rd.forward(request, response);
				
			} catch (ServletException | IOException e) {
				e.printStackTrace();
			}
		}
}
