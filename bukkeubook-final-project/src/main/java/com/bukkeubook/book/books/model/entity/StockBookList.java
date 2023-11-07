package com.bukkeubook.book.books.model.entity;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="TBL_STOCK_BK_LIST")
@SequenceGenerator(
		name = "INPUT_SEQ_GENERATOR2",
		sequenceName = "SEQ_STOCK_BK_LIST_CODE",
		initialValue = 21,
		allocationSize = 1
)
public class StockBookList implements Serializable{
	
	private static final long serialVersionUID = 3180325881764101089L;

	/* DB 자료형(TBL_STOCK_BK_LIST) */
//	STOCK_BK_LIST_CODE	NUMBER	목록번호
//	ST_CODE	NUMBER	입고 코드
//	BK_NO	VARCHAR2(100 BYTE)	도서코드
//	STOCK_BK_AMOUNT	NUMBER	수량
	@Id
	@GeneratedValue(
			strategy = GenerationType.SEQUENCE,
			generator = "INPUT_SEQ_GENERATOR2"
	)
	@Column(name="STOCK_BK_LIST_CODE")
	private int stockBkListCode;		// 목록번호
	
	@Column(name="ST_CODE")
	private int stCode;					// 입고 코드
	
	@Column(name="BK_NO")
	private String bkNo;				// 도서코드
	
	@Column(name="STOCK_BK_AMOUNT")
	private int stockBkAmount;			// 수량

	public StockBookList() {
	}

	public StockBookList(int stockBkListCode, int stCode, String bkNo, int stockBkAmount) {
		this.stockBkListCode = stockBkListCode;
		this.stCode = stCode;
		this.bkNo = bkNo;
		this.stockBkAmount = stockBkAmount;
	}

	public int getStockBkListCode() {
		return stockBkListCode;
	}

	public void setStockBkListCode(int stockBkListCode) {
		this.stockBkListCode = stockBkListCode;
	}

	public int getStCode() {
		return stCode;
	}

	public void setStCode(int stCode) {
		this.stCode = stCode;
	}

	public String getBkNo() {
		return bkNo;
	}

	public void setBkNo(String bkNo) {
		this.bkNo = bkNo;
	}

	public int getStockBkAmount() {
		return stockBkAmount;
	}

	public void setStockBkAmount(int stockBkAmount) {
		this.stockBkAmount = stockBkAmount;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "StockBookList [stockBkListCode=" + stockBkListCode + ", stCode=" + stCode + ", bkNo=" + bkNo
				+ ", stockBkAmount=" + stockBkAmount + "]";
	}
	
}
