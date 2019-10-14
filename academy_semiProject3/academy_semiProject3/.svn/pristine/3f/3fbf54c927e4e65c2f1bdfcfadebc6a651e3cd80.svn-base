<%@page import=" project.LenderVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function cancel() {
	
		
			document.form1.action="statusInfo.do";
			document.form1.submit();

	};
	

	function deleteLender() {
		result = confirm("정말로 삭제하시겠습니까 ?");
		if(result == true){
			document.form1.action="deleteLender.do";
			document.form1.submit();
		}
		else
			return;
	}
	
</script>
<jsp:useBean id="ld" scope="request" class="project.LenderVO" />



</head>
<body>
<div align="center">
<H2>수정화면 </H2>
<HR>

<form name=form1 method=post action=lenderUpdate.do>
<input type=hidden name="lenderId" value="<%=ld.getLenderId()%>">

<table border="1">
 
  <tr>
    <th>가격</th>
    <td><input type="text" name="price" value="<%=ld.getPrice()%>"></td>
  </tr>
  <tr>
    <td colspan=2 align=center><input type=submit value="수정하기" name="lenderUpdate"> 
    <input type="button" value="삭제하기" name="lenderDelete" onClick="deleteLender()">
    <input type="button" value="취소" onClick="cancel()"></td>
			
</tr>  
</table>
</form>

</div>
</body>
</html>
