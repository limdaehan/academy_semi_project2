package semiProject;

import java.sql.*;
import java.util.*;

public class EtcFunction {

	ArrayList list = new ArrayList();


	//직무를 전발받아서 그 직무인 사원들의 목록을 리턴함
	//



	public static ArrayList<EmpVO> getYearByEmpId() throws Exception {

		ArrayList<EmpVO> result = new ArrayList<EmpVO>();
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = 
				DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "hr", "hr");
		Statement stmt = con.createStatement();
		String sql =" select employee_id, trunc(to_char((sysdate-hire_date)/365))+1 "  +
				" from EMPLOYEES "  ;
		ResultSet rs = stmt.executeQuery(sql);
		while(rs.next()) {
			EmpVO vo = new EmpVO();
			vo.setHireDate(rs.getString("trunc(to_char((sysdate-hire_date)/365))+1"));
			vo.setEmpId(rs.getInt("employee_id"));

			result.add(vo);

		}

		con.close();
		return result;
	}

	public static ArrayList<EmpVO> getWonSalary() throws Exception {

		ArrayList<EmpVO> result = new ArrayList<EmpVO>();
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = 
				DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "hr", "hr");
		Statement stmt = con.createStatement();
		String sql =" select employee_id, salary*1200" + 
				"	from EMPLOYEES ";
		ResultSet rs = stmt.executeQuery(sql);
		while(rs.next()) {
			EmpVO vo = new EmpVO();
			vo.setSalary(rs.getInt("salary*1200"));
			vo.setEmpId(rs.getInt("employee_id"));

			result.add(vo);

		}

		con.close();
		return result;
	}


	public static ArrayList<EmpVO> getYearSalaryByEmpId() throws Exception {

		ArrayList<EmpVO> result = new ArrayList<EmpVO>();
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = 
				DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "hr", "hr");
		Statement stmt = con.createStatement();
		String sql =" select employee_id, salary*12 "  +
				" from EMPLOYEES " ;
		ResultSet rs = stmt.executeQuery(sql);
		while(rs.next()) {
			EmpVO vo = new EmpVO();
			vo.setSalary(rs.getInt("salary*12"));
			vo.setEmpId(rs.getInt("employee_id"));

			result.add(vo);

		}

		con.close();
		return result;
	}

	public static ArrayList<EmpVO> getFullName() throws Exception {

		ArrayList<EmpVO> result = new ArrayList<EmpVO>();
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = 
				DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "hr", "hr");
		Statement stmt = con.createStatement();
		String sql =" select  *"  +
				" from EMPLOYEES " ;
		ResultSet rs = stmt.executeQuery(sql);
		while(rs.next()) {
			EmpVO vo = new EmpVO();
			vo.setLastName(rs.getString("last_name"));
			vo.setFirstName(rs.getString("first_name"));
			vo.setEmpId(rs.getInt("employee_id"));
			result.add(vo);

		}

		con.close();
		return result;
	}

	public static ArrayList<EmpVO> getMeanSalaryByJobId() throws Exception {

		ArrayList<EmpVO> result = new ArrayList<EmpVO>();
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = 
				DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "hr", "hr");
		Statement stmt = con.createStatement();
		String sql =" select job_id, trunc(avg(salary)) "  +
				" from EMPLOYEES "  + 
				" group by job_id " +
				" order by avg(salary) desc ";
		ResultSet rs = stmt.executeQuery(sql);
		while(rs.next()) {
			EmpVO vo = new EmpVO();
			vo.setSalary(rs.getInt("trunc(avg(salary))"));
			vo.setJobId(rs.getString("job_id"));;

			result.add(vo);

		}

		con.close();
		return result;
	}

	public static ArrayList<EmpVO> getMeanSalaryByCity() throws Exception {

		ArrayList<EmpVO> result = new ArrayList<EmpVO>();
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = 
				DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "hr", "hr");
		Statement stmt = con.createStatement();
		String sql =" select l.City, trunc(avg(salary))" + 
				" from COUNTRIES c, DEPARTMENTS d, EMPLOYEES e, JOBS j, LOCATIONS l " + 
				" where c.COUNTRY_ID(+) = l.COUNTRY_ID and d.LOCATION_ID = l.LOCATION_ID(+) and " + 
				" d.DEPARTMENT_ID(+) = e.DEPARTMENT_ID and e.JOB_ID = j.JOB_ID " + 
				" group by l.City " +
				" order by avg(salary) desc";
		ResultSet rs = stmt.executeQuery(sql);
		while(rs.next()) {
			EmpVO vo = new EmpVO();
			vo.setSalary(rs.getInt("trunc(avg(salary))"));

			result.add(vo);
		}
		con.close();
		return result;
	}

}
