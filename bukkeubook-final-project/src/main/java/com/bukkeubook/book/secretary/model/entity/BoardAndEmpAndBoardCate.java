package com.bukkeubook.book.secretary.model.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.bukkeubook.book.manage.model.entity.Emp;

@Entity
@Table(name="TBL_BOARD")
@SequenceGenerator(
		name = "BOARD_SEQ_GENERATOR",
		sequenceName = "SEQ_BOARD_NO",
		initialValue = 1,
		allocationSize = 1
		)
public class BoardAndEmpAndBoardCate {
	
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
	@Column(name="BOARD_NO")
	private int no;
	
	@Column(name="BOARD_CONTENT")
	private String content;
	
	@Column(name="BOARD_TITLE")
	private String title;
	
	@Column(name="BOARD_DATE")
	private java.sql.Date date;
	
	@Column(name="BOARD_HITS")
	private int hits;
	
	@Column(name="BOARD_YN")
	private String boardYn;
	
	@ManyToOne
	@JoinColumn(name="CATE_NO")
	private BoardCate cate;
	
	@ManyToOne
	@JoinColumn(name="EMP_NO")
	private Emp emp;

	public BoardAndEmpAndBoardCate() {
	}

	public BoardAndEmpAndBoardCate(int no, String content, String title, Date date, int hits, String boardYn,
			BoardCate cate, Emp emp) {
		this.no = no;
		this.content = content;
		this.title = title;
		this.date = date;
		this.hits = hits;
		this.boardYn = boardYn;
		this.cate = cate;
		this.emp = emp;
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

	public BoardCate getCate() {
		return cate;
	}

	public void setCate(BoardCate cate) {
		this.cate = cate;
	}

	public Emp getEmp() {
		return emp;
	}

	public void setEmp(Emp emp) {
		this.emp = emp;
	}

	@Override
	public String toString() {
		return "BoardAndEmpAndBoardCate [no=" + no + ", content=" + content + ", title=" + title + ", date=" + date
				+ ", hits=" + hits + ", boardYn=" + boardYn + ", cate=" + cate + ", emp=" + emp + "]";
	}
	
	
	

}
