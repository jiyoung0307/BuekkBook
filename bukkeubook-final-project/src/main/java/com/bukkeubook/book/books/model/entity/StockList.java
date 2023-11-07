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

@Entity
@Table(name="TBL_STOCK_LIST")
@SequenceGenerator(
		name = "INPUT_SEQ_GENERATOR",
		sequenceName = "SEQ_ST_CODE",
		initialValue = 21,
		allocationSize = 1
)
public class StockList implements Serializable{

	private static final long serialVersionUID = -5872574390835538568L;
	
	/* DB 자료형(TBL_STOCK_LIST) */
//	ST_CODE	NUMBER	목록번호
//	ST_DATE	DATE	입고날짜
//	EMP_NO	NUMBER	사원번호
//	ST_TYPE	NVARCHAR2(31 CHAR)	입고구분
	@Id
	@GeneratedValue(
			strategy = GenerationType.SEQUENCE,
			generator = "INPUT_SEQ_GENERATOR"
	)
	@Column(name="ST_CODE")
	private int stCode;				// 목록번호
	
	@Column(name="ST_DATE")
	private java.sql.Date stDate;	// 입고날짜
	
	@Column(name="EMP_NO")
	private int empNo;				// 사원번호
	
	@Column(name="ST_TYPE")
	private String stType;			// 입고구분

	public StockList() {
	}

	public StockList(int stCode, Date stDate, int empNo, String stType) {
		this.stCode = stCode;
		this.stDate = stDate;
		this.empNo = empNo;
		this.stType = stType;
	}

	public int getStCode() {
		return stCode;
	}

	public void setStCode(int stCode) {
		this.stCode = stCode;
	}

	public java.sql.Date getStDate() {
		return stDate;
	}

	public void setStDate(java.sql.Date stDate) {
		this.stDate = stDate;
	}

	public int getEmpNo() {
		return empNo;
	}

	public void setEmpNo(int empNo) {
		this.empNo = empNo;
	}

	public String getStType() {
		return stType;
	}

	public void setStType(String stType) {
		this.stType = stType;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "StockList [stCode=" + stCode + ", stDate=" + stDate + ", empNo=" + empNo + ", stType=" + stType + "]";
	}
	
}
