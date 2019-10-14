<%@page import="project.ClientVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="x-ua-compatible" content="ie=edge">
<title>Insert title here</title>



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
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<link rel="stylesheet"
	href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">

<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.8.2/css/all.css">
<!-- Bootstrap core CSS -->
<link href="resources/css/bootstrap.min.css" rel="stylesheet">
<!-- Material Design Bootstrap -->
<link href="resources/css/mdb.min.css" rel="stylesheet">

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
.ui-timepicker {
	font-size: 12px;
	width: 80px;
}

#tablestyle {
	position: relative;
	z-index: 10;
}

#timepicker1 {
	position: relative;
	z-index: 4;
}

#timepicker2 {
	position: relative;
	z-index: 4;
}
</style>

</head>
<body>
	<!-- Navigation & Intro -->
	<% ClientVO vo = (ClientVO)session.getAttribute("vo");  %>
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
              <div class=" pricing-card d-flex  background-color: rgba(255, 0, 0, 0.3) py-3 px-3 rounded">

                <!-- Content -->
                <div class="card-body">
                  <h2 class="section-heading h1 pt-4 text-center">주차장 공유하기</h2>
                  <!--Section description-->
                  <p class="section-description pb-4 text-center">여러분이 회사를 가거나
                    여행을 다닐때 비어있는 주차장을 통해서 경제적으로 이득을 보세요 저희 공주님은 여러분의 주차장을 공유해드립니다</p>




                  <div class="row">
                    <div class="col-lg-5 mb-4">
                      <div class="card">
                        <div class="card-body">
                          <div class="form-header warning-color accent-1">
                            <h3>
                              <i class="fas fa-parking"></i> 빌려주기
                            </h3>
                          </div>

                          <p>공유 가능한 여러분의 주차 공간과 날짜 시간 금액을 입력해주세요</p>
                          <br>
                          <h3>
                            <i class="far fa-calendar-check light-blue-text fa-1x"></i>
                            공유 일자를 입력하세요 </h3>
                          <form name=address method=post action="addParkingLot.do" id="tablestyle">
                          <input type="hidden" name="mobile" value="<%=vo.getMobile() %>"/>
                          <div id="lonlat"></div>
	                            <div class="row">
	                              <div class="col-6 md-form">
	                                <input type="text" name="start_day" id="fromDate" class="form-control form-control-sm" value="" placeholder="공유일자" />
	                              </div>
	
	                              <div class="col-6 md-form">
	                                <input type="text" name="start_time" id="timepicker1" class="form-control form-control-sm"
	                                  placeholder="공유 시간" />
	                              </div>
	
	                              <br>
	
	
	                              <div class="col-6 md-form ">
	                                <input type="text" name="end_day" id="toDate" class="form-control form-control-sm"
	                                  placeholder="종료일자" />
	                              </div>
	
	
	                              <div class="col-6 md-form ">
	                                <input type="text" name="end_time" id="timepicker2" class="form-control form-control-sm"
	                                  placeholder="종료시간" />
	                              </div>
	                            </div>
	                            <br>
	                            <div class="row">
	                              <div class="col-sm-1 md-form"><i class="fas fa-dollar-sign prefix green-text"></i></div>
	                              <div class="col-sm-1 md-form"></div>
	                              <div class="col-sm-5 md-form">
	
	                                <div>
	                                  <label for="price"> <span style="font-size: 15px"> 30분당 주차 이용 비용</span></label>
	                                </div>
	                              </div>
	                              <div class="md-form col-4">
	                                <input type="text" id="price" class="form-control form-control-sm" name="price">
	
	                              </div>
	
	                              <div class="text-center md-form col-1" style="font-size: 20px;">
	                               			 원</div>
	
	
	                            </div>
	                            <div class="text-center mt-4">
	                              <button type="submit" class="btn btn-warning" onclick="checkEmpty()">등록하기</button>
	                            </div>
	
	
	                              </div>
	
	                            </div>
	                            <!--Form with header-->
	          
	                            <!--Grid column-->
	                          </div>
	                          
	                          <div class="col-lg-7" id="ssss">
	
										
	                              <div id="map" style="width: 100%; height: 540px;"></div>
	            
	            
	                              <br>
	                              <!--Buttons-->
	                              <div class="row">
	                                <div class="col-1"></div>
	                                <input class="col-9" type="text" id="adress" placeholder="주차장의 위치를 입력하고 옆에 버튼을 눌러주세요" >
	            
	                                <div class="col-2">
	                                  <a class="btn-floating warning-color accent-1"> <i
	                                    class="fas fa-map-marked-alt" onclick="searchPlace()"></i>
	                                  </a>
	                                </div>
	            
	                              </div>
	            
	                            </div>
                          </form>


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


		<!-- Card -->
	</header>
	
	<!-- 한상이형
   <form name=address method=post action=addParkingLot.do />
   
   
