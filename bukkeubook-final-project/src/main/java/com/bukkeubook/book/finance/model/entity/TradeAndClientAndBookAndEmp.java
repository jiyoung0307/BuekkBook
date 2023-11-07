package com.bukkeubook.book.finance.model.entity;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.bukkeubook.book.books.model.entity.Book;
import com.bukkeubook.book.document.model.entity.Emp;

@Entity
@Table(name="TBL_TRADE_LIST")
public class TradeAndClientAndBookAndEmp implements Serializable{

	private static final long serialVersionUID = -2391827774906552843L;

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
	@Id
	@Column(name="TL_NO")
	private int tlNo;				// 거래번호
	
	@Column(name="TL_DATE")
	private java.sql.Date tlDate;	// 거래일자
	
	@Column(name="TL_AMOUNT")
	private int tlAmount;			// 도서수량
	
	@Column(name="TL_DETAIL")
	private String tlDetail;		// 상세내용
	
	@ManyToOne
	@JoinColumn(name="CNT_NO")
	private Client client;				// 거래처번호
	
	@ManyToOne
	@JoinColumn(name="BK_NO")
	private Book book;			// 도서코드
	
	@ManyToOne
	@JoinColumn(name="EMP_NO")
	private Emp emp;				// 사원번호

	public TradeAndClientAndBookAndEmp() {
	}

	public TradeAndClientAndBookAndEmp(int tlNo, Date tlDate, int tlAmount, String tlDetail, Client client, Book book,
			Emp emp) {
		this.tlNo = tlNo;
		this.tlDate = tlDate;
		this.tlAmount = tlAmount;
		this.tlDetail = tlDetail;
		this.client = client;
		this.book = book;
		this.emp = emp;
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

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "TradeAndClientAndBookAndEmp [tlNo=" + tlNo + ", tlDate=" + tlDate + ", tlAmount=" + tlAmount
				+ ", tlDetail=" + tlDetail + ", client=" + client + ", book=" + book + ", emp=" + emp + "]";
	}
	
}
