package com.bukkeubook.book.document.model.dto;

import java.io.Serializable;
import java.sql.Date;

public class EmpDTO implements Serializable {

	
//	EMP_NO	NUMBER
//	EMP_NAME	NVARCHAR2(31 CHAR)
//	EMP_PHONE_1	VARCHAR2(10 BYTE)
//	EMP_PHONE_2	VARCHAR2(10 BYTE)
//	EMP_PHONE_3	VARCHAR2(10 BYTE)
//	EMP_BIRTH	DATE
//	EMP_GENDER	VARCHAR2(15 BYTE)
//	EMP_EMAIL	VARCHAR2(63 BYTE)
//	EMP_JOB_CODE	NVARCHAR2(31 CHAR)
//	EMP_ADDRESS	NVARCHAR2(255 CHAR)
//	EMP_D_ADDRESS	NVARCHAR2(255 CHAR)
//	EMP_ENT_DATE	DATE
//	EMP_END_DATE	DATE
//	EMP_END_YN	VARCHAR2(3 BYTE)
//	EMP_PWD	VARCHAR2(255 BYTE)
//	DEPT_CODE	NUMBER
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3924113693989561067L;
	private int empNo;
	private String empName;
	private String empPhone1;
	private String empPhone2;
	private String empPhone3;
	private java.sql.Date empBirth;
	private String empGender;
	private String empEmail;   
	private String empJobCode;
	private String empAddress1;
	private String empAddress2;
	private java.sql.Date empEntDate;
	private java.sql.Date empEndDate;
	private String empEndYn;
	private String empPwd;
	private int deptCode;
	
	public EmpDTO() {
		super();
	}

	public EmpDTO(int empNo, String empName, String empPhone1, String empPhone2, String empPhone3, Date empBirth,
			String empGender, String empEmail, String empJobCode, String empAddress1, String empAddress2,
			Date empEntDate, Date empEndDate, String empEndYn, String empPwd, int deptCode) {
		super();
		this.empNo = empNo;
		this.empName = empName;
		this.empPhone1 = empPhone1;
		this.empPhone2 = empPhone2;
		this.empPhone3 = empPhone3;
		this.empBirth = empBirth;
		this.empGender = empGender;
		this.empEmail = empEmail;
		this.empJobCode = empJobCode;
		this.empAddress1 = empAddress1;
		this.empAddress2 = empAddress2;
		this.empEntDate = empEntDate;
		this.empEndDate = empEndDate;
		this.empEndYn = empEndYn;
		this.empPwd = empPwd;
		this.deptCode = deptCode;
	}

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

	public String getEmpPhone1() {
		return empPhone1;
	}

	public void setEmpPhone1(String empPhone1) {
		this.empPhone1 = empPhone1;
	}

	public String getEmpPhone2() {
		return empPhone2;
	}

	public void setEmpPhone2(String empPhone2) {
		this.empPhone2 = empPhone2;
	}

	public String getEmpPhone3() {
		return empPhone3;
	}

	public void setEmpPhone3(String empPhone3) {
		this.empPhone3 = empPhone3;
	}

	public java.sql.Date getEmpBirth() {
		return empBirth;
	}

	public void setEmpBirth(java.sql.Date empBirth) {
		this.empBirth = empBirth;
	}

	public String getEmpGender() {
		return empGender;
	}

	public void setEmpGender(String empGender) {
		this.empGender = empGender;
	}

	public String getEmpEmail() {
		return empEmail;
	}

	public void setEmpEmail(String empEmail) {
		this.empEmail = empEmail;
	}

	public String getEmpJobCode() {
		return empJobCode;
	}

	public void setEmpJobCode(String empJobCode) {
		this.empJobCode = empJobCode;
	}

	public String getEmpAddress1() {
		return empAddress1;
	}

	public void setEmpAddress1(String empAddress1) {
		this.empAddress1 = empAddress1;
	}

	public String getEmpAddress2() {
		return empAddress2;
	}

	public void setEmpAddress2(String empAddress2) {
		this.empAddress2 = empAddress2;
	}

	public java.sql.Date getEmpEntDate() {
		return empEntDate;
	}

	public void setEmpEntDate(java.sql.Date empEntDate) {
		this.empEntDate = empEntDate;
	}

	public java.sql.Date getEmpEndDate() {
		return empEndDate;
	}

	public void setEmpEndDate(java.sql.Date empEndDate) {
		this.empEndDate = empEndDate;
	}

	public String getEmpEndYn() {
		return empEndYn;
	}

	public void setEmpEndYn(String empEndYn) {
		this.empEndYn = empEndYn;
	}

	public String getEmpPwd() {
		return empPwd;
	}

	public void setEmpPwd(String empPwd) {
		this.empPwd = empPwd;
	}

	public int getDeptCode() {
		return deptCode;
	}

	public void setDeptCode(int deptCode) {
		this.deptCode = deptCode;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "EmpDTO [empNo=" + empNo + ", empName=" + empName + ", empPhone1=" + empPhone1 + ", empPhone2="
				+ empPhone2 + ", empPhone3=" + empPhone3 + ", empBirth=" + empBirth + ", empGender=" + empGender
				+ ", empEmail=" + empEmail + ", empJobCode=" + empJobCode + ", empAddress1=" + empAddress1
				+ ", empAddress2=" + empAddress2 + ", empEntDate=" + empEntDate + ", empEndDate=" + empEndDate
				+ ", empEndYn=" + empEndYn + ", empPwd=" + empPwd + ", deptCode=" + deptCode + "]";
	}

	
	
	
}
