<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="data.Candidate"%>
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
    <title>Candidate</title>
</head>

<body id="candidate">

    <main class="main_candidate">
    <div class="adminlogin"><a href="../Logout"><img src="/pics/icons8-logout-32.png">Log out</a></div>

		<div class="col" style="position: absolute; left: 0; margin-top:-30px;"><a href="/jsp/adminhome.jsp" class="btnhome">HOME</a></div>
        <div class="container">

            <div class="rowcan1">
                <div class="col">
                <div class="image"><img class="profile_cand" src="/pics/${requestScope.candidate.pic}"></div>
                    <p class="candnumber">${requestScope.candidate.candidate_id}</p>
                    <h2 class="candname">${requestScope.candidate.fname}
						${requestScope.candidate.lname}</h2>
                </div>
            </div>

            <div class="card">

                <div class="row-info">
                    <div class="col-12">
                        <div class="textbox">
                        <p><span class="party">${requestScope.candidate.party}</span></p>
                        <p class="age">Age: ${requestScope.candidate.age}</p>
                        <p class="city">City: ${requestScope.candidate.munic}</p>
                        <p class="profession">Profession: ${requestScope.candidate.prof}</p>
                        
                    </div>
                    </div>

                    <div class="row-prom">
                        <div class="col-12">
                            <p class="promote">“${requestScope.candidate.promo}”</p>
                            
                        </div>
                        
                </div>
            </div>


        </div>


<div class="row justify-content-center">
    <div class="col-7">
        <button type="button" class="btn btn-primary" name="back" onclick="history.back()" style="margin-bottom:50px; margin-right:400px;">BACK</button>
    </div>
    
    <div class="col-2">
    
        <a href="/rest/questions/editcandidate/${candidate.candidate_id}" class="btn btn-primary" style="margin-bottom:50px; color:#3A6DF2">EDIT</a>
    </div>

    <div class="col-3">
    
        <a href="/rest/questions/deletecandidate/${candidate.candidate_id}" class="btn btn-primary" style="margin-bottom:50px;margin-left:50px; color:rgb(245, 51, 51)">DELETE</a>
    </div>

    </div>

	</div>
    </main>


    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous">
    </script>
</body>

</html>