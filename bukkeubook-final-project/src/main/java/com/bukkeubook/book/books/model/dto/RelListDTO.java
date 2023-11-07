package com.bukkeubook.book.books.model.dto;

import java.sql.Date;

public class RelListDTO {
//	REL_NO	NUMBER
//	REL_DATE	DATE
//	EMP_NO	NUMBER
	
	private int relNo;				// 출고번호
	private java.sql.Date relDate;	// 출고날짜
	private int empNo;				// 사원번호
	
	public RelListDTO() {
	}
	public RelListDTO(int relNo, Date relDate, int empNo) {
		this.relNo = relNo;
		this.relDate = relDate;
		this.empNo = empNo;
	}
	public int getRelNo() {
		return relNo;
	}
	public void setRelNo(int relNo) {
		this.relNo = relNo;
	}
	public java.sql.Date getRelDate() {
		return relDate;
	}
	public void setRelDate(java.sql.Date relDate) {
		this.relDate = relDate;
	}
	public int getEmpNo() {
		return empNo;
	}
	public void setEmpNo(int empNo) {
		this.empNo = empNo;
	}
	@Override
	public String toString() {
		return "RelListDTO [relNo=" + relNo + ", relDate=" + relDate + ", empNo=" + empNo + "]";
	}
	
	
}
