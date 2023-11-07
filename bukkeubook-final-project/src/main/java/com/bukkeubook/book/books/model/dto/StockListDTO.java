package com.bukkeubook.book.books.model.dto;

import java.io.Serializable;
import java.sql.Date;

public class StockListDTO implements Serializable{

	private static final long serialVersionUID = 1047873989721980719L;

	/* DB 자료형(TBL_STOCK_LIST) */
//	ST_CODE	NUMBER	목록번호
//	ST_DATE	DATE	입고날짜
//	EMP_NO	NUMBER	사원번호
//	ST_TYPE	NVARCHAR2(31 CHAR)	입고구분
	private int stCode;				// 목록번호
	private java.sql.Date stDate;	// 입고날짜
	private int empNo;				// 사원번호
	private String stType;			// 입고구분
	
	public StockListDTO() {
	}

	public StockListDTO(int stCode, Date stDate, int empNo, String stType) {
		this.stCode = stCode;
		this.stDate = stDate;
		this.empNo = empNo;
		this.stType = stType;
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

	public int getEmpNo() {
		return empNo;
	}

	public void setEmpNo(int empNo) {
		this.empNo = empNo;
	}

	public String getStType() {
		return stType;
	}

	public void setStType(String stType) {
		this.stType = stType;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "StockListDTO [stCode=" + stCode + ", stDate=" + stDate + ", empNo=" + empNo + ", stType=" + stType
				+ "]";
	}
	
}
