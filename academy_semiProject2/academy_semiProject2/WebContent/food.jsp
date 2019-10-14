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
		      background-color:#B5B4B4;		      
		      margin-right:1.5%;
		      width:80%;		      
		      margin-top:8%
		    }
		    .card{
		      height:45em;
		    }
		    
		    #logo1{
		    	position:relative;
		    	width:20%;
		    	left:3em;
		    	top:1em;		    			    
		    }
		    
		    #howto{
		    	width:100%;
		    	height:100%
		    }
		    #image1{
		    	position:relative;
		    	width:45em;
		    	
		    }
		    #image2{
		    	position:relative;
		    	top:-32em;
		    	width:22em;
		    	left:1em;
		    	
		    }
        </style>
        
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
							<li class="nav-item"><a class="nav-link" onclick="location.href='login.html'">Link</a></li>
							<li class="nav-item"><a class="nav-link" onclick="location.href='login.html'">문의하기</a>
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
				        <a class="nav-link" href="sayhello.jsp">인사말</a>
				      </li>
				      <li class="nav-item">
				        <a class="nav-link" href="ours.jsp">조직소개</a>
				      </li>
				       <li class="nav-item">
				        <a class="nav-link" href="map.jsp">찾아오시는 길</a>				        
				      </li>
				       <li class="nav-item">
				        <a class="nav-link" href="job.jsp">주요업무 소개</a>
				      </li>
				      <li class="nav-item">
				        <a class="nav-link" href="food.jsp">Coogle 식단표</a>
				      </li>
				      <li class="nav-item">
				        <a class="nav-link" href="homepage.jsp">메인 페이지로 이동</a>
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
		  		<input type="image" src="image/food2.png" id="image1"><input type="image" src="image/foodhome.PNG" id="image2">
		  		
 			  </div>
		    </div>		   
		   </div>		 
	
	</body>
</html>