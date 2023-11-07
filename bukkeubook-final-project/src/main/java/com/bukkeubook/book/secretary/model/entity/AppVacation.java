package com.bukkeubook.book.secretary.model.entity;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/* TBL_APP_VACATION 테이블에 매칭될 AppVacation 엔티티 클래스도 만들어 보기 */
@Entity( name = "vacSecret")
@Table(name = "TBL_APP_VACATION")
public class AppVacation implements Serializable{

	private static final long serialVersionUID = -273268265611843958L;

	/* DB 자료형 */
	
//	VAC_NO			NUMBER					신청서번호(PK)
//	VAC_APP_NO		DATE					신청일자
//	VAC_START_DATE	DATE					휴가시작일
//	VAC_END_DATE	DATE					휴가종료일
//	VAC_REASON		NVARCHAR2(255 CHAR)		휴가사유
//	VAC_STATUS		NVARCHAR2(15 CHAR)		휴가상태
//	EMP_NO			NUMBER					사원번호
//	VAC_EMER		VARCHAR2(31 BYTE)		비상연락처
//	VAC_COMPANION	NVARCHAR2(2000 CHAR)	휴가반려사유
	
	@Id
	@Column(name = "VAC_NO")
	private int vacNo;
	
	@Column(name = "VAC_APP_NO")
	private java.sql.Date vacAppNo;
	
	@Column(name = "VAC_START_DATE")
	private java.sql.Date vacStartDate;
	
	@Column(name = "VAC_END_DATE")
	private java.sql.Date vacEndDate;
	
	@Column(name = "VAC_REASON")
	private String vacReason;
	
	@Column(name = "VAC_STATUS")
	private String vacStatus;
	
	@Column(name = "EMP_NO")
	private int empNo;
	
	@Column(name = "VAC_EMER")
	private int vacEmer;
	
	@Column(name = "VAC_COMPANION")
	private String vacCompanion;

	public AppVacation() {
	}

	public AppVacation(int vacNo, Date vacAppNo, Date vacStartDate, Date vacEndDate, String vacReason, String vacStatus,
			int empNo, int vacEmer, String vacCompanion) {
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

	public int getVacEmer() {
		return vacEmer;
	}

	public void setVacEmer(int vacEmer) {
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
		return "AppVacation [vacNo=" + vacNo + ", vacAppNo=" + vacAppNo + ", vacStartDate=" + vacStartDate
				+ ", vacEndDate=" + vacEndDate + ", vacReason=" + vacReason + ", vacStatus=" + vacStatus + ", empNo="
				+ empNo + ", vacEmer=" + vacEmer + ", vacCompanion=" + vacCompanion + "]";
	}
	
}
