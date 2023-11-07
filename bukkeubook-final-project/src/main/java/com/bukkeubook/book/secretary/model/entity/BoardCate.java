package com.bukkeubook.book.secretary.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

//TBL_BOARD_CATE 전사게시판 카테고리 테이블

//CATE_NO	NUMBER
//CATE_NAME	NVARCHAR2(31 CHAR)

@Entity(name = "BoardCate")
@Table(name = "TBL_BOARD_CATE")
public class BoardCate {
	
	@Id
	@Column(name = "CATE_NO")
	private int cateNo;
	
	@Column(name = "CATE_NAME")
	private String cateName;

	public BoardCate() {
	}

	public BoardCate(int cateNo, String cateName) {
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
		return "BoardCate [cateNo=" + cateNo + ", cateName=" + cateName + "]";
	}

	
	
	

}
