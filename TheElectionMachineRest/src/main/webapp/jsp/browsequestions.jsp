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
 	
 	<script src="https://cdn.jsdelivr.net/npm/sweetalert2@10.10.1/dist/sweetalert2.all.min.js"></script>
 	<link rel='stylesheet' href='https://cdn.jsdelivr.net/npm/sweetalert2@10.10.1/dist/sweetalert2.min.css'>    
    
    
    <title>View questions</title>
</head>

<body id="showans">
    
    <main class="main_show">
    <div class="adminlogin"><a href="/../Logout"><img src="/pics/icons8-logout-32.png">Log out</a></div>
        <div class="col" style="position: absolute; left: 0px; width: 50px;"><a href="/jsp/adminhome.jsp" class="btnhome">HOME</a></div>

        
        <h2 class="h2show">Questions</h2>
        <div class="container-fluid" id="showcon">

        <table class="table table-bordered" id="tableshow">
            <thead>
                <tr>
                    <th scope="col">#</th>
                    <th scope="col">Question</th>
                   
                   
                </tr>
            </thead>
            <c:forEach var="ques" items="${requestScope.questions}" varStatus="loop">
            <tbody>
                <tr>
                    <th scope="row"><c:out value="${loop.index+1}" /></th>
                    <td>
                    
                        <div class="row">

                        <div class="col-9"><c:out value="${ques.question}" /></div>    
                        <div class="col-1"><a href="/rest/questions/showquestion/${ques.question_id}" style="color: #3A6DF2">Edit</a></div><div class="col-1"><a onClick="success(event)" href="/rest/questions/deletequestion/${ques.question_id}" id="delete" style="color: rgb(255, 0, 0)">Delete</a></div>
                        </div>
                    </td>
                     
                </tr>
                
            </tbody>
            </c:forEach>
        </table>
    </div>

</div>
       
        <div class="row justify-content-end">
            
            <div class="col-3"><a href="/../jsp/addquestion.jsp" class="btn btn-primary">ADD NEW QUESTION</a></div>

        </div>
        </div>

    </main>
    
    <script>
function success(ev) {
	
	ev.preventDefault();
	var url = ev.currentTarget.getAttribute('href');
	console.log(ev);
	console.log(url);
	 Swal.fire({
	        icon: 'warning',
	        title: 'Are you sure?',
	        text: "You won't be able to revert this!",
	        showCancelButton: true,
	        confirmButtonColor: '#3085d6',
	        cancelButtonColor: '#d33',
	        confirmButtonText: 'Yes, do it!'
	    }).then((result) => {
	        if (result.value) {
	            window.location.href=url;
	        }
	    })
	}
	</script>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous">
    </script>
</body>

</html>
</body>
</html>