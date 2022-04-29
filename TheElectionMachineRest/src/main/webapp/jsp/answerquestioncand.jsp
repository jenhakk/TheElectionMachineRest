<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<%@ page import= "java.util.ArrayList" %>

<%@ page import="data.Answers"%>
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
		<div class="row" id="row-ansque">

			<div class="col-6">

				<form action="/GetCandId" method="post" class="candform">

					<div class="row" style="margin-bottom: 5px;">
						<div class="col">
							<label for="candi">Candidate</label>
						</div>
						<div class="col">
							<input type="text" id="name" name="name"
								value="${answers.get(0).getLastname()} ${answers.get(0).getFirstname()}"
								disabled="disabled">
						</div>
					</div>

					<div class="row">
						<div class="col">
							<label for="candi_id">Number</label>
						</div>
						<div class="col">
							<input type="text" id="candi_id" name="candi_id"
								value="${answers.get(0).getCandi_id()}" disabled="disabled">
						</div>

					</div>

				</form>

			</div>

			<div class="col-6">
				<a href="/GetCandId?id=${answers.get(0).getCandi_id()}"><div
						class="btn btn-primary" id="but-personal">PERSONAL
						INFORMATION</div></a>

			</div>
		</div>


		<h2 class="answer">Answer questions and submit</h2>
		<form action="/SaveValueButtons" method="POST" class="forminfo">
			<% 
			ArrayList<Answers> answers = (ArrayList<Answers>)request.getAttribute("answers");
			%>
			<input type="hidden" name="answerssize" value="<%=answers.size()%>">
			<% 
			for (int i = 1; i < answers.size()+1; i++)
		
			{
			%>
			

		<!-- Question element starts -->
		
		
			<div>
				<input type="hidden" name="candidate" value="${candi.id}">
				<input type="hidden" id="ques" name="quesid" value="<%=i%>"/>
				
				

			</div>

				
				<p class="question"><%=i%>. <%=answers.get(i-1).getQuestion()%></p>


				<div class="card" id="ques-card">
				
					<div>
						<input type="radio" id="strdis"
							name="ques<%=(answers.get(i-1).getQuess_id())%>" value="1"> 
							<label for="strdis">Strongly disagree</label>

					</div>
					<div>
						<input type="radio" id="dis"
							name="ques<%=(answers.get(i-1).getQuess_id())%>" value="2">
							<label for="dis">Disagree</label>
					</div>
					<div>
						<input type="radio" id="ntrl"
							name="ques<%=(answers.get(i-1).getQuess_id())%>" value="3" checked> 
							<label for="ntrl">Neutral</label>
					</div>
					<div>
						<input type="radio" id="agr"
							name="ques<%=(answers.get(i-1).getQuess_id())%>" value="4"> 
							<label for="agr">Agree</label>
					</div>
					<div>
						<input type="radio" id="stragr"
							name="ques<%=(answers.get(i-1).getQuess_id())%>" value="5"> 
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