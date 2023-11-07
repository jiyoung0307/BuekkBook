package com.bukkeubook.book.books.model.dto;

public class RelBkListDTO {
//	REL_BK_CODE	NUMBER
//	BK_NO	VARCHAR2(100 BYTE)
//	REL_NO	NUMBER
//	REL_BK_AMOUNT	NUMBER
	
	private int relBkCode;		// 목록번호
	private String bkNo;		// 도서코드
	private int relNo;			// 출고번호
	private int relBkAmount;	// 출고수량
	
	public RelBkListDTO() {
	}
	public RelBkListDTO(int relBkCode, String bkNo, int relNo, int relBkAmount) {
		this.relBkCode = relBkCode;
		this.bkNo = bkNo;
		this.relNo = relNo;
		this.relBkAmount = relBkAmount;
	}
	public int getRelBkCode() {
		return relBkCode;
	}
	public void setRelBkCode(int relBkCode) {
		this.relBkCode = relBkCode;
	}
	public String getBkNo() {
		return bkNo;
	}
	public void setBkNo(String bkNo) {
		this.bkNo = bkNo;
	}
	public int getRelNo() {
		return relNo;
	}
	public void setRelNo(int relNo) {
		this.relNo = relNo;
	}
	public int getRelBkAmount() {
		return relBkAmount;
	}
	public void setRelBkAmount(int relBkAmount) {
		this.relBkAmount = relBkAmount;
	}
	@Override
	public String toString() {
		return "RelBkList [relBkCode=" + relBkCode + ", bkNo=" + bkNo + ", relNo=" + relNo + ", relBkAmount="
				+ relBkAmount + "]";
	}
	
	
}
