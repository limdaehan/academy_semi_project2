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

		document.form1.action = "statusInfo.do";
		document.form1.submit();

	}

	function deleteLoaner() {
		if (result == true) {
			result = confirm("정말로 삭제하시겠습니까 ?");
			document.form1.action = "deleteLoaner.do";
			document.form1.submit();
		} else
			return;
	}
</script>
<jsp:useBean id="ln" scope="request" class="project.LoanerVO" />



</head>
<body>
	<div align="center">
		<H2>빌리기:수정화면</H2>
		<HR>

		<form name=form1 method=post action=loanerUpdate.do>
			<input type=hidden name="loanerId" value="<%=ln.getLoanerId()%>">
			<input type=hidden name="action" value="update">

			<table border="1">
				<tr>
					<th>시작 날짜</th>
					<td><input type="text" name="startDay"
						value="<%=ln.getStartDay()%>"></td>
				</tr>
				<tr>
					<th>시작 시간</th>
					<td><input type="text" name="startTime"
						value="<%=ln.getStartTime()%>"></td>
				</tr>
				<tr>
				<tr>
					<th>끝나는 날짜</th>
					<td><input type="text" name="endDay"
						value="<%=ln.getEndDay()%>"></td>
				</tr>
				<tr>
					<th>끝나는 시간</th>
					<td><input type="text" name="endTime"
						value="<%=ln.getEndTime()%>"></td>
				</tr>
				<tr>
					<td colspan=2 align=center><input type=submit value="빌리기수정하기"><input
						type="button" value="삭제하기" name="loanerDelete"
						onClick="deleteLoaner()"><input type="button" value="취소"
						onClick="cancel()"></td>

				</tr>
			</table>
		</form>

	</div>
</body>
</html>