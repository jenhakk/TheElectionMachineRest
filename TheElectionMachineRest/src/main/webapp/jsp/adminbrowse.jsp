<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="data.Candidate"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous">
<link rel="stylesheet" href="/css/style2.css">
<meta name='viewport' content='width=device-width, initial-scale=1'>
<title>Browse Candidates</title>
</head>
<body id="browse">

	<main class="main_browse">
	
	<div class="col"><a href="/adminhome.html" class="btnhome">HOME</a></div>
		<h1>Candidates</h1>
		
		<h2 style="margin-bottom: 50px;">Choose a candidate to edit or delete them</h2>

		<div class="container-fluid">

			
			<!-- This forEach gets info from ShowAll.java-file, makes a loop to go through every candidate -->
			<c:forEach var="cand" items="${requestScope.candidates}">
			
				
				<div class="card" id="card-cand"><a href="/rest/questions/showcandidate/${cand.candidate_id}">

					<div class="row no-gutters">
						<div class="col-4">

							<div class="image">
								<img class="profile" src="<c:out value="${cand.pic}"/>">
							</div>
							<p class="candnum">
								<c:out value="${cand.candidate_id}" />
							</p>
						</div>
						<div class="col-7">
							<div class="card-body">
								<h5 class="card-title">
									<c:out value="${cand.lname}" />
									<c:out value="${cand.fname}" />
								</h5>
								<p class="card-text">
									"
									<c:out value="${cand.promo}" />
									"
								</p>
							</div>

						</div>
						<div class="col-1">
							<img class="arrow" src="/pics/chevron-right.svg"></img>
						</div>


					</div>

					</a>
				</div>
				<br>	

				<!-- -------Candidate element ends---------- -->
			</c:forEach>

			<div class="row justify-content-center">
            
            <div class="col-3"><a href="/../jsp/addcandidate.jsp" class="btn btn-primary">ADD NEW CANDIDATE</a></div>

        </div>

		</div>



	</main>


	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
		crossorigin="anonymous">
		
	</script>

</body>

</html>
