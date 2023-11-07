package com.bukkeubook.book.manage.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name="EmpSign")
@Table(name = "TBL_SIGN")
public class Sign {

//	TBL_SIGN 서명 테이블
//	
//	SIGN_NAME	VARCHAR2(255 BYTE)
//	SIGN_SAVED_NAME	VARCHAR2(255 BYTE)
//	SIGN_PATH	VARCHAR2(255 BYTE)
//	EMP_NO	NUMBER
	
	@Id
	@Column(name = "EMP_NO")
	private int empNo;
	
	@Column(name = "SIGN_NAME")
	private String signName;
	
	@Column(name = "SIGN_SAVED_NAME")
	private String signSavedName;
	
	@Column(name = "SIGN_PATH")
	private String signPath;

	public Sign() {
	}

	public Sign(int empNo, String signName, String signSavedName, String signPath) {
		this.empNo = empNo;
		this.signName = signName;
		this.signSavedName = signSavedName;
		this.signPath = signPath;
	}

	public int getEmpNo() {
		return empNo;
	}

	public void setEmpNo(int empNo) {
		this.empNo = empNo;
	}

	public String getSignName() {
		return signName;
	}

	public void setSignName(String signName) {
		this.signName = signName;
	}

	public String getSignSavedName() {
		return signSavedName;
	}

	public void setSignSavedName(String signSavedName) {
		this.signSavedName = signSavedName;
	}

	public String getSignPath() {
		return signPath;
	}

	public void setSignPath(String signPath) {
		this.signPath = signPath;
	}

	@Override
	public String toString() {
		return "Sign [empNo=" + empNo + ", signName=" + signName + ", signSavedName=" + signSavedName + ", signPath="
				+ signPath + "]";
	}
	
	
	
	

}
