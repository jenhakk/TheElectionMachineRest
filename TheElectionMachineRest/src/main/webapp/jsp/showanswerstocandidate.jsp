<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="data.Answers"%>
<%@ page import="dao.Dao" %>
<%@ page errorPage="error.jsp" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <link rel="stylesheet" href="/css/style2.css">
    <title>Show answers</title>
</head>

<body id="showans" style="background-image: url(/pics/minionsvertical.png); background-repeat: no-repeat;background-position: left 50px bottom 50px;background-size: 25vw;">

    <main class="main_show">
    <div class="col"><a href="/index.html" class="btnhome">HOME</a></div>
    
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

        <h2 class="h2show">Your answers dear ${answers.get(0).getFirstname()} ${answers.get(0).getLastname()}:</h2>
        <div class="container-fluid" id="showcon">

        <table class="table table-bordered" id="tableshow">
            <thead>
                <tr>
                    <th scope="col">#</th>
                    <th scope="col">Question</th>
                    <th scope="col">Your answer</th>
                    <th scope="col">Comment</th>
                </tr>
            </thead>
            <tbody>
            <c:forEach var="ques" items="${requestScope.answers}" varStatus="loop">
                <tr>
                    <th scope="row"><c:out value="${loop.index+1}" /></th>
                    <td><c:out value="${ques.question}" /></td>
                    <td><c:choose><c:when test="${ques.answer==1}">Strongly disagree</c:when> 
                    <c:when test="${ques.answer==2 }">Disagree</c:when>
                    <c:when test="${ques.answer==3 }">Neutral</c:when>
                    <c:when test="${ques.answer==4 }">Agree</c:when>
                    <c:when test="${ques.answer==5 }">Strongly agree</c:when>
                    <c:otherwise>No opinion yet</c:otherwise>
                    </c:choose></td>
                    <th><c:out value="${ques.comment}" /></th>
                </tr>
			</c:forEach>
            </tbody>
        </table>

        <div class="row justify-content-end">
             	<c:choose>
            <c:when test="${answers.get(0).getAnswer() == 0}"><div class="col-3"><a href="/AnswerQuestionsCandidate?id=${answers.get(0).getCandi_id()}" class="btn btn-primary">ANSWER<br>QUESTIONS</a></div></c:when>
            
            <c:when test="${answers.get(0).getAnswer() != 0}"><div class="col-3"><a href="/EditQuestionsCand?id=${answers.get(0).getCandi_id()}" style="display:block;" class="btn btn-primary">EDIT</a></div>
            <div class="col-3"><a href="/DeleteAnswers?id=${answers.get(0).getCandi_id()}&qid=${answers.get(0).getQuess_id()}" class="btn btn-primary">DELETE ANSWERS</a></div></c:when></c:choose>
				
			        
			</div>
        </div>

    </main>




    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous">
    </script>
</body>

</html>