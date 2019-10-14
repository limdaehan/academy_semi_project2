<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="project.ClientVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<title>개인주차장</title>
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
 <link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/jquery.jqChart.css"/>" />
        <link rel="stylesheet" type="text/css" href="<c:url value="/resources/themes/le-frog/styles.css"/>" />
        <%-- <script src="<c:url value="/resources/js/jquery-1.11.1.min.js"/>" type="text/javascript"></script> --%>
        <script src="<c:url value="/resources/js/jquery.jqChart.min.js"/>" type="text/javascript"></script>

<style>
html, body, header, .intro-4 {
   height: 100%;
}
object {
	width: 100%;
	margin-left: -575px;
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

.wrap {
   position: absolute;
   left: 0;
   bottom: 40px;
   width: 288px;
   height: 132px;
   margin-left: -144px;
   text-align: left;
   overflow: hidden;
   font-size: 12px;
   font-family: 'Malgun Gothic', dotum, '돋움', sans-serif;
   line-height: 1.5;
}

.wrap * {
   padding: 0;
   margin: 0;
}

.wrap .info {
   width: 286px;
   height: 120px;
   border-radius: 5px;
   border-bottom: 2px solid #ccc;
   border-right: 1px solid #ccc;
   overflow: hidden;
   background: #fff;
}

.wrap .info:nth-child(1) {
   border: 0;
   box-shadow: 0px 1px 2px #888;
}

.info .title {
   padding: 5px 0 0 10px;
   height: 30px;
   background: #eee;
   border-bottom: 1px solid #ddd;
   font-size: 18px;
   font-weight: bold;
}

.info .close {
   position: absolute;
   top: 10px;
   right: 10px;
   color: #888;
   width: 17px;
   height: 17px;
   background:
      url('http://t1.daumcdn.net/localimg/localimages/07/mapapidoc/overlay_close.png');
}

.info .close:hover {
   cursor: pointer;
}

.info .body {
   position: relative;
   overflow: hidden;
   color: black;
}

.info .desc {
   position: relative;
   margin: 13px 0 0 90px;
   height: 75px;
}

.desc .ellipsis {
   overflow: hidden;
   text-overflow: ellipsis;
   white-space: nowrap;
}

.desc .jibun {
   font-size: 11px;
   color: #888;
   margin-top: -2px;
}

.info .img {
   position: absolute;
   top: 6px;
   left: 5px;
   width: 73px;
   height: 71px;
   border: 1px solid #ddd;
   color: #888;
   overflow: hidden;
}

.info:after {
   content: '';
   position: absolute;
   margin-left: -12px;
   left: 50%;
   bottom: 0;
   width: 22px;
   height: 12px;
   background:
      url('http://t1.daumcdn.net/localimg/localimages/07/mapapidoc/vertex_white.png')
}

.info .link {
   color: #5085BB;
}

#container {
   overflow: hidden;
   height: 600px;
   position: relative;
}

#btnRoadview, #btnMap {
   z-index: 1;
   cursor: pointer;
}

#btnRoadview:hover, #btnMap:hover {
   background-color: #fcfcfc;
   border: 1px solid #c1c1c1;
}

#container.view_map #mapWrapper {
   z-index: 10;
}

#container.view_map #btnMap {
   display: none;
}

#container.view_roadview #mapWrapper {
   z-index: 0;
}

#container.view_roadview #btnRoadview {
   display: none;
}

#totalbody {
   background:
      url('https://mdbootstrap.com/img/Photos/Others/images/91.jpg');
   background-repeat: no-repeat;
   background-size: cover;
   background-position: center center;
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
   height : 250px;
   position: relative;
   z-index: 10;
}

#menu_wrap {
   position: absolute;
   top: 0;
   left: 0;
   bottom: 0;
   width: 400px;
   height: 125px;
   margin: 10px 0 30px 10px;
   padding: 5px;
   background: rgba(255, 255, 255, 0.7);
   z-index: 1;
   border-radius: 10px;
}
</style>

