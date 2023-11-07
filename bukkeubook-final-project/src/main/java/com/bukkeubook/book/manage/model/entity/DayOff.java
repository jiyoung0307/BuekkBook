package com.bukkeubook.book.manage.model.entity;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/* TBL_DAYOFF 테이블에 매칭될 DayOff 엔티티 클래스도 만들어 보기 */
@Entity(name="DayOff")
@Table(name = "TBL_DAYOFF")

public class DayOff implements Serializable{

	private static final long serialVersionUID = 8796692768633218703L;
	
	/* DB 자료형 */
	
//	DOFF_NO		NUMBER	연차관리번호
//	DOFF_YEAR	DATE	년도
//	DOFF_AMOUNT	NUMBER	연차횟수
//	DOFF_REMAIN	NUMBER	잔여연차횟수
//	DOFF_USE	NUMBER	사용연차횟수
//	EMP_NO		NUMBER	사원번호
	
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

	public DayOff() {
	}

	public DayOff(int doffNo, Date doffYear, int doffAmount, int doffRemain, int doffUse, int empNo) {
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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "DayOff [doffNo=" + doffNo + ", doffYear=" + doffYear + ", doffAmount=" + doffAmount + ", doffRemain="
				+ doffRemain + ", doffUse=" + doffUse + ", empNo=" + empNo + "]";
	}
	
	
}
