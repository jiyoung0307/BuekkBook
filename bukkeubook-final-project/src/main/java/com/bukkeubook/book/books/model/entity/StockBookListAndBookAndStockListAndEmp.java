package com.bukkeubook.book.books.model.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="TBL_STOCK_BK_LIST")
public class StockBookListAndBookAndStockListAndEmp implements Serializable{
	private static final long serialVersionUID = 1L;

//	STOCK_BK_LIST_CODE	NUMBER	목록번호
//	ST_CODE	NUMBER	입고 코드
//	BK_NO	VARCHAR2(100 BYTE)	도서코드
//	STOCK_BK_AMOUNT	NUMBER	수량
	
	@Id
	@Column(name="STOCK_BK_LIST_CODE")
	private int stockBkListCode;		// 목록번호
	
	@Column(name="STOCK_BK_AMOUNT")
	private int stockBkAmount;			// 수량

	@ManyToOne
	@JoinColumn(name="ST_CODE")
	private StockListAndEmp stockListEmp;					// 입고 코드
	
	@ManyToOne
	@JoinColumn(name="BK_NO")
	private Book book;				// 도서코드

	public StockBookListAndBookAndStockListAndEmp() {
	}

	public StockBookListAndBookAndStockListAndEmp(int stockBkListCode, int stockBkAmount, StockListAndEmp stockListEmp,
			Book book) {
		this.stockBkListCode = stockBkListCode;
		this.stockBkAmount = stockBkAmount;
		this.stockListEmp = stockListEmp;
		this.book = book;
	}

	public int getStockBkListCode() {
		return stockBkListCode;
	}

	public void setStockBkListCode(int stockBkListCode) {
		this.stockBkListCode = stockBkListCode;
	}

	public int getStockBkAmount() {
		return stockBkAmount;
	}

	public void setStockBkAmount(int stockBkAmount) {
		this.stockBkAmount = stockBkAmount;
	}

	public StockListAndEmp getStockListEmp() {
		return stockListEmp;
	}

	public void setStockListEmp(StockListAndEmp stockListEmp) {
		this.stockListEmp = stockListEmp;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	@Override
	public String toString() {
		return "StockBookListAndBookAndStockListAndEmp [stockBkListCode=" + stockBkListCode + ", stockBkAmount="
				+ stockBkAmount + ", stockListEmp=" + stockListEmp + ", book=" + book + "]";
	}
	
	
}
