package com.bukkeubook.book.books.model.dto;

import java.io.Serializable;

public class StockBookListDTO implements Serializable{

	private static final long serialVersionUID = -4765647628823286670L;
	
	/* DB 자료형(TBL_STOCK_BK_LIST) */
//	STOCK_BK_LIST_CODE	NUMBER	목록번호
//	ST_CODE	NUMBER	입고 코드
//	BK_NO	VARCHAR2(100 BYTE)	도서코드
//	STOCK_BK_AMOUNT	NUMBER	수량
	private int stockBkListCode;		// 목록번호
	private int stCode;					// 입고 코드
	private String bkNo;				// 도서코드
	private int stockBkAmount;			// 수량
	
	public StockBookListDTO() {
	}

	public StockBookListDTO(int stockBkListCode, int stCode, String bkNo, int stockBkAmount) {
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
		return "StockBookListDTO [stockBkListCode=" + stockBkListCode + ", stCode=" + stCode + ", bkNo=" + bkNo
				+ ", stockBkAmount=" + stockBkAmount + "]";
	}
	
}
