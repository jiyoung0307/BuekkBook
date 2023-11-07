package com.bukkeubook.book.document.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name = "DocSign")
@Table(name = "TBL_SIGN")
public class DocSign {

	
//	SIGN_NAME	파일본명	VARCHAR2(255 BYTE)
//	SIGN_SAVED_NAME	변경된파일명	VARCHAR2(255 BYTE)
//	SIGN_PATH	저장경로	VARCHAR2(255 BYTE)
//	EMP_NO	사원번호	NUMBER

	@Id
	@Column(name = "EMP_NO")
	private int empNo;
	
	@Column(name = "SIGN_SAVED_NAME")
	private String signSavedName;
	
	@Column(name = "SIGN_NAME")
	private String signName;
	
	@Column(name = "SIGN_PATH")
	private String signPath;
	
	public DocSign() {
	}
	public DocSign(int empNo, String signSavedName, String signName, String signPath) {
		this.empNo = empNo;
		this.signSavedName = signSavedName;
		this.signName = signName;
		this.signPath = signPath;
	}
	public int getEmpNo() {
		return empNo;
	}
	public void setEmpNo(int empNo) {
		this.empNo = empNo;
	}
	public String getSignSavedName() {
		return signSavedName;
	}
	public void setSignSavedName(String signSavedName) {
		this.signSavedName = signSavedName;
	}
	public String getSignName() {
		return signName;
	}
	public void setSignName(String signName) {
		this.signName = signName;
	}
	public String getSignPath() {
		return signPath;
	}
	public void setSignPath(String signPath) {
		this.signPath = signPath;
	}
	@Override
	public String toString() {
		return "DocSign [empNo=" + empNo + ", signSavedName=" + signSavedName + ", signName=" + signName + ", signPath="
				+ signPath + "]";
	}
	
}
