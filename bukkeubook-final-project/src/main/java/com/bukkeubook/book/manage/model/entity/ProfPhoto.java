package com.bukkeubook.book.manage.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity(name="EmpProfile11")
@Table(name = "TBL_PROF_PHOTO")
@SequenceGenerator(
		name = "PHOTO_SEQ_GENERATOR",
		sequenceName = "SEQ_PHOTO_NO",
		initialValue = 2,
		allocationSize = 1
		)
public class ProfPhoto {
	
//	PHOTO_NO	NUMBER
//	PHOTO_ORIG_NAME	VARCHAR2(255 BYTE)
//	PHOTO_SAVED_NAME	VARCHAR2(255 BYTE)
//	PHOTO_SAVED_PATH	VARCHAR2(255 BYTE)
//	EMP_NO	NUMBER
	
	@Id
	@GeneratedValue(
			strategy = GenerationType.SEQUENCE,
			generator = "PHOTO_SEQ_GENERATOR"
			)
	@Column(name = "PHOTO_NO")
	private int photoNo;
	
	@Column(name = "PHOTO_ORIG_NAME")
	private String photoOrigName;
	
	@Column(name = "PHOTO_SAVED_NAME")
	private String photoSavedName;
	
	@Column(name = "PHOTO_SAVED_PATH")
	private String photoSavedPath;
	
	@Column(name = "EMP_NO")
	private int empNo;

	public ProfPhoto() {
	}

	public ProfPhoto(int photoNo, String photoOrigName, String photoSavedName, String photoSavedPath, int empNo) {
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
		return "ProfPhoto [photoNo=" + photoNo + ", photoOrigName=" + photoOrigName + ", photoSavedName="
				+ photoSavedName + ", photoSavedPath=" + photoSavedPath + ", empNo=" + empNo + "]";
	}
	
	
	
	
	

}
