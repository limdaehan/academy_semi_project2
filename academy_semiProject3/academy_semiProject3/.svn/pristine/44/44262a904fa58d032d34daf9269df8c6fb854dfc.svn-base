<%@page import="project.ClientVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
<title>공용주차장 찾기</title>

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
    .map_wrap, .map_wrap * {
	margin: 0;
	padding: 0;
	font-family: 'Malgun Gothic', dotum, '돋움', sans-serif;
	font-size: 12px;
}

.map_wrap a, .map_wrap a:hover, .map_wrap a:active {
	color: #000;
	text-decoration: none;
}

.map_wrap {
	position: relative;
	width: 100%;
	height: 500px;
}

#menu_wrap {
	position: absolute;
	top: 0;
	left: 0;
	bottom: 0;
	width: 300px;
	margin: 10px 0 30px 10px;
	padding: 5px;
	overflow-y: auto;
	background: rgba(255, 255, 255, 0.7);
	z-index: 1;
	font-size: 12px;
	border-radius: 10px;
}

.bg_white {
	background: #fff;
}

#menu_wrap hr {
	display: block;
	height: 1px;
	border: 0;
	border-top: 2px solid #5F5F5F;
	margin: 3px 0;
}

#menu_wrap .option {
	text-align: center;
}

#menu_wrap .option p {
	margin: 10px 0;
}

#menu_wrap .option button {
	margin-left: 5px;
}

#placesList li {
	list-style: none;
}

#placesList .item {
	position: relative;
	border-bottom: 1px solid #888;
	overflow: hidden;
	cursor: pointer;
	min-height: 65px;
}

#placesList .item span {
	display: block;
	margin-top: 4px;
}

#placesList .item h5, #placesList .item .info {
	text-overflow: ellipsis;
	overflow: hidden;
	white-space: nowrap;
}

#placesList .item .info {
	padding: 10px 0 10px 55px;
}

#placesList .info .gray {
	color: #8a8a8a;
}

#placesList .info .jibun {
	padding-left: 26px;
	background:
		url(http://t1.daumcdn.net/localimg/localimages/07/mapapidoc/places_jibun.png)
		no-repeat;
}

#placesList .info .tel {
	color: #009900;
}

#placesList .item .markerbg {
	float: left;
	position: absolute;
	width: 36px;
	height: 37px;
	margin: 10px 0 0 10px;
	background:
		url(http://t1.daumcdn.net/localimg/localimages/07/mapapidoc/marker_number_blue.png)
		no-repeat;
}

#placesList .item .marker_1 {
	background-position: 0 -10px;
}

#placesList .item .marker_2 {
	background-position: 0 -56px;
}

#placesList .item .marker_3 {
	background-position: 0 -102px
}

#placesList .item .marker_4 {
	background-position: 0 -148px;
}

#placesList .item .marker_5 {
	background-position: 0 -194px;
}

#placesList .item .marker_6 {
	background-position: 0 -240px;
}

#placesList .item .marker_7 {
	background-position: 0 -286px;
}

#placesList .item .marker_8 {
	background-position: 0 -332px;
}

#placesList .item .marker_9 {
	background-position: 0 -378px;
}

#placesList .item .marker_10 {
	background-position: 0 -423px;
}

#placesList .item .marker_11 {
	background-position: 0 -470px;
}

#placesList .item .marker_12 {
	background-position: 0 -516px;
}

#placesList .item .marker_13 {
	background-position: 0 -562px;
}

#placesList .item .marker_14 {
	background-position: 0 -608px;
}

#placesList .item .marker_15 {
	background-position: 0 -654px;
}

#pagination {
	margin: 10px auto;
	text-align: center;
}

#pagination a {
	display: inline-block;
	margin-right: 10px;
}

#pagination .on {
	font-weight: bold;
	cursor: default;
	color: #777;
}
    #total_container {
	background: white;
	width: auto;
	height: auto;
	max-width: 1150px;
	max-height: 850px;
	margin: 0 auto;
}

