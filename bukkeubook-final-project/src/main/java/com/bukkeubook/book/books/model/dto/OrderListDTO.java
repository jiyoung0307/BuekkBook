package com.bukkeubook.book.books.model.dto;

import java.io.Serializable;
import java.sql.Date;

public class OrderListDTO implements Serializable{

	private static final long serialVersionUID = 4913387832743442477L;
	
	/*
	 * DB 자료형
	 * 
	 * OR_NO	NUMBER	발주번호
		OR_DATE	DATE	등록날짜
		OR_APPR_YN	VARCHAR2(6 BYTE)	승인현황
		OR_AMOUNT	NUMBER	발주수량
		CNT_NO	NUMBER	거래처번호
		BK_NO	VARCHAR2(100 BYTE)	도서코드
		EMP_NO	NUMBER	사원번호
		OR_APP_DATE	DATE	승인날짜
	 */
	private int orderNo;					// 발주번호
	private java.sql.Date orderDate;		// 등록날짜
	private String orderApprYn;			// 승인현황
	private int orderAmount;				// 발주수량
	private int cntNo;					// 거래처번호
	private String bkNo;					// 도서코드
	private int empNo;					// 사원번호
	private java.sql.Date orderAppDate;	// 승인날짜
	
	public OrderListDTO() {
	}

	public OrderListDTO(int orderNo, Date orderDate, String orderApprYn, int orderAmount, int cntNo, String bkNo,
			int empNo, Date orderAppDate) {
		this.orderNo = orderNo;
		this.orderDate = orderDate;
		this.orderApprYn = orderApprYn;
		this.orderAmount = orderAmount;
		this.cntNo = cntNo;
		this.bkNo = bkNo;
		this.empNo = empNo;
		this.orderAppDate = orderAppDate;
	}

	public int getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(int orderNo) {
		this.orderNo = orderNo;
	}

	public java.sql.Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(java.sql.Date orderDate) {
		this.orderDate = orderDate;
	}

	public String getOrderApprYn() {
		return orderApprYn;
	}

	public void setOrderApprYn(String orderApprYn) {
		this.orderApprYn = orderApprYn;
	}

	public int getOrderAmount() {
		return orderAmount;
	}

	public void setOrderAmount(int orderAmount) {
		this.orderAmount = orderAmount;
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

	public java.sql.Date getOrderAppDate() {
		return orderAppDate;
	}

	public void setOrderAppDate(java.sql.Date orderAppDate) {
		this.orderAppDate = orderAppDate;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "OrderListDTO [orderNo=" + orderNo + ", orderDate=" + orderDate + ", orderApprYn=" + orderApprYn
				+ ", orderAmount=" + orderAmount + ", cntNo=" + cntNo + ", bkNo=" + bkNo + ", empNo=" + empNo
				+ ", orderAppDate=" + orderAppDate + "]";
	}
	
}
