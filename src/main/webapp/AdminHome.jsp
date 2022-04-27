
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>OES | Home</title>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
	<script src="https://use.fontawesome.com/releases/v5.0.8/js/all.js"></script>
        <link rel="canonical" href="https://getbootstrap.com/docs/4.5/examples/carousel/">

     <style>
      .bd-placeholder-img {
        font-size: 1.125rem;
        text-anchor: middle;
        -webkit-user-select: none;
        -moz-user-select: none;
        -ms-user-select: none;
        user-select: none;
      }

      @media (min-width: 768px) {
        .bd-placeholder-img-lg {
          font-size: 3.5rem;
        }
      }
      
    </style>

    <link rel="stylesheet" type="text/css" href="home.css">

</head>
<body>
    <form id="form1">
        <header>
			<jsp:include page="AdminNavbar.jsp" />
        </header>

    <div class="jumbotron">
              <div class="container-fluid">


               </div>
               <div class="row jumbotron">
        		<div class="col-xs-12 col-sm-12 col-md-9 col-lg-9 col-xl-10">
            	<p class="lead">Welcome to Online Examination System!

            </p>
            <p class="lead">
               		Admins can make new accounts as well as schedule exams.
               		
            </p>
             <p class="lead">
               		This website was built using jsp and servlets.          		
            </p>
        </div>
    </div>
                
    </div>
    
    <!--Jumbotron-->
    <div class="container-fluid">
    <div class="row jumbotron">
        <div class="col-xs-12 col-sm-12 col-md-9 col-lg-9 col-xl-10">
            <p class="lead">An Online Examination System for Colleges and Universities to schedule their exams.
                If your organization faces any challenges while conducting the exams or your organization has any concerns regarding the system please contact us. 
            </p>
        </div>
    </div>
    </div>
    <!--Build with Ease and Logos section-->
    <div class="container-fluid padding">
    <div class="row welcome text-center">
        <div class="col-12">
            <h1 class="display-4">Assess with ease.</h1>
        </div>
        <hr />
        <div class="col-12">
            <p class="lead">
                An Online Examination Tool that allows for the swift, efficient and smooth conduction of college and university exams.
            </p>
        </div>
    </div>
    </div>
    <div class="container-fluid">
    <div class="row text-center padding">
        <div class="col-xs-12 col-sm-6 col-md-4">
            <i class="fa fa-bolt" aria-hidden="true"></i>
            <h3>Fast</h3>
            <p>Fast and Smooth Assessment.</p>
        </div>
        <div class="col-xs-12 col-sm-6 col-md-4">
            <i class="fa fa-lock" aria-hidden="true"></i>
            <h3>Secure</h3>
            <p>Secure Examination Process.</p>
        </div>
        <div class="col-sm-12 col-md-4">
            <i class="fa fa-check-square" aria-hidden="true"></i>
            <h3>Reliable</h3>
            <p>Reliable and Trustworthy Platform</p>
        </div>
    </div>
    <hr class="my-4"/>
    </div>

    <!--Connect Section-->
    <div class="container-fluid padding">
    <div class="row text-center padding">
        <div class="col-12">
            <h2>Connect</h2>
        </div>
        <div class="col-12 social padding">
            <a href="https://www.facebook.com/"><i class="fab fa-facebook"></i></a>
            <a href="https://www.youtube.com/"><i class="fab fa-youtube"></i></a>
            <a href="https://www.instagram.com/"><i class="fab fa-instagram"></i></a>
            <a href="https://google.com"><i class="fab fa-google-plus-g"></i></a>
            <a href="https://twitter.com/"><i class="fab fa-twitter"></i></a>
        </div>
    </div>
    </div>
    <!--Footer-->
    <jsp:include page="Footer.jsp"/>
   </form>
</body>
</html>