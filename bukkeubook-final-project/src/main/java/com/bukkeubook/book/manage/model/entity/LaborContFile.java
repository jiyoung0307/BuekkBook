package com.bukkeubook.book.manage.model.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/* TBL_CONT_FILE 테이블에 매칭될 ContFile 엔티티 클래스도 만들어 보기 */
@Entity
@Table(name = "TBL_CONT_FILE")
@SequenceGenerator(
		name = "CFILE_SEQ_GENERATOR",
		sequenceName = "SEQ_C_FILE_NO",
		initialValue = 1,
		allocationSize = 1
		)
public class LaborContFile implements Serializable{

	private static final long serialVersionUID = -1131043244610318049L;

	/* DB 자료형 */
	
//	C_FILE_NO			NUMBER				파일번호
//	C_FILE_ORIG_NAME	VARCHAR2(255 BYTE)	파일본명
//	C_FILE_SAVED_NAME	VARCHAR2(255 BYTE)	변경된파일명
//	C_FILE_PATH			VARCHAR2(255 BYTE)	저장경로
//	CONT_NO				NUMBER				근로계약번호
	
	@Id
	@GeneratedValue(
			strategy = GenerationType.SEQUENCE,
			generator = "CFILE_SEQ_GENERATOR"
	)
	@Column(name = "C_FILE_NO")
	private int cfileNo;
	
	@Column(name = "C_FILE_ORIG_NAME")
	private String cfileOrigName;
	
	@Column(name = "C_FILE_SAVED_NAME")
	private String cfileSavedName;
	
	@Column(name = "C_FILE_PATH")
	private String cfilePath;
	
	
	@Column(name = "CONT_NO")
	private int contNo;

	public LaborContFile() {
	}

	public LaborContFile(int cfileNo, String cfileOrigName, String cfileSavedName, String cfilePath, int contNo) {
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
		return "LaborContFile [cfileNo=" + cfileNo + ", cfileOrigName=" + cfileOrigName + ", cfileSavedName="
				+ cfileSavedName + ", cfilePath=" + cfilePath + ", contNo=" + contNo + "]";
	}
	
	

	
	
}
