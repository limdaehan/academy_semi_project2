<%@page import="secondproject.EmpDAO"%>
<%@page import="secondproject.EmpVO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
      
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
      
      <style>
            .my-custom-scrollbar {
              position: relative;
              height: 100%;
              overflow: auto;
              margin-top:1.5%
            }
            .table-wrapper-scroll-y {
              display: block;
              margin-top:8%
            }
            #body {
            background-color:#B5B4B4
          }
          #area2{
            margin-top:25%;
            margin-left:10%
          }
          #area1{
            background-color:#FEFDFE;            
            margin-right:1.5%;
            width:80%;            
            margin-top:8%
          }
          .card{
            height:45em;
          }
        </style>
        <script type="text/javascript">
        if (!headers.inempid.value) {//  name 값이 없을 때 
         alert("사번을 입력해 주세요"); // 경고창 띄움 
         headers.inputs.focus(); //  name 위치로 이동 
         return;
      }
        
        
        </script>
</head>
<body id="body">
      <%
      String userIds = (String)session.getAttribute("userId");
    %> 
  <div>
    <div>
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
      </div>   
   </div>
      <div class="row">
        <div class="col-3">
          <div id="area2">
               <nav class="navbar navbar-light navbar-1 white">
              <!-- Navbar brand -->
              <a class="navbar-brand" href="#">Coogle</a>
            
              <!-- Collapse button -->
              <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent15"
                aria-controls="navbarSupportedContent15" aria-expanded="false" aria-label="Toggle navigation"><span class="navbar-toggler-icon"></span></button>
            
              <!-- Collapsible content -->
              <div class="collapse navbar-collapse" id="navbarSupportedContent15">
            
                <!-- Links -->
                <ul class="navbar-nav mr-auto">
                  <li class="nav-item">
                    <a class="nav-link" href="login.html">CoogleHome <span class="sr-only">(current)</span></a>
                  </li>
                  <li class="nav-item">
                    <a class="nav-link" href="login.html">로그인 페이지로 이동</a>
                  </li>
                  <li class="nav-item">
                    <a class="nav-link" href="#"></a>
                  </li>
                  <li class="nav-item">
                    <a class="nav-link" href="#">사번 정보조회</a>
                  </li>               
                </ul>
               <!-- Links -->            
            </div>
              <!-- Collapsible content -->
          </nav>
          </div>
           
      </div> 
         <div class="col-9">
         <div class="panel">
          <div id="area1">
              <!-- Card -->
           <div class="card">
        <!-- Card content -->
        <div class="card-body">
      
          <!-- Title -->
          <h4 class="card-title">사원정보 관리페이지 입니다.</h4>
          <!-- Text -->
          <p class="card-text">사원의 정보를 추가하실 수 있습니다.</p>
          <!-- Button -->
          <div>
             <form action="addemp.jsp" name="bodys">
                <table>
                <tr>
                   <td>사번  <input type="text" value="" name="empid"></td>
                   <td>이름  <input type="text" value="" name="empfname"></td>
                   <td>성  <input type="text" value="" name="emplname"></td>
                </tr>
                <tr>
                   <td>이메일  <input type="text" value="" name="empemail"></td>
                   <td>연락처  <input type="text" value="" name="empmobile"></td>
                   <td>입사일자  <input type="text" value="" name="emphdate"></td>
                </tr>
                
                
                <tr>
                   <td>직급  <select name="empjobid">
                           <option value="FI_MGR">FI_MGR</option>
                           <option value="FI_ACCOUNT">FI_ACCOUNT</option>
                           <option value="AC_MGR">AC_MGR</option>
                           <option value="AC_ACCOUNT">AC_ACCOUNT</option>
                           <option value="SA_MAN">SA_MAN</option>
                           <option value="SA_REP">SA_REP</option>
                           <option value="PU_MAN">PU_MAN</option>
                           <option value="PU_CLERK">PU_CLERK</option>
                           <option value="ST_MAN">ST_MAN</option>
                           <option value="ST_CLERK">ST_CLERK</option>
                           <option value="SH_CLERK">SH_CLERK</option>
                           <option value="IT_PROG">IT_PROG</option>
                           <option value="MK_MAN">MK_MAN</option>
                           <option value="MK_REP">MK_REP</option>
                           <option value="HR_REP">HR_REP</option>
                           <option value="PR_REP">PR_REP</option>
                           </select>
                   </td>
                   <td>급여 <input type="text" value="" name="empsalary"></td>
                   <td>커미션  <input type="text" value="" name="empcomm"></td>
                </tr>
                <tr>
                   <td>관리자번호  <input type="text" value="" name="empmanid"></td>
                </tr>
                </table>
                <button type="submit" class="btn btn-dark">저장하기</button>
             </form>
          </div>
          <div>        
            <button type="button" class="btn btn-dark" onclick='addemp.jsp'>관리자페이지로</button>
         </div>                       
            </div>
          </div>         
         </div>       
        </div>   
      </div>
   </div>
   </body>
</html>