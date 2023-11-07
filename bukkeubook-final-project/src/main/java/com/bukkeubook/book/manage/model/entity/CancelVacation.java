package com.bukkeubook.book.manage.model.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity(name="CancelVacation")
@Table(name = "TBL_CANCEL_VACATION")
public class CancelVacation {
	
//	VAC_CANC_NO	NUMBER	취소신청서번호
//	VAC_CANC_DATE	DATE	신청일자
//	VAC_CANC_REASON	NVARCHAR2(255 CHAR)	취소사유
//	VAC_CANC_STATUS	NVARCHAR2(15 CHAR)	문서상태
//	EMP_NO	NUMBER	사원번호
	
	@Id
	@Column(name = "VAC_CANC_NO")
	private int vacCancNo;
	   
	@Column(name = "VAC_CANC_DATE")
	private java.sql.Date vacCancDate;
	
	@Column(name = "VAC_CANC_REASON")
	private String vacCancReason;
	
	@Column(name = "VAC_CANC_STATUS")
	private String vacCancStatus;
	
	@Column(name = "EMP_NO")
	private int empNo;

	public CancelVacation() {
		super();
	}

	public CancelVacation(int vacCancNo, Date vacCancDate, String vacCancReason, String vacCancStatus, int empNo) {
		super();
		this.vacCancNo = vacCancNo;
		this.vacCancDate = vacCancDate;
		this.vacCancReason = vacCancReason;
		this.vacCancStatus = vacCancStatus;
		this.empNo = empNo;
	}

	public int getVacCancNo() {
		return vacCancNo;
	}

	public void setVacCancNo(int vacCancNo) {
		this.vacCancNo = vacCancNo;
	}

	public java.sql.Date getVacCancDate() {
		return vacCancDate;
	}

	public void setVacCancDate(java.sql.Date vacCancDate) {
		this.vacCancDate = vacCancDate;
	}

	public String getVacCancReason() {
		return vacCancReason;
	}

	public void setVacCancReason(String vacCancReason) {
		this.vacCancReason = vacCancReason;
	}

	public String getVacCancStatus() {
		return vacCancStatus;
	}

	public void setVacCancStatus(String vacCancStatus) {
		this.vacCancStatus = vacCancStatus;
	}

	public int getEmpNo() {
		return empNo;
	}

	public void setEmpNo(int empNo) {
		this.empNo = empNo;
	}

	@Override
	public String toString() {
		return "CancelVacation [vacCancNo=" + vacCancNo + ", vacCancDate=" + vacCancDate + ", vacCancReason="
				+ vacCancReason + ", vacCancStatus=" + vacCancStatus + ", empNo=" + empNo + "]";
	}
	
	

}
