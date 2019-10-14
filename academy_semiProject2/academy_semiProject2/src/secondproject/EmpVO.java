package secondproject;

import java.util.Date;

public class EmpVO {
	
	int empId;
	String fName;
	String lName;
	int salary;
	Date hDate;
	int deptID;
	String mobile;
	String comm;
	String eMail;
	String jobId;
	String managerId;
	
	public String getComm() {
		return comm;
	}
	public void setComm(String comm) {
		this.comm = comm;
	}
	public String geteMail() {
		return eMail;
	}
	public void seteMail(String eMail) {
		this.eMail = eMail;
	}
	public String getJobId() {
		return jobId;
	}
	public void setJobId(String jobId) {
		this.jobId = jobId;
	}
	public String getManagerId() {
		return managerId;
	}
	public void setManagerId(String managerId) {
		this.managerId = managerId;
	}
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public String getfName() {
		return fName;
	}
	public void setfName(String fName) {
		this.fName = fName;
	}
	public String getlName() {
		return lName;
	}
	public void setlName(String lName) {
		this.lName = lName;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public Date gethDate() {
		return hDate;
	}
	public void sethDate(Date hDate) {
		this.hDate = hDate;
	}
	public int getDeptID() {
		return deptID;
	}
	public void setDeptID(int deptID) {
		this.deptID = deptID;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	
	public EmpVO (){
		
	}
	
	public EmpVO(int empID, String fName, String lName, Date hDate, int deptID) {
		this.empId = empID;
		this.fName = fName;
		this.lName = lName;
		this.hDate = hDate;
		this.deptID = deptID;  
	}
	
	public EmpVO(int empId, String fName, String lName, int salary, Date hDate, int deptID, String eMail, String jobId,
			String managerId, String mobile, String comm) {
		super();
		this.empId = empId;
		this.fName = fName;
		this.lName = lName;
		this.salary = salary;
		this.hDate = hDate;
		this.deptID = deptID;
		this.eMail = eMail;
		this.jobId = jobId;
		this.managerId = managerId;
		this.mobile = mobile;
		this.comm = comm;
	}
	
}
