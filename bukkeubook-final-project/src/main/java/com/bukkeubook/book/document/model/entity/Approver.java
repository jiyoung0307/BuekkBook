package com.bukkeubook.book.document.model.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity(name = "Approver")
@Table(name = "TBL_APPROVER")
@SequenceGenerator(
		name = "APPROVER_SEQ_APP_NO",
		sequenceName = "SEQ_APP_NO",
		initialValue = 1,
		allocationSize = 1
)
public class Approver{

//	APP_NO	결재자번호	NUMBER
//	EMP_NO	결재자	NUMBER
//	APP_ROOT_NO	결재경로번호	NUMBER
//	APP_STATUS	문서상태	VARCHAR2(100 BYTE)
	
	@Id
	@GeneratedValue(
			strategy = GenerationType.SEQUENCE,
			generator = "APPROVER_SEQ_APP_NO"
	)
	@Column(name = "APP_NO")
	private int appNo;
	
	@Column(name = "EMP_NO")
	private int empNo;
	
	@Column(name = "APP_ROOT_NO")
	private int appRootNo;
	
	@Column(name = "APP_STATUS")
	private String appStatus;

	public Approver() {
		super();
	}

	public Approver(int appNo, int empNo, int appRootNo, String appStatus) {
		super();
		this.appNo = appNo;
		this.empNo = empNo;
		this.appRootNo = appRootNo;
		this.appStatus = appStatus;
	}

	public int getAppNo() {
		return appNo;
	}

	public void setAppNo(int appNo) {
		this.appNo = appNo;
	}

	public int getEmpNo() {
		return empNo;
	}

	public void setEmpNo(int empNo) {
		this.empNo = empNo;
	}

	public int getAppRootNo() {
		return appRootNo;
	}

	public void setAppRootNo(int appRootNo) {
		this.appRootNo = appRootNo;
	}

	public String getAppStatus() {
		return appStatus;
	}

	public void setAppStatus(String appStatus) {
		this.appStatus = appStatus;
	}

	@Override
	public String toString() {
		return "Approver [appNo=" + appNo + ", empNo=" + empNo + ", appRootNo=" + appRootNo + ", appStatus=" + appStatus
				+ "]";
	}

	
	
	
	
}
