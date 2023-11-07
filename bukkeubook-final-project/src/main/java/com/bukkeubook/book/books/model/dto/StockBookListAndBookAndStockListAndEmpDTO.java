package com.bukkeubook.book.books.model.dto;

public class StockBookListAndBookAndStockListAndEmpDTO {
	
//	STOCK_BK_LIST_CODE	NUMBER	목록번호
//	ST_CODE	NUMBER	입고 코드
//	BK_NO	VARCHAR2(100 BYTE)	도서코드
//	STOCK_BK_AMOUNT	NUMBER	수량
	private int stockBkListCode;		// 목록번호
	private int stCode;					// 입고 코드
	private String bkNo;				// 도서코드
	private int stockBkAmount;			// 수량
	private BookDTO book;
	private StockListAndEmpDTO stockListEmp;
	
	public StockBookListAndBookAndStockListAndEmpDTO() {
	}
	public StockBookListAndBookAndStockListAndEmpDTO(int stockBkListCode, int stCode, String bkNo, int stockBkAmount,
			BookDTO book, StockListAndEmpDTO stockListEmp) {
		this.stockBkListCode = stockBkListCode;
		this.stCode = stCode;
		this.bkNo = bkNo;
		this.stockBkAmount = stockBkAmount;
		this.book = book;
		this.stockListEmp = stockListEmp;
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
	public BookDTO getBook() {
		return book;
	}
	public void setBook(BookDTO book) {
		this.book = book;
	}
	public StockListAndEmpDTO getStockListEmp() {
		return stockListEmp;
	}
	public void setStockListEmp(StockListAndEmpDTO stockListEmp) {
		this.stockListEmp = stockListEmp;
	}
	@Override
	public String toString() {
		return "StockBookListAndBookAndStockListAndEmpDTO [stockBkListCode=" + stockBkListCode + ", stCode=" + stCode
				+ ", bkNo=" + bkNo + ", stockBkAmount=" + stockBkAmount + ", book=" + book + ", stockListEmp="
				+ stockListEmp + "]";
	}
	
	
	
}
