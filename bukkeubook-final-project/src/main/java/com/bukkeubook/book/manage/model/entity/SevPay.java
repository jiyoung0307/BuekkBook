package com.bukkeubook.book.manage.model.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/* TBL_SEV_PAY 테이블에 매칭될 SevPay 엔티티 클래스도 만들어 보기 */
@Entity
@Table(name = "TBL_SEV_PAY")
public class SevPay implements Serializable{

	private static final long serialVersionUID = -2770384285664436408L;

	/* DB 자료형 */
	
//	SEV_MONTH_PAY	NUMBER	3개월급여총액
//	SEV_AVG_PAY		NUMBER	평균임금
//	SEV_REAL_PAY	NUMBER	실지급액
//	EMP_NO			NUMBER	사원번호
	
	@Id
	@Column(name = "SEV_MONTH_PAY")
	private int sevMonthPay;
	
	@Column(name = "SEV_AVG_PAY")
	private int sevAvgPay;
	
	@Column(name = "SEV_REAL_PAY")
	private int empNo;

	public SevPay() {
		super();
	}

	public SevPay(int sevMonthPay, int sevAvgPay, int empNo) {
		super();
		this.sevMonthPay = sevMonthPay;
		this.sevAvgPay = sevAvgPay;
		this.empNo = empNo;
	}

	public int getSevMonthPay() {
		return sevMonthPay;
	}

	public void setSevMonthPay(int sevMonthPay) {
		this.sevMonthPay = sevMonthPay;
	}

	public int getSevAvgPay() {
		return sevAvgPay;
	}

	public void setSevAvgPay(int sevAvgPay) {
		this.sevAvgPay = sevAvgPay;
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
		return "SevPay [sevMonthPay=" + sevMonthPay + ", sevAvgPay=" + sevAvgPay + ", empNo=" + empNo + "]";
	}
	
	
}
