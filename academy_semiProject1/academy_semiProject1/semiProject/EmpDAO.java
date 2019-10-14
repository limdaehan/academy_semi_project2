
package semiProject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class EmpDAO {

	ArrayList list = new ArrayList();


	//������ ���߹޾Ƽ� �� ������ ������� ����� ������
	//




	public static ArrayList<EmpVO> getEmpListByDeptId(int deptId) throws Exception {

		ArrayList<EmpVO> result = new ArrayList<EmpVO>();
		Class.forName("oracle.jdbc.driver.OracleDriver");//��Ű�� Ŭ����
		Connection con = 
				DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "hr", "hr");
		Statement stmt = con.createStatement();
		String sql ="select EMPLOYEE_ID, FIRST_NAME, LAST_NAME, SALARY, EMAIL, JOB_ID,\r\n" + 
				"  to_char(HIRE_DATE, 'YYYY-MM-DD') hire_date, PHONE_NUMBER, COMMISSION_PCT, DEPARTMENT_ID, MANAGER_ID\r\n" + 
				"from EMPLOYEES\r\n" +
				" where DEPARTMENT_ID = " + deptId;
		ResultSet rs = stmt.executeQuery(sql);
		while(rs.next()) {
			EmpVO vo = new EmpVO();
			vo.setEmpId(rs.getInt("employee_id"));
			vo.setLastName(rs.getString("last_name"));
			vo.setSalary(rs.getInt("salary"));
			vo.setHireDate(rs.getString("HIRE_DATE"));
			vo.setFirstName(rs.getString("first_name"));
			vo.setCommissionPct(rs.getInt("commission_pct"));
			vo.setPhoneNumber(rs.getString("phone_number"));
			vo.setJobId(rs.getString("job_id"));
			vo.setEmail(rs.getString("email"));
			vo.setDeptId(rs.getInt("department_id"));
			vo.setManagerId(rs.getInt("manager_id"));

			result.add(vo);
		}
		con.close();
		return result;

	}
	public static ArrayList<EmpVO> getEmpListByCityName(String cityName) throws Exception {

		ArrayList<EmpVO> result = new ArrayList<EmpVO>();
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = 
				DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "hr", "hr");
		Statement stmt = con.createStatement();
		String sql ="select *"  +
				" from EMPLOYEES e,departments d, locations l"  + 
				" where e.department_id = d.department_id and d.location_id = l.location_id and  l.city like '%" + cityName+"%'";
		ResultSet rs = stmt.executeQuery(sql);
		while(rs.next()) {
			EmpVO vo = new EmpVO();
			vo.setEmpId(rs.getInt("employee_id"));
			vo.setLastName(rs.getString("last_name"));
			vo.setSalary(rs.getInt("salary"));
			vo.setHireDate(rs.getString("HIRE_DATE"));
			vo.setFirstName(rs.getString("first_name"));
			vo.setCommissionPct(rs.getInt("commission_pct"));
			vo.setPhoneNumber(rs.getString("phone_number"));
			vo.setJobId(rs.getString("job_id"));
			vo.setEmail(rs.getString("email"));
			vo.setDeptId(rs.getInt("department_id"));
			vo.setManagerId(rs.getInt("manager_id"));

			result.add(vo);
		}
		con.close();
		return result;

	}

	public static ArrayList<EmpVO> getEmpListByDeptManagerName(String deptManagerName) throws Exception {

		ArrayList<EmpVO> result = new ArrayList<EmpVO>();
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = 
				DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "hr", "hr");
		Statement stmt = con.createStatement();
		String sql = "select   E.FIRST_NAME m_first_name, ee.*" + 
				"FROM EMPLOYEES E,DEPARTMENTS D, EMPLOYEES ee, LOCATIONS l\r\n" + 
				"WHERE E.EMPLOYEE_ID(+) = D.MANAGER_ID and E.DEPARTMENT_ID = ee.DEPARTMENT_ID \r\n" + 
				"      AND E.DEPARTMENT_ID = D.DEPARTMENT_ID and l.LOCATION_ID = D.LOCATION_ID\r\n" + 
				"      and ee.DEPARTMENT_ID = D.DEPARTMENT_ID and E.FIRST_NAME like '%" + deptManagerName +"%'";

		ResultSet rs = stmt.executeQuery(sql);
		while (rs.next()) {


			EmpVO vo = new EmpVO();
			vo.setEmpId(rs.getInt("employee_id"));
			vo.setLastName(rs.getString("last_name"));
			vo.setSalary(rs.getInt("salary"));
			vo.setHireDate(rs.getString("HIRE_DATE"));
			vo.setFirstName(rs.getString("first_name"));
			vo.setCommissionPct(rs.getInt("commission_pct"));
			vo.setPhoneNumber(rs.getString("phone_number"));
			vo.setJobId(rs.getString("job_id"));
			vo.setEmail(rs.getString("email"));
			vo.setDeptId(rs.getInt("department_id"));
			vo.setManagerId(rs.getInt("manager_id"));

			result.add(vo);

		}
		con.close();
		return result;

	}
	public static ArrayList<EmpVO> getEmpListByManagerName(String managerName) throws Exception {

		ArrayList<EmpVO> result = new ArrayList<EmpVO>();
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = 
				DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "hr", "hr");
		Statement stmt = con.createStatement();
		String sql = "select ee.*" +  
				"from EMPLOYEES e, EMPLOYEES ee, LOCATIONS L, DEPARTMENTS D\r\n" + 
				"where e.EMPLOYEE_ID = ee.MANAGER_ID AND D.DEPARTMENT_ID = ee.DEPARTMENT_ID\r\n" + 
				"      and D.LOCATION_ID = L.LOCATION_ID AND  e.FIRST_NAME like '%" + managerName +"%'";


		ResultSet rs = stmt.executeQuery(sql);
		while (rs.next()) {


			EmpVO vo = new EmpVO();
			vo.setEmpId(rs.getInt("employee_id"));
			vo.setLastName(rs.getString("last_name"));
			vo.setSalary(rs.getInt("salary"));
			vo.setHireDate(rs.getString("HIRE_DATE"));
			vo.setFirstName(rs.getString("first_name"));
			vo.setCommissionPct(rs.getInt("commission_pct"));
			vo.setPhoneNumber(rs.getString("phone_number"));
			vo.setJobId(rs.getString("job_id"));
			vo.setEmail(rs.getString("email"));
			vo.setDeptId(rs.getInt("department_id"));
			vo.setManagerId(rs.getInt("manager_id"));

			result.add(vo);

		}
		con.close();
		return result;

	}

	public static ArrayList<EmpVO> getEmpListByHireDate(int hiredate) throws Exception {

		ArrayList<EmpVO> result = new ArrayList<EmpVO>();
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = 
				DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "hr", "hr");
		Statement stmt = con.createStatement();
		String sql ="select EMPLOYEE_ID, FIRST_NAME, LAST_NAME, SALARY, EMAIL, JOB_ID,\r\n" + 
				"  to_char(HIRE_DATE, 'YYYY-MM-DD') hire_date, PHONE_NUMBER, COMMISSION_PCT, DEPARTMENT_ID, MANAGER_ID\r\n" + 
				"from EMPLOYEES\r\n" +
				" where to_char(hire_date,'yyyy') like '%" + hiredate+"%'";
		ResultSet rs = stmt.executeQuery(sql);
		while(rs.next()) {
			EmpVO vo = new EmpVO();
			vo.setEmpId(rs.getInt("employee_id"));
			vo.setLastName(rs.getString("last_name"));
			vo.setSalary(rs.getInt("salary"));
			vo.setHireDate(rs.getString("HIRE_DATE"));
			vo.setFirstName(rs.getString("first_name"));
			vo.setCommissionPct(rs.getInt("commission_pct"));
			vo.setPhoneNumber(rs.getString("phone_number"));
			vo.setJobId(rs.getString("job_id"));
			vo.setEmail(rs.getString("email"));
			vo.setDeptId(rs.getInt("department_id"));
			vo.setManagerId(rs.getInt("manager_id"));

			result.add(vo);
		}
		con.close();
		return result;

	}
	public static ArrayList<EmpVO> getEmpListBySalary(int salary) throws Exception {

		ArrayList<EmpVO> result = new ArrayList<EmpVO>();
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = 
				DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "hr", "hr");
		Statement stmt = con.createStatement();
		String sql ="select EMPLOYEE_ID, FIRST_NAME, LAST_NAME, SALARY, EMAIL, JOB_ID,\r\n" + 
				"  to_char(HIRE_DATE, 'YYYY-MM-DD') hire_date, PHONE_NUMBER, COMMISSION_PCT, DEPARTMENT_ID, MANAGER_ID\r\n" + 
				"from EMPLOYEES\r\n" +
				" where salary >" + salary;
		ResultSet rs = stmt.executeQuery(sql);

		while(rs.next()) {
			EmpVO vo = new EmpVO();
			vo.setEmpId(rs.getInt("employee_id"));
			vo.setLastName(rs.getString("last_name"));
			vo.setSalary(rs.getInt("salary"));
			vo.setHireDate(rs.getString("HIRE_DATE"));
			vo.setFirstName(rs.getString("first_name"));
			vo.setCommissionPct(rs.getInt("commission_pct"));
			vo.setPhoneNumber(rs.getString("phone_number"));
			vo.setJobId(rs.getString("job_id"));
			vo.setEmail(rs.getString("email"));
			vo.setDeptId(rs.getInt("department_id"));
			vo.setManagerId(rs.getInt("manager_id"));

			result.add(vo);
		}
		con.close();
		return result;

	}
	
	public static ArrayList<EmpVO> getEmpListByEmpId(int empId) throws Exception {

		ArrayList<EmpVO> result = new ArrayList<EmpVO>();
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = 
				DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "hr", "hr");
		// 3.statement���� 
		Statement stmt = con.createStatement();
		// 4.SQL����
				String sql = "select EMPLOYEE_ID, FIRST_NAME, LAST_NAME, SALARY, EMAIL, JOB_ID,\r\n" + 
						"  to_char(HIRE_DATE, 'YYYY-MM-DD') hire_date, PHONE_NUMBER, COMMISSION_PCT, DEPARTMENT_ID, MANAGER_ID\r\n" + 
						"from EMPLOYEES\r\n" + 
						"where EMPLOYEE_ID= "+ empId;
		ResultSet rs = stmt.executeQuery(sql);
		// 5.����ޱ�
		while(rs.next()) {
			EmpVO vo = new EmpVO();
			vo.setEmpId(rs.getInt("employee_id"));
			vo.setLastName(rs.getString("last_name"));
			vo.setSalary(rs.getInt("salary"));
			vo.setHireDate(rs.getString("HIRE_DATE"));
			vo.setFirstName(rs.getString("first_name"));
			vo.setCommissionPct(rs.getInt("commission_pct"));
			vo.setPhoneNumber(rs.getString("phone_number"));
			vo.setJobId(rs.getString("job_id"));
			vo.setEmail(rs.getString("email"));
			vo.setDeptId(rs.getInt("department_id"));
			vo.setManagerId(rs.getInt("manager_id"));

			result.add(vo);
		}
		// 6.Ŀ�ؼ� ���� ����
		con.close();
		return result;

	}
	public static ArrayList<EmpVO> getEmpListByLastName(String lastName) throws Exception {

		ArrayList<EmpVO> result = new ArrayList<EmpVO>();
		//�����ͺ��̽��� ��ȸ�Ͽ� result�� ��´�.
		// 1.JDBC����̹� �ε�(����122p��������)
		Class.forName("oracle.jdbc.driver.OracleDriver");//��Ű�� Ŭ����
		// 2.Ŀ�ؼ� ����(122p�Ʒ�)
		Connection con = 
				DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "hr", "hr");
		// 3.statement���� 
		Statement stmt = con.createStatement();
		// 4.SQL����
		String sql ="select EMPLOYEE_ID, FIRST_NAME, LAST_NAME, SALARY, EMAIL, JOB_ID,\r\n" + 
				"  to_char(HIRE_DATE, 'YYYY-MM-DD') hire_date, PHONE_NUMBER, COMMISSION_PCT, DEPARTMENT_ID, MANAGER_ID\r\n" + 
				"from EMPLOYEES\r\n" +
				" where Last_name like '%" + lastName+"%'";
		ResultSet rs = stmt.executeQuery(sql);
		// 5.����ޱ�
		while(rs.next()) {
			EmpVO vo = new EmpVO();
			vo.setEmpId(rs.getInt("employee_id"));
			vo.setLastName(rs.getString("last_name"));
			vo.setSalary(rs.getInt("salary"));
			vo.setHireDate(rs.getString("HIRE_DATE"));
			vo.setFirstName(rs.getString("first_name"));
			vo.setCommissionPct(rs.getInt("commission_pct"));
			vo.setPhoneNumber(rs.getString("phone_number"));
			vo.setJobId(rs.getString("job_id"));
			vo.setEmail(rs.getString("email"));
			vo.setDeptId(rs.getInt("department_id"));
			vo.setManagerId(rs.getInt("manager_id"));

			result.add(vo);
		}
		// 6.Ŀ�ؼ� ���� ����
		con.close();
		return result;

	}
	public static ArrayList<EmpVO> getEmpListByFirstName(String firstName) throws Exception {

		ArrayList<EmpVO> result = new ArrayList<EmpVO>();
		//�����ͺ��̽��� ��ȸ�Ͽ� result�� ��´�.
		// 1.JDBC����̹� �ε�(����122p��������)
		Class.forName("oracle.jdbc.driver.OracleDriver");//��Ű�� Ŭ����
		// 2.Ŀ�ؼ� ����(122p�Ʒ�)
		Connection con = 
				DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "hr", "hr");
		// 3.statement���� 
		Statement stmt = con.createStatement();
		// 4.SQL����
		String sql ="select EMPLOYEE_ID, FIRST_NAME, LAST_NAME, SALARY, EMAIL, JOB_ID,\r\n" + 
				"  to_char(HIRE_DATE, 'YYYY-MM-DD') hire_date, PHONE_NUMBER, COMMISSION_PCT, DEPARTMENT_ID, MANAGER_ID\r\n" + 
				"from EMPLOYEES\r\n" +
				" where First_name like '%" + firstName+"%'";
		ResultSet rs = stmt.executeQuery(sql);
		// 5.����ޱ�
		while(rs.next()) {
			EmpVO vo = new EmpVO();
			vo.setEmpId(rs.getInt("employee_id"));
			vo.setLastName(rs.getString("last_name"));
			vo.setSalary(rs.getInt("salary"));
			vo.setHireDate(rs.getString("HIRE_DATE"));
			vo.setFirstName(rs.getString("first_name"));
			vo.setCommissionPct(rs.getInt("commission_pct"));
			vo.setPhoneNumber(rs.getString("phone_number"));
			vo.setJobId(rs.getString("job_id"));
			vo.setEmail(rs.getString("email"));
			vo.setDeptId(rs.getInt("department_id"));
			vo.setManagerId(rs.getInt("manager_id"));

			result.add(vo);
		}
		// 6.Ŀ�ؼ� ���� ����
		con.close();
		return result;

	}
	public static ArrayList<EmpVO> getEmpListByCommiPct(int comPct) throws Exception {

		ArrayList<EmpVO> result = new ArrayList<EmpVO>();
		//�����ͺ��̽��� ��ȸ�Ͽ� result�� ��´�.
		// 1.JDBC����̹� �ε�(����122p��������)
		Class.forName("oracle.jdbc.driver.OracleDriver");//��Ű�� Ŭ����
		// 2.Ŀ�ؼ� ����(122p�Ʒ�)
		Connection con = 
				DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "hr", "hr");
		// 3.statement���� 
		Statement stmt = con.createStatement();
		// 4.SQL����
		String sql ="select EMPLOYEE_ID, FIRST_NAME, LAST_NAME, SALARY, EMAIL, JOB_ID,\r\n" + 
				"  to_char(HIRE_DATE, 'YYYY-MM-DD') hire_date, PHONE_NUMBER, COMMISSION_PCT, DEPARTMENT_ID, MANAGER_ID\r\n" + 
				"from EMPLOYEES\r\n" +
				" where commission_pct >" + comPct;
		ResultSet rs = stmt.executeQuery(sql);
		// 5.����ޱ�
		while(rs.next()) {
			EmpVO vo = new EmpVO();
			vo.setEmpId(rs.getInt("employee_id"));
			vo.setLastName(rs.getString("last_name"));
			vo.setSalary(rs.getInt("salary"));
			vo.setHireDate(rs.getString("HIRE_DATE"));
			vo.setFirstName(rs.getString("first_name"));
			vo.setCommissionPct(rs.getInt("commission_pct"));
			vo.setPhoneNumber(rs.getString("phone_number"));
			vo.setJobId(rs.getString("job_id"));
			vo.setEmail(rs.getString("email"));
			vo.setDeptId(rs.getInt("department_id"));
			vo.setManagerId(rs.getInt("manager_id"));

			result.add(vo);
		}
		// 6.Ŀ�ؼ� ���� ����
		con.close();
		return result;

	}
	public static ArrayList<EmpVO> getEmpListByManagerId(int managerId) throws Exception {

		ArrayList<EmpVO> result = new ArrayList<EmpVO>();
		//�����ͺ��̽��� ��ȸ�Ͽ� result�� ��´�.
		// 1.JDBC����̹� �ε�(����122p��������)
		Class.forName("oracle.jdbc.driver.OracleDriver");//��Ű�� Ŭ����
		// 2.Ŀ�ؼ� ����(122p�Ʒ�)
		Connection con = 
				DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "hr", "hr");
		// 3.statement���� 
		Statement stmt = con.createStatement();
		// 4.SQL����
		String sql ="select EMPLOYEE_ID, FIRST_NAME, LAST_NAME, SALARY, EMAIL, JOB_ID,\r\n" + 
				"  to_char(HIRE_DATE, 'YYYY-MM-DD') hire_date, PHONE_NUMBER, COMMISSION_PCT, DEPARTMENT_ID, MANAGER_ID\r\n" + 
				"from EMPLOYEES\r\n" +
				" where manager_id =" + managerId;
		ResultSet rs = stmt.executeQuery(sql);
		// 5.����ޱ�
		while(rs.next()) {
			EmpVO vo = new EmpVO();
			vo.setEmpId(rs.getInt("employee_id"));
			vo.setLastName(rs.getString("last_name"));
			vo.setSalary(rs.getInt("salary"));
			vo.setHireDate(rs.getString("HIRE_DATE"));
			vo.setFirstName(rs.getString("first_name"));
			vo.setCommissionPct(rs.getInt("commission_pct"));
			vo.setPhoneNumber(rs.getString("phone_number"));
			vo.setJobId(rs.getString("job_id"));
			vo.setEmail(rs.getString("email"));
			vo.setDeptId(rs.getInt("department_id"));
			vo.setManagerId(rs.getInt("manager_id"));

			result.add(vo);
		}
		// 6.Ŀ�ؼ� ���� ����
		con.close();
		return result;

	}
	public static ArrayList<EmpVO> getEmpListByEmail(String email) throws Exception {

		ArrayList<EmpVO> result = new ArrayList<EmpVO>();
		//�����ͺ��̽��� ��ȸ�Ͽ� result�� ��´�.
		// 1.JDBC����̹� �ε�(����122p��������)
		Class.forName("oracle.jdbc.driver.OracleDriver");//��Ű�� Ŭ����
		// 2.Ŀ�ؼ� ����(122p�Ʒ�)
		Connection con = 
				DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "hr", "hr");
		// 3.statement���� 
		Statement stmt = con.createStatement();
		// 4.SQL����
		String sql ="select EMPLOYEE_ID, FIRST_NAME, LAST_NAME, SALARY, EMAIL, JOB_ID,\r\n" + 
				"  to_char(HIRE_DATE, 'YYYY-MM-DD') hire_date, PHONE_NUMBER, COMMISSION_PCT, DEPARTMENT_ID, MANAGER_ID\r\n" + 
				"from EMPLOYEES\r\n" +
				" where email like '%" + email+"%'";
		ResultSet rs = stmt.executeQuery(sql);
		// 5.����ޱ�
		while(rs.next()) {
			EmpVO vo = new EmpVO();
			vo.setEmpId(rs.getInt("employee_id"));
			vo.setLastName(rs.getString("last_name"));
			vo.setSalary(rs.getInt("salary"));
			vo.setHireDate(rs.getString("HIRE_DATE"));
			vo.setFirstName(rs.getString("first_name"));
			vo.setCommissionPct(rs.getInt("commission_pct"));
			vo.setPhoneNumber(rs.getString("phone_number"));
			vo.setJobId(rs.getString("job_id"));
			vo.setEmail(rs.getString("email"));
			vo.setDeptId(rs.getInt("department_id"));
			vo.setManagerId(rs.getInt("manager_id"));

			result.add(vo);
		}
		// 6.Ŀ�ؼ� ���� ����
		con.close();
		return result;

	}
	public static ArrayList<EmpVO> getEmpListByPhoneNumber(String phoneNumber) throws Exception {

		ArrayList<EmpVO> result = new ArrayList<EmpVO>();
		//�����ͺ��̽��� ��ȸ�Ͽ� result�� ��´�.
		// 1.JDBC����̹� �ε�(����122p��������)
		Class.forName("oracle.jdbc.driver.OracleDriver");//��Ű�� Ŭ����
		// 2.Ŀ�ؼ� ����(122p�Ʒ�)
		Connection con = 
				DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "hr", "hr");
		// 3.statement���� 
		Statement stmt = con.createStatement();
		// 4.SQL����
		String sql ="select EMPLOYEE_ID, FIRST_NAME, LAST_NAME, SALARY, EMAIL, JOB_ID,\r\n" + 
				"  to_char(HIRE_DATE, 'YYYY-MM-DD') hire_date, PHONE_NUMBER, COMMISSION_PCT, DEPARTMENT_ID, MANAGER_ID\r\n" + 
				"from EMPLOYEES\r\n" +
				" where phone_number like '%" + phoneNumber+"%'";
		ResultSet rs = stmt.executeQuery(sql);
		// 5.����ޱ�
		while(rs.next()) {
			EmpVO vo = new EmpVO();
			vo.setEmpId(rs.getInt("employee_id"));
			vo.setLastName(rs.getString("last_name"));
			vo.setSalary(rs.getInt("salary"));
			vo.setHireDate(rs.getString("HIRE_DATE"));
			vo.setFirstName(rs.getString("first_name"));
			vo.setCommissionPct(rs.getInt("commission_pct"));
			vo.setPhoneNumber(rs.getString("phone_number"));
			vo.setJobId(rs.getString("job_id"));
			vo.setEmail(rs.getString("email"));
			vo.setDeptId(rs.getInt("department_id"));
			vo.setManagerId(rs.getInt("manager_id"));

			result.add(vo);
		}
		// 6.Ŀ�ؼ� ���� ����
		con.close();
		return result;

	}


	public static ArrayList<EmpVO> getEmpListByJobId(String jobId) throws Exception {

		ArrayList<EmpVO> result = new ArrayList<EmpVO>();
		//�����ͺ��̽��� ��ȸ�Ͽ� result�� ��´�.
		// 1.JDBC����̹� �ε�(����122p��������)
		Class.forName("oracle.jdbc.driver.OracleDriver");//��Ű�� Ŭ����
		// 2.Ŀ�ؼ� ����(122p�Ʒ�)
		Connection con = 
				DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "hr", "hr");
		// 3.statement���� 
		Statement stmt = con.createStatement();
		// 4.SQL����
		String sql ="select EMPLOYEE_ID, FIRST_NAME, LAST_NAME, SALARY, EMAIL, JOB_ID,\r\n" + 
				"  to_char(HIRE_DATE, 'YYYY-MM-DD') hire_date, PHONE_NUMBER, COMMISSION_PCT, DEPARTMENT_ID, MANAGER_ID\r\n" + 
				"from EMPLOYEES\r\n" +
				" where phone_number like '%" + jobId+"%'";
		ResultSet rs = stmt.executeQuery(sql);
		// 5.����ޱ�
		while(rs.next()) {
			EmpVO vo = new EmpVO();
			vo.setEmpId(rs.getInt("employee_id"));
			vo.setLastName(rs.getString("last_name"));
			vo.setSalary(rs.getInt("salary"));
			vo.setHireDate(rs.getString("HIRE_DATE"));
			vo.setFirstName(rs.getString("first_name"));
			vo.setCommissionPct(rs.getInt("commission_pct"));
			vo.setPhoneNumber(rs.getString("phone_number"));
			vo.setJobId(rs.getString("job_id"));
			vo.setEmail(rs.getString("email"));
			vo.setDeptId(rs.getInt("department_id"));
			vo.setManagerId(rs.getInt("manager_id"));

			result.add(vo);
		}
		// 6.Ŀ�ؼ� ���� ����
		con.close();
		return result;

	}

}
