package com.bukkeubook.book.manage.model.dto;

import java.io.Serializable;
import java.sql.Date;

public class SalaryDTO implements Serializable{

	private static final long serialVersionUID = -6614322611156997085L;
//	SAL_NO	NUMBER			목록번호
//	SAL_MONTH DATE			지급월
//	SAL_BASE	NUMBER		기본급
//	SAL_PENSION	NUMBER		국민연금
//	SAL_HEALTH	NUMBER		건강보험
//	SAL_CARE	NUMBER		요양보험
//	SAL_HIRE	NUMBER		고용보험
//	SAL_INC_TAX	NUMBER		근로소득세
//	SAL_LOCAL_TAX	NUMBER	지방소득세
//	SAL_REAL_AMOUNT	NUMBER	실수령액
//	SAL_TOTAL_MINUS	NUMBER	공제액 합계
//	EMP_NO	NUMBER			사원번호
	
	
	private int salNo;
	private java.sql.Date salMonth;
	private int salBase;
	private int salPension;				//국민연금
	private int salHealth;				//건강보험
	private int salCare;				//요양보험
	private int salHire;				//고용보험
	private int salIncTax;				//근로소득세
	private int salLocalTax;			//지방소득세
	private int salRealAmount;
	private int salTotalMinus; 
	private int empNo;
	public SalaryDTO() {
		super();
	}
	public SalaryDTO(int salNo, java.sql.Date salMonth, int salBase, int salPension, int salHealth, int salCare,
			int salHire, int salIncTax, int salLocalTax, int salRealAmount, int salTotalMinus, int empNo) {
		super();
		this.salNo = salNo;
		this.salMonth = salMonth;
		this.salBase = salBase;
		this.salPension = salPension;
		this.salHealth = salHealth;
		this.salCare = salCare;
		this.salHire = salHire;
		this.salIncTax = salIncTax;
		this.salLocalTax = salLocalTax;
		this.salRealAmount = salRealAmount;
		this.salTotalMinus = salTotalMinus;
		this.empNo = empNo;
	}
	public int getSalNo() {
		return salNo;
	}
	public void setSalNo(int salNo) {
		this.salNo = salNo;
	}
	public java.sql.Date getSalMonth() {
		return salMonth;
	}
	public void setSalMonth(java.sql.Date salMonth) {
		this.salMonth = salMonth;
	}
	public int getSalBase() {
		return salBase;
	}
	public void setSalBase(int salBase) {
		this.salBase = salBase;
	}
	public int getSalPension() {
		return salPension;
	}
	public void setSalPension(int salPension) {
		this.salPension = salPension;
	}
	public int getSalHealth() {
		return salHealth;
	}
	public void setSalHealth(int salHealth) {
		this.salHealth = salHealth;
	}
	public int getSalCare() {
		return salCare;
	}
	public void setSalCare(int salCare) {
		this.salCare = salCare;
	}
	public int getSalHire() {
		return salHire;
	}
	public void setSalHire(int salHire) {
		this.salHire = salHire;
	}
	public int getSalIncTax() {
		return salIncTax;
	}
	public void setSalIncTax(int salIncTax) {
		this.salIncTax = salIncTax;
	}
	public int getSalLocalTax() {
		return salLocalTax;
	}
	public void setSalLocalTax(int salLocalTax) {
		this.salLocalTax = salLocalTax;
	}
	public int getSalRealAmount() {
		return salRealAmount;
	}
	public void setSalRealAmount(int salRealAmount) {
		this.salRealAmount = salRealAmount;
	}
	public int getSalTotalMinus() {
		return salTotalMinus;
	}
	public void setSalTotalMinus(int salTotalMinus) {
		this.salTotalMinus = salTotalMinus;
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
		return "SalaryDTO [salNo=" + salNo + ", salMonth=" + salMonth + ", salBase=" + salBase + ", salPension="
				+ salPension + ", salHealth=" + salHealth + ", salCare=" + salCare + ", salHire=" + salHire
				+ ", salIncTax=" + salIncTax + ", salLocalTax=" + salLocalTax + ", salRealAmount=" + salRealAmount
				+ ", salTotalMinus=" + salTotalMinus + ", empNo=" + empNo + "]";
	}
	
	
}
