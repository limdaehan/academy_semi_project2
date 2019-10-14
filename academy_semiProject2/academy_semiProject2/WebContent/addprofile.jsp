<%@page import="java.io.PrintWriter"%>
<%@page import="secondproject.EmpDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function erralert(){
		alert("회원가입 도중 문제가 발생하였습니다. 관리자에게 문의하세요.");
	}

</script>
</head>
<body>
	<%
		String failurevalue=null;
		String inputid = request.getParameter("inputId");
		String inputpw = request.getParameter("inputPw");
		String empids = request.getParameter("inputempId");
		String fName = request.getParameter("inputfName");
		String lName = request.getParameter("inputlName");
		String eMail = request.getParameter("inputEmail");
		String adress = request.getParameter("inputadress");
		String mobile = request.getParameter("inputmobile");
		String failchk = null;
		
		System.out.println(empids);
		int inputempId = Integer.parseInt(empids);
		String sql = "INSERT INTO HR.MY_PROFILE (ID, PW, EMPLOYEE_ID, FIRST_NAME, LAST_NAME, ADDRESS, EMAIL, PHONE_NUMBER) VALUES ('"+ inputid + "','" + inputpw+ "'," + inputempId +",'"+fName +"','" + lName + "','" + adress + "','"+ eMail + "','" + mobile + "')";
		try{
			EmpDAO.insertnewProfile(sql, inputempId);
		}catch (Exception e){
			failurevalue="fail";
		}
		
	%>
		<% if(failurevalue==null){%>
	  		<jsp:forward page="addfinish.jsp"></jsp:forward>
	  	<%}else{%>
	  		<jsp:forward page="login.html"></jsp:forward>
	  	<%} %>
</body>
</html>