package com.bukkeubook.book.secretary.model.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity(name="Board")
@Table(name = "TBL_BOARD")
@SequenceGenerator(
		name = "BOARD_SEQ_GENERATOR",
		sequenceName = "SEQ_BOARD_NO",
		initialValue = 1,
		allocationSize = 1
		)
public class Board {
	
	// TBL_BOARD 전사 게시판 테이블
	
//		BOARD_NO	NUMBER
//		BOARD_CONTENT	NVARCHAR2(2000 CHAR)
//		BOARD_TITLE	NVARCHAR2(255 CHAR)
//		BOARD_DATE	DATE
//		BOARD_HITS	NUMBER
//		BOARD_YN	VARCHAR2(3 BYTE)
//		CATE_NO	NUMBER
//		EMP_NO	NUMBER
	
	@Id
	@GeneratedValue(
			strategy = GenerationType.SEQUENCE,
			generator = "BOARD_SEQ_GENERATOR"
	)
	@Column(name = "BOARD_NO")
	private int no;
	
	@Column(name = "BOARD_CONTENT")
	private String content;
	
	@Column(name = "BOARD_TITLE")
	private String title;
	
	@Column(name = "BOARD_DATE")
	private java.sql.Date date;
	
	@Column(name = "BOARD_HITS")
	private int hits;
	
	@Column(name = "BOARD_YN")
	private String boardYn;
	
	@Column(name = "CATE_NO")
	private int cateNo;
	
	@Column(name = "EMP_NO")
	private int empNo;

	public Board() {
	}

	public Board(int no, String content, String title, Date date, int hits, String boardYn, int cateNo, int empNo) {
		this.no = no;
		this.content = content;
		this.title = title;
		this.date = date;
		this.hits = hits;
		this.boardYn = boardYn;
		this.cateNo = cateNo;
		this.empNo = empNo;
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

	@Override
	public String toString() {
		return "Board [no=" + no + ", content=" + content + ", title=" + title + ", date=" + date + ", hits=" + hits
				+ ", boardYn=" + boardYn + ", cateNo=" + cateNo + ", empNo=" + empNo + "]";
	}
	
	
	
	

}
