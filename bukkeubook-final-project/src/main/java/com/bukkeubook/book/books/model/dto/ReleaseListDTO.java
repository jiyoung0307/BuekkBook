package com.bukkeubook.book.books.model.dto;

import java.io.Serializable;
import java.sql.Date;

public class ReleaseListDTO implements Serializable{

	private static final long serialVersionUID = -6392965906152638710L;

	/* DB 자료형(TBL_REL_LIST) */
//	REL_NO	NUMBER	출고번호
//	REL_DATE	DATE	출고 날짜
//	EMP_NO	NUMBER	사원번호
	private int relNo;				// 출고번호
	private java.sql.Date relDate;	// 출고 날짜
	private int empNo;				// 사원번호
	
	public ReleaseListDTO() {
	}

	public ReleaseListDTO(int relNo, Date relDate, int empNo) {
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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "ReleaseListDTO [relNo=" + relNo + ", relDate=" + relDate + ", empNo=" + empNo + "]";
	}
	
}
