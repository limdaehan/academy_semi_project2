<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="utf-8">

<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta http-equiv="x-ua-compatible" content="ie=edge">
  <title>회원가입 페이지 입니다</title>
  <!-- Font Awesome -->
  <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.2/css/all.css">
  <!-- Bootstrap core CSS -->
  <link href="resources/css/bootstrap.min.css" rel="stylesheet">
  <!-- Material Design Bootstrap -->
  <link href="resources/css/mdb.min.css" rel="stylesheet">
  <!--êµ¬ê¸ ê¸ì í°í¸-->
  <link href="https://fonts.googleapis.com/css?family=Single+Day&display=swap" rel="stylesheet">
	
<script language="javascript">
     
        function check() { window.open("checkMobile.do", "a", "width=500, height=300, left=500, top=50"); }
    </script>
  <style>
    html,
    body,
    header,
    .intro-4 {
      height: 100%;
    }

    @media (max-width: 450px) {

      html,
      body,
      header,
      .intro-4 {
        height: 700px;
      }
    }

    @media (min-width: 451px) and (max-width: 740px) {

      html,
      body,
      header,
      .intro-4 {
        height: 500px;
      }
    }

    @media (min-width: 800px) and (max-width: 850px) {

      html,
      body,
      header,
      .intro-4 {
        height: 550px;
      }
    }

    #con_gongju {

      font-family: 'Single Day', cursive;
      color:hotpink


    }
  </style>
</head>

