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

@Entity(name = "DocCancelVacation")
@DynamicInsert
@Table(name = "TBL_CANCEL_VACATION")
@SequenceGenerator(
		name = "CANCEL_VACATION_SEQ_VAC_CANC_NO",
		sequenceName = "SEQ_VAC_CANC_NO",
		initialValue = 1,
		allocationSize = 1
)
public class DocCancelVacation {

//	VAC_CANC_NO	취소신청서번호	NUMBER
//	VAC_CANC_DATE	신청일자	DATE
//	VAC_CANC_REASON	취소사유	NVARCHAR2(255 CHAR)
//	VAC_CANC_STATUS	문서상태	NVARCHAR2(15 CHAR)
//	VAC_NO	휴가신청서번호	NUMBER
//	EMP_NO	사원번호	NUMBER
	
	@Id
	@GeneratedValue(
			strategy = GenerationType.SEQUENCE,
			generator = "CANCEL_VACATION_SEQ_VAC_CANC_NO"
	)
	@Column(name = "VAC_CANC_NO")
	private int vacCancNo;
	
	@Column(name = "VAC_CANC_DATE")
	private java.sql.Date vacCancDate;
	
	@Column(name = "VAC_CANC_REASON")
	private String vacCancReason;
	
	@Column(name = "VAC_CANC_STATUS")
	private String vacCancStatus;
	
	@Column(name = "VAC_NO")
	private int vacNo;
	
	@Column(name = "EMP_NO")
	private int empNo;

	public DocCancelVacation() {
	}

	public DocCancelVacation(int vacCancNo, Date vacCancDate, String vacCancReason, String vacCancStatus, int vacNo,
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

	@Override
	public String toString() {
		return "DocCancelVacation [vacCancNo=" + vacCancNo + ", vacCancDate=" + vacCancDate + ", vacCancReason="
				+ vacCancReason + ", vacCancStatus=" + vacCancStatus + ", vacNo=" + vacNo + ", empNo=" + empNo + "]";
	}
	
	
}
