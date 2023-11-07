package com.bukkeubook.book.books.model.entity;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.bukkeubook.book.document.model.entity.Emp;


@Entity
@Table(name="TBL_ORDER_LIST")
public class OrderAndEmpAndBook implements Serializable{

	private static final long serialVersionUID = -9067766925393245784L;

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
	@Id
	@Column(name="OR_NO")
	private int orderNo;				// 발주번호
	
	@Column(name="OR_DATE")
	private java.sql.Date orderDate;	// 등록날짜
	
	@Column(name="OR_APPR_YN")
	private String orderApprYn;		// 승인현황
	
	@Column(name="OR_AMOUNT")
	private int orderAmount;			// 발주수량
	
	@Column(name="CNT_NO")
	private int cntNo;				// 거래처번호
	
	@ManyToOne
	@JoinColumn(name="BK_NO")
	private Book book;				// 도서코드
	
	@ManyToOne
	@JoinColumn(name="EMP_NO")
	private Emp emp;				// 사원번호
	
	@Column(name="OR_APP_DATE")
	private java.sql.Date orderAppDate;	// 승인날짜

	public OrderAndEmpAndBook() {
	}

	public OrderAndEmpAndBook(int orderNo, Date orderDate, String orderApprYn, int orderAmount, int cntNo, Book book,
			Emp emp, Date orderAppDate) {
		this.orderNo = orderNo;
		this.orderDate = orderDate;
		this.orderApprYn = orderApprYn;
		this.orderAmount = orderAmount;
		this.cntNo = cntNo;
		this.book = book;
		this.emp = emp;
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

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public Emp getEmp() {
		return emp;
	}

	public void setEmp(Emp emp) {
		this.emp = emp;
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
		return "OrderAndEmpAndBook [orderNo=" + orderNo + ", orderDate=" + orderDate + ", orderApprYn=" + orderApprYn
				+ ", orderAmount=" + orderAmount + ", cntNo=" + cntNo + ", book=" + book + ", emp=" + emp
				+ ", orderAppDate=" + orderAppDate + "]";
	}
	
}
