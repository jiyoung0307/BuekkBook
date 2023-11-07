package com.bukkeubook.book.manage.model.entity;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "TBL_CANCEL_VACATION")
public class CancelVacationAndAppVacation implements Serializable{

	private static final long serialVersionUID = 8185722278352154353L;
	
	/* DB 자료형 */
	
//	VAC_CANC_NO		NUMBER				취소신청서번호
//	VAC_NO			NUMBER				휴가신청서번호
//	EMP_NO			NUMBER				사원번호
//	VAC_CANC_DATE	DATE				신청일자
//	VAC_CANC_REASON	NVARCHAR2(255 CHAR)	취소사유
//	VAC_CANC_STATUS	NVARCHAR2(15 CHAR)	문서상태
//	AppVacationAndEmpDTO
	
	@Id
	@Column(name = "VAC_CANC_NO")
	private int vacCancNo;
	
	@ManyToOne
	@JoinColumn(name = "VAC_NO")
	private AppVacationAndEmp appvacEmp;
	
	@Column(name = "EMP_NO")
	private int empNo;
	
	@Column(name = "VAC_CANC_DATE")
	private java.sql.Date vacCancDate;
	
	@Column(name = "VAC_CANC_REASON")
	private String vacCancReason;
	
	@Column(name = "VAC_CANC_STATUS")
	private String vacCancStatus;

	public CancelVacationAndAppVacation() {
		super();
	}

	public CancelVacationAndAppVacation(int vacCancNo, AppVacationAndEmp appvacEmp, int empNo, Date vacCancDate,
			String vacCancReason, String vacCancStatus) {
		super();
		this.vacCancNo = vacCancNo;
		this.appvacEmp = appvacEmp;
		this.empNo = empNo;
		this.vacCancDate = vacCancDate;
		this.vacCancReason = vacCancReason;
		this.vacCancStatus = vacCancStatus;
	}

	public int getVacCancNo() {
		return vacCancNo;
	}

	public void setVacCancNo(int vacCancNo) {
		this.vacCancNo = vacCancNo;
	}

	public AppVacationAndEmp getAppvacEmp() {
		return appvacEmp;
	}

	public void setAppvacEmp(AppVacationAndEmp appvacEmp) {
		this.appvacEmp = appvacEmp;
	}

	public int getEmpNo() {
		return empNo;
	}

	public void setEmpNo(int empNo) {
		this.empNo = empNo;
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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "CancelVacationAndAppVacation [vacCancNo=" + vacCancNo + ", appvacEmp=" + appvacEmp + ", empNo=" + empNo
				+ ", vacCancDate=" + vacCancDate + ", vacCancReason=" + vacCancReason + ", vacCancStatus="
				+ vacCancStatus + "]";
	}

	
	
}