<body>

  <!-- Navigation & Intro -->
  <header>



    <!-- Intro Section -->
    <section class="text-center  view intro-4"
      style="background-image: url('https://mdbootstrap.com/img/Photos/Others/images/91.jpg'); background-repeat: no-repeat; background-size: cover; background-position: center center;"
      id="home">
      <div class="mask rgba-indigo-light">


        <div class="container h-100 d-flex justify-content-center align-items-center">
          <!-- Grid column -->
          <div class="col-lg-12 col-md-12 mb-12">
            <!-- Card -->
            <div class="card card-image">
              <!-- Content -->
              <div
                class="text-white text-center pricing-card d-flex align-items-center background-color: rgba(255, 0, 0, 0.3) py-3 px-3 rounded">

                <!-- Content -->
                <div  class="card-body">
                  <h1 id="con_gongju" class="font-weight-bold mt-2">공주가입</h1>
                  	<form name="form" method="post" onsubmit="return checkEmpty();">
	                  <div class="card-body mx-4">
	                      <div class="md-form font-weight-bold text-white mt-2 brown-lighter-hover">
	                          <input type="text" class="form-control" name="carNum" value="" id="carNum">
	                          <label for="carNum">차량번호</label>
	                      </div>
	                      <div class="md-form font-weight-bold text-white mt-2 brown-lighter-hover">
	                          <input type="text" class="form-control" name="name" value="" id="name">
	                          <label for="name">이름</label>
	                      </div>
	                      <div class="md-form font-weight-bold text-white mt-2 brown-lighter-hover">
	                          <input type="text" class="form-control" name="mobile" value="" id="mobile" onclick="check()">
	                          <label for="mobile">전화번호</label>
	                      </div>
	                      <div class="md-form font-weight-bold text-white mt-2 brown-lighter-hover">
	                          <input type="password" class="form-control" name="password" value="" id="password">
	                          <label for="password">비밀번호</label>
	                      </div>
	                      <div class="md-form font-weight-bold text-white mt-2 brown-lighter-hover">
	                          <input type="text" class="form-control" name="address" value="" id="address">
	                          <label for="address">주소</label>
	                      </div>
	                      <div class="md-form font-weight-bold text-white mt-2 brown-lighter-hover">
	                          <input type="text" class="form-control" name="bankName" value="" id="bankName">
	                          <label for="bankName">은행명</label>
	                      </div>
	                      <div class="md-form font-weight-bold text-white mt-2 brown-lighter-hover">
	                          <input type="text" class="form-control" name="accountNumber" value="" id="accountNumber">
	                          <label for="accountNumber">계좌번호</label>
	                      </div>
						
	                    <!--Grid row-->
	                    <div class="row d-flex align-items-center  mb-3 mt-4">
	
	                      <!--Grid column-->
	                      <div class="col-md-12">
	                        <div class="text-center row flex-center">
	                            <button type="submit" class="btn pink-gradient btn-rounded btn-lg font-weight-bold" name="join"  onclick="javascript: form.action='addClient.do';">회원가입</button></form>
	                            <form><button type="submit" class="btn btn-white btn-rounded btn-lg orange-text font-weight-bold ml-lg-0 wow fadeIn" name="cancel" onclick="javascript: form.action='cancel.do';">취소</button></form>
	                        </div>
	                      </div>
	                      <!--Grid column-->
	
	                    </div>
	                    <!--Grid row-->
	                  </div>
               	 
                </div>


              </div>
              <!-- Card -->
            </div>
            <!-- Grid column -->


            <!-- Grid row -->
          </div>
    </section>
    </div>
    </div>
    </div>
    </section>

    <!-- Footer -->
    <footer class="page-footer text-center text-md-left unique-color-dark pt-0 mt-0">

      <div class="top-pink-footer">
        <div class="container">

          <!-- Grid row -->
          <div class="row py-4 d-flex align-items-center">

            <!-- Grid column -->
            <div class="col-md-6 col-lg-5 text-center text-md-left mb-md-0">
              <h6 class="mb-4 mb-md-0 white-text">Get connected with us on social networks!</h6>
            </div>
            <!-- Grid column -->

            <!-- Grid column -->
            <div class="col-md-6 col-lg-7 text-center text-md-right">
              <!-- Facebook -->
              <a class="p-2 m-2 fa-lg fb-ic ml-0">
                <i class="fab fa-facebook-f white-text mr-lg-4"> </i>
              </a>
              <!-- Twitter -->
              <a class="p-2 m-2 fa-lg tw-ic">
                <i class="fab fa-twitter white-text mr-lg-4"> </i>
              </a>
              <!-- Google + -->
              <a class="p-2 m-2 fa-lg gplus-ic">
                <i class="fab fa-google-plus-g white-text mr-lg-4"> </i>
              </a>
              <!-- Linkedin -->
              <a class="p-2 m-2 fa-lg li-ic">
                <i class="fab fa-linkedin-in white-text mr-lg-4"> </i>
              </a>
              <!-- Instagram -->
              <a class="p-2 m-2 fa-lg ins-ic">
                <i class="fab fa-instagram white-text mr-lg-4"> </i>
              </a>
            </div>
            <!-- Grid column -->

          </div>
          <!-- Grid row -->

        </div>
      </div>
    </footer>

    <!-- JQuery -->
    <script type="text/javascript" src="resources/js/jquery-3.4.1.min.js"></script>
    <!-- Bootstrap tooltips -->
    <script type="text/javascript" src="resources/js/popper.min.js"></script>
    <!-- Bootstrap core JavaScript -->
    <script type="text/javascript" src="resources/js/bootstrap.min.js"></script>
    <!-- MDB core JavaScript -->
    <script type="text/javascript" src="resources/js/mdb.min.js"></script>
    <script>
      // Animation init
      new WOW().init();

      // Material Select Initialization
      $(document).ready(function () {
        $('.mdb-select').material_select();
      });
     
      
      function checkEmpty() {
    	if($("#carNum").val()==''){
    		alert('차량 번호를 입력해주세요');
    		$("#carNum").focus();
    		return false;
    	} else if($("#name").val()==''){
    		alert('이를을 입력해주세요');
    		$("#name").focus();
    		return false;
    	} else if($("#mobile").val()==''){
    		alert('연락처를 입력해주세요');
    		$("#mobile").focus();
    		return false;
    	} else if($("#password").val()==''){
    		alert('비밀번호를 입력해주세요');
    		$("#passwors").focus();
    		return false;
    	} else if($("#address").val()==''){
    		alert('주소를 입력해주세요');
    		$("#address").focus();
    		return false;
    	} else if($("#bankName").val()==''){
    		alert('은행명을 입력해주세요');
    		$("#bankName").focus();
    		return false;
    	} else if($("#accountNumber").val()==''){
    		alert('계좌번호를 입력해주세요');
    		$("#accountNumber").focus();
    		return false;
    	}
      }
	   
      function print(data){
    	  console.log(data);
      }
	  

    </script>

</body>

</html>