#menuborder {
	border-bottom: 2px solid #4B515D;
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
              <div class="text-white text-center pricing-card d-flex align-items-center">

                <!-- Content1111111 -->
                <div >

                 <div id="total_container" style="background-color: rgba(255, 0, 0, 0.3) py-3 px-3 rounded; overflow: hidden; " >
                  <div id="information_form">
                  <div class="card" >
                    <div class="card-body" 
                      style="width: auto; font-size: 20px; color: white; background: #ff4081;">
                      <strong>공유주차장 확인</strong>
                    </div>
                  </div>
                  <%ClientVO vo = (ClientVO) session.getAttribute("vo"); %>
                  <form name=address method=post action=addressPage.do>
                    <ul class="nav grey lighten-4 py-4"
                      style="height: 110px; width: 1175px;" id="menuborder">
                      &emsp;&emsp;
                      <li><label for="adminMobile" class="indigo-text"
                        style="text-align: center;"><strong>등록전화번호</strong></label> <input
                        type="text" value="<%=vo.getMobile()%>" style="text-align:center;" name="adminMobile"
                        id="adminMobile" class="form-control" /></li> 
                        &emsp;&emsp;&emsp;&emsp;
                      <li><div><p style="color:black; font-family:'Malgun Gothic', dotum, '돋움', sans-serif; font-size:15px;">좌측의 검색기능을 활용하여 서울시 각 구의 공용주차장을 확인하세요<br>
                      공용주차장이 차들로 가득차 있거나, 위치상 이용에 적절하지 않은 경우 개인 공유주차장을 활용해보세요.</p>
                      </div>
                      </li>
                      &emsp;
                      <li><img src="resources/img/smile.png" style="width:65px; height:65px;"/>
                      </li>
                    </ul>
                  </form>
                </div>

                <div id="container">
                    <div class="map_wrap">
                      <div id="map"
                        style="width: 1175px; height: 500px; position: relative; overflow: hidden; margin: 0 auto;"></div>
              
                      <div id="menu_wrap" class="bg_white">
                        <div class="option" style="height: 25px;">
                          <div>
                            <form onsubmit="searchPlaces(); return false;">
                            <ul class="list-group list-group-horizontal">
                                 <li style="width: 200px;"><select name="keyword" id="keyword" class="custom-select custom-select-sm">
                                <option value=" ">전체</option>
                                <option value="강남구">강남구</option>
                                <option value="강동구">강동구</option>
                                <option value="강북구">강북구</option>
                                <option value="강서구">강서구</option>
                                <option value="관악구">관악구</option>
                                <option value="광진구">광진구</option>
                                <option value="구로구">구로구</option>
                                <option value="금천구">금천구</option>
                                <option value="노원구">노원구</option>
                                <option value="도봉구">도봉구</option>
                                <option value="동대문구">동대문구</option>
                                <option value="동작구">동작구</option>
                                <option value="마포구">마포구</option>
                                <option value="서대문구">서대문구</option>
                                <option value="서초구">서초구</option>
                                <option value="성동구">성동구</option>
                                <option value="성북구">성북구</option>
                                <option value="송파구">송파구</option>
                                <option value="양천구">양천구</option>
                                <option value="영등포구">영등포구</option>
                                <option value="용산구">용산구</option>
                                <option value="은평구">은평구</option>
                                <option value="종로구">종로구</option>
                                <option value="중구">중구</option>
                                <option value="중랑구">중랑구</option>
                              </select></li>
                              <li style="width:100px;"><button type="submit" class="btn btn-brown" style="width:100px; height:28px;">검색하기</button></li>
                              </ul>
                            </form>
                          </div>
                        </div>
                        <hr>
                        <ul id="placesList"></ul>
                        <div id="pagination"></div>
                      </div>
                    </div>
                  </div>
                </div>
<!-- Content1111111 -->
                </div>
