<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>소비자의 이용정보를 다운받는 페이지입니다.</title>
</head>
<body>
<form action="printPage.do">
	영수증 파일의 이름을 결정해주세요
	<br>
	<input type="text" name="fileName" id="fileName">
	<input type="submit" name="consumerReport" id="consumerReport">
</form>
</body>
</html>