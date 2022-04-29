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
	
	<div class="col" style="position: absolute; left: 0; margin-top:0px;"><a href="/index.html" class="btnhome">HOME</a></div>
	<main class="main_candidate">
	
	


		<div class="container">


			<div class="rowcan1">
				<div class="col">
					<img class="profile_cand" name="pic"
						src="/pics/${requestScope.candper.pic}">



					<p class="candnumber">${requestScope.candper.candi_id}</p>
					<h2 class="candname">${requestScope.candper.firstname}
						${requestScope.candper.lastname}</h2>
				</div>
			</div>
			
			<div class="card">

				<div class="row-info">
					<div class="col-12">
						<div class="textbox">
							<p>
								<span class="party" style="">${requestScope.candper.party}</span>
							</p>
							<p class="age">Age: ${requestScope.candper.age}</p>
							<p class="city">Municipality: ${requestScope.candper.municipality}</p>
							<p class="profession">Profession: ${requestScope.candper.profession}</p>

						</div>
					</div>

					<div class="row-prom">
						<div class="col-12">
							<p class="promote">What I promote: <br><br>"${requestScope.candper.promo}"</p>

						</div>

					</div>
				</div>


			</div>

			<div class="row justify-content-center">
			<div class="col-3">
				<button type="button" class="btn btn-primary" name="back" onclick="history.back()" style="margin-bottom:50px;">BACK</button>
			</div>
			
			<div class="col-3">
			
				<a href="/ShowInfoForm?id=${candper.candi_id}" class="btn btn-primary" style="margin-bottom:50px;">EDIT</a>
			</div>
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