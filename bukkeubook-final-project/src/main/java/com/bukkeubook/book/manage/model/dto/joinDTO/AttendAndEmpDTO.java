package com.bukkeubook.book.manage.model.dto.joinDTO;

import java.io.Serializable;
import java.sql.Date;

import com.bukkeubook.book.manage.model.dto.EmpDTO;


public class AttendAndEmpDTO implements Serializable{
	
	private static final long serialVersionUID = 685111264582119468L;
	
//	ATT_NO		NUMBER	근태번호
//	ATT_DATE	DATE	근무날짜
//	ATT_START	DATE	출근시간
//	ATT_END		DATE	퇴근시간
//	EMP_NO		NUMBER	사원번호
	
	private int attNo;					// 근태번호
	private java.sql.Date attDate;		// 근무날짜
	private java.sql.Date attStart;		// 출근시간
	private java.sql.Date attEnd;		// 퇴근시간
	private int empNo;					// 사원번호
	private EmpDTO emp;
	public AttendAndEmpDTO() {
	}
	public AttendAndEmpDTO(int attNo, Date attDate, Date attStart, Date attEnd, int empNo, EmpDTO emp) {
		this.attNo = attNo;
		this.attDate = attDate;
		this.attStart = attStart;
		this.attEnd = attEnd;
		this.empNo = empNo;
		this.emp = emp;
	}
	public int getAttNo() {
		return attNo;
	}
	public void setAttNo(int attNo) {
		this.attNo = attNo;
	}
	public java.sql.Date getAttDate() {
		return attDate;
	}
	public void setAttDate(java.sql.Date attDate) {
		this.attDate = attDate;
	}
	public java.sql.Date getAttStart() {
		return attStart;
	}
	public void setAttStart(java.sql.Date attStart) {
		this.attStart = attStart;
	}
	public java.sql.Date getAttEnd() {
		return attEnd;
	}
	public void setAttEnd(java.sql.Date attEnd) {
		this.attEnd = attEnd;
	}
	public int getEmpNo() {
		return empNo;
	}
	public void setEmpNo(int empNo) {
		this.empNo = empNo;
	}
	public EmpDTO getEmp() {
		return emp;
	}
	public void setEmp(EmpDTO emp) {
		this.emp = emp;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public String toString() {
		return "AttendAndEmpDTO [attNo=" + attNo + ", attDate=" + attDate + ", attStart=" + attStart + ", attEnd="
				+ attEnd + ", empNo=" + empNo + ", emp=" + emp + "]";
	}
	
	
	
}
