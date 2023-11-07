package com.bukkeubook.book.document.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name = "DocDept")
@Table(name = "TBL_DEPT")
public class Dept {

/* DB 자료형 */
	
//	DEPT_CODE		NUMBER				부서코드
//	DEPT_NAME		NVARCHAR2(31 CHAR)	부서명
//	DEPT_REP_PHONE	VARCHAR2(15 BYTE)	대표번호
	
	@Id
	@Column(name = "DEPT_CODE")
	private int deptCode;
	
	@Column(name = "DEPT_NAME")
	private String deptName;
	
	@Column(name = "DEPT_REP_PHONE")
	private String deptRepPhone;

	public Dept() {
		super();
	}

	public Dept(int deptCode, String deptName, String deptRepPhone) {
		super();
		this.deptCode = deptCode;
		this.deptName = deptName;
		this.deptRepPhone = deptRepPhone;
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

	public String getDeptRepPhone() {
		return deptRepPhone;
	}

	public void setDeptRepPhone(String deptRepPhone) {
		this.deptRepPhone = deptRepPhone;
	}

	@Override
	public String toString() {
		return "Dept [deptCode=" + deptCode + ", deptName=" + deptName + ", deptRepPhone=" + deptRepPhone + "]";
	}
	
	
	
}
