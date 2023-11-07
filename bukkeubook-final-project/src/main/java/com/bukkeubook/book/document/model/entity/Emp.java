package com.bukkeubook.book.document.model.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name="DocEmp")
@Table(name = "TBL_EMP")
public class Emp {
	
//  EMP_NO   NUMBER   사원번호
//  EMP_NAME   NVARCHAR2(31 CHAR)   사원명
//  EMP_PHONE_1   VARCHAR2(10 BYTE)   연락처1
//  EMP_PHONE_2   VARCHAR2(10 BYTE)   연락처2
//  EMP_PHONE_3   VARCHAR2(10 BYTE)   연락처3
//  EMP_BIRTH   DATE   생년월일
//  EMP_GENDER   VARCHAR2(15 BYTE)   성별
//  EMP_EMAIL   VARCHAR2(63 BYTE)   이메일
//  EMP_JOB_CODE   NVARCHAR2(31 CHAR)   직급
//  EMP_ADDRESS   NVARCHAR2(255 CHAR)   주소
//  EMP_D_ADDRESS   NVARCHAR2(255 CHAR)   상세주소
//  EMP_ENT_DATE   DATE   입사일자
//  EMP_END_DATE   DATE   퇴사일자
//  EMP_END_YN   VARCHAR2(3 BYTE)   퇴사여부
//  EMP_PWD   VARCHAR2(255 BYTE)   비밀번호
//  DEPT_CODE   NUMBER   부서코드
  
  @Id
  @Column(name = "EMP_NO")
  private int empNo;
  
  @Column(name = "EMP_NAME")
  private String empName;
  
  @Column(name = "EMP_PHONE_1")
  private String empPhone1;
  
  @Column(name = "EMP_PHONE_2")
  private String empPhone2;
  
  @Column(name = "EMP_PHONE_3")
  private String empPhone3;
  
  @Column(name = "EMP_BIRTH")
  private java.sql.Date empBirth;
  
  @Column(name = "EMP_GENDER")
  private String empGender;
  
  @Column(name = "EMP_JOB_CODE")
  private String empJobCode;
  
  @Column(name = "EMP_EMAIL")
  private String empEmail;
  
  @Column(name = "EMP_ADDRESS")
  private String empAddress;
  
  @Column(name = "EMP_D_ADDRESS")
  private String empDAdreess;
  
  @Column(name = "EMP_ENT_DATE")
  private java.sql.Date empEntDate;
  
  @Column(name = "EMP_END_DATE")
  private java.sql.Date empEndDate;
  
  @Column(name = "EMP_END_YN")
  private String empEndYn;
  
  @Column(name = "EMP_PWD")
  private String empPwd;
  
  @Column(name = "DEPT_CODE")
  private int deptCode;


	public Emp() {
		super();
	}


	public Emp(int empNo, String empName, String empPhone1, String empPhone2, String empPhone3, Date empBirth,
			String empGender, String empJobCode, String empEmail, String empAddress, String empDAdreess,
			Date empEntDate, Date empEndDate, String empEndYn, String empPwd, int deptCode) {
		super();
		this.empNo = empNo;
		this.empName = empName;
		this.empPhone1 = empPhone1;
		this.empPhone2 = empPhone2;
		this.empPhone3 = empPhone3;
		this.empBirth = empBirth;
		this.empGender = empGender;
		this.empJobCode = empJobCode;
		this.empEmail = empEmail;
		this.empAddress = empAddress;
		this.empDAdreess = empDAdreess;
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


	public String getEmpJobCode() {
		return empJobCode;
	}


	public void setEmpJobCode(String empJobCode) {
		this.empJobCode = empJobCode;
	}


	public String getEmpEmail() {
		return empEmail;
	}


	public void setEmpEmail(String empEmail) {
		this.empEmail = empEmail;
	}


	public String getEmpAddress() {
		return empAddress;
	}


	public void setEmpAddress(String empAddress) {
		this.empAddress = empAddress;
	}


	public String getEmpDAdreess() {
		return empDAdreess;
	}


	public void setEmpDAdreess(String empDAdreess) {
		this.empDAdreess = empDAdreess;
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


	@Override
	public String toString() {
		return "Emp [empNo=" + empNo + ", empName=" + empName + ", empPhone1=" + empPhone1 + ", empPhone2=" + empPhone2
				+ ", empPhone3=" + empPhone3 + ", empBirth=" + empBirth + ", empGender=" + empGender + ", empJobCode="
				+ empJobCode + ", empEmail=" + empEmail + ", empAddress=" + empAddress + ", empDAdreess=" + empDAdreess
				+ ", empEntDate=" + empEntDate + ", empEndDate=" + empEndDate + ", empEndYn=" + empEndYn + ", empPwd="
				+ empPwd + ", deptCode=" + deptCode + "]";
	}

	
	
}
