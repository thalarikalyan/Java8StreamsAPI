package com.kalyan.java8;

public class Employee {
	

	private Integer empid;
	private String empname;
	private String designation;
	private Integer empsalary;
	private String empaddress;
	private Integer age;
	
	


	
	

	public Employee(Integer empid, String empname, String designation, Integer empsalary, String empaddress,
			Integer age) {
		this.empid = empid;
		this.empname = empname;
		this.designation = designation;
		this.empsalary = empsalary;
		this.empaddress = empaddress;
		this.age = age;
	}

	public Integer getEmpid() {
		return empid;
	}

	public void setEmpid(Integer empid) {
		this.empid = empid;
	}

	public String getEmpname() {
		return empname;
	}

	public void setEmpname(String empname) {
		this.empname = empname;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public Integer getEmpsalary() {
		return empsalary;
	}

	public void setEmpsalary(Integer empsalary) {
		this.empsalary = empsalary;
	}

	public String getEmpaddress() {
		return empaddress;
	}

	public void setEmpaddress(String empaddress) {
		this.empaddress = empaddress;
	}
	
	

	
	
	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Employee [empid=" + empid + ", empname=" + empname + ", designation=" + designation + ", empsalary="
				+ empsalary + ", empaddress=" + empaddress + ", age=" + age + "]";
	}

	

}
