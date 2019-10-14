<%@page import="secondproject.EmpDAO"%>
<%@page import="java.io.PrintWriter"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
   <%  /* String failurevalue = request.getParameter("bodys"); */
      int empids = Integer.parseInt(request.getParameter("empid"));
      String fName = request.getParameter("empfname");
      String lName = request.getParameter("emplname");
      String email = request.getParameter("empemail");
      String mobile = request.getParameter("empmobile");
      String hdate = request.getParameter("emphdate");
      String empcomm = request.getParameter("empcomm");
      String jobid = request.getParameter("empjobid");
      int salary = Integer.parseInt(request.getParameter("empsalary"));
      int manid = Integer.parseInt(request.getParameter("empmanid"));
      int deptid = 0;
      switch(jobid){
      case "FI_MGR":
         deptid = 100;
         manid = 108;
         break;
      case "FI_ACCOUNT":
         deptid = 100;
         manid = 108;
         break;
      case "AC_MGR":
         deptid = 110;
         manid = 205;
         break;
      case "AC_ACCOUNT":
         deptid = 110;
         manid = 205;
         break;
      case "SA_MAN":
         deptid = 80;
         manid = 145;
         break;
      case "SA_REP":
         deptid = 80;
         manid = 145;
         break;
      case "PU_MAN":
         deptid = 70;
         manid = 204;
         break;
      case "PU_CLERK":
         deptid = 70;
         manid = 204;
         break;
      case "ST_MAN":
         deptid = 30;
         manid = 114;
         break;
      case "ST_CLERK":
         deptid = 30;
         manid = 114;
         break;
      case "SH_CLERK":
         deptid = 30;
         manid = 114;
         break;
      case "IT_PROG":
         deptid = 60;
         manid = 103;
         break;
      case "MK_MAN":
         deptid = 20;
         manid = 201;
         break;
      case "MK_REP":
         deptid = 20;
         manid = 201;
         break;
      case "HR_REP":
         deptid = 40;
         manid = 203;
         break;
      case "PR_REP":
         deptid = 70;
         manid = 204;
         break;
      }
      
      
      System.out.println("시작");
      String sql = "INSERT INTO HR.EMPLOYEES VALUES ("+ empids + ",'" + fName+ "','" + lName +"','"+email +"','" + mobile + "','"+hdate+"','" + jobid + "'," + salary + ","+empcomm+" , " +manid+ "," +deptid+")";
      System.out.println(sql);
      try{
         
      if(lName != null){
         EmpDAO.insertnewEmp(sql);%>
         <script type="text/javascript">alert('사원을 추가하였습니다.');</script>
           <jsp:forward page="adminpage.jsp"></jsp:forward>
         <%}else{%>
           <script>
           alert('추가에 실패했습니다.');
           history.go(-1);
           </script>
        <%}%>
           
      <% }catch (Exception e){
         lName="fail";
         System.out.println(lName);
         e.printStackTrace();
      }%>
</body>
</html>