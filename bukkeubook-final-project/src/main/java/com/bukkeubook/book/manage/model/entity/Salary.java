package com.bukkeubook.book.manage.model.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity(name="Salary")
@Table(name = "TBL_SALARY")
@SequenceGenerator(
		name = "SAL_SEQ_SAL_NO",
		sequenceName = "SEQ_SAL_NO",
		initialValue = 300,
		allocationSize = 1
)
public class Salary {
	
//	SAL_NO	NUMBER	목록번호
//	SAL_MONTH DATE	지급월
//	SAL_BASE	NUMBER	기본급 ooooo
//	SAL_PENSION	NUMBER	국민연금  dddd
//	SAL_HEALTH	NUMBER	건강보험 
//	SAL_CARE	NUMBER	요양보험
//	SAL_HIRE	NUMBER	고용보험
//	SAL_INC_TAX	NUMBER	근로소득세
//	SAL_LOCAL_TAX	NUMBER	지방소득세
//	SAL_REAL_AMOUNT	NUMBER	실수령액
//	SAL_TOTAL_MINUS	NUMBER	공제액 합계
//	EMP_NO	NUMBER	사원번호
	
	@Id
	@GeneratedValue(
			strategy = GenerationType.SEQUENCE,
			generator = "SAL_SEQ_SAL_NO"
	)
	@Column(name = "SAL_NO")
	private int salNo;
	
	@Column(name = "SAL_MONTH")
	private java.sql.Date salMonth; 
	
	@Column(name = "SAL_BASE")
	private int salBase;  
	
	@Column(name = "SAL_PENSION")
	private int salPension; 
	
	@Column(name = "SAL_HEALTH")
	private int salHealth;
	
	@Column(name = "SAL_CARE")
	private int salCare;
	
	@Column(name = "SAL_HIRE")
	private int salHire;
	
	@Column(name = "SAL_INC_TAX")
	private int salIncTax;
	
	@Column(name = "SAL_LOCAL_TAX")
	private int salLocalTax;
	
	@Column(name = "SAL_REAL_AMOUNT")
	private int salRealAmount;
	
	@Column(name = "SAL_TOTAL_MINUS")
	private int salTotalMinus;
	
	@Column(name = "EMP_NO")
	private int empNo;

	public Salary() {
		super();
	}

	public Salary(int salNo, Date salMonth, int salBase, int salPension, int salHealth, int salCare, int salHire,
			int salIncTax, int salLocalTax, int salRealAmount, int salTotalMinus, int empNo) {
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

	@Override
	public String toString() {
		return "Salary [salNo=" + salNo + ", salMonth=" + salMonth + ", salBase=" + salBase + ", salPension="
				+ salPension + ", salHealth=" + salHealth + ", salCare=" + salCare + ", salHire=" + salHire
				+ ", salIncTax=" + salIncTax + ", salLocalTax=" + salLocalTax + ", salRealAmount=" + salRealAmount
				+ ", salTotalMinus=" + salTotalMinus + ", empNo=" + empNo + "]";
	}
	
	
}


