<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

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
    
    
    <title>Election machine</title>
</head>

<body id="adminhome" style="background-image: url('/pics/admin.png'); background-repeat: no-repeat;background-position: left 150px bottom 100px;background-size: 18vw;">
    
    <div class="col" style="position: absolute; left: 0; margin-top:0px;"><a href="/index.html" class="btnhome">HOME</a></div>
    
    <main class="admin_home">
    <div class="adminlogin"><a href="/../Logout"><img src="/pics/icons8-logout-32.png">Log out</a></div>

        <div class="container-fluid">
            <h1>Admin homepage </h1>
            <h2 style="margin-top: 80px;">Choose your action</h2>

            <div class="row1 justify-content-center" style="margin: 50px;">
                
                <div class="col-3"><a href="/rest/questions/getquestions" class="btnindex">VIEW<br>QUESTIONS</a></div>

                <div class="col-3"><a href="/rest/questions/getcandidates" class="btnindex">VIEW<br>CANDIDATES</a></div>

            </div>
       
    </main>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous">
    </script>
</body>

</html>
