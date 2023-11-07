package com.bukkeubook.book.secretary.model.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "TBL_BOARD_CATE")
public class CateAndBoard {
	
	@Id
	@Column(name = "CATE_NO")
	private int cateNo;
	
	@Column(name = "CATE_NAME")
	private String cateName;
	
	@OneToMany(mappedBy = "boardCate")
	private List<BoardAndCate> boardList = new ArrayList<>();

	public CateAndBoard() {
	}

	public CateAndBoard(int cateNo, String cateName, List<BoardAndCate> boardList) {
		this.cateNo = cateNo;
		this.cateName = cateName;
		this.boardList = boardList;
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

	public List<BoardAndCate> getBoardList() {
		return boardList;
	}

	public void setBoardList(List<BoardAndCate> boardList) {
		this.boardList = boardList;
	}

	@Override
	public String toString() {
		return "CateAndBoard [cateNo=" + cateNo + ", cateName=" + cateName + ", boardList=" + boardList + "]";
	}
	
	
	


}
