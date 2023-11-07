package com.bukkeubook.book.manage.model.dto;

import java.io.Serializable;
import java.sql.Date;

public class DayOffDTO implements Serializable {
	
	private static final long serialVersionUID = 1081220253308884321L;
	
//	DOFF_NO		NUMBER	연차관리번호
//	DOFF_YEAR	DATE	년도
//	DOFF_AMOUNT	NUMBER	연차횟수
//	DOFF_REMAIN	NUMBER	잔여연차횟수
//	DOFF_USE	NUMBER	사용연차횟수
//	EMP_NO		NUMBER	사원번호
	
	private int doffNo;					// 연차관리번호
	private java.sql.Date doffYear;		// 년도
	private int doffAmount;				// 연차횟수
	private int doffRemain;				// 잔여연차횟수
	private int doffUse;				// 사용연차횟수
	private int empNo;					// 사원번호
	
	public DayOffDTO() {
	}
	
	public DayOffDTO(int doffNo, Date doffYear, int doffAmount, int doffRemain, int doffUse, int empNo) {
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
		return "DayOffDTO [doffNo=" + doffNo + ", doffYear=" + doffYear + ", doffAmount=" + doffAmount + ", doffRemain="
				+ doffRemain + ", doffUse=" + doffUse + ", empNo=" + empNo + "]";
	}
	
}