<table>
   <tr>
   <tr><th>시작날짜<input type="text" name="start_day" id="fromDate">시간<input type="text" name="start_time" id='timepicker1'></th></tr>
   <tr><th>끝나는 날짜<input type="text" name="end_day" id="toDate">시간<input type="text"  name="end_time" id='timepicker2'></th></tr>
   <tr><th>가격(10분 당)<input type="text" name="price" value="가격"></th></tr>
   </tr>
    
</table>
<input type="submit" value="등록하기">
</form>

주차장 주소<textarea id="adress" ></textarea>
<input type="button" onclick="searchPlace()" value="찾기"/> 

<p style="margin-top:-12px">
    <em class="link">
        <!-- <a href="javascript:void(0);" onclick="window.open('http://fiy.daum.net/fiy/map/CsGeneral.daum', '_blank', 'width=981, height=650')">
            혹시 주소 결과가 잘못 나오는 경우에는 여기에 제보해주세요.
        </a>
	</em>
	</p> -->


	<script type="text/javascript"
		src="//dapi.kakao.com/v2/maps/sdk.js?appkey=28df0e330a1fae6da72324685f22a583&libraries=services"></script>
	<script>
		function addLonlat(y, x, adress) {
			$('#lonlat')
					.html(
							'<input type="hidden" name="y" value="'+y+'"/><input type="hidden" name="x" value="'+x+'"/><input type="hidden" name="adress" value="'+adress+'"/>')
		}
		function searchPlace() {
			var adress = document.getElementById('adress').value;
			var mapContainer = document.getElementById('map'), // 지도를 표시할 div 
			mapOption = {
				center : new kakao.maps.LatLng(33.450701, 126.570667), // 지도의 중심좌표
				level : 3
			// 지도의 확대 레벨
			};

			// 지도를 생성합니다    
			var map = new kakao.maps.Map(mapContainer, mapOption);

			// 주소-좌표 변환 객체를 생성합니다
			var geocoder = new kakao.maps.services.Geocoder();

			// 주소로 좌표를 검색합니다

			geocoder
					.addressSearch(
							"'" + adress + "'",
							function(result, status) {
								var adress = document.getElementById('adress').value;
								// 정상적으로 검색이 완료됐으면 
								if (status === kakao.maps.services.Status.OK) {

									var coords = new kakao.maps.LatLng(
											result[0].y, result[0].x);
									addLonlat(result[0].y, result[0].x, adress);
									// 결과값으로 받은 위치를 마커로 표시합니다
									var marker = new kakao.maps.Marker({
										map : map,
										position : coords
									});

									// 인포윈도우로 장소에 대한 설명을 표시합니다
									var infowindow = new kakao.maps.InfoWindow(
											{
												content : '<div style="width:150px;text-align:center;padding:6px 0;">공주님</div>'
											});
									infowindow.open(map, marker);

									// 지도의 중심을 결과값으로 받은 위치로 이동시킵니다
									map.setCenter(coords);
								}
							});
		}
	</script>


	<script type="text/javascript">
		$(function() {
			$('#fromDate, #toDate').datepicker(
					{
						changeMonth : true,
						dateFormat : 'yy.mm.dd',
						dayNames : [ '월요일', '화요일', '수요일', '목요일', '금요일', '토요일',
								'일요일' ],
						dayNamesMin : [ '월', '화', '수', '목', '금', '토', '일' ],
						monthNamesShort : [ '1', '2', '3', '4', '5', '6', '7',
								'8', '9', '10', '11', '12' ],
						monthNames : [ '1월', '2월', '3월', '4월', '5월', '6월',
								'7월', '8월', '9월', '10월', '11월', '12월' ]
					});
		});

		$(function() {
			$('#timepicker1, #timepicker2').timepicker({
				timeFormat : 'H:i',
				step : 30
			});
		});
		
		
	</script>
	
	<script>
	 function checkEmpty() {
      	if($("#fromDate").val()==''){
      		alert('시작 날짜를 입력해주세요');
      		$("#fromDate").focus();
      		return false;
      	} else if($("#password").val()==''){
      		alert('비밀번호를 입력해주세요');
      		$("#password").focus();
      		return false;
      	}
      }
	 </script>
	 
	<script type="text/javascript"
		src="resources/js/timepicker/jquery.timepicker.min.js"></script>
	<!-- 타이머js -->
	<link type="text/css" rel="stylesheet"
		href="resources/js/timepicker/jquery.timepicker.css" media="" />
	<!-- 타이머css -->


</body>
</html>