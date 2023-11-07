package com.bukkeubook.book.document.model.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name = "DocDayOff")
@Table(name = "TBL_DAYOFF")
public class DocDayOff {

//	DOFF_NO	연차관리번호	NUMBER
//	DOFF_YEAR	년도	DATE
//	DOFF_AMOUNT	연차횟수	NUMBER
//	DOFF_REMAIN	잔여연차횟수	NUMBER
//	DOFF_USE	사용연차횟수	NUMBER
//	EMP_NO	사원번호	NUMBER
	
	@Id
	@Column(name = "DOFF_NO")
	private int doffNo;
	
	@Column(name = "DOFF_YEAR")
	private java.sql.Date doffYear;
	
	@Column(name = "DOFF_AMOUNT")
	private int doffAmount;
	
	@Column(name = "DOFF_REMAIN")
	private int doffRemain;
	
	@Column(name = "DOFF_USE")
	private int doffUse;
	
	@Column(name = "EMP_NO")
	private int empNo;

	public DocDayOff() {
	}

	public DocDayOff(int doffNo, Date doffYear, int doffAmount, int doffRemain, int doffUse, int empNo) {
		this.doffNo = doffNo;
		this.doffYear = doffYear;
		this.doffAmount = doffAmount;
		this.doffRemain = doffRemain;
		this.doffUse = doffUse;
		this.empNo = empNo;
	}

	public int getDoffNo() {
		return doffNo;
	}

	public void setDoffNo(int doffNo) {
		this.doffNo = doffNo;
	}

	public java.sql.Date getDoffYear() {
		return doffYear;
	}

	public void setDoffYear(java.sql.Date doffYear) {
		this.doffYear = doffYear;
	}

	public int getDoffAmount() {
		return doffAmount;
	}

	public void setDoffAmount(int doffAmount) {
		this.doffAmount = doffAmount;
	}

	public int getDoffRemain() {
		return doffRemain;
	}

	public void setDoffRemain(int doffRemain) {
		this.doffRemain = doffRemain;
	}

	public int getDoffUse() {
		return doffUse;
	}

	public void setDoffUse(int doffUse) {
		this.doffUse = doffUse;
	}

	public int getEmpNo() {
		return empNo;
	}

	public void setEmpNo(int empNo) {
		this.empNo = empNo;
	}

	@Override
	public String toString() {
		return "DocDayOff [doffNo=" + doffNo + ", doffYear=" + doffYear + ", doffAmount=" + doffAmount + ", doffRemain="
				+ doffRemain + ", doffUse=" + doffUse + ", empNo=" + empNo + "]";
	}
	
	
}
