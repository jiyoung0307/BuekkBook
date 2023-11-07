package com.bukkeubook.book.manage.model.entity;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

//DOFF_NO	NUMBER
//DOFF_YEAR	DATE
//DOFF_AMOUNT	NUMBER
//DOFF_REMAIN	NUMBER
//DOFF_USE	NUMBER
//EMP_NO	NUMBER

@Entity(name="DayOffAndEmpAndDept")
@Table(name = "TBL_DAYOFF")
public class DayOffAndEmpAndDept implements Serializable{
   
	private static final long serialVersionUID = -3348819890309683545L;

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

   @ManyToOne
   @JoinColumn(name="EMP_NO" , insertable=false, updatable=false)
   private EmpAndDept EmpAndDept;
   
	public DayOffAndEmpAndDept() {
		super();
	}

	public DayOffAndEmpAndDept(int doffNo, Date doffYear, int doffAmount, int doffRemain, int doffUse, int empNo,
			com.bukkeubook.book.manage.model.entity.EmpAndDept empAndDept) {
		super();
		this.doffNo = doffNo;
		this.doffYear = doffYear;
		this.doffAmount = doffAmount;
		this.doffRemain = doffRemain;
		this.doffUse = doffUse;
		this.empNo = empNo;
		EmpAndDept = empAndDept;
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

	public EmpAndDept getEmpAndDept() {
		return EmpAndDept;
	}

	public void setEmpAndDept(EmpAndDept empAndDept) {
		EmpAndDept = empAndDept;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "DayOffAndEmpAndDept [doffNo=" + doffNo + ", doffYear=" + doffYear + ", doffAmount=" + doffAmount
				+ ", doffRemain=" + doffRemain + ", doffUse=" + doffUse + ", empNo=" + empNo + ", EmpAndDept="
				+ EmpAndDept + "]";
	}



}

