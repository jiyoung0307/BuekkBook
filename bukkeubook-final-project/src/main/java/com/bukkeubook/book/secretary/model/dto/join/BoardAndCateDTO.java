package com.bukkeubook.book.secretary.model.dto.join;

import java.sql.Date;

import com.bukkeubook.book.secretary.model.dto.BoardCateDTO;

public class BoardAndCateDTO {
	
// TBL_BOARD 전사 게시판 테이블
	
//	BOARD_NO	NUMBER
//	BOARD_CONTENT	NVARCHAR2(2000 CHAR)
//	BOARD_TITLE	NVARCHAR2(255 CHAR)
//	BOARD_DATE	DATE
//	BOARD_HITS	NUMBER
//	BOARD_YN	VARCHAR2(3 BYTE)
//	CATE_NO	NUMBER
//	EMP_NO	NUMBER
	
	private int no;
	private String content;
	private String title;
	private java.sql.Date date;
	private int hits;
	private String boardYn;
	private int cateNo;
	private int empNo;
	private BoardCateDTO cate;
	public BoardAndCateDTO() {
	}
	public BoardAndCateDTO(int no, String content, String title, Date date, int hits, String boardYn, int cateNo,
			int empNo, BoardCateDTO cate) {
		this.no = no;
		this.content = content;
		this.title = title;
		this.date = date;
		this.hits = hits;
		this.boardYn = boardYn;
		this.cateNo = cateNo;
		this.empNo = empNo;
		this.cate = cate;
	}
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public java.sql.Date getDate() {
		return date;
	}
	public void setDate(java.sql.Date date) {
		this.date = date;
	}
	public int getHits() {
		return hits;
	}
	public void setHits(int hits) {
		this.hits = hits;
	}
	public String getBoardYn() {
		return boardYn;
	}
	public void setBoardYn(String boardYn) {
		this.boardYn = boardYn;
	}
	public int getCateNo() {
		return cateNo;
	}
	public void setCateNo(int cateNo) {
		this.cateNo = cateNo;
	}
	public int getEmpNo() {
		return empNo;
	}
	public void setEmpNo(int empNo) {
		this.empNo = empNo;
	}
	public BoardCateDTO getCate() {
		return cate;
	}
	public void setCate(BoardCateDTO cate) {
		this.cate = cate;
	}
	@Override
	public String toString() {
		return "BoardAndCateDTO [no=" + no + ", content=" + content + ", title=" + title + ", date=" + date + ", hits="
				+ hits + ", boardYn=" + boardYn + ", cateNo=" + cateNo + ", empNo=" + empNo + ", cate=" + cate + "]";
	}
	
	
	
	
}
