<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	String result = (String)request.getAttribute("result");
%>
	<div id="first">
		<form action="checkMobile.do" name="form" method="post" onsubmit="return checkEmpty();">
			전화번호를 입력해주세요
			<input type="text" value="" name="mobile" id="mobile">
			<button type="submit" name="test" onclick="show()">중복 검사</button>
		</form>
	</div>
	
	<div id="second" style="display:none">

			<p>등록 가능한 전화번호 입니다</p>
			<input type="text" name="result" value="<%= result %>" id="result">
			<input type="button" name="ok" value="생성하기" id="ok" onclick="setResult()">

	</div>
	
	<script type="text/javascript" src="resources/js/jquery-3.4.1.min.js"></script>
    <!-- Bootstrap tooltips -->
    <script type="text/javascript" src="resources/js/popper.min.js"></script>
    <!-- Bootstrap core JavaScript -->
    <script type="text/javascript" src="resources/js/bootstrap.min.js"></script>
    <!-- MDB core JavaScript -->
    <script type="text/javascript" src="resources/js/mdb.min.js"></script>
	
	<script>
		$(function(){
			if($("#result").val()=='null'){
				$("#second").hide();
			} else if($("#result").val()=='이미 존재하는 전화번호 입니다'){
				alert('이미 가입한 전화번호 입니다.');
				$("#second").hide();
			} else {
				$("#second").show();
			}
		})
		
		function checkEmpty() {
	    	if($("#mobile").val()==''){
	    		alert('전화번호를 입력해주세요');
	    		$("#mobile").focus();
	    		return false;
	    	}
    	}
		
		function setResult() {
			opener.document.getElementById("mobile").value = document.getElementById("result").value;
			window.close();
		}
		
		
	</script>
</body>
</html>