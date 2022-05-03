<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="data.Candidate"%>
<%@ page errorPage="error.jsp" %>
<%@ page import = "java.io.File"%>
<%@ page import = "java.io.IOException"%>
<%@ page import = "java.io.PrintWriter"%>

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
    <title>Edit info</title>
    
    
</head>

<body id="profile">

<script type="text/javascript">
    
    //document.getElementById("file-type").onchange = function() {changeImage()};
    
    //function changeImage() {
    	
    var changeImage = function(event) {	
    	//document.getElementById("profilepic").src = document.getElementById("input-file").value;
    	var image = document.getElementById("profilepic");
    	image.src = URL.createObjectURL(event.target.files[0]);
    
    };

    </script>

	<div class="col" style="position: absolute; left: 0; margin-top:0px;"><a href="/jsp/adminhome.jsp" class="btnhome">HOME</a></div>
    <main class="main_profile">
    <div class="adminlogin"><a href="../Logout"><img src="/pics/icons8-logout-32.png">Log out</a></div>
    

        <h2 class="h2prof">Candidate's info</h2>

        <div class="container">
			
            <div class="rowcan1" style="height: 300px;">
                <div class="col">
                
          	<form action="/rest/questions/addcandidate" method="POST" class="forminfo" enctype="multipart/form-data">	
                    <image style="margin-bottom:0;"><img class="profile_cand" id="profilepic" src="/pics/emptyminion.png"></image>
                    
                       
                        <h2 class="candnameprof"></h2>
                        
                </div>
            </div>

            <div class="row" id="rowprof-info">

                <div class="col-12">
                <div class="form-group">
               
               <label for="id" id="label">Picture</label><br>
               <input type="file" id="input-file" class="infoper" name="file" accept=".png" onchange="changeImage(event)"/>
    
     			</div>
			 
                <div class="form-group">
             
             		
                    <input type="hidden" class="infoper" id="pic" name="pic" value="">
                </div>
            
                <div class="form-group">
                    <label for="fname" id="label">First name</label><br>
                    <input type="text" class="infoper" id="fname" name="fname" value="" required>
                </div>

                <div class="form-group">
                    <label for="lname" id="label">Last name</label><br>
                    <input type="text" class="infoper" id="lname" name="lname" value="" required>
                </div>

                <div class="form-group">
                    <label for="party" id="label">Party</label><br>
                    <input type="text" class="infoper" id="party" name="party" value="" required>
                </div>

                <div class="form-group">
                    <label for="munic" id="label">Municipality</label><br>
                    <input type="text" class="infoper" id="munic" name="munic" value="" required>
                </div>

                <div class="form-group">
                    <label for="age" id="label">Age</label><br>
                    <input type="text" class="infoper" id="age" name="age" value="" required>
                </div>
 
                <div class="form-group">
                    <label for="prof" id="label">Profession</label><br>
                    <input type="text" class="infoper" id="prof" name="prof" value="" required>
                </div>

                <div class="form-group">
                    <label for="promo" id="label">Promote</label><br>
                    <textarea type="text" class="infoperarea" id="promo" name="promo" required></textarea>
                
                </div>
                
                <div class="row justify-content-center">
              	<div class="col-2">
				<button type="button" class="btn btn-primary" name="back" onclick="history.back()">BACK</button>
				</div>
				<div class="col-2">
				<input type="submit" class="btn btn-primary" name="ok" value="SAVE">
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
