package com.bukkeubook.book.manage.model.dto;

public class SignDTO {
	
//	TBL_SIGN 서명 테이블
//	
//	SIGN_NAME			VARCHAR2(255 BYTE)	파일본명
//	SIGN_SAVED_NAME		VARCHAR2(255 BYTE)	변경된파일명
//	SIGN_PATH			VARCHAR2(255 BYTE)	저장경로
//	EMP_NO				NUMBER				사원번호

	
	private int empNo; 
	private String signName;
	private String signSavedName;
	private String signPath;
	
	public SignDTO() {
	}
	
	public SignDTO(int empNo, String signName, String signSavedName, String signPath) {
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
		return "SignDTO [empNo=" + empNo + ", signName=" + signName + ", signSavedName=" + signSavedName + ", signPath="
				+ signPath + "]";
	}
	
	

}
