package com.bukkeubook.book.secretary.model.dto;

public class BoardCateDTO {
	
//	TBL_BOARD_CATE 전사게시판 카테고리 테이블
	
//	CATE_NO	NUMBER
//	CATE_NAME	NVARCHAR2(31 CHAR)
	
	private int cateNo;
	private String cateName;
	public BoardCateDTO() {
	}
	public BoardCateDTO(int cateNo, String cateName) {
		this.cateNo = cateNo;
		this.cateName = cateName;
	}
	public int getCateNo() {
		return cateNo;
	}
	public void setCateNo(int cateNo) {
		this.cateNo = cateNo;
	}
	public String getCateName() {
		return cateName;
	}
	public void setCateName(String cateName) {
		this.cateName = cateName;
	}
	@Override
	public String toString() {
		return "BoardCateDTO [cateNo=" + cateNo + ", cateName=" + cateName + "]";
	}
	
	

}
