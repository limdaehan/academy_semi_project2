<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
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

<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">

   #up {
   
      margin-left: 400px;
      margin-top: 100px;
   }

   #up2 {
    margin-top: 100px;
   }
   
   
   
   #down {
      margin-left: 200px;
   }
  
</style>


</head>
<body id="body" >
		<%
		String userIds = (String)session.getAttribute("userId");
	 %> 
     <!--Navbar-->
     <nav
				class="navbar navbar-expand-lg navbar-dark fixed-top scrolling-navbar">
				<div class="container">
					<a class="navbar-brand" href="#"><strong>Coogle</strong></a>
					<button class="navbar-toggler" type="button" data-toggle="collapse"
						data-target="#navbarSupportedContent-7"
						aria-controls="navbarSupportedContent-7" aria-expanded="false"
						aria-label="Toggle navigation">
						<span class="navbar-toggler-icon"></span>
					</button>
					<div class="collapse navbar-collapse" id="navbarSupportedContent-7">
						<ul class="navbar-nav mr-auto">
							<li class="nav-item active"><a class="nav-link" onclick="location.href='homepage.jsp'">처음으로
									<span class="sr-only">(current)</span>
							</a></li>
							<li class="nav-item"><a class="nav-link" onclick="window.open('request.jsp', '문의하기', 'width=430, height=500, location=no, scrollbars=yes')">문의하기</a>
							</li>
						</ul>
						<form class="form-inline">
				            <div class="md-form mt-0">
					            <h6 class="text-uppercase mb-4 white-text wow fadeInDown">
								<strong><%= userIds %>님, 반갑습니다.</strong>
								</h6>
				            </div>
			          	</form>
					</div>
				</div>
			</nav>
          <!-- Navbar -->

<!-- Section: Team v.1 -->
<div class="mask rgba-black-light d-flex justify-content-center align-items-center">
<section class="team-section text-center my-5">

  <!-- Section heading -->

  
  <!-- Section description -->
  <div class="row">
  <!-- Grid column -->
    <div class="col-lg-3 col-md-6 mb-lg-0 mb-5"  id="up">
      <div class="avatar mx-auto">
        <img src="image/wonjin.jpg" class="rounded-circle z-depth-1"
          alt="Sample avatar">
      </div>
      <h5 class="font-weight-bold mt-4 mb-3">이원진</h5>
      <p class="text-uppercase white-text"><strong><b>Graphic designer</b></strong></p>
        <p class="text-uppercase white-text"><strong><i class="fas fa-address-book"></i>3931-1417</strong></p>
      <p class="white-text">1995년생 고양시가 고향인 이원진입니다.고양시에 살고있는 이쁜여자를 좋아하니 이쁜여자들 상담만 전담하고있습니다. 행복하시고 웃는날만 있으시길 기원합니다.</p>
      <ul class="list-unstyled mb-0">
      
     
      </ul>
    </div>
    <!-- Grid column -->
    
    <!-- Grid column -->
    <div class="col-lg-3 col-md-6 mb-lg-0 mb-5"  id="up2">
      <div class="avatar mx-auto">
        <img src="image/sojung.jpg" class="rounded-circle z-depth-1"
          alt="Sample avatar">
      </div>
      <h5 class="font-weight-bold mt-4 mb-3"> 강소정 </h5>
      <p class="text-uppercase white-text"><strong><b>Graphic designer</b></strong></p>
       <p class="text-uppercase white-text"><strong><i class="fas fa-address-book"></i>2522-9672</strong></p>
      <p class="white-text">1999년생 대전사는 강소정입니다. 강아지를 좋아하고 아구찜을 좋아하는분들만 상담을 받고있습니다. 당신의 행복하고 찬란한 앞날을 응원합니다.</p>
      <ul class="list-unstyled mb-0">
       
    </div>
    <!-- Grid column -->
  
  </div>
  

  <!-- Grid row -->
  <div class="row">

    

    <!-- Grid column -->
    <div class="col-lg-3 col-md-6 mb-lg-0 mb-5"  id="down">
      <div class="avatar mx-auto">
        <img src="image/suho.jpg" class="rounded-circle z-depth-1"
          alt="Sample avatar">
      </div>
      <h5 class="font-weight-bold mt-4 mb-3">이수호</h5>
      <p class="text-uppercase white-text"><strong><b>Web developer</b></strong></p>
     
       <p class="text-uppercase white-text"><strong><i class="fas fa-address-book"></i>9896-3528</strong></p>
      <p class="white-text">1992년생 인천살고 있는 이수호 입니다. 통학거리 너무 멀어서 힘들어요. 밥잘하는 이쁜누나만 상담받고 있습니다. 누나의 행복이 100% 될때 까지 최선을다하겠습니다.   </p>
      <ul class="list-unstyled mb-0">
       
    </div>
    <!-- Grid column -->

    <!-- Grid column -->
    <div class="col-lg-3 col-md-6 mb-md-0 mb-5"  id="down2">
      <div class="avatar mx-auto">
        <img src="image/deahan.jpg" class="rounded-circle z-depth-1"
          alt="Sample avatar">
      </div>
      <h5 class="font-weight-bold mt-4 mb-3">임대한</h5>
      <p class="text-uppercase white-text"><strong><b>Web developer</b></strong></p>
       <p class="text-uppercase white-text"><strong><i class="fas fa-address-book"></i>9828-2838</strong></p>
      <p class="white-text">1994년생 임대한입니다. 수원살고있어요. 수원 정~말 살기 좋은 동네예요. 대한민국에서 수원이 안전율 1위로 예상합니다. 왜냐면 제가 살고있기때문입니다.
      돈많은 외동딸들 상담주세요.  </p>
      <ul class="list-unstyled mb-0">
       
    </div>
    <!-- Grid column -->

    <!-- Grid column -->
    <div class="col-lg-3 col-md-6"  id="down3">
      <div class="avatar mx-auto">
        <img src="image/sohee.jpg" class="rounded-circle z-depth-1"
          alt="Sample avatar">
      </div>
      <h5 class="font-weight-bold mt-4 mb-3">한소희</h5>
      <p class="text-uppercase white-text"><strong><b>Graphic designer</b></strong></p>
        <p class="text-uppercase white-text"><strong><i class="fas fa-address-book"></i>4829-9823</strong></p>
      <p class="white-text">1998년생 태안이 고향인 한소희입니다. 창문열면 바로 바다 안보입니다. 날음식 너무 좋아해요. 횟집사장님들 상담주세요.</p>
      <ul class="list-unstyled mb-0">
    </div>
    <!-- Grid column -->
  </div>
  <!-- Grid row -->
</section>
<!-- Section: Team v.1 -->
</div>


</body>