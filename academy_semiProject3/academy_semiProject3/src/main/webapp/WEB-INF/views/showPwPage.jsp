<%@page import="project.ClientVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta http-equiv="x-ua-compatible" content="ie=edge">
  <title>Material Design Bootstrap</title>
  <!-- Font Awesome -->
 <link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.8.2/css/all.css">
<!-- Bootstrap core CSS -->
<link href="resources/css/bootstrap.min.css" rel="stylesheet">
<!-- Material Design Bootstrap -->
<link href="resources/css/mdb.min.css" rel="stylesheet">
<!--êµ¬ê¸ ê¸ì í°í¸-->
<link
	href="https://fonts.googleapis.com/css?family=Single+Day&display=swap"
	rel="stylesheet">

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

                  <%	ClientVO showPW = (ClientVO)request.getAttribute("checkPW");%>
                  <h1 id="con_gongju" class="font-weight-bold mt-2"><%= showPW.getMobile() %>님의 비밀번호:<%= showPW.getPassword() %>  </h1>

                       
                       
                    <!--Grid row-->
                    <div class="row d-flex align-items-center  mb-3 mt-4">

                      <!--Grid column-->
                      <div class="col-md-12">
                        <div class="text-center">
                               <a href="loginPage.do" class="btn pink-gradient btn-rounded btn-lg font-weight-bold wow fadeIn" data-wow-delay="0.3s">
                  <i class="fas fa-location-arrow weight-text mr-2" aria-hidden="true"></i>로그인
              </a>
                          
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
    <script type="text/javascript" src="../../js/jquery-3.4.1.min.js"></script>
    <!-- Bootstrap tooltips -->
    <script type="text/javascript" src="../../js/popper.min.js"></script>
    <!-- Bootstrap core JavaScript -->
    <script type="text/javascript" src="../../js/bootstrap.min.js"></script>
    <!-- MDB core JavaScript -->
    <script type="text/javascript" src="../../js/mdb.min.js"></script>
    <script>
      // Animation init
      new WOW().init();

      // Material Select Initialization
      $(document).ready(function () {
        $('.mdb-select').material_select();
      });
    </script>

</body>

</html>