package semiProject;

import java.sql.*;
import java.util.*;

public class Update {

	// ��� : 2. ����
	public static void updateSalaryByDept() throws Exception {

		int result = 0;
		Connection con = null;
		Statement stmt = null;
		String query = null;




		System.out.print("�μ���ȣ : ");
		Scanner scan = new Scanner(System.in);
		int deptId = scan.nextInt();
		System.out.print("���� : ");
		Scanner scan2 = new Scanner(System.in);
		double per = scan2.nextDouble();
		System.out.println("�μ���ȣ '" + deptId + "' �˻�.");
		System.out.println("�λ� ���� '" + per + "' �˻�.");
		Class.forName("oracle.jdbc.driver.OracleDriver");
		con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "hr", "hr");
		stmt = con.createStatement();

		query = "update EMPLOYEES\r\n" + 
				"set SALARY = SALARY* "+ per +" where DEPARTMENT_ID = "+ deptId;

		System.out.println(query);         
		result = stmt.executeUpdate(query);         
		System.out.println(result + "���� ���� �����Ǿ����ϴ�.");


	}

	public static void updateSalaryByEmp() throws Exception {

		int result = 0;
		Connection con = null;
		Statement stmt = null;
		String query = null;




		System.out.print("��� : ");
		Scanner scan = new Scanner(System.in);
		int empId = scan.nextInt();
		System.out.print("���� : ");
		Scanner scan2 = new Scanner(System.in);
		double per = scan2.nextDouble();
		System.out.println("��� '" + empId + "' �˻�.");
		System.out.println("�λ� ���� '" + per + "' �˻�.");
		Class.forName("oracle.jdbc.driver.OracleDriver");
		con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "hr", "hr");
		stmt = con.createStatement();
		query = "update EMPLOYEES\r\n" + 
				"set SALARY = SALARY* "+ per +" where employee_ID ="+empId;



		System.out.println(query);         
		result = stmt.executeUpdate(query);         
		System.out.println(result + "���� ���� �����Ǿ����ϴ�.");


	}
}