package com.bukkeubook.book.document.model.dto;

import java.io.Serializable;
import java.sql.Date;

public class ApproverDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6494212300682273135L;

//	APP_NO	결재자번호	NUMBER
//	EMP_NO	결재자	NUMBER
//	APP_ROOT_NO	결재경로번호	NUMBER
//	APP_STATUS	문서상태	VARCHAR2(100 BYTE)
	
	private int appNo;
	private int empNo;
	private int appRootNo;
	private String appStatus;
	public ApproverDTO() {
		super();
	}
	public ApproverDTO(int appNo, int empNo, int appRootNo, String appStatus) {
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
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public String toString() {
		return "ApproverDTO [appNo=" + appNo + ", empNo=" + empNo + ", appRootNo=" + appRootNo + ", appStatus="
				+ appStatus + "]";
	}
	
	
	
}
