<%@ page language="java" contentType="text/html; charset=utf-8"
	isErrorPage="true" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="utf-8">

<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta http-equiv="x-ua-compatible" content="ie=edge">
<title>메인 페이지 입니다</title>
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
<%
	response.setStatus(500);
%>

<body>

	<!-- Navigation & Intro -->
	<header>



		<!-- Intro Section -->
		<section class="text-center  view intro-4"
			style="background-image: url('https://mdbootstrap.com/img/Photos/Others/images/91.jpg'); background-repeat: no-repeat; background-size: cover; background-position: center center;"
			id="home">
			<div class="mask rgba-indigo-light">


				<div
					class="container h-100 d-flex justify-content-center align-items-center wow fadeIn">
					<!-- Grid column -->
					<div class="col-lg-12 col-md-12 mb-12">
						<!-- Card -->
						<div class="card card-image">
							<!-- Content -->
							<div
								class="text-white text-center pricing-card d-flex align-items-center background-color: rgba(255, 0, 0, 0.3) py-3 px-3 rounded">

								<!-- Content -->
								<div class="card-body">
									<h1 id="con_gongju" class="font-weight-bold mt-2">전화번호나
										비밀번호를 다시 확인하시고 입력해 주세요</h1>
									<form name="form" method="post" onsubmit="return checkEmpty();">
										<div class="card-body mx-4">
											<div
												class="md-form font-weight-bold text-white mt-2 brown-lighter-hover">
												<input type="text" id="mobile" class="form-control" value=""
													name="mobile"> <label for="mobile">전화전호</label>
											</div>
											<div
												class="md-form font-weight-bold text-white mt-2 brown-lighter-hover">
												<input type="password" id="password" class="form-control"
													value="" name="password"> <label for="password">비밀번호</label>
											</div>
										</div>
									
									<!--Grid row-->
									<div class="row d-flex align-items-center  mb-3 mt-4">

										<!--Grid column-->

										<div class="col-md-12">
											<div class="text-center">

												<div class="container">
												
													<div class="row justify-content-md-center">
													
														<button type="submit" class="btn pink-gradient btn-rounded btn-lg font-weight-bold" onclick="javascript: form.action='checkClient.do';">로그인</button></form>

														<form>
															<button type="submit"
																class=" btn pink-gradient btn-rounded btn-lg font-weight-bold"
																onclick="javascript: form.action='joinPage.do';">회원가입</button>
														</form>

														<form>
															<button type="submit"
																class=" btn pink-gradient btn-rounded btn-lg font-weight-bold"
																onclick="javascript: form.action='cancel.do';">취소</button>
														</form>
														
													</div>
													<br>
													<form>
															<button type="submit" method="post"
																class="btn btn-white btn-rounded btn-lg orange-text font-weight-bold wow fadeIn"
																onclick="javascript: form.action='findPwPage.do';" data-wow-delay="0.6s">비밀번호 찾기</button>
														</form>
												</div>

											</div>

										</div>
										<!--Grid column-->
									</div>
									<!--Grid row-->

								</div>
							</div>

						</div>
		</section>
	</header>

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
      if ($("#mobile").val() == '') {
        alert('전화번호를 입력해주세요');
        $("#mobile").focus();
        return false;
      } else if ($("#password").val() == '') {
        alert('비밀번호를 입력해주세요');
        $("#password").focus();
        return false;
      }
    }

  </script>

</body>

</html>