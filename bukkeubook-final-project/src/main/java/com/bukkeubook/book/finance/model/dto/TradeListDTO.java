package com.bukkeubook.book.finance.model.dto;

import java.io.Serializable;
import java.sql.Date;

public class TradeListDTO implements Serializable{

	private static final long serialVersionUID = 7259115047051463544L;

	/*
	 * DB 자료형
	 * 
	 * TL_NO	NUMBER	거래번호
		TL_DATE	DATE	거래일자
		TL_AMOUNT	NUMBER	도서수량
		TL_DETAIL	NVARCHAR2(255 CHAR)	상세내용
		CNT_NO	NUMBER	거래처번호
		BK_NO	VARCHAR2(100 BYTE)	도서코드
		EMP_NO	NUMBER	사원번호
	 */
	private int tlNo;					// 거래번호
	private java.sql.Date tlDate;		// 거래일자
	private int tlAmount;				// 도서수량
	private String tlDetail;			// 상세내용
	private int cntNo;					// 거래처번호
	private String bkNo;					// 도서코드
	private int empNo;					// 사원번호
	
	public TradeListDTO() {
	}

	public TradeListDTO(int tlNo, Date tlDate, int tlAmount, String tlDetail, int cntNo, String bkNo, int empNo) {
		this.tlNo = tlNo;
		this.tlDate = tlDate;
		this.tlAmount = tlAmount;
		this.tlDetail = tlDetail;
		this.cntNo = cntNo;
		this.bkNo = bkNo;
		this.empNo = empNo;
	}

	public int getTlNo() {
		return tlNo;
	}

	public void setTlNo(int tlNo) {
		this.tlNo = tlNo;
	}

	public java.sql.Date getTlDate() {
		return tlDate;
	}

	public void setTlDate(java.sql.Date tlDate) {
		this.tlDate = tlDate;
	}

	public int getTlAmount() {
		return tlAmount;
	}

	public void setTlAmount(int tlAmount) {
		this.tlAmount = tlAmount;
	}

	public String getTlDetail() {
		return tlDetail;
	}

	public void setTlDetail(String tlDetail) {
		this.tlDetail = tlDetail;
	}

	public int getCntNo() {
		return cntNo;
	}

	public void setCntNo(int cntNo) {
		this.cntNo = cntNo;
	}

	public String getBkNo() {
		return bkNo;
	}

	public void setBkNo(String bkNo) {
		this.bkNo = bkNo;
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
		return "TradeListDTO [tlNo=" + tlNo + ", tlDate=" + tlDate + ", tlAmount=" + tlAmount + ", tlDetail=" + tlDetail
				+ ", cntNo=" + cntNo + ", bkNo=" + bkNo + ", empNo=" + empNo + "]";
	}
	
}
