package semiProject;

import java.sql.*;
import java.util.*;

public class Update {

	// 기능 : 2. 수정
	public static void updateSalaryByDept() throws Exception {

		int result = 0;
		Connection con = null;
		Statement stmt = null;
		String query = null;




		System.out.print("부서번호 : ");
		Scanner scan = new Scanner(System.in);
		int deptId = scan.nextInt();
		System.out.print("비율 : ");
		Scanner scan2 = new Scanner(System.in);
		double per = scan2.nextDouble();
		System.out.println("부서번호 '" + deptId + "' 검색.");
		System.out.println("인상 비율 '" + per + "' 검색.");
		Class.forName("oracle.jdbc.driver.OracleDriver");
		con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "hr", "hr");
		stmt = con.createStatement();

		query = "update EMPLOYEES\r\n" + 
				"set SALARY = SALARY* "+ per +" where DEPARTMENT_ID = "+ deptId;

		System.out.println(query);         
		result = stmt.executeUpdate(query);         
		System.out.println(result + "개의 행이 수정되었습니다.");


	}

	public static void updateSalaryByEmp() throws Exception {

		int result = 0;
		Connection con = null;
		Statement stmt = null;
		String query = null;




		System.out.print("사번 : ");
		Scanner scan = new Scanner(System.in);
		int empId = scan.nextInt();
		System.out.print("비율 : ");
		Scanner scan2 = new Scanner(System.in);
		double per = scan2.nextDouble();
		System.out.println("사번 '" + empId + "' 검색.");
		System.out.println("인상 비율 '" + per + "' 검색.");
		Class.forName("oracle.jdbc.driver.OracleDriver");
		con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "hr", "hr");
		stmt = con.createStatement();
		query = "update EMPLOYEES\r\n" + 
				"set SALARY = SALARY* "+ per +" where employee_ID ="+empId;



		System.out.println(query);         
		result = stmt.executeUpdate(query);         
		System.out.println(result + "개의 행이 수정되었습니다.");


	}
}