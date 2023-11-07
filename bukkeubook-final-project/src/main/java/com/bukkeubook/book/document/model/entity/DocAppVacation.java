package com.bukkeubook.book.document.model.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;

@Entity(name = "DocAppVacation")
@Table(name = "TBL_APP_VACATION")
@DynamicInsert
@SequenceGenerator(
		name = "APP_VACTION_SEQ_VAC_NO",
		sequenceName = "SEQ_VAC_NO",
		initialValue = 10,
		allocationSize = 1
)
public class DocAppVacation{

//	VAC_APP_NO	신청일자
//	VAC_START_DATE	휴가시작일
//	VAC_END_DATE	휴가종료일
//	VAC_EMER	비상연락처
//	VAC_REASON	휴가사유
//	VAC_STATUS	휴가상태
//	VAC_NO	신청서번호
//	EMP_NO	사원번호
//	VAC_COMPANION	
	
	@Id
	@GeneratedValue(
			strategy = GenerationType.SEQUENCE,
			generator = "APP_VACTION_SEQ_VAC_NO"
	)
	@Column(name = "VAC_NO")
	private int vacNo;
	
	@Column(name = "VAC_COMPANION")
	private String vacCompinion;
	
	@Column(name = "VAC_STATUS")
	private String vacStatus;

	@Column(name = "VAC_APP_NO")
	private java.sql.Date vacAppNo;
	
	@Column(name = "VAC_START_DATE")
	private java.sql.Date vacStartDate;
	
	@Column(name = "VAC_END_DATE")
	private java.sql.Date vacEndDate;
	
	@Column(name = "VAC_EMER")
	private String vacEmer;
	
	@Column(name = "VAC_REASON")
	private String vacReason;
	
	@Column(name = "EMP_NO")
	private int empNo;

	public DocAppVacation() {
	}

	public DocAppVacation(int vacNo, String vacCompinion, String vacStatus, Date vacAppNo, Date vacStartDate,
			Date vacEndDate, String vacEmer, String vacReason, int empNo) {
		this.vacNo = vacNo;
		this.vacCompinion = vacCompinion;
		this.vacStatus = vacStatus;
		this.vacAppNo = vacAppNo;
		this.vacStartDate = vacStartDate;
		this.vacEndDate = vacEndDate;
		this.vacEmer = vacEmer;
		this.vacReason = vacReason;
		this.empNo = empNo;
	}

	public int getVacNo() {
		return vacNo;
	}

	public void setVacNo(int vacNo) {
		this.vacNo = vacNo;
	}

	public String getVacCompinion() {
		return vacCompinion;
	}

	public void setVacCompinion(String vacCompinion) {
		this.vacCompinion = vacCompinion;
	}

	public String getVacStatus() {
		return vacStatus;
	}

	public void setVacStatus(String vacStatus) {
		this.vacStatus = vacStatus;
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

	public int getEmpNo() {
		return empNo;
	}

	public void setEmpNo(int empNo) {
		this.empNo = empNo;
	}

	@Override
	public String toString() {
		return "AppVacation [vacNo=" + vacNo + ", vacCompinion=" + vacCompinion + ", vacStatus=" + vacStatus
				+ ", vacAppNo=" + vacAppNo + ", vacStartDate=" + vacStartDate + ", vacEndDate=" + vacEndDate
				+ ", vacEmer=" + vacEmer + ", vacReason=" + vacReason + ", empNo=" + empNo + "]";
	}
	
	
	
}
