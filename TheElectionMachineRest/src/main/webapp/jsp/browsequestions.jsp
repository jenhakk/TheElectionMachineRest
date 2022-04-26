<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="data.Answers"%>
<%@ page import="dao.Dao" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <link rel="stylesheet" href="/css/style2.css">
    <title>View questions</title>
</head>

<body id="showans">
    
    <main class="main_show">
        <div class="col" style="position: absolute; left: 0px; width: 50px;"><a href="index.html" class="btnhome">HOME</a></div>

        
        <h2 class="h2show">Questions</h2>
        <div class="container-fluid" id="showcon">

        <table class="table table-bordered" id="tableshow">
            <thead>
                <tr>
                    <th scope="col">#</th>
                    <th scope="col">Question</th>
                   
                   
                </tr>
            </thead>
            <c:forEach var="ques" items="${requestScope.questions}">
            <tbody>
                <tr>
                    <th scope="row"><c:out value="${ques.question_id}" /></th>
                    <td>
                    
                        <div class="row">

                        <div class="col-9"><c:out value="${ques.question}" /></div>    
                        <div class="col-1"><a href="/rest/questions/showquestion/${ques.question_id}" style="color: #3A6DF2">Edit</a></div><div class="col-1"><a href="" style="color: rgb(255, 0, 0)">Delete</a></div>
                        </div>
                    </td>
                     
                </tr>
                
            </tbody>
            </c:forEach>
        </table>
    </div>

</div>
       
        <div class="row justify-content-end">
            
            <div class="col-3"><a href="http://localhost:8080/jsp/addquestion.jsp" class="btn btn-primary">ADD NEW QUESTION</a></div>

        </div>
        </div>

    </main>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous">
    </script>
</body>

</html>
</body>
</html>