package com.bukkeubook.book.secretary.model.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.bukkeubook.book.manage.model.entity.Dept;

@Entity(name="BoardAndCate")
@Table(name = "TBL_BOARD")
public class BoardAndCate {
	
	
		@Id
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
	
		@Column(name = "EMP_NO")
		private int empNo;
		
		@ManyToOne 
	    @JoinColumn(name = "CATE_NO")
	    private BoardCate boardCate;

		public BoardAndCate() {
		}

		public BoardAndCate(int no, String content, String title, Date date, int hits, String boardYn, int empNo,
				BoardCate boardCate) {
			this.no = no;
			this.content = content;
			this.title = title;
			this.date = date;
			this.hits = hits;
			this.boardYn = boardYn;
			this.empNo = empNo;
			this.boardCate = boardCate;
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

		public int getEmpNo() {
			return empNo;
		}

		public void setEmpNo(int empNo) {
			this.empNo = empNo;
		}

		public BoardCate getBoardCate() {
			return boardCate;
		}

		public void setBoardCate(BoardCate boardCate) {
			this.boardCate = boardCate;
		}

		@Override
		public String toString() {
			return "BoardAndCate [no=" + no + ", content=" + content + ", title=" + title + ", date=" + date + ", hits="
					+ hits + ", boardYn=" + boardYn + ", empNo=" + empNo + ", boardCate=" + boardCate + "]";
		}

		


}
