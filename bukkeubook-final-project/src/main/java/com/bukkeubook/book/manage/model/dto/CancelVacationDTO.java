package com.bukkeubook.book.manage.model.dto;

import java.io.Serializable;
import java.sql.Date;

public class CancelVacationDTO implements Serializable {

	private static final long serialVersionUID = 4441129064376804159L;
	
//	VAC_CANC_NO		NUMBER				취소신청서번호
//	VAC_CANC_DATE	DATE				신청일자
//	VAC_CANC_REASON	NVARCHAR2(255 CHAR)	취소사유
//	VAC_CANC_STATUS	NVARCHAR2(15 CHAR)	문서상태
//	EMP_NO	NUMBER	사원번호
	
	private int vacCancNo;
	private java.sql.Date vacCancDate;
	private String vacCancReason;
	private String vacCancStatus;
	private int empNo;
	public CancelVacationDTO() {
		super();
	}
	public CancelVacationDTO(int vacCancNo, Date vacCancDate, String vacCancReason, String vacCancStatus, int empNo) {
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
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public String toString() {
		return "CancelVacationDTO [vacCancNo=" + vacCancNo + ", vacCancDate=" + vacCancDate + ", vacCancReason="
				+ vacCancReason + ", vacCancStatus=" + vacCancStatus + ", empNo=" + empNo + "]";
	}
	
	
}
