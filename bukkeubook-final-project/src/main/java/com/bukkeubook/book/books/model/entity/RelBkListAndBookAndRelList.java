package com.bukkeubook.book.books.model.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity(name="RelBkListAndBookAndRelList")
@Table(name="TBL_REL_BK_LIST")
public class RelBkListAndBookAndRelList implements Serializable{
//	REL_BK_CODE	NUMBER
//	BK_NO	VARCHAR2(100 BYTE)
//	REL_NO	NUMBER
//	REL_BK_AMOUNT	NUMBER
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="REL_BK_CODE")
	private int relBkCode;		// 목록번호
	
	@Column(name="REL_BK_AMOUNT")
	private int relBkAmount;	// 출고수량
	
	@ManyToOne()
	@JoinColumn(name="REL_NO")
	private RelListAndEmp relListEmp;			// 출고번호
	
	@ManyToOne()
	@JoinColumn(name="BK_NO")
	private Book book;		// 도서코드

	public RelBkListAndBookAndRelList() {
	}

	public RelBkListAndBookAndRelList(int relBkCode, int relBkAmount, RelListAndEmp relListEmp, Book book) {
		super();
		this.relBkCode = relBkCode;
		this.relBkAmount = relBkAmount;
		this.relListEmp = relListEmp;
		this.book = book;
	}

	public int getRelBkCode() {
		return relBkCode;
	}

	public void setRelBkCode(int relBkCode) {
		this.relBkCode = relBkCode;
	}

	public int getRelBkAmount() {
		return relBkAmount;
	}

	public void setRelBkAmount(int relBkAmount) {
		this.relBkAmount = relBkAmount;
	}

	public RelListAndEmp getRelListEmp() {
		return relListEmp;
	}

	public void setRelListEmp(RelListAndEmp relListEmp) {
		this.relListEmp = relListEmp;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "RelBkListAndBookAndRelList [relBkCode=" + relBkCode + ", relBkAmount=" + relBkAmount + ", relListEmp="
				+ relListEmp + ", book=" + book + "]";
	}


	
	

	
	
	
	
}
