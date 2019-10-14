<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- Font Awesome -->
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.2/css/all.css">
<!-- Bootstrap core CSS -->
<link href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.3.1/css/bootstrap.min.css" rel="stylesheet">
<!-- Material Design Bootstrap -->
<link href="https://cdnjs.cloudflare.com/ajax/libs/mdbootstrap/4.8.8/css/mdb.min.css" rel="stylesheet">
<!-- JQuery -->
<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<!-- Bootstrap tooltips -->
<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.4/umd/popper.min.js"></script>
<!-- Bootstrap core JavaScript -->
<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.3.1/js/bootstrap.min.js"></script>
<!-- MDB core JavaScript -->
<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/mdbootstrap/4.8.8/js/mdb.min.js"></script>

<style>
		    img {
		      position: relative;
		      width: 70em;
		      height: 70em;
		      left: 440px;     
		     }
		      h5 {
		      letter-spacing: 3px;
		      }
		
		      .hr-light {
		      border-top: 3px solid #fff;
		      width: 80px;
		      }
      
  		</style>
</head>
<body>
		<%
		String userIds = (String)session.getAttribute("userId");
	 %> 

       <!-- Main navigation -->
<header>
    <!--Navbar-->
    <nav class="navbar navbar-expand-lg navbar-dark fixed-top scrolling-navbar">
      <div class="container">
        <a class="navbar-brand" href="#"><strong>Coogle</strong></a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent-7"
          aria-controls="navbarSupportedContent-7" aria-expanded="false" aria-label="Toggle navigation">
          <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarSupportedContent-7">
          <ul class="navbar-nav mr-auto">
            <li class="nav-item active">
              <a class="nav-link" href="login.html">처음으로 <span class="sr-only">(current)</span></a>
            </li>
            <li class="nav-item"><a class="nav-link" onclick="window.open('request.jsp', '문의하기', 'width=430, height=500, location=no, scrollbars=yes')">문의하기</a>
            </li>
          </ul>
		</div>
      </div>
    </nav>
    <!-- Navbar -->
    <!-- Full Page Intro -->
    <div class="view jarallax" data-jarallax='{"speed": 0.2}'>
      <div>
        <img src="https://blogfiles.pstatic.net/MjAxOTA4MjBfMTUg/MDAxNTY2Mjg1ODM3NDY0.PiqzSrzv6g7IdDbwl5Aw5IjZrk085GfTrWREOoBUm0Eg.oQuaJLIy0THduMHpoaCox1_ef5zzG_ZJMwAvvFQpwnsg.PNG.dldnjs1417/logo3.PNG" > 
      </div>  
      <!-- Mask & flexbox options-->
      <div class="mask rgba-black-light d-flex justify-content-center align-items-center">
        <!-- Content -->
        <div class="container">
          <!--Grid row-->
          <!-- Material input -->
          <div id="loginBox">   
            
              <form action="addprofile.jsp">
              	<div class="form-row">
                  <div class="col-md-6 mb-3 md-form">
                    <label for="validationDefault22">ID</label>
                    <input type="text" class="form-control" id="validationDefault22" value="" name="inputId" required>
                  </div>
                  <div class="col-md-6 mb-3 md-form">
                    <label for="validationDefault22">Password</label>
                    <input type="text" class="form-control" id="validationDefault22" value="" name="inputPw" required>
                  </div>
                </div>
                <div class="form-row">
                  <div class="col-md-4 mb-3 md-form">
                    <label for="validationDefault22">First name</label>
                    <input type="text" class="form-control" id="validationDefault22" value="" name="inputfName" required>
                  </div>
                  <div class="col-md-4 mb-3 md-form">
                    <label for="validationDefault22">Last name</label>
                    <input type="text" class="form-control" id="validationDefault22" value="" name="inputlName" required>
                  </div>
                  <div class="col-md-4 mb-3 md-form">
                    <label for="validationDefault22">Employee_id</label>
                    <input type="text" class="form-control" id="validationDefault22" value="" name="inputempId" required>
                  </div>
                </div>
                <div class="form-row">
                  <div class="col-md-6 mb-3 md-form">
                    <label for="validationDefault22">Email</label>
                    <input type="text" class="form-control" id="validationDefault22" name="inputEmail" required>
                  </div>
                  <div class="col-md-3 mb-3 md-form">
                    <label for="validationDefault22">Adress</label>
                    <input type="text" class="form-control" id="validationDefault22" name="inputadress" required>
                  </div>
                  <div class="col-md-3 mb-3 md-form">
                    <label for="validationDefault22">Mobile</label>
                    <input type="text" class="form-control" id="validationDefault22" name="inputmobile" required>
                  </div>
                </div>
                <div class="form-group">
                  <div class="form-check pl-0">
                    <input class="form-check-input" type="checkbox" value="" id="invalidCheck222" onclick="window.open('3rdpeoplopage.jsp', '문의하기', 'width=430, height=500, location=no, scrollbars=yes')" required>
                    <label class="form-check-label" for="invalidCheck222">
                      	본 회사의 직원임을 확인합니다.
                    </label>
                  </div>
                </div>
                
	            <div class="col-md-12 mb-4 white-text text-center">
	                     
	              <h5 class="text-uppercase mb-4 white-text wow fadeInDown" data-wow-delay="0.4s"><strong> Welcome to Coogle</strong></h5>
	                  <hr class="hr-light my-4 wow fadeInDown" data-wow-delay="0.4s">
	              <button type="submit" class="btn btn-blue-grey">회원가입하기</button>
	            </div>
              </form>

            <!--Grid column-->
          </div>
          <!--Grid row-->
        </div>
        <!-- Content -->
      </div>
      <!-- Mask & flexbox options-->
    </div>
    <!-- Full Page Intro -->
  </header>
  <!-- Main navigation -->
        <script type="text/javascript" src="mdb/js/jquery-3.4.1.min.js"></script>
        <script type="text/javascript" src="mdb/js/popper.min.js"></script>
        <script type="text/javascript" src="mdb/js/bootstrap.min.js"></script>
        <script type="text/javascript" src="mdb/js/mdb.min.js"></script> 

  </body>
</html>