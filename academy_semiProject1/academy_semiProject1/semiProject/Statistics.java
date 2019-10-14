package semiProject;

import java.sql.*;
import java.util.*;

public class Statistics {

	ArrayList list = new ArrayList();


	//직무를 전발받아서 그 직무인 사원들의 목록을 리턴함
	//

	public static ArrayList<EmpVO> getMeanSalaryByDeptId() throws Exception {

		ArrayList<EmpVO> result = new ArrayList<EmpVO>();
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = 
				DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "hr", "hr");
		Statement stmt = con.createStatement();
		String sql =" select department_id, trunc(avg(salary)) "  +
				" from EMPLOYEES "  + 
				" group by department_id " +
				" order by avg(salary) desc ";
		ResultSet rs = stmt.executeQuery(sql);
		while(rs.next()) {
			EmpVO vo = new EmpVO();
			vo.setSalary(rs.getInt("trunc(avg(salary))"));
			vo.setDeptId(rs.getInt("department_id"));

			result.add(vo);

		}

		con.close();
		return result;
	}

	public static ArrayList<EmpVO> getNumbersByDeptId() throws Exception {

		ArrayList<EmpVO> result = new ArrayList<EmpVO>();
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = 
				DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "hr", "hr");
		Statement stmt = con.createStatement();
		String sql =" select department_id, count(*) "  +
				" from EMPLOYEES "  + 
				" group by department_id " +
				" order by count(*) desc ";
		ResultSet rs = stmt.executeQuery(sql);
		while(rs.next()) {
			EmpVO vo = new EmpVO();
			vo.setSalary(rs.getInt("count(*)"));
			vo.setDeptId(rs.getInt("department_id"));

			result.add(vo);

		}

		con.close();
		return result;
	}
	public static ArrayList<EmpVO> getNumbersByCity() throws Exception {

		ArrayList<EmpVO> result = new ArrayList<EmpVO>();
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = 
				DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "hr", "hr");
		Statement stmt = con.createStatement();
		String sql =" select l.City, count(*)" + 
				" from COUNTRIES c, DEPARTMENTS d, EMPLOYEES e, JOBS j, LOCATIONS l " + 
				" where c.COUNTRY_ID(+) = l.COUNTRY_ID and d.LOCATION_ID = l.LOCATION_ID(+) and " + 
				" d.DEPARTMENT_ID(+) = e.DEPARTMENT_ID and e.JOB_ID = j.JOB_ID " + 
				" group by l.City " +
				" order by count(*) desc";
		ResultSet rs = stmt.executeQuery(sql);
		while(rs.next()) {
			EmpVO vo = new EmpVO();
			vo.setSalary(rs.getInt("count(*)"));
			vo.setCityName(rs.getString("city"));;

			result.add(vo);
		}
		con.close();
		return result;
	}

	public static ArrayList<EmpVO> getNumbersByJobId() throws Exception {

		ArrayList<EmpVO> result = new ArrayList<EmpVO>();
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = 
				DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "hr", "hr");
		Statement stmt = con.createStatement();
		String sql =" select job_id, count(*) "  +
				" from EMPLOYEES "  + 
				" group by job_id " +
				" order by count(*) desc ";
		ResultSet rs = stmt.executeQuery(sql);
		while(rs.next()) {
			EmpVO vo = new EmpVO();
			vo.setSalary(rs.getInt("count(*)"));
			vo.setJobId(rs.getString("job_id"));

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
			vo.setCityName(rs.getString("city"));;

			result.add(vo);
		}
		con.close();
		return result;
	}

}