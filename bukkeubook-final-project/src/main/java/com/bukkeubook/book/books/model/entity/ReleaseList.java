package com.bukkeubook.book.books.model.entity;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="TBL_REL_BK_LIST")
public class ReleaseList implements Serializable{

	private static final long serialVersionUID = 5321352540198355808L;

	/* DB 자료형(TBL_REL_LIST) */
//	REL_NO	NUMBER	출고번호
//	REL_DATE	DATE	출고 날짜
//	EMP_NO	NUMBER	사원번호
	@Id
	@Column(name="REL_NO")
	private int relNo;				// 출고번호
	
	@Column(name="REL_DATE")
	private java.sql.Date relDate;	// 출고 날짜
	
	@Column(name="EMP_NO")
	private int empNo;				// 사원번호

	public ReleaseList() {
	}

	public ReleaseList(int relNo, Date relDate, int empNo) {
		this.relNo = relNo;
		this.relDate = relDate;
		this.empNo = empNo;
	}

	public int getRelNo() {
		return relNo;
	}

	public void setRelNo(int relNo) {
		this.relNo = relNo;
	}

	public java.sql.Date getRelDate() {
		return relDate;
	}

	public void setRelDate(java.sql.Date relDate) {
		this.relDate = relDate;
	}

	public int getEmpNo() {
		return empNo;
	}

	public void setEmpNo(int empNo) {
		this.empNo = empNo;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "ReleaseList [relNo=" + relNo + ", relDate=" + relDate + ", empNo=" + empNo + "]";
	}
	
}
