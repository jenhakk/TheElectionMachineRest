package app;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

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
 * Servlet implementation class SaveValueButtonsUser
 */
@WebServlet("/SaveValueButtonsUser")
public class SaveValueButtonsUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Dao dao = null;

	public void init() {
		dao = new Dao("jdbc:mysql://localhost:3306/minion", "admin", "password");
	}

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SaveValueButtonsUser() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@SuppressWarnings({ "null", "unchecked" })
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// new ArrayList to store end user's answers
		ArrayList<Integer> userlist = new ArrayList<Integer>();

		// loop through the number of questions
		for (int i = 1; i < 11; i++) {

			// search the answers value (i) from the jsp-file "answerquestionsuser"
			int answer = Integer.parseInt(request.getParameter("ques" + (i)));

			// add the answer to a list "userlist"
			userlist.add(answer);

		}
		// new linkedhashmap candpoints to save the three best candidates for the end user  
		LinkedHashMap<Integer, Integer> candpoints = new LinkedHashMap<Integer, Integer>();
		
		// Call method SortCandidatesByPoints, give candpoints and userlist as a parameter, save result to candpoints
		candpoints = SortCandidatesByPoints(candpoints, userlist);

		//Create entryset for candpoints
		Set<Map.Entry<Integer, Integer>> entrySet = candpoints.entrySet();

		//Create iterators for keys and values
		Iterator<Map.Entry<Integer, Integer>> iteratorK = entrySet.iterator();
		Iterator<Map.Entry<Integer, Integer>> iteratorV = entrySet.iterator();

		// Initialize variables for iteration
		int i = 0;
		int index = 1;
		
		//keys
		int cand1 = 0;
		int cand2 = 0;
		int cand3 = 0;
		
		//values (points)
		int cand1p = 0;
		int cand2p = 0;
		int cand3p = 0;

		// get first three keys from map
		while (iteratorK.hasNext()) {

			if (index - 1 == i) {
				cand1 = iteratorK.next().getKey();
				cand2 = iteratorK.next().getKey();
				cand3 = iteratorK.next().getKey();
				break;
			}
		}

		// get first three values from map
		while (iteratorV.hasNext()) {

			if (index - 1 == i) {
				cand1p = iteratorV.next().getValue();
				cand2p = iteratorV.next().getValue();
				cand3p = iteratorV.next().getValue();
				break;
			}
		}

		// Multiply points by 10 to get percentage values
		cand1p = cand1p*10;
		cand2p = cand2p*10;
		cand3p = cand3p*10;
		
		// Change keys to Strings
		String cand1str = Integer.toString(cand1);
		String cand2str = Integer.toString(cand2);
		String cand3str = Integer.toString(cand3);
		
		// Change values to Strings
		String cand1pstr = Integer.toString(cand1p);
		String cand2pstr = Integer.toString(cand2p);
		String cand3pstr = Integer.toString(cand3p);
	
		// Create ArrayList for top three candidates, candidates answers and points
		ArrayList<String> top3 = new ArrayList<String>();
		ArrayList<Candidate> cands = new ArrayList<Candidate>();
		ArrayList<String> pointslist = new ArrayList<String>();
		
		// Add candidates (keys) to top3 list
		top3.add(cand1str);
		top3.add(cand2str);
		top3.add(cand3str);
		
		// Add candidates points (values) to list
		pointslist.add(cand1pstr);
		pointslist.add(cand2pstr);
		pointslist.add(cand3pstr);
		
		// If dao gets connection 
		if (dao.getConnection()) {
			
			// Send top3 and pointslist to dao method to get candidates info
			// Save top3 candidates info from database to a list
			 cands = dao.readAllTopThree(top3, pointslist);

		
		} else {

			System.out.println("dao is not working!");
		}

		request.setAttribute("top", cands);
	
		RequestDispatcher rd = request.getRequestDispatcher("/jsp/suitablecandidates.jsp");
		rd.forward(request, response);

		
		
	
	}

	
	// Method that get candidates answer from database into a list, takes candidates id as a paramater
	private ArrayList<Integer> getCandidatesAnswers(int y) {

		// Create new list from Answers that will save candidates answers from database as objects
		ArrayList<Answers> clist = new ArrayList<Answers>();

		// Initialize Integer ArrayList for saving candidates answers as integers
		ArrayList<Integer> ansintlist = new ArrayList<Integer>();

		if (dao.getConnection()) {

			// get candidates answers from database into a list (objects)
			clist = dao.readCandAns(y);

			// Create object from Answers class that is used to loop through list of objects
			for (Answers ans : clist) {

				// luodaan int-muuttuja johon haetaan vastaus int-muodossa
				// initialize variable to save answer from object 
				int answers = ans.getAnswer();

				// add answers to list one by one
				ansintlist.add(answers);

			}

		}
		
		// return answers as a integer list
		return ansintlist;

	}

	
	// Method that compares end users and candidates answers, takes users answers as a list and candidates id as parameters
	// returns number of matching answers
	private Integer compareAnswers(ArrayList<Integer> ulist, int can) {

		ArrayList<Integer> candintlist = new ArrayList<Integer>();
		
		// call method getCandidatesAnswers and save values to list
		candintlist = getCandidatesAnswers(can);

		// Initialize variable for matching answers
		int a = 0;

		// Loop through lists by indexes
		for (int i = 0; i < ulist.size(); i++) {

			// get both lists indexes and compare those, save boolean value in to a variable
			boolean isEqual = ulist.get(i).equals(candintlist.get(i));
	
			// If answer matches, increase value by one
			if (isEqual == true) {

				a++;
			}

		}

		// return number of matching answers
		return a;
	}


	// 1. First called method, maps the candidates and their points as ascending order
	private LinkedHashMap SortCandidatesByPoints(LinkedHashMap<Integer, Integer> candpoints,
			ArrayList<Integer> userlist) {

		// candidate number
		int candidate = 1;

		// loop through the number of candidates, at this point we got seven candidates
		for (int j = 0; j < 7; j++) {

			// Initialize new variable where save similar answers of candidate and end-user, method "compareAnswers" is called, it gets
			// userlist and candidates id-numbers as a parameter
			int points = compareAnswers(userlist, candidate);

			// Add candidate and its points to a candpoints list
			candpoints.put(candidate, points);

			// next candidate
			candidate++;
		}
		// print candidates and them points
		for (Map.Entry<Integer, Integer> m : candpoints.entrySet()) {
			System.out.println("candidate " + m.getKey() + " " + "points " + m.getValue());
		}

		// This part is from internet and we don't fully understand what is happening in every point. 
		// Basically it sorts list by values in ascending order
		// https://www.benchresources.net/java-how-to-sort-linkedhashmap-by-its-values/
		Set<Map.Entry<Integer, Integer>> CandidateOrder = candpoints.entrySet();

		List<Map.Entry<Integer, Integer>> CandidateOrderListEntry = new ArrayList<Map.Entry<Integer, Integer>>(
				CandidateOrder);

		Collections.sort(CandidateOrderListEntry, new Comparator<Map.Entry<Integer, Integer>>() {

			@Override
			public int compare(Entry<Integer, Integer> es1, Entry<Integer, Integer> es2) {
				return es2.getValue().compareTo(es1.getValue());
			}
		});

		candpoints.clear();

		for (Map.Entry<Integer, Integer> map : CandidateOrderListEntry) {
			candpoints.put(map.getKey(), map.getValue());
		}

		for (Map.Entry<Integer, Integer> lhmap : candpoints.entrySet()) {
			System.out.println("Key : " + lhmap.getKey() + "\t\t" + "Value : " + lhmap.getValue());

		}

		return candpoints;

	}

}
