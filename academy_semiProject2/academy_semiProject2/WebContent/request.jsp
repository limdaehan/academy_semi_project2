<%@page import="java.io.FileWriter"%>
<%@page import="java.io.BufferedWriter"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

</head>
<body>
<script type="text/javascript">
		function writeCheck() {
			
			if (!write.name.value) {//  name 값이 없을 때 
				alert("이름을 적어주세요"); // 경고창 띄움 
				write.name.focus(); //  name 위치로 이동 
				return;
			}
			if (!write.phone.value) {
				alert("비밀번호를 적어주세요");
				write.phone.focus();
				return;
			}
			alert('관리자에게 전송되었습니다.');
			<%
			try {
				
				String name = request.getParameter("name");
				String phone = request.getParameter("phone");
				String memo = request.getParameter("memo");
				
				BufferedWriter output = new BufferedWriter(
						new FileWriter("C:/jsp/Requests.txt", true)); //요청사항을 C:Requests.txt 로 저장 
				
				String str = "이름: " + name + "\n" + "전화번호: " + phone + "\n" + "메모: " + memo; //txt 파일에 들어갈 내용을 작성
				output.write(str);
				output.newLine();
				output.newLine();
				output.flush();
				output.close();

			} catch (Exception e) {
				e.getStackTrace();
			}
		%>
			
			
		}
		</script>
		
		




	<form name="write">
		<div>
			이름 : <br /> <input type="text" name="name">
		</div>

		<div>
			전화번호 : <br /> <input type="text" name="phone">
		</div>
		<div>
			내용 : <br />
			<textarea name="memo" col="50" rows="13"></textarea>
		</div>

		<input type="submit" id="btn" name="add" value="전송" OnClick="writeCheck()">
	</form>
	

</body>
</html>