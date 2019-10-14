<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="EUC-KR"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="utf-8">

<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta http-equiv="x-ua-compatible" content="ie=edge">
<title>Material Design Bootstrap</title>
<!-- Font Awesome -->
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.8.2/css/all.css">
<!-- Bootstrap core CSS -->
<link href="<c:url value="/resources/css/bootstrap.min.css"/>"
	rel="stylesheet">
<!-- Material Design Bootstrap -->
<link href="<c:url value="/resources/css/mdb.min.css"/>"
	rel="stylesheet">
<!--구글 글자 폰트-->
<link
	href="https://fonts.googleapis.com/css?family=Single+Day&display=swap"
	rel="stylesheet">

<style>
html, body, header, .intro-4 {
	height: 100%;
}

@media ( max-width : 450px) {
	html, body, header, .intro-4 {
		height: 700px;
	}
}

@media ( min-width : 451px) and (max-width: 740px) {
	html, body, header, .intro-4 {
		height: 500px;
	}
}

@media ( min-width : 800px) and (max-width: 850px) {
	html, body, header, .intro-4 {
		height: 550px;
	}
}

#con_gongju {
	font-family: 'Single Day', cursive;
	color: hotpink
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


				<div
					class="container h-100 d-flex justify-content-center align-items-center">
					<!-- Grid column -->
					<div class="col-lg-12 col-md-12 mb-12">
						<!-- Card -->
						<div class="card card-image">
							<!-- Content -->
							<div
								class="text-black text-center pricing-card d-flex align-items-center background-color: rgba(255, 0, 0, 0.3) py-3 px-3 rounded">

								<!-- Content -->
								<div class="card-body">
									<div class="container">
										<br> <br>
										<div class="row">

											<div class="col-3 col-sm-3">날자</div>
											<div class="col-3 col-sm-3">날자 시작</div>
											<div class="col-3 col-sm-3">여긴 아이콘</div>
											<div class="col-3 col-sm-3">날자 마지막</div>


											<!-- Force next columns to break to new line -->
											<div class="w-100"></div>
											<br> <br>
											<div class="col-3 col-sm-3">시간</div>
											<div class="col-3 col-sm-3">시작 시작</div>
											<div class="col-3 col-sm-3">여긴 아이콘</div>
											<div class="col-3 col-sm-3">시작 마지막</div>
											<div class="w-100"></div>
											<br> <br>
											<div class="col-3 col-sm-3">위치를 받을거야</div>
											<div class="w-100"></div>
											<br> <br>
											<div class="col-3 col-sm-3">가격을 넣을거야</div>
											<div class="w-100"></div>
											<br> <br>
											<div class="col-2 col-sm-6">체크박스</div>
											<div class="col-10 col-sm-6">정보 저장 하실건가요</div>
											<br> <br> <br>

											<div class="col-md-12">
												<div class="text-center">
													<button type="button"
														class="btn pink-gradient btn-rounded btn-lg font-weight-bold">로그인</button>
													<button type="button"
														class="btn btn-white btn-rounded btn-lg orange-text font-weight-bold ml-lg-0 wow fadeIn">취소</button>
												</div>
											</div>
										</div>
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
		<footer
			class="page-footer text-center text-md-left unique-color-dark pt-0 mt-0">

			<div class="top-pink-footer">
				<div class="container">

					<!-- Grid row -->
					<div class="row py-4 d-flex align-items-center">

						<!-- Grid column -->
						<div class="col-md-6 col-lg-5 text-center text-md-left mb-md-0">
							<h6 class="mb-4 mb-md-0 white-text">Get connected with us on
								social networks!</h6>
						</div>
						<!-- Grid column -->

						<!-- Grid column -->
						<div class="col-md-6 col-lg-7 text-center text-md-right">
							<!-- Facebook -->
							<a class="p-2 m-2 fa-lg fb-ic ml-0"> <i
								class="fab fa-facebook-f white-text mr-lg-4"> </i>
							</a>
							<!-- Twitter -->
							<a class="p-2 m-2 fa-lg tw-ic"> <i
								class="fab fa-twitter white-text mr-lg-4"> </i>
							</a>
							<!-- Google + -->
							<a class="p-2 m-2 fa-lg gplus-ic"> <i
								class="fab fa-google-plus-g white-text mr-lg-4"> </i>
							</a>
							<!-- Linkedin -->
							<a class="p-2 m-2 fa-lg li-ic"> <i
								class="fab fa-linkedin-in white-text mr-lg-4"> </i>
							</a>
							<!-- Instagram -->
							<a class="p-2 m-2 fa-lg ins-ic"> <i
								class="fab fa-instagram white-text mr-lg-4"> </i>
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

      $('#input_starttime').pickatime({
// Light or Dark theme
darktheme: true
});

// Data Picker Initialization
$('.datepicker').pickadate();
      
    </script>
</body>

</html>