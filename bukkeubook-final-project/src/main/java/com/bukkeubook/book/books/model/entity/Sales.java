package com.bukkeubook.book.books.model.entity;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="TBL_SALES")
public class Sales implements Serializable{

	private static final long serialVersionUID = 8124302994616177315L;

	/* DB 자료형(TBL_SALES) */
//	SALES_CODE	NUMBER	목록번호
//	SALES_AMOUNT	NUMBER	판매수량
//	BK_NO	VARCHAR2(100 BYTE)	도서코드
	@Id
	@Column(name="SALES_CODE")
	private int salesCode;		// 목록번호
	
	@Column(name="SALES_AMOUNT")
	private int salesAmount;	// 판매수량
	
	@Column(name="BK_NO")
	private String bkNo;		// 도서코드

	public Sales() {
	}

	public Sales(int salesCode, int salesAmount, String bkNo) {
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
		return "Sales [salesCode=" + salesCode + ", salesAmount=" + salesAmount + ", bkNo=" + bkNo + "]";
	}
	
}
