package com.erp.test.vo;

public class EmployeeVO {
	private int empNo;
	private String empName;
	private String empCredat;
	private int empSalaty;
	private int grdNo;
	private int empActive;
	
	public int getEmpNo() {
		return empNo;
	}
	public void setEmpNo(int empNo) {
		this.empNo = empNo;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public String getEmpCredat() {
		return empCredat;
	}
	public void setEmpCredat(String empCredat) {
		this.empCredat = empCredat;
	}
	public int getEmpSalaty() {
		return empSalaty;
	}
	public void setEmpSalaty(int empSalaty) {
		this.empSalaty = empSalaty;
	}
	public int getGrdNo() {
		return grdNo;
	}
	public void setGrdNo(int grdNo) {
		this.grdNo = grdNo;
	}
	public int getEmpActive() {
		return empActive;
	}
	public void setEmpActive(int empActive) {
		this.empActive = empActive;
	}
	@Override
	public String toString() {
		return "EmployeeVO [empNo=" + empNo + ", empName=" + empName + ", empCredat=" + empCredat + ", empSalaty="
				+ empSalaty + ", grdNo=" + grdNo + ", empActive=" + empActive + "]";
	}
	
}
