<%@page import="secondproject.EmpDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>   
	<%	//클라이언트가 전송한 ID와 PW 추출(Parameter를 이용)
		String id = request.getParameter("id");
		String pw = request.getParameter("passw");
		String sql = "select pw, admin from my_profile where id like '"+id +"'";
		String login = EmpDAO.selectPassword(sql);
		String adminChk = EmpDAO.selectAdminchk(sql);
		//제어문(조건문)을 사용하여 추출한 ID와 PW가 같다면, main.jsp화면을 보여주며, session에 userId라는것을 입력
		//두개가 다르다면, login.html화면을 보여줌
	  	if(id!=null && pw.equals(login)){
	  		session.setAttribute("userId", id);
	  		session.setAttribute("admin", adminChk);
	  	%>
	  		<jsp:forward page="homepage.jsp"></jsp:forward>
	  	<%}else{
	  	%>
	  		
	  		<jsp:forward page="login.html"></jsp:forward>
	  		
	  	<%} %>
</body>
</html>
<!-- 사용자 아이디와 패스워드가 동일하면, 세션내장객체에 사용자 이름을 id라는 키로 저장하고, 
 main.jsp로 포워딩한다.                  ->session.setAttribute("userid", 사용자아이디값);

동일하지 않으면 login.jsp로 포워딩 한다. -->