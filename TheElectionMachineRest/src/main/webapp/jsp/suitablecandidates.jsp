<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList"%>
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
    <link rel="stylesheet" href="css/style2.css">
    <title>Suitable candidates for you</title>
</head>

<body id="suit">
    <main class="main_suit">
        <div class="col"><a href="index.html" class="btnhome">HOME</a></div>



        <h2 class="h2_suit">Suitable candidates</h2>

        <div class="container-fluid">
        
        <h4 class="h4_best">Best three candidates for you</h4>
        
        <c:forEach var="cand" items="${requestScope.top}">

            

            <!--Row for the candidates card and percentage-->
            <div class="row">

			
                <!-- Empty column to get elements centered -->
                <div class="col-1"></div>
				
				

                <!---Candidate card element-->
                <div class="col-8">
                
                
                    <div class="card" id="card-cand"><a href="/ShowSpesificCandidate?id=${cand.id}">

                            <div class="row no-gutters">
                                <div class="col-4">

                                    <div class="image"><img class="profile"
                                            src="<c:out value="${cand.pic}"/>"></div>
                                    <p class="candnumsui"><c:out value="${cand.id}" /></p>
                                </div>
                                <div class="col-7">
                                    <div class="card-body">
                                        <h5 class="card-title"><c:out value="${cand.name}" />
									<c:out value="${cand.fname}" /></h5>
                                        <p class="card-text">“<c:out value="${cand.promo}" />”</p>
                                    </div>

                                </div>
                                <div class="col-1">
                                    <img class="arrow" src="pics/chevron-right.svg"></img>
                                </div>
                            </div>
                        </a></div>
                </div>
                <!-- Candidate card element ends-->


                <!-- Percentage element starts-->
                <div class="col-3">

                    <div class="percentage">

                        <!--Actual percentage-->
                        <span class="per">${cand.points} %</span>
                    </div>


                </div>
                
                <!-- Percentage element ends-->

               
            </div>
            <br>
            <!---Row ends here-->
			</c:forEach>


        </div>

    </main>


    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous">
    </script>
</body>

</html>