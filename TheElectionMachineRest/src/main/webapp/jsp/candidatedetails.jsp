<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

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
<link rel="stylesheet" href="/css/style2.css">
<title>Candidate</title>
</head>
<body id="candidate">
	
	<div class="row">
	<div class="col" style="position: absolute; left: 0; margin-top:0px; margin-right: 10px;"><a href="/index.html" class="btnhome">HOME</a></div>
	<div class="col" style="position: absolute; left: 180px"; margin-top:0px;><a href="/ShowAll" class="btn btn-primary" onclick="history.back()">BACK</a></div>
	
	</div>
	<main class="main_candidate">

		<div class="container">

			<!-- Here we use requestScope to get info from the ShowSpesificCandidate-servlet. There we have made a request and set attributes "candidate" and object candi
			     in it. Now we can use this objects details here in this .jsp-file. -->
			<div class="rowcan1">
				<div class="col">
					<img class="profile_cand" name="pic"
						src="/pics/${requestScope.candidate.pic}">



					<p class="candnumber">${requestScope.candidate.id}</p>
					<h2 class="candname">${requestScope.candidate.name}
						${requestScope.candidate.fname}</h2>
				</div>
			</div>
			
			<div class="card">

				<div class="row-info">
					<div class="col-12">
						<div class="textbox">
							<p>
								<span class="party" style="">${requestScope.candidate.party}</span>
							</p>
							<p class="age">Age: ${requestScope.candidate.age}</p>
							<p class="city">Municipality: ${requestScope.candidate.municipality}</p>
							<p class="profession">Profession: ${requestScope.candidate.profession}</p>

						</div>
					</div>

					<div class="row-prom">
						<div class="col-12">
							<p class="promote">What I promote: <br><br>"${requestScope.candidate.promo}"</p>

						</div>

					</div>
				</div>


			</div>

			<!-- Not sure if we want to have this, can be deleted later -->
			<div class="col">
			
			<!-- link to next servlet, which get candidates answers from a database. Send candidates id-number with the link-->
				<a href="/ShowAnswersToUser?id=${candidate.id}" class="btn btn-primary">CHECK
					CANDIDATES ANSWERS</a>
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