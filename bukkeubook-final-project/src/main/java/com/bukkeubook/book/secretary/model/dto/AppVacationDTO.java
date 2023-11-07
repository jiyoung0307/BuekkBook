package com.bukkeubook.book.secretary.model.dto;

import java.io.Serializable;
import java.sql.Date;

public class AppVacationDTO implements Serializable {
	
	private static final long serialVersionUID = 6732206787548796035L;
	
//	VAC_NO			NUMBER					신청서번호(PK)
//	VAC_APP_NO		DATE					신청일자
//	VAC_START_DATE	DATE					휴가시작일
//	VAC_END_DATE	DATE					휴가종료일
//	VAC_REASON		NVARCHAR2(255 CHAR)		휴가사유
//	VAC_STATUS		NVARCHAR2(15 CHAR)		휴가상태
//	EMP_NO			NUMBER					사원번호
//	VAC_EMER		VARCHAR2(31 BYTE)		비상연락처
//	VAC_COMPANION	NVARCHAR2(2000 CHAR)	휴가반려사유
	
	private int vacNo;						// 신청서번호(pk)
	private java.sql.Date vacAppNo;			// 신청일자
	private java.sql.Date vacStartDate;		// 휴가시작일
	private java.sql.Date vacEndDate;		// 휴가종료일
	private String vacReason;				// 휴가사유
	private String vacStatus;				// 휴가상태
	private int empNo;						// 사원번호
	private String vacEmer;					// 비상연락처
	private String vacCompanion;			// 휴가반려사유
	
	public AppVacationDTO() {
	}
	
	public AppVacationDTO(int vacNo, Date vacAppNo, Date vacStartDate, Date vacEndDate, String vacReason,
			String vacStatus, int empNo, String vacEmer, String vacCompanion) {
		this.vacNo = vacNo;
		this.vacAppNo = vacAppNo;
		this.vacStartDate = vacStartDate;
		this.vacEndDate = vacEndDate;
		this.vacReason = vacReason;
		this.vacStatus = vacStatus;
		this.empNo = empNo;
		this.vacEmer = vacEmer;
		this.vacCompanion = vacCompanion;
	}
	
	public int getVacNo() {
		return vacNo;
	}
	public void setVacNo(int vacNo) {
		this.vacNo = vacNo;
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
	public int getEmpNo() {
		return empNo;
	}
	public void setEmpNo(int empNo) {
		this.empNo = empNo;
	}
	public String getVacEmer() {
		return vacEmer;
	}
	public void setVacEmer(String vacEmer) {
		this.vacEmer = vacEmer;
	}
	public String getVacCompanion() {
		return vacCompanion;
	}
	public void setVacCompanion(String vacCompanion) {
		this.vacCompanion = vacCompanion;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	@Override
	public String toString() {
		return "AppVacationDTO [vacNo=" + vacNo + ", vacAppNo=" + vacAppNo + ", vacStartDate=" + vacStartDate
				+ ", vacEndDate=" + vacEndDate + ", vacReason=" + vacReason + ", vacStatus=" + vacStatus + ", empNo="
				+ empNo + ", vacEmer=" + vacEmer + ", vacCompanion=" + vacCompanion + "]";
	}
}

