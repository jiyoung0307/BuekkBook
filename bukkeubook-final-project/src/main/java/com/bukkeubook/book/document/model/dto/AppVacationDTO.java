package com.bukkeubook.book.document.model.dto;

import java.io.Serializable;
import java.sql.Date;

public class AppVacationDTO implements Serializable{

	private static final long serialVersionUID = -6161676259331614456L;

//	VAC_APP_NO	신청일자
//	VAC_START_DATE	휴가시작일
//	VAC_END_DATE	휴가종료일
//	VAC_EMER	비상연락처
//	VAC_REASON	휴가사유
//	VAC_STATUS	휴가상태
//	VAC_NO	신청서번호
//	EMP_NO	사원번호
//	VAC_COMPANION	
	
	private int vacNo;
	private java.sql.Date vacAppNo;
	private java.sql.Date vacStartDate;
	private java.sql.Date vacEndDate;
	private String vacEmer;
	private String vacReason;
	private String vacStatus;
	private int empNo;
	private String vacCompinion;
	public AppVacationDTO() {
	}
	public AppVacationDTO(Date vacAppNo, Date vacStartDate, Date vacEndDate, String vacEmer, String vacReason,
			String vacStatus, int vacNo, int empNo, String vacCompinion) {
		this.vacAppNo = vacAppNo;
		this.vacStartDate = vacStartDate;
		this.vacEndDate = vacEndDate;
		this.vacEmer = vacEmer;
		this.vacReason = vacReason;
		this.vacStatus = vacStatus;
		this.vacNo = vacNo;
		this.empNo = empNo;
		this.vacCompinion = vacCompinion;
	}
	public java.sql.Date getVacAppNo() {
		return vacAppNo;
	}
	public void setVacAppNo(java.sql.Date vacAppNo) {
		this.vacAppNo = vacAppNo;
	}
	public java.sql.Date getVacStartDate() {
		return vacStartDate;
	}
	public void setVacStartDate(java.sql.Date vacStartDate) {
		this.vacStartDate = vacStartDate;
	}
	public java.sql.Date getVacEndDate() {
		return vacEndDate;
	}
	public void setVacEndDate(java.sql.Date vacEndDate) {
		this.vacEndDate = vacEndDate;
	}
	public String getVacEmer() {
		return vacEmer;
	}
	public void setVacEmer(String vacEmer) {
		this.vacEmer = vacEmer;
	}
	public String getVacReason() {
		return vacReason;
	}
	public void setVacReason(String vacReason) {
		this.vacReason = vacReason;
	}
	public String getVacStatus() {
		return vacStatus;
	}
	public void setVacStatus(String vacStatus) {
		this.vacStatus = vacStatus;
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
	public String getVacCompinion() {
		return vacCompinion;
	}
	public void setVacCompinion(String vacCompinion) {
		this.vacCompinion = vacCompinion;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public String toString() {
		return "AppVacationDTO [vacAppNo=" + vacAppNo + ", vacStartDate=" + vacStartDate + ", vacEndDate=" + vacEndDate
				+ ", vacEmer=" + vacEmer + ", vacReason=" + vacReason + ", vacStatus=" + vacStatus + ", vacNo=" + vacNo
				+ ", empNo=" + empNo + ", vacCompinion=" + vacCompinion + "]";
	}
	
	
}
