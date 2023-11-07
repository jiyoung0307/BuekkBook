package com.bukkeubook.book.books.model.dto;

public class DamBookAndBookDTO {
	
//	BK_NO	VARCHAR2(100 BYTE)	도서코드
//	DAM_AMOUNT	NUMBER	훼손수량
	
	private String bkNo;
	private int damAmount;
	
	private BookDTO book;

	public DamBookAndBookDTO() {
	}

	public DamBookAndBookDTO(String bkNo, int damAmount, BookDTO book) {
		this.bkNo = bkNo;
		this.damAmount = damAmount;
		this.book = book;
	}

	public String getBkNo() {
		return bkNo;
	}

	public void setBkNo(String bkNo) {
		this.bkNo = bkNo;
	}

	public int getDamAmount() {
		return damAmount;
	}

	public void setDamAmount(int damAmount) {
		this.damAmount = damAmount;
	}

	public BookDTO getBook() {
		return book;
	}

	public void setBook(BookDTO book) {
		this.book = book;
	}

	@Override
	public String toString() {
		return "DamBookAndBookDTO [bkNo=" + bkNo + ", damAmount=" + damAmount + ", book=" + book + "]";
	}
	
	
}
