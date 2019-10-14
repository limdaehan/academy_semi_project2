<%@page import="project.ClientVO"%>
<%@page import="project.LoanerVO"%>
<%@page import="project.LenderVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
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
      color: hotpink
    }
    #tt{
      left: 100px;
    
    }
    #t{
      width: 1400px ;
    }
    #ttt{
      margin-top: 5%;
      margin-left: 13%;
         
    }
    #tablemargin{
      margin-right: auto;
      margin-left: auto; 
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


        <div  id="ttt">
          <!-- Grid column -->
          <div class="col-lg-12 col-md-12 mb-12">
            <!-- Card -->
            <div class="card card-image" id="t">
              <!-- Content -->
              <div
                class="text-blue text-center pricing-card d-flex align-items-center background-color: rgba(255, 0, 0, 0.3) py-3 px-3 rounded"id="tt" >

                <!-- Content -->
                <div class="card-body" id="tt">

                    <div>
                        
                        <form>
                           <a href="javascript:history.back(-1)">뒤로가기</a>
                           <br>
                           <h1><i class="fas fa-parking"></i>내가 등록한 주차장</h1>
                              <table border="1"id="tablemargin">
                              <tr>
                                 <th>Id</th>
                                 <th>주소</th>
                                 <th>전화번호</th>
                                 <th>시작날짜</th>
                                 <th>시작시간</th>
                                 <th>끝나는 날짜</th>
                                 <th>끝나는시간</th>
                                 <th>가격</th>
                                 <th>위치</th>
                              </tr>
                              <%
                        
                               ClientVO vo4 = (ClientVO)session.getAttribute("vo");
                               List <LenderVO> lenderVO1 =(List <LenderVO>)session.getAttribute("LenderVO");
                              %>
                              <%
                                 //String sql = "select LENDERID lenderId, ADRESS adress, CLIENT_MOBILE mobile, AVAILABLE_START_DAY start_day,   AVAILABLE_END_DAY end_day, AVAILABLE_START_TIME start_time,   AVAILABLE_END_TIME end_time, PARKING_AREA_LATITUTE x, PARKING_AREA_LONGITUDE y, PRICE_PER_30MIN price from Lender where lenderid =" + covId;
                              
                                 //List<LenderVO> list3 = (List<LenderVO>) request.getAttribute("list3");
                                 for (LenderVO vo3 : lenderVO1) {
                              %>
                              <tr>
                                 <td><a href=lender_edit_form.do?=CLIENT_MOBILE
                                    <%= vo3.getMobile()%>><%= vo3.getLenderId()%></a></td>
                                 <td><%=vo3.getAdress()%></td>
                                 <td><%=vo3.getMobile()%></td>
                                 <td><%=vo3.getStart_day()%></td>
                                 <td><%=vo3.getStart_time()%></td>
                                 <td><%=vo3.getEnd_day()%></td>
                                 <td><%=vo3.getStart_time()%></td>
                                 <td><%=vo3.getPrice()%></td>
                                 <td><%=vo3.getX()%>, <%=vo3.getY()%></td>
                  
                              </tr>
                              <%
                                 }
                              %>
                           </table>
                           <P>
                           
                           <P>
                           <h1><i class="fas fa-users"></i>빌려간 사람들</h1>
                           <table border="1" id="tablemargin">
                              <tr>
                                             
                                 <th>전화번호</th>
                                 <th>시작날짜</th>
                                 <th>시작시간</th>
                                 <th>끝나는 날짜</th>
                                 <th>끝나는시간</th>
                                 
                                 
                              </tr>
                              <%
                                 List <LoanerVO> loanerList = (List <LoanerVO>)session.getAttribute("loanerList");
                                 //List<LenderVO> list = (List<LenderVO>) request.getAttribute("list");
                                 for (LoanerVO loaner : loanerList) {
                              %>
                              <tr>
                                 <td><a href=lender_edit_form.do?lenderMobile=
                                    <%=loaner.getClientMobile()%>><%=loaner.getClientMobile()%></a></td>
                                 <td><%=loaner.getStartDay()%></td>
                                 <td><%=loaner.getStartTime()%></td>
                                 <td><%=loaner.getEndDay()%></td>
                                 <td><%=loaner.getEndTime()%></td>
                                 
                                 
                                 
                                 
                              </tr>
                              <%
                                 }
                              %>
                           </table>
                  
                  
                  
                           <p />
                  
                  
                           <h1><i class="fas fa-car-side"></i>내가 빌린 주차장 </h1>
                           <div class="align-items-center">
                           <table border="1" id="tablemargin">
                              <tr>
                                 <th>Id</th>
                                 <th>전화번호</th>
                                 <th>시작날짜</th>
                                 <th>시작시간</th>
                                 <th>끝나는 날짜</th>
                                 <th>끝나는시간</th>
                                 <th>총금액</th>
                              </tr>
                              <%
                              List <LoanerVO> loanerList2 = (List <LoanerVO>)session.getAttribute("loanerList2");
                                 for (LoanerVO vo2 : loanerList2) {
                              %>
                              <tr>
                                 <td><a href=loaner_edit_form.do?client_mobile=
                                    <%=vo2.getClientMobile()%>><%=vo2.getLoanerId()%></a></td>
                                 <td><%=vo2.getClientMobile()%></td>
                                 <td><%=vo2.getStartDay()%></td>
                                 <td><%=vo2.getStartTime()%></td>
                                 <td><%=vo2.getEndDay()%></td>
                                 <td><%=vo2.getEndTime()%></td>
                                 <td><%=vo2.getTotalFee() %></td>
                  
                              </tr>
                              <%
                              }
                            %>
                  
                           </table>
                          </div>
                        </form>
                  
                     </div>

                    <!--카드 바디 끝 -->
                  </div>

                </div>


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