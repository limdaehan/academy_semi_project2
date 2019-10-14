<%@ page contentType="text/html; charset=UTF-8"%>
<html>
<head>
<meta charset="UTF-8">
<title>Search_dept_id</title>
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
       <script type="text/javascript">
      	function emptychk() {
      		if (!inputs.inputIconEx2.value){
      			alert("입력값이 없습니다.");
      			inputs.inputIconEx2.focus();
      			return false;
      		}else{
      			return true;
      		}
      	}
      </script>
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

</style>
</head>
<body>
	<%
		String userIds = (String)session.getAttribute("userId");
	 %> 
	 <header>
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
			<!-- Full Page Intro -->
		</header>	
		
		
	<div class="view jarallax" data-jarallax='{"speed": 0.2}'>
		<div>
			<img
				src="https://blogfiles.pstatic.net/MjAxOTA4MjBfMTUg/MDAxNTY2Mjg1ODM3NDY0.
					PiqzSrzv6g7IdDbwl5Aw5IjZrk085GfTrWREOoBUm0Eg.oQuaJLIy0THduMHpoaCox1_ef5zzG_
					ZJMwAvvFQpwnsg.PNG.dldnjs1417/logo3.PNG">
		</div>
		<!-- Mask & flexbox options-->
		<div
			class="mask rgba-black-light d-flex justify-content-center align-items-center">
			<!-- Content -->
			<div class="container">
				<!--Grid row-->
				<!-- Material input -->
				<div id="searchBox">
					<h3 class="text-uppercase mb-4 white-text wow fadeInDown"
							data-wow-delay="0.4s">
							<strong> 사원이름으로 검색</strong>
					</h3>
				<form action="emp_listbyname.jsp" id="inputs">
					<div class="md-form">
						<i class="fas fa-user prefix"></i> <input type="text"
							id="inputIconEx2" class="form-control" name="nameinput">
					</div>
					<!-- Material input -->
					<div class="row"></div>
					<!--Grid column-->
					<div class="col-md-12 mb-4 white-text text-center">
						<hr class="hr-light my-4 wow fadeInDown" data-wow-delay="0.4s">
						<button type="submit" class="btn btn-blue-grey" onclick="return emptychk();">검색하기</button>
						<button type="button" class="btn btn-blue-grey" onclick="location.href='homepage.jsp'">메인으로</button>  
					</div>
					<!--Grid column-->
					</form>
				</div>
				<!--Grid row-->
			</div>
			<!-- Content -->
		</div>
		<!-- Mask & flexbox options-->
	</div>
	<!-- Full Page Intro -->

</body>
</html>