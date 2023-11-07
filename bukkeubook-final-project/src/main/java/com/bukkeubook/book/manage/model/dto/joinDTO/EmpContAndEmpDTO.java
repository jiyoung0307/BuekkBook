package com.bukkeubook.book.manage.model.dto.joinDTO;

import java.sql.Date;

import com.bukkeubook.book.manage.model.dto.EmpDTO;

public class EmpContAndEmpDTO {
	
//	CONT_NO			UMBER				근로계약번호
//	CONT_NAME		NVARCHAR2(63 CHAR)	계약서명
//	CONT_DATE		DATE				개시일
//	CONT_WRITER		NVARCHAR2(31 CHAR)	작성자
//	CONT_EXP_DATE	DATE				만료일
//	EMP_NO			NUMBER				사원번호
	
	private int contNo;					// 근로계약번호
	private String contName;			// 계약서명
	private java.sql.Date contDate;		// 개시일
	private String contWriter;			// 작성자
	private java.sql.Date contExpDate;	// 만료일
	private int empNo;					// 사원번호
	private EmpDTO emp;
	public EmpContAndEmpDTO() {
	}
	public EmpContAndEmpDTO(int contNo, String contName, Date contDate, String contWriter, Date contExpDate, int empNo,
			EmpDTO emp) {
		this.contNo = contNo;
		this.contName = contName;
		this.contDate = contDate;
		this.contWriter = contWriter;
		this.contExpDate = contExpDate;
		this.empNo = empNo;
		this.emp = emp;
	}
	public int getContNo() {
		return contNo;
	}
	public void setContNo(int contNo) {
		this.contNo = contNo;
	}
	public String getContName() {
		return contName;
	}
	public void setContName(String contName) {
		this.contName = contName;
	}
	public java.sql.Date getContDate() {
		return contDate;
	}
	public void setContDate(java.sql.Date contDate) {
		this.contDate = contDate;
	}
	public String getContWriter() {
		return contWriter;
	}
	public void setContWriter(String contWriter) {
		this.contWriter = contWriter;
	}
	public java.sql.Date getContExpDate() {
		return contExpDate;
	}
	public void setContExpDate(java.sql.Date contExpDate) {
		this.contExpDate = contExpDate;
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
	@Override
	public String toString() {
		return "EmpContAndEmpDTO [contNo=" + contNo + ", contName=" + contName + ", contDate=" + contDate
				+ ", contWriter=" + contWriter + ", contExpDate=" + contExpDate + ", empNo=" + empNo + ", emp=" + emp
				+ "]";
	}
	
	
}
