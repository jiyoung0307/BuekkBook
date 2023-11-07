package com.bukkeubook.book.manage.model.dto.joinDTO;

import java.io.Serializable;
import java.sql.Date;

public class CancelVacationAndAppVacationDTO implements Serializable{

	private static final long serialVersionUID = -115964226227707479L;
	
//	VAC_CANC_NO		NUMBER				취소신청서번호
//	VAC_NO			NUMBER				휴가신청서번호
//	EMP_NO			NUMBER				사원번호
//	VAC_CANC_DATE	DATE				신청일자
//	VAC_CANC_REASON	NVARCHAR2(255 CHAR)	취소사유
//	VAC_CANC_STATUS	NVARCHAR2(15 CHAR)	문서상태
//	AppVacationAndEmpDTO
	
	private int vacCancNo;
	private int vacNo;
	private int empNo;
	private java.sql.Date vacCancDate;
	private String vacCancReason;
	private String vacCancStatus;
	private AppVacationAndEmpDTO appvacEMP;
	
	public CancelVacationAndAppVacationDTO() {
	}
	
	public CancelVacationAndAppVacationDTO(int vacCancNo, int vacNo, int empNo, Date vacCancDate, String vacCancReason,
			String vacCancStatus, AppVacationAndEmpDTO appvacEMP) {
		this.vacCancNo = vacCancNo;
		this.vacNo = vacNo;
		this.empNo = empNo;
		this.vacCancDate = vacCancDate;
		this.vacCancReason = vacCancReason;
		this.vacCancStatus = vacCancStatus;
		this.appvacEMP = appvacEMP;
	}
	
	public int getVacCancNo() {
		return vacCancNo;
	}
	public void setVacCancNo(int vacCancNo) {
		this.vacCancNo = vacCancNo;
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
	public AppVacationAndEmpDTO getAppvacEMP() {
		return appvacEMP;
	}
	public void setAppvacEMP(AppVacationAndEmpDTO appvacEMP) {
		this.appvacEMP = appvacEMP;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	@Override
	public String toString() {
		return "CancelVacationAndAppVacationDTO [vacCancNo=" + vacCancNo + ", vacNo=" + vacNo + ", empNo=" + empNo
				+ ", vacCancDate=" + vacCancDate + ", vacCancReason=" + vacCancReason + ", vacCancStatus="
				+ vacCancStatus + ", appvacEMP=" + appvacEMP + "]";
	}

}
