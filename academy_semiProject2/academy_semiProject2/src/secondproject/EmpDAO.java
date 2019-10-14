package secondproject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

public class EmpDAO {
	
	public static ArrayList<EmpVO> selectEmpListBySQL(String sql) throws Exception {
				ArrayList<EmpVO> emplist = new ArrayList<>();
				Class.forName("oracle.jdbc.driver.OracleDriver");
				Connection con = DriverManager.getConnection("jdbc:oracle:thin:@1.250.62.160:1521:xe","hr","hr");								
				System.out.println(con.getClass().getName());
				Statement stmt = con.createStatement();
				String sqls = sql;
				ResultSet rs = stmt.executeQuery(sqls);
			
				while(rs.next()) {
					EmpVO info = new EmpVO();
					info.setEmpId(rs.getInt("employee_id"));
					info.setfName(rs.getString("first_name"));
					info.setlName(rs.getString("last_name"));
					info.setSalary(rs.getInt("salary"));
					info.sethDate(rs.getDate("hire_date"));
					info.setDeptID(rs.getInt("department_id"));
					emplist.add(info);
				}
				con.close();
				return emplist;
	}
	
	public static ArrayList<EmpVO> selectEmpListBySQLForAdmin(String sql) throws Exception {
		ArrayList<EmpVO> emplist = new ArrayList<>();

		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@1.250.62.160:1521:xe","hr","hr");								
		System.out.println(con.getClass().getName());
		Statement stmt = con.createStatement();
		String sqls = sql;
		ResultSet rs = stmt.executeQuery(sqls);
	
		while(rs.next()) {
			EmpVO info = new EmpVO();
			info.setEmpId(rs.getInt("employee_id"));
			info.setfName(rs.getString("first_name"));
			info.setlName(rs.getString("last_name"));
			info.setSalary(rs.getInt("salary"));
			info.sethDate(rs.getDate("hire_date"));
			info.setDeptID(rs.getInt("department_id"));
			info.seteMail(rs.getString("email"));
			info.setJobId(rs.getString("job_id"));
			info.setManagerId(rs.getString("manager_id"));
			info.setMobile(rs.getString("phone_number"));
			info.setComm(rs.getString("commission_pct"));
			emplist.add(info);
		}
		con.close();
		return emplist;
}

	
	public static String selectPassword(String sql) throws Exception {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@1.250.62.160:1521:xe","hr","hr");								
		System.out.println(con.getClass().getName());
		Statement stmt = con.createStatement();
		String sqls = sql;
		ResultSet rs = stmt.executeQuery(sqls);
		String pw = null;
		while(rs.next()) {
			pw = rs.getString("pw");
		}
		con.close();
		return pw;
	}
	
	public static String selectAdminchk(String sql) throws Exception {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@1.250.62.160:1521:xe","hr","hr");								
		System.out.println(con.getClass().getName());
		Statement stmt = con.createStatement();
		String sqls = sql;
		ResultSet rs = stmt.executeQuery(sqls);
		String adminchk = null;
		while(rs.next()) {
			adminchk = rs.getString("admin");
		}
		con.close();
		return adminchk;
	}
	
	public static void insertnewProfile(String sql, int empid) throws Exception {
		ArrayList<Integer> empidcheck = new ArrayList<>();
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@1.250.62.160:1521:xe","hr","hr");								
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery("select employee_id from my_profile");
		while(rs.next()) {
		int getempid = rs.getInt("employee_id");
		empidcheck.add(getempid);
		}
		for(int check:empidcheck) {
			if(check==empid) {
				System.out.println("이미 사용된 사번");
				con.close();
				break;
			}
		}
		String sqls = sql;
		rs = stmt.executeQuery(sqls);
		while(rs.next()) {
			System.out.println("신규 회원이 가입되었습니다.");
			break;
		}
		con.close();
	}
	public static void insertnewEmp(String sql) throws Exception {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@1.250.62.160:1521:xe","hr","hr");								
		Statement stmt = con.createStatement();
		String sqls = sql;
		System.out.println("여기는 실행 됨.");
		ResultSet rs = stmt.executeQuery(sqls);
		System.out.println("여기도 실행 됨.");
		while(rs.next()) {
			System.out.println("새로운 사원정보가 등록되었습니다.");
			break;
		}
		con.close();
	}
}
