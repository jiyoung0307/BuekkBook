package com.bukkeubook.book.books.model.dto;

import java.sql.Date;

import com.bukkeubook.book.manage.model.entity.Emp;

public class StockListAndEmpDTO {
//	ST_CODE	NUMBER	목록번호
//	ST_DATE	DATE	입고날짜
//	EMP_NO	NUMBER	사원번호
//	ST_TYPE	NVARCHAR2(31 CHAR)	입고구분
	
	private int stCode;				// 목록번호
	private java.sql.Date stDate;	// 입고날짜
	private String stType;			// 입고구분
	private int empNo;				// 사원번호
	private Emp emp;
	
	public StockListAndEmpDTO() {
	}
	public StockListAndEmpDTO(int stCode, Date stDate, String stType, int empNo, Emp emp) {
		this.stCode = stCode;
		this.stDate = stDate;
		this.stType = stType;
		this.empNo = empNo;
		this.emp = emp;
	}
	public int getStCode() {
		return stCode;
	}
	public void setStCode(int stCode) {
		this.stCode = stCode;
	}
	public java.sql.Date getStDate() {
		return stDate;
	}
	public void setStDate(java.sql.Date stDate) {
		this.stDate = stDate;
	}
	public String getStType() {
		return stType;
	}
	public void setStType(String stType) {
		this.stType = stType;
	}
	public int getEmpNo() {
		return empNo;
	}
	public void setEmpNo(int empNo) {
		this.empNo = empNo;
	}
	public Emp getEmp() {
		return emp;
	}
	public void setEmp(Emp emp) {
		this.emp = emp;
	}
	@Override
	public String toString() {
		return "StockListAndEmpDTO [stCode=" + stCode + ", stDate=" + stDate + ", stType=" + stType + ", empNo=" + empNo
				+ ", emp=" + emp + "]";
	}
	
	
	
}
