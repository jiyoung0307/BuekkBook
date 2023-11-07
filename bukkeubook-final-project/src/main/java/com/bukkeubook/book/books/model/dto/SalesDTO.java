package com.bukkeubook.book.books.model.dto;

import java.io.Serializable;

public class SalesDTO implements Serializable{

	private static final long serialVersionUID = 4982412334573083321L;

	/* DB 자료형(TBL_SALES) */
//	SALES_CODE	NUMBER	목록번호
//	SALES_AMOUNT	NUMBER	판매수량
//	BK_NO	VARCHAR2(100 BYTE)	도서코드
	private int salesCode;		// 목록번호
	private int salesAmount;	// 판매수량
	private String bkNo;		// 도서코드
	
	public SalesDTO() {
	}

	public SalesDTO(int salesCode, int salesAmount, String bkNo) {
		this.salesCode = salesCode;
		this.salesAmount = salesAmount;
		this.bkNo = bkNo;
	}

	public int getSalesCode() {
		return salesCode;
	}

	public void setSalesCode(int salesCode) {
		this.salesCode = salesCode;
	}

	public int getSalesAmount() {
		return salesAmount;
	}

	public void setSalesAmount(int salesAmount) {
		this.salesAmount = salesAmount;
	}

	public String getBkNo() {
		return bkNo;
	}

	public void setBkNo(String bkNo) {
		this.bkNo = bkNo;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "SalesDTO [salesCode=" + salesCode + ", salesAmount=" + salesAmount + ", bkNo=" + bkNo + "]";
	}
	
}
