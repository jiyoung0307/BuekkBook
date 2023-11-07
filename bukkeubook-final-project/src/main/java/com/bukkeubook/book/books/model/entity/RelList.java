package com.bukkeubook.book.books.model.entity;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity(name="RelList")
@Table(name="TBL_REL_LIST")
@SequenceGenerator(
		name = "OUTPUT_SEQ_GENERATOR",
		sequenceName = "SEQ_REL_NO",
		initialValue = 21,
		allocationSize = 1
)
public class RelList implements Serializable{
	private static final long serialVersionUID = 1L;
//	REL_NO	NUMBER
//	REL_DATE	DATE
//	EMP_NO	NUMBER
	
	@Id
	@GeneratedValue(
			strategy = GenerationType.SEQUENCE,
			generator = "OUTPUT_SEQ_GENERATOR"
	)
	@Column(name="REL_NO")
	private int relNo;				// 출고번호
	
	@Column(name="REL_DATE")
	private java.sql.Date relDate;	// 출고날짜
	
	@Column(name="EMP_NO")
	private int empNo;				// 사원번호

	public RelList() {
	}

	public RelList(int relNo, Date relDate, int empNo) {
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
		return "RelList [relNo=" + relNo + ", relDate=" + relDate + ", empNo=" + empNo + "]";
	}
	
	
}
