

package semiProject;

public class EmpVO {

   int empId;
   String lastName;
   int salary;
   String hireDate;
   String firstName;
   int commissionPct;
   String phoneNumber;
   String jobId;
   String email;
   int deptId;
   int managerId;
   String cityName;
   
   
   


   
   public String getFirstName() {
      return firstName;
   }
   public void setFirstName(String firstName) {
      this.firstName = firstName;
   }
   public int getCommissionPct() {
      return commissionPct;
   }
   public void setCommissionPct(int commissionPct) {
      this.commissionPct = commissionPct;
   }
   public String getPhoneNumber() {
      return phoneNumber;
   }
   public void setPhoneNumber(String phoneNumber) {
      this.phoneNumber = phoneNumber;
   }
   public String getJobId() {
      return jobId;
   }
   public void setJobId(String jobId) {
      this.jobId = jobId;
   }
   public String getEmail() {
      return email;
   }
   public void setEmail(String email) {
      this.email = email;
   }
   public int getDeptId() {
      return deptId;
   }
   public void setDeptId(int deptId) {
      this.deptId = deptId;
   }
   public int getManagerId() {
      return managerId;
   }
   public void setManagerId(int managerId) {
      this.managerId = managerId;
   }
   public int getEmpId() {
      return empId;
   }
   public void setEmpId(int empId) {
      this.empId = empId;
   }
   public String getLastName() {
      return lastName;
   }
   public void setLastName(String lastName) {
      this.lastName = lastName;
   }
   public int getSalary() {
      return salary;
   }
   public void setSalary(int salary) {
      this.salary = salary;
   }
   public String getHireDate() {
      return hireDate;
   }
   public void setHireDate(String hireDate) {
      this.hireDate = hireDate;
   }
   public String getCityName() {
      return cityName;
   }
   public void setCityName(String cityName) {
      this.cityName = cityName;
   }
   
   @Override
   public String toString() {
      return "[ ��� : " + empId + "  " + "�� : " + lastName + "  " + "�̸� : " + firstName + "  " + "�Ի��� : " + hireDate
            + "  " + "�޿� : " + salary + "  " + "Ŀ�̼� : " + commissionPct  + "  " + "��ȭ��ȣ :" + phoneNumber + "  " 
            + "���� : " + jobId + "  " + "�̸��� : " + email + "  " +  "�μ���ȣ : " + deptId + "  " +  "�����ڹ�ȣ : " + managerId + "]";
   }
   

}