</head>
<body id="totalbody">

   <header> <!-- Intro Section --> 
   <section
      class="text-center  view intro-4"
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
                     class="text-white text-center pricing-card d-flex align-items-center">
                     <!-- Content1111111 -->
                     <div>
                        <%
                           ClientVO vo = (ClientVO) session.getAttribute("vo");
                        %>
                        <div id="total_container"
                           style="background-color: rgba(255, 0, 0, 0.3) py-3 px-3 rounded; overflow: hidden;">
                           <div id="information_form">
                              <form name="loan" method="get" action="sendTest.do">
                                 <div class="card-body"
                                    style="width: auto; background: #4db6ac;">
                                    <ul class="list-group list-group-horizontal">
                                       <li style="text-align: center;">
                                          <p style="font-size: 20px; color: white;">
                                             <strong>개인주차장 확인</strong>
                                          </p>
                                       </li>
                                       <li style="text-align: right;">
                                          <p>등록전화번호</p>
                                       </li>
                                       <li style="text-align: right;"><input type="text"
                                          value="<%=vo.getMobile()%>" name="clientMobile"
                                          id="adminMobile" class="form-control" style="width: 10px;" />
                                          <input type="text"
                                          value="<%=vo.getCarNum()%>" name="clientCarNum"
                                          id="adminMobile" class="form-control" style="width: 10px;" />
                                       </li>
                                    </ul>
                                 </div>

                                 <div id="hiddenVal">
                                    
                                 </div>
                                 <br>
                                 <ul class="list-group list-group-horizontal"
                                    style="height: 110px; width: 1175px;" id="menuborder">
                                    &emsp;&emsp;&emsp;&emsp;
                                    <li class="md-form form-sm"><label class="teal-text">대여일자</label>
                                       <input type="text" name="startDay" id="fromDate"
                                       class="form-control form-control-sm"
                                       placeholder="대여일자를 입력해주세요" /></li> &emsp;&emsp;
                                    <li class="md-form form-sm"><label class="teal-text">시간</label>
                                       <input type="text" id="timepicker1" name="startTime"
                                       class="form-control form-control-sm"
                                       placeholder="시간을 입력해주세요" /></li> &emsp;&emsp;
                                    <li class="md-form form-sm"><label class="teal-text">반납일자</label>
                                       <input type="text" name="endDay" id="toDate"
                                       class="form-control form-control-sm"
                                       placeholder="반납일자를 입력해주세요" /></li> &emsp;&emsp;
                                    <li class="md-form form-sm"><label class="teal-text">시간</label>
                                       <input type="text" name="endTime" id="timepicker2"
                                       class="form-control form-control-sm"
                                       placeholder="시간을 입력해주세요" /></li> &emsp;&emsp;
                                    <li><label for="priceValue" class="brown-text"
                                       style="font-size: 12px;"><strong>책정가격</strong></label> <input
                                       type="text" name="price" placeholder="per/30min"
                                       id="priceValue" class="form-control form-control-sm"></li>
                                       &emsp;
                                    <li><input type="submit" class="btn btn-primary"
                                    value="빌리기" /></li>
                                 </ul>
                              </form>
                           </div>
                           <br>
                        <div id="map_container">
                           <div id="container" class="view_map">
                              <div id="mapWrapper" style="width: 100%; height: 600px; position: relative;">
                                 <div id="map" style="width: 100%; height: 100%; overflow:hidden;"></div>
                                 <!-- 지도를 표시할 div 입니다 -->
                                 <div id="menu_wrap" class="bg_white">
                                    <div class="form-group shadow-textarea">
                                            <textarea class="form-control z-depth-1" id="search" rows="2" placeholder="세부주소를 입력해주세요"></textarea>
                                    </div>
                                    <div>
                                       <ul class="list-group list-group-horizontal">
                                          <li><input type="button" id="btnRoadview" class="btn btn-deep-orange btn-sm"
                                             onclick="toggleMap(false)" title="로드뷰 보기" value="로드뷰" style="font-size:12px;"/></li>                        
                                          <li><input type="button" id="btn1" value="검색" class="btn btn-deep-orange btn-sm" style="font-size:12px;"/></li>
                                          <li><input type="button" id="btn2" title="예약현황" value="현황" class="btn btn-deep-orange btn-sm" style="font-size:12px;"/></li>
                                       </ul>
                                    </div>
                                 </div>      
                              </div>
                              

                              
                              <div id="rvWrapper" style="width: 100%; height: 600px; position: absolute; top: 0; left: 0;">
                                 <div id="roadview" style="height:100%"></div>
                                 <!-- 로드뷰를 표시할 div 입니다 -->
                                 <div id="menu_wrap" class="bg_white">
                                    <div class="form-group shadow-textarea">
                                            <textarea class="form-control z-depth-1" id="search" rows="2" placeholder="세부주소를 입력해주세요"></textarea>
                                    </div>
                                    <div>
                                    
                                       <ul class="list-group list-group-horizontal">
                                          <li><input type="button" id="btnMap" onclick="toggleMap(true)" class="btn btn-deep-orange btn-sm"
                                       title="지도 보기" value="지도"  style="font-size:12px;"></li>                        
                                          <li><input type="button" id="btn1" value="검색" class="btn btn-deep-orange btn-sm" style="font-size:12px;"/></li>
                                          <li><input type="button" id="btn2" title="예약현황" value="현황" class="btn btn-deep-orange btn-sm" style="font-size:12px;"/></li>
                                       </ul>
                                    </div>
                                    
                                              <div id="statistics" style="height: 100%"></div>                          
                                 </div>
                              </div>
                           </div>
                           
                        </div>
                     </div>
                  </div>
               </div>
            </div>
         </div>
      </div>
   </div>
   </section> 
   
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
         </div>
      </div>
   </footer> <script type="text/javascript"
      src="//dapi.kakao.com/v2/maps/sdk.js?appkey=28df0e330a1fae6da72324685f22a583"></script>
   <script type="text/javascript">
      $(function() {
         $("#fromDate, #toDate").datepicker({
            dateFormat : 'yy.mm.dd'
         });
      });

      $(function() {
         $('#timepicker1, #timepicker2').timepicker({
             timeFormat : 'H:i',
             step : 30
         });
      });
   </script> <script>
      var rv = document.getElementById('rv');
      var mapContainer = document.getElementById('view_map') // 지도를 표시할 div
      var container = document.getElementById('container'), // 지도와 로드뷰를 감싸고 있는 div 입니다
      mapWrapper = document.getElementById('mapWrapper'), // 지도를 감싸고 있는 div 입니다
      btnRoadview = document.getElementById('btnRoadview'), // 지도 위의 로드뷰 버튼, 클릭하면 지도는 감춰지고 로드뷰가 보입니다 
      btnMap = document.getElementById('btnMap'), // 로드뷰 위의 지도 버튼, 클릭하면 로드뷰는 감춰지고 지도가 보입니다 
      rvContainer = document.getElementById('roadview'), // 로드뷰를 표시할 div 입니다
      mapContainer = document.getElementById('map'); // 지도를 표시할 div 입니다
      // 로드뷰 객체를 생성합니다 
      var roadview = new kakao.maps.Roadview(rvContainer);
      var roadviewClient = new kakao.maps.RoadviewClient();

      /* ////jqchart
         var background = {
                   type: 'linearGradient',
                   x0: 0,
                   y0: 0,
                   x1: 0,
                   y1: 1,
                   colorStops: [{ offset: 0, color: '#d2e6c9' },
                                { offset: 1, color: 'white' }]
               };
      //////////jqchart
         var $body = $('<div class="body"><a href="http://www.kakaocorp.com/main" target="_blank" class="link">홈페이지</a></div>').jqChart({
               title: { text: 'Radar Line Chart' },
               border: { strokeStyle: '#6ba851' },
               background: background,
               shadows: {
                   enabled: true
               },
               animation: { duration: 1 },
               axes: [
                   {
                       type: 'categoryAngle',
                       categories: ['France', 'Canada', 'Germany', 'USA', 'Italy', 'Spain', 'Russia', 'Sweden', 'Japan']
                   }
               ],
               series: [
                   {
                       title: 'Series 1',
                       type: 'radarLine',
                       data: [65.62, 75.54, 60.45, 34.73, 85.42, 55.9, 63.6, 55.1, 77.2]
                   },
                   {
                       title: 'Series 2',
                       type: 'radarLine',
                       data: [76.45, 23.78, 86.45, 30.76, 23.79, 35.67, 89.56, 67.45, 38.98]
                   }
               ]
           }); // body 안쪽은 생략 */
      ////////////////////////////
      $('#btn1')
            .on(
                  'click',
                  function(event) {
                     event.preventDefault();
                     var form = {
                        "user" : $("#search").val()
                     }
                     $
                           .ajax({

                              url : "requestObject",
                              type : "POST",
                              data : form,
                              success : function(data) {

                                 $('#result').text(
                                       JSON.stringify(data.y));

                                 var y0 = JSON.stringify(data[0].y)
                                       .substr(1, 11)
                                 var x0 = JSON.stringify(data[0].x)
                                       .substr(1, 10)

                                 var y_n0 = parseFloat(y0)
                                 var x_n0 = parseFloat(x0)

                                 mapOption = {
                                    center : new kakao.maps.LatLng(
                                          x_n0, y_n0), // 지도의 중심좌표
                                    level : 3
                                 // 지도의 확대 레벨
                                 };
                                 // 지도를 표시할 div와 지도 옵션으로 지도를 생성합니다
                                 var map = new kakao.maps.Map(
                                       mapContainer, mapOption);

                                 var map = new kakao.maps.Map(
                                       mapContainer, mapOption); // 지도를 생성합니다
                                 var positions = [];
                                 var currentmarkImage = new kakao.maps.MarkerImage(
                                       'https://t1.daumcdn.net/localimg/localimages/07/2018/pc/roadview_minimap_wk_2018.png',
                                       new kakao.maps.Size(26, 46),
                                       {
                                          // 스프라이트 이미지를 사용합니다.
                                          // 스프라이트 이미지 전체의 크기를 지정하고
                                          spriteSize : new kakao.maps.Size(
                                                1666, 168),
                                          // 사용하고 싶은 영역의 좌상단 좌표를 입력합니다.
                                          // background-position으로 지정하는 값이며 부호는 반대입니다.
                                          spriteOrigin : new kakao.maps.Point(
                                                705, 114),
                                          offset : new kakao.maps.Point(
                                                13, 46)
                                       });
                                 var currentMarker = new kakao.maps.Marker(
                                       {
                                          image : currentmarkImage,
                                          position : mapOption.center,
                                          draggable : true,
                                          map : map
                                       });
                                 var selectedMarker = null;
                                 $
                                       .each(
                                             data,
                                             function(i, item) {

                                                // 지도와 로드뷰 위에 마커로 표시할 특정 장소의 좌표입니다 

                                                var y = JSON
                                                      .stringify(
                                                            item.y)
                                                      .substr(
                                                            1,
                                                            11)
                                                var x = JSON
                                                      .stringify(
                                                            item.x)
                                                      .substr(
                                                            1,
                                                            10)
                                                var adress = String(JSON.stringify(item.adress))
                                                adress = adress.substr(
                                                        1,
                                                        adress.length);
                                                var startDay = String(JSON.stringify(item.start_day))
                                                startDay = startDay.substr(
                                                        1,
                                                        startDay.length);
                                                var startTime = String(JSON.stringify(item.start_time))
                                                startTime = startTime.substr(
                                                        1,
                                                        startTime.length);
                                                var endDay = String(JSON.stringify(item.end_day))
                                                endDay = endDay.substr(
                                                        1,
                                                        endDay.length);
                                                var endTime = String(JSON.stringify(item.end_time))
                                                endTime = endTime.substr(
                                                        1,
                                                        endTime.length);
                                                var price = String(JSON.stringify(item.price))
                                                price = price.substr(
                                                        1,
                                                        price.length);
                                                
                                                var y_n = parseFloat(y)
                                                var x_n = parseFloat(x)

                                                position = {
                                                   title : JSON
                                                         .stringify(item.adress),

                                                   latlng : new kakao.maps.LatLng(
                                                         x_n,
                                                         y_n)
                                                };

                                                var placePosition = position.latlng

                                                // 지도와 로드뷰를 감싸고 있는 div의 class를 변경하여 지도를 숨기거나 보이게 하는 함수입니다 

                                                // 마커 이미지의 이미지 주소입니다
                                                var imageSrc = "http://t1.daumcdn.net/localimg/localimages/07/mapapidoc/markerStar.png";
                                                var clickImageSrc = "http://t1.daumcdn.net/localimg/localimages/07/mapapidoc/marker_red.png";
                                                // 마커 이미지의 이미지 크기 입니다
                                                var imageSize = new kakao.maps.Size(24, 35);

                                                // 마커 이미지를 생성합니다    
                                                var markerImage = new kakao.maps.MarkerImage(
                                                      imageSrc,
                                                      imageSize);
                                                var clickMarkerImage = new kakao.maps.MarkerImage(
                                                      clickImageSrc,
                                                      imageSize);

                                                // 마커를 생성합니다
                                                var marker = new kakao.maps.Marker(
                                                      {
                                                         map : map, // 마커를 표시할 지도
                                                         position : position.latlng, // 마커를 표시할 위치
                                                         title : position.title, // 마커의 타이틀, 마커에 마우스를 올리면 타이틀이 표시됩니다
                                                         image : markerImage
                                                      // 마커 이미지 
                                                      });

                                                var closeOverlay = function() {
                                                   overlay
                                                         .setMap(null);
                                                };
                                                // 로드뷰 객체를 생성합니다 
													
                                                var $wrap = $('<div class="wrap" />');
                                                var $info = $('<div class="info" />');
                                                var $title = $('<div class="title" />').text(adress);
                                                var $close = $(
                                                      '<div class="close" title="닫기" />')
                                                      .click(
                                                            closeOverlay);
                                                var $body = $('<div class="body"></div>').text('대여기간 : '+startDay+' '+startTime+' ~ '+endDay+' '+endTime);
                                                var $button = $('<button class="button" href="http://www.kakaocorp.com/main" target="_blank" class="link">경로</button>')

                                                $wrap.append($info);
                                                $info.append($title).append($body);
                                                $title
                                                      .append($close);
                                                $body
                                                      .append($button);

                                                var content = $wrap[0];
                                                var overlay = new kakao.maps.CustomOverlay(
                                                      {
                                                         content : content,
                                                         map : map,
                                                         position : marker
                                                               .getPosition()
                                                      });

                                                // 마커를 클릭했을 때 커스텀 오버레이를 표시합니다
                                                kakao.maps.event
                                                      .addListener(
                                                            marker,
                                                            'click',
                                                            function() {
                                                               overlay
                                                                     .setMap(map);
                                                               if (!selectedMarker
                                                                     || selectedMarker !== marker) {

                                                                  // 클릭된 마커 객체가 null이 아니면
                                                                  // 클릭된 마커의 이미지를 기본 이미지로 변경하고
                                                                  !!selectedMarker
                                                                        && selectedMarker
                                                                              .setImage(selectedMarker.markerImage);

                                                                  // 현재 클릭된 마커의 이미지는 클릭 이미지로 변경합니다
                                                                  marker
                                                                        .setImage(clickMarkerImage);
                                                               }

                                                               // 클릭된 마커를 현재 클릭된 마커 객체로 설정합니다
                                                               selectedMarker = marker;
                                                               placePosition = marker
                                                                     .getPosition()

                                                               console
                                                                     .log(placePosition)
                                                               roadView(
                                                                     placePosition,
                                                                     map)

                                                               $(
                                                                     '#hiddenVal')
                                                                     .html(
                                                                           '<input type="hidden" name="lenderId" id="lenderId" value="'+item.lenderId+'"/>'
                                                                                 + '<input type="hidden" name="lenderMobile" value="'+item.mobile+'"/>')
                                                            })
                                             })

                              },
                              error : function() {
                                 alert("simpleWithObject err");
                              }
                           });
                  });

      $('#btn2')
            .on(
                  'click',
                  function(event) {
                     event.preventDefault();
                     var form = {
                        "lenderId" : $("#lenderId").val()
                     }
                     $
                           .ajax({

                              url : "requestLoaner",
                              type : "POST",
                              data : form,
                              success : function(data) {
                                 
                                 var times = data
                                 console.log(times);
                                 var timechart = new Array();
                                 for(var i = 0; i<data.length-1; i+=2){
                                	 
                                	 timechart.push([i,data[i],data[i+1],'tast'+i])
                                 }
                                 console.log(timechart);
                                 //////////jqchart
                                 $('#statistics').jqChart({
                                     title: { text: 'Gantt Chart' },
                                     animation: { duration: 1 },
                                     legend: {
                                         visible: false
                                     },
                                     series: [
                                         {
                                             type: 'gantt',
                                             fillStyles: ["#418CF0", "#FCB441", "#E0400A", "#056492", "#BFBFBF"],
                                             data: timechart,
                                             labels: {
                                                 fillStyle: 'white',
                                                 font: '14px sans-serif'
                                             }
                                         }
                                     ]
                                 });
                                       

                              },
                              error : function() {
                                 alert("simpleWithObject err");
                              }
                           });
                  });
      function toggleMap(active) {
         if (active) {

            // 지도가 보이도록 지도와 로드뷰를 감싸고 있는 div의 class를 변경합니다
            container.className = "view_map"
         } else {

            // 지도가 숨겨지도록 지도와 로드뷰를 감싸고 있는 div의 class를 변경합니다
            container.className = "view_roadview"
         }
      }

      function roadView(placePosition, map) {

         //좌표로부터 로드뷰 파노ID를 가져올 로드뷰 helper객체

         // 특정 위치의 좌표와 가까운 로드뷰의 panoId를 추출하여 로드뷰를 띄운다.
         roadviewClient.getNearestPanoId(placePosition, 50,
               function(panoId) {

                  roadview.setPanoId(panoId, placePosition); //panoId와 중심좌표를 통해 로드뷰 실행
               });

         // 특정 장소가 잘보이도록 로드뷰의 적절한 시점(ViewPoint)을 설정합니다 
         // Wizard를 사용하면 적절한 로드뷰 시점(ViewPoint)값을 쉽게 확인할 수 있습니다
         roadview.setViewpoint({
            pan : 321,
            tilt : 0,
            zoom : 0
         });

         // 지도 중심을 표시할 마커를 생성하고 특정 장소 위에 표시합니다 

         var rvMarker = new kakao.maps.Marker({
            position : placePosition,
            map : roadview
         });

         // 로드뷰 초기화가 완료되면 
         kakao.maps.event.addListener(roadview, 'init', function() {

            // 로드뷰에 특정 장소를 표시할 마커를 생성하고 로드뷰 위에 표시합니다 
            rvMarker.setMap(null);

         });
      }
   </script> <!-- Bootstrap tooltips --> <script type="text/javascript"
      src="resources/js/popper.min.js"></script> <!-- Bootstrap core JavaScript -->
   <script type="text/javascript" src="resources/js/bootstrap.min.js"></script>
   <!-- MDB core JavaScript --> <script type="text/javascript"
      src="resources/js/mdb.min.js"></script> <script type="text/javascript"
      src="resources/js/timepicker/jquery.timepicker.min.js"></script> <!-- 타이머js -->
   <link type="text/css" rel="stylesheet"
      href="resources/js/timepicker/jquery.timepicker.css" media="" />
   <!-- 타이머css -->
</body>
</html>