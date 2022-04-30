<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="data.Answers"%>
<%@ page import="dao.Dao" %>

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
    <div class="row">
	<div class="col" style="position: absolute; left: 0; margin-top:0px; margin-right: 10px;"><a href="/index.html" class="btnhome">HOME</a></div>
	<div class="col"><button type="button" class="btn btn-primary" name="back" onclick="history.back()" style="position: absolute; left: 180px;">BACK</button></div>
	</div>
		
        <h2 class="h2show"> </h2>
      
        <!-- Here we get name of the candidate from servlets "ShowAnswersToUser" ArrayList "list", scope the
             details needed -->
        <div class="container-fluid" id="showcon">Candidates ${answers.get(0).getFirstname()} ${answers.get(0).getLastname()}s answers:</div>
 		
	
        <table class="table table-bordered" id="tableshow">
            <thead>
                <tr>
                    <th scope="col">#</th>
                    <th scope="col">Question</th>
                    <th scope="col">Candidates answer</th>
                </tr>
            </thead>
            
            <tbody>
            <!-- Go through candidates answers by using foreach -->
            <c:forEach var="ques" items="${requestScope.answers}" varStatus="loop">
                <tr>
                    <th scope="row"><c:out value="${loop.index+1}" /></th>
                    <td><c:out value="${ques.question}" /></td>
                    <!-- Here we get values of candidates answers from database and change them to text outputs -->                    
                	<td><c:choose><c:when test="${ques.answer==1}">Strongly disagree</c:when> 
                    <c:when test="${ques.answer==2 }">Disagree</c:when>
                    <c:when test="${ques.answer==3 }">Neutral</c:when>
                    <c:when test="${ques.answer==4 }">Agree</c:when>
                    <c:when test="${ques.answer==5 }">Strongly agree</c:when>
                    <c:otherwise>No opinion yet</c:otherwise>
                    </c:choose></td>
                </tr>
          	</c:forEach>
            </tbody>          
        </table>
        <div class="row justify-content-end">                
        </div>

    </main>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous">
    </script>
</body>
</html>