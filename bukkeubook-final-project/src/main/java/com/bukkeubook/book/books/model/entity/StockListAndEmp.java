package com.bukkeubook.book.books.model.entity;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.bukkeubook.book.manage.model.entity.Emp;

@Entity
@Table(name="TBL_STOCK_LIST")
public class StockListAndEmp implements Serializable{
	private static final long serialVersionUID = 1L;

//	ST_CODE	NUMBER	목록번호
//	ST_DATE	DATE	입고날짜
//	EMP_NO	NUMBER	사원번호
//	ST_TYPE	NVARCHAR2(31 CHAR)	입고구분
	
	@Id
	@Column(name="ST_CODE")
	private int stCode;				// 목록번호
	
	@Column(name="ST_DATE")
	private java.sql.Date stDate;	// 입고날짜
	
	@Column(name="ST_TYPE")
	private String stType;			// 입고구분
	
	@ManyToOne
	@JoinColumn(name="EMP_NO")
	private Emp emp;

	public StockListAndEmp() {
	}

	public StockListAndEmp(int stCode, Date stDate, String stType, Emp emp) {
		this.stCode = stCode;
		this.stDate = stDate;
		this.stType = stType;
		this.emp = emp;
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

	public String getStType() {
		return stType;
	}

	public void setStType(String stType) {
		this.stType = stType;
	}

	public Emp getEmp() {
		return emp;
	}

	public void setEmp(Emp emp) {
		this.emp = emp;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "StockListAndEmp [stCode=" + stCode + ", stDate=" + stDate + ", stType=" + stType + ", emp=" + emp + "]";
	}
	
	
	
	
	
}
