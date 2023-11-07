package com.bukkeubook.book.manage.model.dto;

import java.io.Serializable;

public class ContFileDTO implements Serializable {
	
	private static final long serialVersionUID = 4956459758570618817L;
	
//	C_FILE_NO			NUMBER				파일번호
//	C_FILE_ORIG_NAME	VARCHAR2(255 BYTE)	파일본명
//	C_FILE_SAVED_NAME	VARCHAR2(255 BYTE)	변경된파일명
//	C_FILE_PATH			VARCHAR2(255 BYTE)	저장경로
//	CONT_NO				NUMBER				근로계약번호
	
	private int cfileNo;				// 파일번호
	private String cfileOrigName;		// 파일본명
	private String cfileSavedName;		// 변경된파일명
	private String cfilePath;			// 저장경로
	private int contNo;					// 근로계약번호
	public ContFileDTO() {
	}
	public ContFileDTO(int cfileNo, String cfileOrigName, String cfileSavedName, String cfilePath, int contNo) {
		this.cfileNo = cfileNo;
		this.cfileOrigName = cfileOrigName;
		this.cfileSavedName = cfileSavedName;
		this.cfilePath = cfilePath;
		this.contNo = contNo;
	}
	public int getCfileNo() {
		return cfileNo;
	}
	public void setCfileNo(int cfileNo) {
		this.cfileNo = cfileNo;
	}
	public String getCfileOrigName() {
		return cfileOrigName;
	}
	public void setCfileOrigName(String cfileOrigName) {
		this.cfileOrigName = cfileOrigName;
	}
	public String getCfileSavedName() {
		return cfileSavedName;
	}
	public void setCfileSavedName(String cfileSavedName) {
		this.cfileSavedName = cfileSavedName;
	}
	public String getCfilePath() {
		return cfilePath;
	}
	public void setCfilePath(String cfilePath) {
		this.cfilePath = cfilePath;
	}
	public int getContNo() {
		return contNo;
	}
	public void setContNo(int contNo) {
		this.contNo = contNo;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public String toString() {
		return "ContFileDTO [cfileNo=" + cfileNo + ", cfileOrigName=" + cfileOrigName + ", cfileSavedName="
				+ cfileSavedName + ", cfilePath=" + cfilePath + ", contNo=" + contNo + "]";
	}
	
	
}