package com.bukkeubook.book.manage.model.dto;

public class ProfPhotoDTO {
	
//	TBL_PROF_PHOTO 프로필 사진 테이블
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
	
	public ProfPhotoDTO() {
	}
	public ProfPhotoDTO(int photoNo, String photoOrigName, String photoSavedName, String photoSavedPath, int empNo) {
		this.photoNo = photoNo;
		this.photoOrigName = photoOrigName;
		this.photoSavedName = photoSavedName;
		this.photoSavedPath = photoSavedPath;
		this.empNo = empNo;
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
	@Override
	public String toString() {
		return "ProfPhotoDTO [photoNo=" + photoNo + ", photoOrigName=" + photoOrigName + ", photoSavedName="
				+ photoSavedName + ", photoSavedPath=" + photoSavedPath + ", empNo=" + empNo + "]";
	}
	
	

}
