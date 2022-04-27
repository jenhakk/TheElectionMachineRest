<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
    <title>Edit question</title>
</head>

<body id="profile">

    <div class="col" style="position: absolute; left: 0; margin-top:0px;"><a href="/index.html" class="btnhome">HOME</a>
    </div>
    <main class="main_profile">


        <h2>Edit question</h2>

        <div class="container">


            <div class="row" id="rowprof-info">

                <form action="/rest/questions/updatequestion" method="POST" class="forminfo">
                <div class="form-group">
             
                    <input type="hidden" class="infoper" id="question_id" name="question_id" value="${requestScope.question.question_id}">
                </div>
                    <div class="form-group">
                        <label for="promo" id="label">Question ${requestScope.question.question_id} </label><br>
                        <textarea type="text" class="infoperarea" id="ques" name="question" required>${requestScope.question.question}</textarea>

                    </div>

                    <div class="row justify-content-center">
                        <div class="col-2">
                            <button type="button" class="btn btn-primary" name="back"
                                onclick="history.back()">BACK</button>
                        </div>
                        <div class="col-2">
                            <input type="submit" class="btn btn-primary" name="ok" value="SAVE">
                        </div>

                    </div>

                </form>

            </div>

        </div>


    </main>


    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous">
    </script>
</body>

</html>