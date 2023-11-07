package com.bukkeubook.book.manage.model.dto.joinDTO;

import java.io.Serializable;

public class ProfPhotoAndEmpDTO implements Serializable{

	private static final long serialVersionUID = 7337729857873241833L;

//	TBL_EMP 프로필 사진 테이블
//	
//	PHOTO_NO	NUMBER
//	PHOTO_ORIG_NAME	VARCHAR2(255 BYTE)
//	PHOTO_SAVED_NAME	VARCHAR2(255 BYTE)
//	PHOTO_SAVED_PATH	VARCHAR2(255 BYTE)
//	EMP_NO	NUMBER
	
	private int photoNo;
	private String photoOrigName;
	private String photoSavedName;
	private String photoSavedPath;
	private int empNo;
	private EmpAndDeptDTO empAndDept;
	
	public ProfPhotoAndEmpDTO() {
	}
	
	public ProfPhotoAndEmpDTO(int photoNo, String photoOrigName, String photoSavedName, String photoSavedPath,
			int empNo, EmpAndDeptDTO empAndDept) {
		this.photoNo = photoNo;
		this.photoOrigName = photoOrigName;
		this.photoSavedName = photoSavedName;
		this.photoSavedPath = photoSavedPath;
		this.empNo = empNo;
		this.empAndDept = empAndDept;
	}
	
	public int getPhotoNo() {
		return photoNo;
	}
	public void setPhotoNo(int photoNo) {
		this.photoNo = photoNo;
	}
	public String getPhotoOrigName() {
		return photoOrigName;
	}
	public void setPhotoOrigName(String photoOrigName) {
		this.photoOrigName = photoOrigName;
	}
	public String getPhotoSavedName() {
		return photoSavedName;
	}
	public void setPhotoSavedName(String photoSavedName) {
		this.photoSavedName = photoSavedName;
	}
	public String getPhotoSavedPath() {
		return photoSavedPath;
	}
	public void setPhotoSavedPath(String photoSavedPath) {
		this.photoSavedPath = photoSavedPath;
	}
	public int getEmpNo() {
		return empNo;
	}
	public void setEmpNo(int empNo) {
		this.empNo = empNo;
	}
	public EmpAndDeptDTO getEmpAndDept() {
		return empAndDept;
	}
	public void setEmpAndDept(EmpAndDeptDTO empAndDept) {
		this.empAndDept = empAndDept;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	@Override
	public String toString() {
		return "ProfPhotoAndEmpDTO [photoNo=" + photoNo + ", photoOrigName=" + photoOrigName + ", photoSavedName="
				+ photoSavedName + ", photoSavedPath=" + photoSavedPath + ", empNo=" + empNo + ", empAndDept="
				+ empAndDept + "]";
	}
}
