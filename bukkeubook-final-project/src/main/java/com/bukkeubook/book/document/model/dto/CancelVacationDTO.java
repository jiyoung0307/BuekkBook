package com.bukkeubook.book.document.model.dto;

import java.io.Serializable;
import java.sql.Date;

public class CancelVacationDTO implements Serializable{

	private static final long serialVersionUID = 3212194563796599204L;

//	VAC_CANC_NO	취소신청서번호	NUMBER
//	VAC_CANC_DATE	신청일자	DATE
//	VAC_CANC_REASON	취소사유	NVARCHAR2(255 CHAR)
//	VAC_CANC_STATUS	문서상태	NVARCHAR2(15 CHAR)
//	VAC_NO	휴가신청서번호	NUMBER
//	EMP_NO	사원번호	NUMBER
	
	private int vacCancNo;
	private java.sql.Date vacCancDate;
	private String vacCancReason;
	private String vacCancStatus;
	private int vacNo;
	private int empNo;
	public CancelVacationDTO() {
	}
	public CancelVacationDTO(int vacCancNo, Date vacCancDate, String vacCancReason, String vacCancStatus, int vacNo,
			int empNo) {
		this.vacCancNo = vacCancNo;
		this.vacCancDate = vacCancDate;
		this.vacCancReason = vacCancReason;
		this.vacCancStatus = vacCancStatus;
		this.vacNo = vacNo;
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
	public int getVacNo() {
		return vacNo;
	}
	public void setVacNo(int vacNo) {
		this.vacNo = vacNo;
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
				+ vacCancReason + ", vacCancStatus=" + vacCancStatus + ", vacNo=" + vacNo + ", empNo=" + empNo + "]";
	}
	
	
}
