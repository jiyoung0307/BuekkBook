package com.bukkeubook.book.manage.model.dto.joinDTO;

import java.io.Serializable;
import java.sql.Date;

public class EmpAndDeptDTO2 implements Serializable {

	private static final long serialVersionUID = 3511557515410322346L;
	
//  EMP_NO      	NUMBER                 사원번호
//  EMP_NAME   		NVARCHAR2(31 CHAR)     사원명
//  EMP_JOB_CODE   	NVARCHAR2(31 CHAR)     직급
//  EMP_ENT_DATE   	DATE            	   입사일자
//  EMP_END_DATE   	DATE            	   퇴사일자
//  DEPT_CODE   	NUMBER                 부서코드
//	DEPT_NAME		NVARCHAR2(31 CHAR)	   부서명
	
	private int empNo;
	private String empName;
	private String empJobCode;
	private java.sql.Date empEntDate;
	private java.sql.Date empEndDate;
	private int deptCode;
	private String deptName;
	
	public EmpAndDeptDTO2() {
	}
	
	public EmpAndDeptDTO2(int empNo, String empName, String empJobCode, Date empEntDate, Date empEndDate,
			int deptCode, String deptName) {
		this.empNo = empNo;
		this.empName = empName;
		this.empJobCode = empJobCode;
		this.empEntDate = empEntDate;
		this.empEndDate = empEndDate;
		this.deptCode = deptCode;
		this.deptName = deptName;
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
	public String getEmpJobCode() {
		return empJobCode;
	}
	public void setEmpJobCode(String empJobCode) {
		this.empJobCode = empJobCode;
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
	public int getDeptCode() {
		return deptCode;
	}
	public void setDeptCode(int deptCode) {
		this.deptCode = deptCode;
	}
	public String getDeptName() {
		return deptName;
	}
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	@Override
	public String toString() {
		return "ZeroEmpAndDeptDTO [empNo=" + empNo + ", empName=" + empName + ", empJobCode=" + empJobCode
				+ ", empEntDate=" + empEntDate + ", empEndDate=" + empEndDate + ", deptCode=" + deptCode + ", deptName="
				+ deptName + "]";
	}
	
}