<!-- Content1111111 -->

              </div>
              <!-- Card -->
            </div>
            <!-- Grid column -->


            <!-- Grid row -->
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
        </div>
      </div>
    </footer>
	

	<script type="text/javascript"
		src="//dapi.kakao.com/v2/maps/sdk.js?appkey=28df0e330a1fae6da72324685f22a583&libraries=services"></script>

	<script>
		// 마커를 담을 배열입니다
		var markers = [];

		var mapContainer = document.getElementById('map'), // 지도를 표시할 div 
		mapOption = {
			center : new kakao.maps.LatLng(37.566826, 126.9786567), // 지도의 중심좌표
			level : 3
		// 지도의 확대 레벨
		};

		// 지도를 생성합니다    
		var map = new kakao.maps.Map(mapContainer, mapOption);

		// 장소 검색 객체를 생성합니다
		var ps = new kakao.maps.services.Places();

		// 검색 결과 목록이나 마커를 클릭했을 때 장소명을 표출할 인포윈도우를 생성합니다
		var infowindow = new kakao.maps.InfoWindow({
			zIndex : 1
		});

		// 키워드로 장소를 검색합니다
		searchPlaces();

		// 키워드 검색을 요청하는 함수입니다
		function searchPlaces() {

			var keyword = document.getElementById('keyword').value;

			if (!keyword.replace(/^\s+|\s+$/g, '')) {
				return false;
			}

			// 장소검색 객체를 통해 키워드로 장소검색을 요청합니다
			ps.keywordSearch(keyword, placesSearchCB);
		}

		// 장소검색이 완료됐을 때 호출되는 콜백함수 입니다
		function placesSearchCB(data, status, pagination) {
			if (status === kakao.maps.services.Status.OK) {

				// 정상적으로 검색이 완료됐으면
				// 검색 목록과 마커를 표출합니다
				displayPlaces(data);

				// 페이지 번호를 표출합니다
				displayPagination(pagination);

			} else if (status === kakao.maps.services.Status.ZERO_RESULT) {

				alert('검색 결과가 존재하지 않습니다.');
				return;

			} else if (status === kakao.maps.services.Status.ERROR) {

				alert('검색 결과 중 오류가 발생했습니다.');
				return;

			}
		}

		// 검색 결과 목록과 마커를 표출하는 함수입니다
		function displayPlaces(places) {

			var listEl = document.getElementById('placesList'), menuEl = document
					.getElementById('menu_wrap'), fragment = document
					.createDocumentFragment(), bounds = new kakao.maps.LatLngBounds(), listStr = '';

			// 검색 결과 목록에 추가된 항목들을 제거합니다
			removeAllChildNods(listEl);

			// 지도에 표시되고 있는 마커를 제거합니다
			removeMarker();

			for (var i = 0; i < places.length; i++) {

				// 마커를 생성하고 지도에 표시합니다
				var placePosition = new kakao.maps.LatLng(places[i].y,
						places[i].x), marker = addMarker(placePosition, i), itemEl = getListItem(
						i, places[i]); // 검색 결과 항목 Element를 생성합니다

				// 검색된 장소 위치를 기준으로 지도 범위를 재설정하기위해
				// LatLngBounds 객체에 좌표를 추가합니다
				bounds.extend(placePosition);

				// 마커와 검색결과 항목에 mouseover 했을때
				// 해당 장소에 인포윈도우에 장소명을 표시합니다
				// mouseout 했을 때는 인포윈도우를 닫습니다
				(function(marker, title) {
					kakao.maps.event.addListener(marker, 'mouseover',
							function() {
								displayInfowindow(marker, title);
							});

					kakao.maps.event.addListener(marker, 'mouseout',
							function() {
								infowindow.close();
							});

					itemEl.onmouseover = function() {
						displayInfowindow(marker, title);
					};

					itemEl.onmouseout = function() {
						infowindow.close();
					};
				})(marker, places[i].place_name);

				fragment.appendChild(itemEl);
			}

			// 검색결과 항목들을 검색결과 목록 Elemnet에 추가합니다
			listEl.appendChild(fragment);
			menuEl.scrollTop = 0;

			// 검색된 장소 위치를 기준으로 지도 범위를 재설정합니다
			map.setBounds(bounds);
		}

		var roadview = new kakao.maps.Roadview(rvContainer);

		function makeLoadview(places) {
			var roadviewContainer = document.getElementById('roadview'); //로드뷰를 표시할 div
			var roadview = new kakao.maps.Roadview(roadviewContainer); //로드뷰 객체
			var roadviewClient = new kakao.maps.RoadviewClient(); //좌표로부터 로드뷰 파노ID를 가져올 로드뷰 helper객체

			var position = new kakao.maps.LatLng(places[i].y, places[i].x);

			// 특정 위치의 좌표와 가까운 로드뷰의 panoId를 추출하여 로드뷰를 띄운다.
			roadviewClient.getNearestPanoId(position, 50, function(panoId) {
				roadview.setPanoId(panoId, position); //panoId와 중심좌표를 통해 로드뷰 실행
			});
		}

		// 검색결과 항목을 Element로 반환하는 함수입니다
		function getListItem(index, places) {

			var el = document.createElement('li'), itemStr = '<span class="markerbg marker_'
					+ (index + 1)
					+ '"></span>'
					+ '<div class="info">'
					+ '   <h5>'
					+ places.place_name
					+ '</h5>'
					+ '<button onclick="roadView('
					+ places.y
					+ ','
					+ places.x
					+ ')">로드뷰</button>';

			if (places.road_address_name) {
				itemStr += '    <span>' + places.road_address_name + '</span>'
						+ '   <span class="jibun gray">' + places.address_name
						+ '</span>';
			} else {
				itemStr += '    <span>' + places.address_name + '</span>';
			}

			itemStr += '  <span class="tel">' + places.phone + '</span>'
					+ '</div>';

			el.innerHTML = itemStr;
			el.className = 'item';

			return el;
		}

		// 마커를 생성하고 지도 위에 마커를 표시하는 함수입니다
		function addMarker(position, idx, title) {
			var imageSrc = 'http://t1.daumcdn.net/localimg/localimages/07/mapapidoc/marker_number_blue.png', // 마커 이미지 url, 스프라이트 이미지를 씁니다
			imageSize = new kakao.maps.Size(36, 37), // 마커 이미지의 크기
			imgOptions = {
				spriteSize : new kakao.maps.Size(36, 691), // 스프라이트 이미지의 크기
				spriteOrigin : new kakao.maps.Point(0, (idx * 46) + 10), // 스프라이트 이미지 중 사용할 영역의 좌상단 좌표
				offset : new kakao.maps.Point(13, 37)
			// 마커 좌표에 일치시킬 이미지 내에서의 좌표
			}, markerImage = new kakao.maps.MarkerImage(imageSrc, imageSize,
					imgOptions), marker = new kakao.maps.Marker({
				position : position, // 마커의 위치
				image : markerImage
			});

			marker.setMap(map); // 지도 위에 마커를 표출합니다
			markers.push(marker); // 배열에 생성된 마커를 추가합니다

			return marker;
		}

		// 지도 위에 표시되고 있는 마커를 모두 제거합니다
		function removeMarker() {
			for (var i = 0; i < markers.length; i++) {
				markers[i].setMap(null);
			}
			markers = [];
		}

		// 검색결과 목록 하단에 페이지번호를 표시는 함수입니다
		function displayPagination(pagination) {
			var paginationEl = document.getElementById('pagination'), fragment = document
					.createDocumentFragment(), i;

			// 기존에 추가된 페이지번호를 삭제합니다
			while (paginationEl.hasChildNodes()) {
				paginationEl.removeChild(paginationEl.lastChild);
			}

			for (i = 1; i <= pagination.last; i++) {
				var el = document.createElement('a');
				el.href = "#";
				el.innerHTML = i;

				if (i === pagination.current) {
					el.className = 'on';
				} else {
					el.onclick = (function(i) {
						return function() {
							pagination.gotoPage(i);
						}
					})(i);
				}

				fragment.appendChild(el);
			}
			paginationEl.appendChild(fragment);
		}

		// 검색결과 목록 또는 마커를 클릭했을 때 호출되는 함수입니다
		// 인포윈도우에 장소명을 표시합니다
		function displayInfowindow(marker, title) {
			var content = '<div style="padding:5px;z-index:1;">' + title
					+ '</div>';

			infowindow.setContent(content);
			infowindow.open(map, marker);
		}

		// 검색결과 목록의 자식 Element를 제거하는 함수입니다
		function removeAllChildNods(el) {
			while (el.hasChildNodes()) {
				el.removeChild(el.lastChild);
			}
		}

		/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		var container = document.getElementById('container'), // 지도와 로드뷰를 감싸고 있는 div 입니다
		mapWrapper = document.getElementById('map_wrap'), // 지도를 감싸고 있는 div 입니다
		btnRoadview = document.getElementById('btnRoadview'), // 지도 위의 로드뷰 버튼, 클릭하면 지도는 감춰지고 로드뷰가 보입니다 
		btnMap = document.getElementById('btnMap'), // 로드뷰 위의 지도 버튼, 클릭하면 로드뷰는 감춰지고 지도가 보입니다 
		rvContainer = document.getElementById('roadview'), // 로드뷰를 표시할 div 입니다
		mapContainer = document.getElementById('map'); // 지도를 표시할 div 입니다

		// 지도와 로드뷰 위에 마커로 표시할 특정 장소의 좌표입니다 
		var placePosition = new kakao.maps.LatLng(33.450701, 126.570667);

		// 지도 옵션입니다 
		var mapOption = {
			center : placePosition, // 지도의 중심좌표 
			level : 3
		// 지도의 확대 레벨
		};

		// 지도를 표시할 div와 지도 옵션으로 지도를 생성합니다
		var map = new kakao.maps.Map(mapContainer, mapOption);

		// 로드뷰 객체를 생성합니다 
		var roadview = new kakao.maps.Roadview(rvContainer);

		// 로드뷰의 위치를 특정 장소를 포함하는 파노라마 ID로 설정합니다
		// 로드뷰의 파노라마 ID는 Wizard를 사용하면 쉽게 얻을수 있습니다 
		roadview.setPanoId(1023434522, placePosition);

		// 특정 장소가 잘보이도록 로드뷰의 적절한 시점(ViewPoint)을 설정합니다 
		// Wizard를 사용하면 적절한 로드뷰 시점(ViewPoint)값을 쉽게 확인할 수 있습니다
		roadview.setViewpoint({
			pan : 321,
			tilt : 0,
			zoom : 0
		});

		// 지도 중심을 표시할 마커를 생성하고 특정 장소 위에 표시합니다 
		var mapMarker = new kakao.maps.Marker({
			position : placePosition,
			map : map
		});

		// 로드뷰 초기화가 완료되면 
		kakao.maps.event.addListener(roadview, 'init', function() {

			// 로드뷰에 특정 장소를 표시할 마커를 생성하고 로드뷰 위에 표시합니다 
			var rvMarker = new kakao.maps.Marker({
				position : placePosition,
				map : roadview
			});
		});

		// 지도와 로드뷰를 감싸고 있는 div의 class를 변경하여 지도를 숨기거나 보이게 하는 함수입니다 
		function toggleMap(active) {
			if (active) {

				// 지도가 보이도록 지도와 로드뷰를 감싸고 있는 div의 class를 변경합니다
				container.className = "view_map"
			} else {

				// 지도가 숨겨지도록 지도와 로드뷰를 감싸고 있는 div의 class를 변경합니다
				container.className = "view_roadview"
			}
		}
	</script>


	<!-- Bootstrap tooltips -->
	<script type="text/javascript" src="resources/js/popper.min.js"></script>
	<!-- Bootstrap core JavaScript -->
	<script type="text/javascript" src="ressources/js/bootstrap.min.js"></script>
	<!-- MDB core JavaScript -->
	<script type="text/javascript" src="resources/js/mdb.min.js"></script>


</body>
</html>