<%@page import="secondproject.EmpVO"%>
<%@page import="secondproject.EmpDAO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
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
		      margin-top:43%;
		      margin-left:10%
		    }
		    #area1{
		      background-color:#FEFDFE;		      
		      margin-right:1.5%
		    }
		    
		    
        </style>
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
      
      
</head>
	<body id="body">
	<%
		String userIds = (String)session.getAttribute("userId");
	 %> 
	<header>
  <div>
	 <div>
		<nav class="navbar navbar-expand-lg navbar-dark fixed-top scrolling-navbar">
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
							<li class="nav-item active"><a class="nav-link" href="#">Home
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
	</header>
		<div class="row" id="user">
		  <div class="col-2">
		    <div id="area2">
		   		<nav class="navbar navbar-light navbar-1 white">
				  <!-- Navbar brand -->
				  <a class="navbar-brand" href="#">정보 조회</a>
				
				  <!-- Collapse button -->
				  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent15"
				    aria-controls="navbarSupportedContent15" aria-expanded="false" aria-label="Toggle navigation"><span class="navbar-toggler-icon"></span></button>
				
				  <!-- Collapsible content -->
				  <div class="collapse navbar-collapse" id="navbarSupportedContent15">
				
				    <!-- Links -->
				    <ul class="navbar-nav mr-auto">
				      <li class="nav-item">
				        <a class="nav-link" href="homepage.jsp">메인화면으로<span class="sr-only">(current)</span></a>
				      </li>
				      <li class="nav-item">
				        <a class="nav-link" href="empid_search.jsp">사원번호로 조회</a>
				      </li>
				      <li class="nav-item">
				        <a class="nav-link" href="deptid_search.jsp">부서번호로 조회</a>
				      </li>	      
				    </ul>
				   <!-- Links -->				
				</div>
				  <!-- Collapsible content -->
			 </nav>
			 </div>
			</div> 
		   <div class="col-10">
		   <div class="panel">
		    <div id="area1">
		  		<div class="table-wrapper-scroll-y my-custom-scrollbar">
						<%
							String lNames = request.getParameter("nameinput");
							System.out.print("lNames="+lNames);
						%>
						<%
							String sql = "Select employee_id, first_name, last_name, salary, hire_date, department_id from employees where last_name like '"+ lNames+"'";
							ArrayList<EmpVO> empList = null;
							try{
								empList = EmpDAO.selectEmpListBySQL(sql);
							}catch (Exception e){
								out.println("<script>alert('SQL입력값 오류입니다.');</script>");
								%>
								<jsp:forward page="main.jsp"></jsp:forward>
							<%}%>
						<table class="table table-bordered table-striped mb-0">
                      <thead>
                        <tr>
                          <th scope="col" ><kbd>사번</kbd></th>
                          <th scope="col"><kbd>성</kbd></th>
                          <th scope="col"><kbd>이름</kbd></th>
                          <th scope="col"><kbd>급여</kbd></th>
                          <th scope="col"><kbd>입사일자</kbd></th>
                          <th scope="col"><kbd>부서번호</kbd></th>
                        </tr>
                      </thead>
                      <tbody>
                       
                      	<%for(EmpVO str : empList){
							String empid = String.valueOf(str.getEmpId());
							String fName = str.getfName();
							String lName = str.getlName();
							String sal = String.valueOf(str.getSalary());
							String hDate = String.valueOf(str.gethDate());
							String deptId = String.valueOf(str.getDeptID());
							String[] result = {empid, fName, lName, sal, hDate, deptId};%>
							<tr>
							<%for(String value : result){%>
								<td><%=value%></td>
							<% } %>
							</tr>				
						<%}%>
                      </tbody>
                    </table>
                  </div>
 			  
		  		</div>
		   
		   </div>		 
		  </div>		  	
		</div>	
	</body>

</html>