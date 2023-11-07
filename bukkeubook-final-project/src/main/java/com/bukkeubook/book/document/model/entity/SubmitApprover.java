package com.bukkeubook.book.document.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity(name = "SubmitApprover")
@Table(name = "TBL_APPROVER")
@SequenceGenerator(
		name = "APPROVER_SEQ_APP_NO",
		sequenceName = "SEQ_APP_NO",
		initialValue = 1,
		allocationSize = 1
)
public class SubmitApprover{

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
	private int appNo2;
	
	@Column(name = "EMP_NO")
	private int empNo2;
	
	@Column(name = "APP_ROOT_NO")
	private int appRootNo2;
	
	@Column(name = "APP_STATUS")
	private String appStatus2;

	public SubmitApprover() {
		super();
	}

	public SubmitApprover(int appNo2, int empNo2, int appRootNo2, String appStatus2) {
		super();
		this.appNo2 = appNo2;
		this.empNo2 = empNo2;
		this.appRootNo2 = appRootNo2;
		this.appStatus2 = appStatus2;
	}

	public int getAppNo2() {
		return appNo2;
	}

	public void setAppNo2(int appNo2) {
		this.appNo2 = appNo2;
	}

	public int getEmpNo2() {
		return empNo2;
	}

	public void setEmpNo2(int empNo2) {
		this.empNo2 = empNo2;
	}

	public int getAppRootNo2() {
		return appRootNo2;
	}

	public void setAppRootNo2(int appRootNo2) {
		this.appRootNo2 = appRootNo2;
	}

	public String getAppStatus2() {
		return appStatus2;
	}

	public void setAppStatus2(String appStatus2) {
		this.appStatus2 = appStatus2;
	}

	@Override
	public String toString() {
		return "SubmitApprover [appNo2=" + appNo2 + ", empNo2=" + empNo2 + ", appRootNo2=" + appRootNo2
				+ ", appStatus2=" + appStatus2 + "]";
	}

	
	
	
}
