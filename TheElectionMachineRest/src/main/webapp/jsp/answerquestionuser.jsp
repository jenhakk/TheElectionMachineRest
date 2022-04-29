<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import= "java.util.ArrayList" %>
<%@ page import="data.Answers"%>
<%@ page import="data.Questions"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous">
<link rel="stylesheet" href="css/style2.css">
<title>Candidates questions</title>
</head>


<body id="candque">

	
	<div class="container">

	<div class="col"><a href="index.html" class="btnhome">HOME</a></div>



		<h2 class="answer">Answer questions and submit</h2>
		
		<form action="/SaveValueButtonsUser" method="POST" class="forminfo">
		<!-- ArrayList from AnswerQuestionsUser-servlets information -->
			<% 
			ArrayList<Questions> questions = (ArrayList<Questions>)request.getAttribute("questions");
			
			%>
			<input type="hidden" name="questionssize" value="<%=questions.size()%>">
			<% 
			// for loop for going through the questions we got
			for (int i = 1; i < questions.size()+1; i++)
		
			{
			%>
			

		<!-- Question element starts -->
		<!-- This jsp-file sends this forms answers to a SaveValueButtonsUser-servlet -->
		
		
			<div>
				<!-- Hidden element to save questionids value -->
				<input type="hidden" id="ques" name="quesid" value="<%=i%>"/>

			</div>

				<!-- questions number and questions in a loop -->
				<p class="question"><%=i%>. <%=questions.get(i-1).getQuestion()%></p>


				<div class="card" id="ques-card">
				
					<div>
						<input type="radio" id="strdis"
							name="ques<%=(questions.get(i-1).getId())%>" value="1"> 
							<label for="strdis">Strongly disagree</label>

					</div>
					<div>
						<input type="radio" id="dis"
							name="ques<%=(questions.get(i-1).getId())%>" value="2">
							<label for="dis">Disagree</label>
					</div>
					<div>
						<input type="radio" id="ntrl"
							name="ques<%=(questions.get(i-1).getId())%>" value="3" checked> 
							<label for="ntrl">Neutral</label>
					</div>
					<div>
						<input type="radio" id="agr"
							name="ques<%=(questions.get(i-1).getId())%>" value="4"> 
							<label for="agr">Agree</label>
					</div>
					<div>
						<input type="radio" id="stragr"
							name="ques<%=(questions.get(i-1).getId())%>" value="5"> 
							<label for="stragr">Strongly agree</label>
					</div>

				</div>
				<br>

				<% } 
									
		 		%>
		<div class="row justify-content-center">	
			<div class="col-2"><button class="btn btn-primary" name="back" onclick="history.back()" style="margin-bottom: 50px;">BACK</button></div>
			<div class="col-2"><button class="btn btn-primary" type="submit" style="margin-bottom: 50px;">SUBMIT</button></div>
		</div>
		
		
		</form>
			
				
				
			
		</div>



	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
		crossorigin="anonymous">
		
	</script>
</body>

</html>