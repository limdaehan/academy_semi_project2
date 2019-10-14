<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" errorPage="error.jsp"%>
<!DOCTYPE HTML>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>주소록:작성화면</title>
<link rel="stylesheet" href="resources/css/addrbook.css" type="text/css" media="screen" />
</head>
<body>
<div align="center">
<H2>회원가입 화면 </H2>
<HR>

<form name=form1 method=post action="addClient.do">
<input type=hidden name="action" value="insert">
<table border="1">
  <tr>
    <th>차량번호</th>	
    <td><input type="text" name="carNum" maxlength="15"></td>
  </tr>
  <tr>
    <th>이름</th>
    <td><input type="text" name="name" maxlength="50"></td>
  </tr>
  <tr>
    <th>전화번호</th>
    <td><input type="text" name="mobile" maxlength="20"></td>
  </tr>
  <tr>
    <th>비밀번호</th>
    <td><input type="password" name="password"></td>
  </tr> 
  <tr>
    <th>주소</th>
    <td><input type="text" name="address"></td>
  </tr>  
  <tr>
    <th>계좌번호</th>
    <td><input type="text" name="bankName" maxlength="2"></td>
    <td><input type="text" name="accountNumber" maxlength="2"></td>
  </tr>

  <tr>
    <td colspan=2 align=center><input type=submit value="회원가입"><input type=reset value="취소"></td>
</tr>
</table>
</form>

</div>
</body>
</html>