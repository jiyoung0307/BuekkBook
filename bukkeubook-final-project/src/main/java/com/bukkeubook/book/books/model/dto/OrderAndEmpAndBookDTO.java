package com.bukkeubook.book.books.model.dto;

import java.io.Serializable;
import java.sql.Date;

import com.bukkeubook.book.document.model.dto.EmpDTO;


public class OrderAndEmpAndBookDTO implements Serializable{

	private static final long serialVersionUID = 2422088674252560622L;

	private int orderNo;					// 발주번호
	private java.sql.Date orderDate;		// 등록날짜
	private String orderApprYn;			// 승인현황
	private int orderAmount;				// 발주수량
	private int cntNo;					// 거래처번호
	private String bkNo;					// 도서코드
	private int empNo;					// 사원번호
	private java.sql.Date orderAppDate;	// 승인날짜
	private EmpDTO emp;
	private BookDTO book;
	
	public OrderAndEmpAndBookDTO() {
	}

	public OrderAndEmpAndBookDTO(int orderNo, Date orderDate, String orderApprYn, int orderAmount, int cntNo,
			String bkNo, int empNo, Date orderAppDate, EmpDTO emp, BookDTO book) {
		this.orderNo = orderNo;
		this.orderDate = orderDate;
		this.orderApprYn = orderApprYn;
		this.orderAmount = orderAmount;
		this.cntNo = cntNo;
		this.bkNo = bkNo;
		this.empNo = empNo;
		this.orderAppDate = orderAppDate;
		this.emp = emp;
		this.book = book;
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

	public EmpDTO getEmp() {
		return emp;
	}

	public void setEmp(EmpDTO emp) {
		this.emp = emp;
	}

	public BookDTO getBook() {
		return book;
	}

	public void setBook(BookDTO book) {
		this.book = book;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "OrderAndEmpAndBookDTO [orderNo=" + orderNo + ", orderDate=" + orderDate + ", orderApprYn=" + orderApprYn
				+ ", orderAmount=" + orderAmount + ", cntNo=" + cntNo + ", bkNo=" + bkNo + ", empNo=" + empNo
				+ ", orderAppDate=" + orderAppDate + ", emp=" + emp + ", book=" + book + "]";
	}
	
}
